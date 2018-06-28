package com.duyun.huihsou.housekepper.pc.service.user;

import com.duyun.huihsou.housekepper.pc.request.UserParams;
import com.duyun.huihsou.housekepper.pc.service.AbstractBaseService;
import com.duyun.huihsou.housekepper.pc.vo.ResData;
import com.duyun.huishou.housekeeper.mapper.IBaseDao;
import com.duyun.huishou.housekeeper.mapper.UserEntityMapper;
import com.duyun.huishou.housekeeper.po.UserEntity;
import com.duyun.huishou.housekeeper.util.EncryptionUtils;
import com.duyun.huishou.housekeeper.util.JWTSignerUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.service.user
 * @email cn.lu.duke@gmail.com
 * @date January 10, 2018
 */

@Service
@Slf4j
public class UserServiceImpl extends AbstractBaseService<UserEntity> implements UserService {

    @Autowired
    private UserEntityMapper userMapper;

    @Override
    public IBaseDao getMapper() {
        return (IBaseDao)userMapper;
    }

    @Override
    public void processSessionData(ResData data) {
        String openId = data.getOpenId();
        if(StringUtils.isNotEmpty(openId)){
            UserEntity userEntity = userMapper.selectByOpenId(openId);
            if(userEntity == null){
                UserEntity insertPo = new UserEntity();
                insertPo.setOpenId(data.getOpenId());
                insertPo.setLastUpdateTime(System.currentTimeMillis());
                insertPo.setInsertTime(System.currentTimeMillis());
                insertPo.setBalance(0);
                insertPo.setUnionId(data.getUnionId());
                userMapper.insert(insertPo);
            }
        }
    }

    @Override
    public UserEntity queryByOpenId(String openId) {
        return userMapper.selectByOpenId(openId);
    }

    @Override
    public String login(UserParams params) {
        UserEntity entity = userMapper.selectByOpenId(params.getOpenId());
        if (!entity.getMobile().equals(params.getMobile())) {
            throw new RuntimeException("请使用本微信绑定账号登录！");
        }
        String salt = entity.getSalt();
        String pwd = EncryptionUtils.encryptPasswordBySalt(params.getPassword(), salt);
        if (!pwd.equals(entity.getPassword())) {
            throw new RuntimeException("密码错误！");
        }

        return generateToken(entity);
    }

    @Override
    public String register(UserParams params) {
        //todo 验证码校验
        if (userMapper.selectByMobile(params.getMobile()) != null) {
            return "该手机号已存在！";
        };
        if (!params.getNewPwd1().equals(params.getNewPwd2())) {
            return  "两次输入密码不一致，请重新输入！";
        }
        UserEntity userEntity = userMapper.selectByOpenId(params.getOpenId());
        if (userEntity == null) {
            return "服务器内部异常，请稍后再试！";
        }
        String salt = EncryptionUtils.generateSalt();
        String password = EncryptionUtils.encryptPasswordBySalt(params.getNewPwd2(), salt);
        userEntity.setMobile(params.getMobile());
        userEntity.setSalt(salt);
        userEntity.setPassword(password);
        userMapper.updateByPrimaryKeySelective(userEntity);

        return "注册成功";
    }

    @Override
    public Boolean repwd(UserParams params, UserEntity userEntity) {
        UserEntity object = userMapper.selectByMobile(params.getMobile());
        if ( !object.getMobile().equals(userEntity.getMobile())) {
            throw new RuntimeException("该手机号与当前登录手机号不一致，请重新输入！");
        }
        if (!params.getNewPwd1().equals(params.getNewPwd2())) {
            throw new RuntimeException("两次输入密码不一致，请重新输入！");
        }
        String salt = userEntity.getSalt();
        String password = EncryptionUtils.encryptPasswordBySalt(params.getNewPwd2(), salt);
        userEntity.setPassword(password);
        int result = userMapper.updateByPrimaryKeySelective(userEntity);
        if (result == 0) {
            return false;
        }
        return true;
    }

    @Override
    public UserEntity selectByOpenId(String openId) {
        return userMapper.selectByOpenId(openId);
    }

    private String generateToken(UserEntity userEntity) {
        String token = null;
        try {
            token = JWTSignerUtil.shouldSignStringOrURICollection(
                    "/user/login", userEntity.getId() + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }


}

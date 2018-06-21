package com.duyun.huihsou.housekepper.portal.service.user;


import com.duyun.huihsou.housekepper.portal.service.AbstractBaseService;
import com.duyun.huihsou.housekepper.portal.vo.ResData;
import com.duyun.huishou.housekeeper.mapper.IBaseDao;
import com.duyun.huishou.housekeeper.mapper.UserEntityMapper;
import com.duyun.huishou.housekeeper.po.UserEntity;
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
                insertPo.setInsertTime(System.currentTimeMillis());
                insertPo.setBalance(0);
//                insertPo.setStatus(1);
                insertPo.setUnionId(data.getUnionId());
                userMapper.insert(insertPo);
            }
        }
    }

    @Override
    public UserEntity queryByOpenId(String openId) {
        return userMapper.selectByOpenId(openId);
    }
}

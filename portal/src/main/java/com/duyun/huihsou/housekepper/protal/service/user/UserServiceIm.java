package com.duyun.huihsou.housekepper.protal.service.user;


import com.duyun.huihsou.housekepper.protal.vo.ResData;
import com.duyun.huishou.housekeeper.mapper.user.UserMapper;
import com.duyun.huishou.housekeeper.po.user.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.service.user
 * @email cn.lu.duke@gmail.com
 * @date January 10, 2018
 */

@Service
@Slf4j
public class UserServiceIm implements UserService {

    @Autowired
    private UserMapper userMapper;

   ;

    @Override
    public int insertPo(User entity) {
        return userMapper.insertPo(entity);
    }

    @Override
    public int updatePo(User entity) {
        return userMapper.updatePo(entity);
    }

    @Override
    public int deletePo(User entity) {
        return userMapper.deletePo(entity);
    }

    @Override
    public User selectPo(User entity) {
        return userMapper.selectPo(entity);
    }

    @Override
    public User queryById(Integer userId) {
        return userMapper.selectById(userId);
    }



    /**
     * 通过用户其他属性获取用户
     * @param openId
     * @return
     */
    private User getUserByOpenid(String openId){
        User user =  userMapper.queryByOpenId(openId);
        return user;
    }



    /**
     * 通过openId 获取user
     *
     * @param openId
     * @return
     */
    @Override
    public User queryByOpenId(String openId) {
        User user = userMapper.queryByOpenId(openId);
        return user;
    }

    @Override
    public void processSessionData(ResData jsData) {
        String openId = jsData.getOpenId();
        if(StringUtils.isNotEmpty(openId)){
            User user = userMapper.queryByOpenId(openId);
            if(user == null){
                User insertPo = new User();
                insertPo.setOpenId(jsData.getOpenId());
                insertPo.setInsertTime(System.currentTimeMillis());
                insertPo.setBalance(0);
//                insertPo.setStatus(1);
                insertPo.setUnionId(jsData.getUnionId());
                userMapper.insertPo(insertPo);
            }
        }
    }
}

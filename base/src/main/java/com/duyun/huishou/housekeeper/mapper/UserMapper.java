package com.duyun.huishou.housekeeper.mapper;

import com.duyun.huishou.housekeeper.po.User;

public interface UserMapper extends IBaseMapper<User>{

    User queryByOpenId(String openId);
}
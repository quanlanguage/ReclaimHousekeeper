package com.duyun.huishou.housekeeper.mapper.user;


import com.duyun.huishou.housekeeper.mapper.IBaseMapper;
import com.duyun.huishou.housekeeper.po.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserMapper extends IBaseMapper<User> {

    /**
     * 通过openId查询用户
     * @param openId
     * @return
     */
    User queryByOpenId(String openId);

    int updateBalance(@Param("addBalance") Integer addBalance,
                      @Param("version") Integer version,
                      @Param("id") Integer id);


}

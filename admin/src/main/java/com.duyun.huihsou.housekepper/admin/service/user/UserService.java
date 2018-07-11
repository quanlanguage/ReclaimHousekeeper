package com.duyun.huihsou.housekepper.admin.service.user;


import com.duyun.huihsou.housekepper.admin.request.UserParams;
import com.duyun.huihsou.housekepper.admin.service.IBaseService;
import com.duyun.huihsou.housekepper.admin.vo.ResData;
import com.duyun.huishou.housekeeper.po.UserEntity;

/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.service.user
 * @email cn.lu.duke@gmail.com
 * @date January 10, 2018
 */
public interface UserService extends IBaseService<UserEntity> {

    void processSessionData(ResData data);

    UserEntity queryByOpenId(String openId);

    String login(UserParams params);

    void register(UserParams params);

    Boolean repwd(UserParams params, UserEntity userEntity);
}

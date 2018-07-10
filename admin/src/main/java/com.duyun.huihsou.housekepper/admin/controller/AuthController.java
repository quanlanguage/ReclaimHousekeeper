package com.duyun.huihsou.housekepper.admin.controller;


import com.duyun.huihsou.housekepper.admin.service.auth.AuthService;
import com.duyun.huihsou.housekepper.admin.service.user.UserService;
import com.duyun.huihsou.housekepper.admin.vo.CheckAccessVO;
import com.duyun.huishou.housekeeper.ApiResponse;
import com.duyun.huishou.housekeeper.constants.RetCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.controller
 * @email cn.lu.duke@gmail.com
 * @date January 10, 2018
 */


@RestController
@RequestMapping("/wechat/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    UserService userService;

    @Autowired
    RedisTemplate redisTemplate;


    /**
     * 收取客户端传入的用户授权码{@code code}
     * 验证wechat用户信息并返回
     * @param code
     * @return
     */

    @RequestMapping(value = "/check_access", method = RequestMethod.GET)
    public ApiResponse<CheckAccessVO> noLoginAccess(String code){
        if (StringUtils.isEmpty(code)) {
            return new ApiResponse<>(RetCode.REQUEST_ERROR, "请求用户code为空", null);
        }
        CheckAccessVO vo = authService.getTicket(code);
        if (null == vo.getTicket()){
            return new ApiResponse(RetCode.NOT_FOUND,  "授权失败，请重试");
        }
        return new ApiResponse(vo);
    }
}


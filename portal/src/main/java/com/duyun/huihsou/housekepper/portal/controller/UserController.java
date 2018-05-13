package com.duyun.huihsou.housekepper.portal.controller;

import com.duyun.huishou.housekeeper.ApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author haoshijing
 * @version 2018年05月08日 21:13
 **/
@RestController
@RequestMapping("/h5/api/user")
public class UserController {

    @RequestMapping("/bindPhone")
    public ApiResponse<Boolean> bindPhone(HttpServletRequest request, String phone) {

        return new ApiResponse<>(false);
    }
}

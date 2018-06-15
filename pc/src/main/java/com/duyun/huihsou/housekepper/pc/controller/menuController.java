package com.duyun.huihsou.housekepper.pc.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu/")
public class menuController {

    /**
     *  得到所有的菜单
     *
     * @param code
     * @return   【object，object】
     */
    @RequestMapping(value = "/get_menuList", method = RequestMethod.GET)
    public Object getMenuList(String code){
        System.out.println("2222");
        return null;
    }



}

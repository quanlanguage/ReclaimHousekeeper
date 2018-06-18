package com.duyun.huihsou.housekepper.pc.controller;


import com.alibaba.fastjson.JSON;
import com.duyun.huihsou.housekepper.pc.service.news.NewsService;
import com.duyun.huishou.housekeeper.ApiResponse;
import com.duyun.huishou.housekeeper.constants.RetCode;
import com.duyun.huishou.housekeeper.po.NewsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/news")
public class newsController {


    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/getNewShowlist", method = RequestMethod.GET)
    public Object getNewShowlist(Integer start,Integer newpagesize) {
        try {
            Map map = new HashMap();
            map.put("start", start <= 0 ? 0 : start);
            map.put("size", newpagesize < 0 ? 10 : newpagesize);
            List<NewsEntity> newLitem=newsService.getNewsprofile(map);
            return JSON.toJSON(newLitem.size()>=0?new  ApiResponse(newLitem):new ApiResponse(RetCode.NOT_FOUND,"请求失败或没有数据"));
        }
        catch(Exception e) {
            System.out.println("异常信息为："+e.getMessage());
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND,"请求失败或没有数据"));
        }
    }

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

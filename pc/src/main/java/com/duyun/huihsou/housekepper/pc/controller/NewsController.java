package com.duyun.huihsou.housekepper.pc.controller;


import com.duyun.huishou.housekeeper.ApiResponse;
import com.duyun.huishou.housekeeper.constants.RetCode;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news/")
public class NewsController {


    /**
     *  用于显示所有的新闻  小标题
     *
     * @param code
     * @return   【object，object】
     */
    @RequestMapping(value = "/get_newsList", method = RequestMethod.GET)
    public Object getNewsList(String code){

        return null;
    }

    /**
     * 得到具体文章   id
     *
     * @param code
     * @return   【object，object】
     */
    @RequestMapping(value = "/get_NewsOfOne", method = RequestMethod.GET)
    public Object get_NewsOne(String code){

        return null;
    }

    /**
     * 插入具体一篇文章
     *
     * @param code
     * @return   【object，object】
     */
    @RequestMapping(value = "/insert_News", method = RequestMethod.GET)
    public Object insert_NewsOne(String code){

        return null;
    }


    /**
     * 更新一篇文章
     *
     * @param code
     * @return   【object，object】
     */
    @RequestMapping(value = "/update_News", method = RequestMethod.GET)
    public Object update_News(String code){

        return null;
    }


    /**
     * 更新一篇文章
     *
     * @param code
     * @return   【object，object】
     */
    @RequestMapping(value = "/delete_News", method = RequestMethod.GET)
    public Object delete_News(String code){

        return null;
    }



}

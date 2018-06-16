package com.duyun.huihsou.housekepper.portal.controller.news;

import com.duyun.huihsou.housekepper.portal.inteceptor.VisitorAccessible;
import com.duyun.huihsou.housekepper.portal.service.news.NewsService;
import com.duyun.huishou.housekeeper.ApiResponse;
import com.duyun.huishou.housekeeper.po.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author haoshijing
 * @version 2018年05月08日 21:13
 **/
@RestController
@RequestMapping("/h5/api/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @VisitorAccessible
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces="application/json")
    public ApiResponse<List<CategoryEntity>> getList() {
        return new ApiResponse(newsService.getAll());
    }
}

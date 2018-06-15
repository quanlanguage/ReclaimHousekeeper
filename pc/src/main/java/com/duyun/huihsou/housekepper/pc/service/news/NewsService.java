package com.duyun.huihsou.housekepper.pc.service.news;


import com.duyun.huihsou.housekepper.pc.service.IBaseService;
import com.duyun.huishou.housekeeper.po.News;

public interface NewsService extends IBaseService<News> {

    News queryById(News newsId);

}

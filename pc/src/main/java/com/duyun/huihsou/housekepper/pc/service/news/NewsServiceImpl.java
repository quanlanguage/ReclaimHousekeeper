package com.duyun.huihsou.housekepper.pc.service.news;

import com.duyun.huihsou.housekepper.pc.service.AbstractBaseService;
import com.duyun.huishou.housekeeper.mapper.IBaseDao;
import com.duyun.huishou.housekeeper.mapper.NewsEntityMapper;
import com.duyun.huishou.housekeeper.po.NewsEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class NewsServiceImpl extends AbstractBaseService<NewsEntity> implements NewsService{

    /**
     *
     */
    @Autowired
    private NewsEntityMapper newsEntityMapper;

    @Override
    public IBaseDao getMapper() {
        return newsEntityMapper;
    }


    // 获取新闻 按照最后时间排序  是否置顶
    @Override
    public List<NewsEntity> getNewsprofile(Map map) {
        return newsEntityMapper.getNewsprofile(map);
    }



}

package com.duyun.huishou.housekeeper.mapper;

import com.duyun.huishou.housekeeper.po.NewsEntity;

import java.util.List;

public interface NewsEntityMapper extends IBaseDao<NewsEntity>{
    List<NewsEntity> selectAll();
}
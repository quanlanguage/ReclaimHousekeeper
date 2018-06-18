package com.duyun.huishou.housekeeper.mapper;

import com.duyun.huishou.housekeeper.po.NewsEntity;

import java.util.List;
import java.util.Map;

public interface NewsEntityMapper extends IBaseDao<NewsEntity>{
    List<NewsEntity> selectAll(Map<String, Object> map);
}
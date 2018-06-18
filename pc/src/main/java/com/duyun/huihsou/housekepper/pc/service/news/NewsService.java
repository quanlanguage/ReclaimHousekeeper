package com.duyun.huihsou.housekepper.pc.service.news;


import com.duyun.huihsou.housekepper.pc.service.IBaseService;
import com.duyun.huishou.housekeeper.po.NewsEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface NewsService extends IBaseService<NewsEntity> {


   List<NewsEntity> getNewsprofile(Map map);


}

package com.duyun.huihsou.housekepper.admin.service.news;


import com.duyun.huihsou.housekepper.admin.request.BaseParams;
import com.duyun.huihsou.housekepper.admin.service.IBaseService;
import com.duyun.huishou.housekeeper.po.NewsEntity;

import java.util.List;

/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.service.user
 * @email cn.lu.duke@gmail.com
 * @date January 10, 2018
 */
public interface NewsService extends IBaseService<NewsEntity> {

    List<NewsEntity> getAll(BaseParams params);

    Integer getNum();
}

package com.duyun.huihsou.housekepper.pc.service.banner;


import com.duyun.huihsou.housekepper.pc.service.IBaseService;
import com.duyun.huishou.housekeeper.po.BannerConfigEntity;
import com.duyun.huishou.housekeeper.po.banner.bannerR;

import java.util.List;
import java.util.Map;

/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.service.user
 * @email cn.lu.duke@gmail.com
 * @date January 10, 2018
 */
public interface BannerConfigService extends IBaseService<BannerConfigEntity> {

    List<BannerConfigEntity> getBannerConfigByConfition(BannerConfigEntity entity);

    List<bannerR> selectItem(Map map);

    int insert(BannerConfigEntity entity);

    int getCountbanner();

    int delectOneBanprom(Integer id);
}

package com.duyun.huihsou.housekepper.pc.service.banner;


import com.duyun.huihsou.housekepper.pc.service.AbstractBaseService;
import com.duyun.huishou.housekeeper.mapper.BannerConfigEntityMapper;
import com.duyun.huishou.housekeeper.mapper.IBaseDao;
import com.duyun.huishou.housekeeper.po.BannerConfigEntity;
import com.duyun.huishou.housekeeper.po.banner.bannerR;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.service.user
 * @email cn.lu.duke@gmail.com
 * @date January 10, 2018
 */

@Service
@Slf4j
public class BannerConfigServiceImpl extends AbstractBaseService<BannerConfigEntity> implements BannerConfigService {

    @Autowired
    private BannerConfigEntityMapper bannerConfigEntityMapper;


    @Override
    public IBaseDao getMapper() {
        return bannerConfigEntityMapper;
    }

    @Override
    public List<BannerConfigEntity> getBannerConfigByConfition(BannerConfigEntity entity) {
        return bannerConfigEntityMapper.selectByCondition(entity);
    }

    @Override
    public List<bannerR> selectItem(Map map) {
        return bannerConfigEntityMapper.selectItem(map);
    }

    @Override
    public int getCountbanner() {
        return bannerConfigEntityMapper.getCountbanner();
    }

    @Override
    public int delectOneBanprom(Integer id) {
        return bannerConfigEntityMapper.delectOneBanprom(id);
    }
}

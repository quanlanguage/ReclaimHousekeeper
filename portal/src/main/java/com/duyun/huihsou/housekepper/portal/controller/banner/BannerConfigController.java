package com.duyun.huihsou.housekepper.portal.controller.banner;

import com.duyun.huihsou.housekepper.portal.inteceptor.VisitorAccessible;
import com.duyun.huihsou.housekepper.portal.service.banner.BannerConfigService;
import com.duyun.huihsou.housekepper.portal.vo.BannerConfigVO;
import com.duyun.huishou.housekeeper.ApiResponse;
import com.duyun.huishou.housekeeper.constants.RetCode;
import com.duyun.huishou.housekeeper.po.BannerConfigEntity;
import com.duyun.huishou.housekeeper.po.CategoryEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haoshijing
 * @version 2018年05月08日 21:13
 **/
@RestController
@RequestMapping("/h5/api/banner")
public class BannerConfigController {

    @Autowired
    private BannerConfigService bannerConfigService;

    @VisitorAccessible
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces="application/json")
    public ApiResponse<List<CategoryEntity>> getList(@RequestBody BannerConfigEntity entity) {
        if (entity.getChannel()==null) {
            return  new ApiResponse(RetCode.ERROR_PARAMS, "必填参数不能为空！");
        }
        List<BannerConfigEntity> listEntity = bannerConfigService.getBannerConfigByConfition(entity);
        List<BannerConfigVO> list = new ArrayList<>();
        listEntity.forEach(obj->{
            BannerConfigVO vo = new BannerConfigVO();
            BeanUtils.copyProperties(obj,vo);
            list.add(vo);
        });
        return new ApiResponse(list);
    }
}

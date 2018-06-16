package com.duyun.huihsou.housekepper.portal.controller.goods;

import com.duyun.huihsou.housekepper.portal.inteceptor.VisitorAccessible;
import com.duyun.huihsou.housekepper.portal.service.goods.GoodsService;
import com.duyun.huishou.housekeeper.ApiResponse;
import com.duyun.huishou.housekeeper.po.ItemSkuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haoshijing
 * @version 2018年05月08日 21:13
 **/
@RestController
@RequestMapping("/h5/api/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @VisitorAccessible
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces="application/json")
    public ApiResponse<Boolean> save(@RequestBody ItemSkuEntity itemSkuEntity) {
        return new ApiResponse(goodsService.save(itemSkuEntity));
    }
}

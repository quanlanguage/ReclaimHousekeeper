package com.duyun.huihsou.housekepper.admin.controller.order;

import com.duyun.huihsou.housekepper.admin.gloabal.GlobalHolder;
import com.duyun.huihsou.housekepper.admin.service.order.OrderService;
import com.duyun.huihsou.housekepper.admin.vo.OrderVO;
import com.duyun.huishou.housekeeper.ApiResponse;
import com.duyun.huishou.housekeeper.po.OrderEntity;
import com.duyun.huishou.housekeeper.po.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author haoshijing
 * @version 2018年05月08日 21:13
 **/
@RestController
@RequestMapping("/h5/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces="application/json")
    public ApiResponse<Boolean> save(@RequestBody OrderEntity orderEntity) {
        UserEntity entity = GlobalHolder.getCurrentLoginUser();
        orderEntity.setUserId(entity.getId());
        if (orderEntity.getId() == null) {
            orderEntity.setInsertTime(System.currentTimeMillis());
            orderEntity.setLastUpdateTime(System.currentTimeMillis());
            orderService.insert(orderEntity);
        } else {
            orderEntity.setLastUpdateTime(System.currentTimeMillis());
            orderService.updateByPrimaryKeySelective(orderEntity);
        }
        return new ApiResponse();
    }

    @RequestMapping(value = "/getorder", method = RequestMethod.POST, produces="application/json")
    public ApiResponse<List<OrderVO>> getOrder(@RequestBody OrderEntity orderEntity) {
        UserEntity entity = GlobalHolder.getCurrentLoginUser();

        List<OrderVO> list = orderService.getOrderInfo(entity.getId(), orderEntity.getOrderStatus());
        return new ApiResponse<>(list);
    }
}

package com.duyun.huihsou.housekepper.portal.service.order;

import com.duyun.huihsou.housekepper.portal.vo.OrderVO;
import com.duyun.huihsou.housekepper.portal.service.IBaseService;
import com.duyun.huishou.housekeeper.po.OrderEntity;

import java.util.List;

public interface OrderService extends IBaseService<OrderEntity> {
    List<OrderVO> getOrderInfo(Integer id, Integer orderStatus);
}

package com.duyun.huihsou.housekepper.pc.service.order;

import com.duyun.huihsou.housekepper.pc.service.IBaseService;
import com.duyun.huihsou.housekepper.pc.vo.OrderVO;
import com.duyun.huishou.housekeeper.po.OrderEntity;

import java.util.List;

public interface OrderService extends IBaseService<OrderEntity> {
    List<OrderVO> getOrderInfo(Integer userId, Integer orderStatus);
}

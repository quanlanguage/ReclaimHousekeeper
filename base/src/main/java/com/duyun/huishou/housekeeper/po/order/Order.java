package com.duyun.huishou.housekeeper.po.order;

import lombok.Data;

/**
 * @author haoshijing
 * @version 2018年05月08日 20:46
 **/
@Data
public class Order {
    private Integer id;
    private String selfOrderId;
    private Integer userId;
    private Integer status;
    private Integer money;
    private Long createTime;
    private Long lastUpdateTime;
    private Integer shopId;
    private String subOrderId;
}

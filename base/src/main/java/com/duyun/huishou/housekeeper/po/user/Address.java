package com.duyun.huishou.housekeeper.po.user;

import lombok.Data;

/**
 * @author haoshijing
 * @version 2018年05月19日 12:37
 **/
@Data
public class Address {
    private Integer id;
    private Integer userId;
    private String address;
    private Integer status;
    private Long insertTime;
    private Long lastUpdateTime;
}

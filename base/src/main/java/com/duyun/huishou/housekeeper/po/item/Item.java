package com.duyun.huishou.housekeeper.po.item;

import lombok.Data;

/**
 * @author haoshijing
 * @version 2018年05月08日 21:06
 **/
@Data
public class Item {
    private Integer id;
    private String name;
    private Integer categoryId;
    private Long createTime;
    private Long lastUpdateTime;
    private Integer status;
}

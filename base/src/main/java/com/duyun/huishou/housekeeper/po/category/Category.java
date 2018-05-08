package com.duyun.huishou.housekeeper.po.category;

import lombok.Data;

/**
 * @author haoshijing
 * @version 2018年05月08日 20:43
 **/
@Data
public class Category {
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 上级类目id
     */
    private Integer parentId;

    /**
     * 创建时间
     */
    private Long createTime;
}

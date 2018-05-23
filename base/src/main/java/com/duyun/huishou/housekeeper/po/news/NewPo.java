package com.duyun.huishou.housekeeper.po.news;

import lombok.Data;

/**
 * @author haoshijing
 * @version 2018年05月23日 22:06
 **/
@Data
public class NewPo {
    private Integer id;
    private String title;
    private String content;
    private Long insertTime;
    private Long lastUpdateTime;
    private Integer isTop;
}

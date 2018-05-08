package com.duyun.huishou.housekeeper.po.cash;

import lombok.Data;

/**
 * 提现记录表
 * @author haoshijing
 * @version 2018年05月08日 21:07
 **/
@Data
public class CashLog {

    private Integer id;
    private Integer userId;
    /**
     * 提现金额
     */
    private Integer money;

    /**
     * 提现交易id
     */
    private String txCashId;

    private Integer status;
    private Long createTime;
    private Long lastUpdateTime;
}

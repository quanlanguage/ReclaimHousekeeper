package com.duyun.huihsou.housekepper.portal.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResData {
    private String openId;
    private String unionId;
    private String sessionKey;
    /**
     * 客户端校验key
     */
    private String ticket;
    /**
     * 附加消息
     */
    private String message;
}

package com.duyun.huihsou.housekepper.pc.vo;

import java.io.Serializable;

public class CheckAccessVO implements Serializable {

    private String ticket;

    private String openId;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
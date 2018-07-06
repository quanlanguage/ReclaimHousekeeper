package com.duyun.huihsou.housekepper.pc.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class OrderVO implements Serializable {

    private Integer userId;

    private Integer orderStatus;

    private String categoryName;

    private List<String> attributeDetailList;

    private BigDecimal price;

    private Long lastUpdateTime;

    private OrderVO orderVO;

    public OrderVO getOrderVO() {
        return orderVO;
    }

    public OrderVO setOrderVO(OrderVO orderVO) {
        this.orderVO = orderVO;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public OrderVO setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public OrderVO setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public OrderVO setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public List<String> getAttributeDetailList() {
        return attributeDetailList;
    }

    public OrderVO setAttributeDetailList(List<String> attributeDetailList) {
        this.attributeDetailList = attributeDetailList;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderVO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public OrderVO setLastUpdateTime(Long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }
}

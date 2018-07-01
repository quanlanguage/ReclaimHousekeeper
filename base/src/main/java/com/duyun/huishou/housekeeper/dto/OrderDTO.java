package com.duyun.huishou.housekeeper.dto;

import java.math.BigDecimal;

public class OrderDTO{


    private Integer orderId;
    private Integer userId;

    private Integer orderStatus;

    private String categoryName;

    private String attributeDetails;

    private BigDecimal price;

    private Long lastUpdateTime;

    public Integer getUserId() {
        return userId;
    }

    public OrderDTO setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public OrderDTO setOrderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public OrderDTO setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public OrderDTO setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public String getAttributeDetails() {
        return attributeDetails;
    }

    public OrderDTO setAttributeDetails(String attributeDetails) {
        this.attributeDetails = attributeDetails;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public OrderDTO setLastUpdateTime(Long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }
}
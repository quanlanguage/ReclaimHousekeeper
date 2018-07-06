package com.duyun.huihsou.housekepper.pc.vo;

import java.util.List;

public class AttributeInfoVO {
    private Integer id;

    private Integer categoryId;

    private Integer parentId;

    private String attributeName;

    private List<AttributeDetailVO> attributeDetailVOList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public List<AttributeDetailVO> getAttributeDetailVOList() {
        return attributeDetailVOList;
    }

    public void setAttributeDetailVOList(List<AttributeDetailVO> attributeDetailVOList) {
        this.attributeDetailVOList = attributeDetailVOList;
    }
}

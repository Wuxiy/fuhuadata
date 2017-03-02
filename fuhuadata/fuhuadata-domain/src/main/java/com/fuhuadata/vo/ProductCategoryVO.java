package com.fuhuadata.vo;

/**
 * 产品目录view
 * Created by intanswer on 2017/2/22.
 */
public class ProductCategoryVO {
    private Integer parentId;
    private String parent;//父节点
    private Integer middleId;
    private String middle;//中间节点
    private Integer smallId;
    private String child;//子节点


    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }


    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getMiddleId() {
        return middleId;
    }

    public void setMiddleId(Integer middleId) {
        this.middleId = middleId;
    }

    public Integer getSmallId() {
        return smallId;
    }

    public void setSmallId(Integer smallId) {
        this.smallId = smallId;
    }
}

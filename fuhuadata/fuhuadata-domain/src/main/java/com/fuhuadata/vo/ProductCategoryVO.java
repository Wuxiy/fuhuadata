package com.fuhuadata.vo;

/**
 * 产品目录view
 * Created by intanswer on 2017/2/22.
 */
public class ProductCategoryVO {
    private Integer id;
    private String parent;//父节点
    private String middle;//中间节点
    private String child;//子节点

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}

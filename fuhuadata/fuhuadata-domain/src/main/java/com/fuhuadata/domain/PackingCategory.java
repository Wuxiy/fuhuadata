package com.fuhuadata.domain;

/**
 * 包材树
 * Created by intanswer on 2017/2/23.
 */
public class PackingCategory {
    private Integer categoryId;

    private Integer parentId;//父节点

    private String categoryName;//目录名


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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}

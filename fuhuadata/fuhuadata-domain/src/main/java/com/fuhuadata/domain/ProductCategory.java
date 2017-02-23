package com.fuhuadata.domain;

/**
 * 产品分类树
 * Created by intanswer on 2017/2/22.
 */

public class ProductCategory {

    private Integer id;//分类id

    private Integer parentId;//父级id，当前分类已经是最大级别时改字段为0

    private String name;//分类名称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

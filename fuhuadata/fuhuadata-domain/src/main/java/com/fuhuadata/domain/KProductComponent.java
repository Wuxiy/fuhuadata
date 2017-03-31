package com.fuhuadata.domain;

/**
 * 成分产品
 * Created by intanswer on 2017/3/31.
 */
public class KProductComponent {
    private Integer id;//主键id

    private Integer componentId;//成分id

    private String consumption;//单耗

    private Integer productCategoryId;//产品分类id

    private String categoryFullName;//产品分类全路径

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
    }

    public String getConsumption() {
        return consumption;
    }

    public void setConsumption(String consumption) {
        this.consumption = consumption;
    }


    public String getCategoryFullName() {
        return categoryFullName;
    }

    public void setCategoryFullName(String categoryFullName) {
        this.categoryFullName = categoryFullName;
    }

    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }
}

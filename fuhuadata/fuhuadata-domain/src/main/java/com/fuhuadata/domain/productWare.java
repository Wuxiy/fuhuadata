package com.fuhuadata.domain;

/**
 * 产品规格型号
 * Created by intanswer on 2017/2/22.
 */
public class productWare {
    private Integer wareId;//产品规格型号id

    private Integer productInfoId;//产品id

    private String specification;//规格

    private String model;//型号

    public productWare() {
    }

    public Integer getWareId() {
        return wareId;
    }

    public void setWareId(Integer wareId) {
        this.wareId = wareId;
    }

    public Integer getProductInfoId() {
        return productInfoId;
    }

    public void setProductInfoId(Integer productInfoId) {
        this.productInfoId = productInfoId;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

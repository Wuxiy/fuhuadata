package com.fuhuadata.domain;

import java.math.BigDecimal;

/**
 * 产品规格型号
 * Created by intanswer on 2017/2/22.
 */
public class ProductWare {
    private Integer wareId;//产品规格型号id

    private Integer productInfoId;//产品id

    private String specification;//规格

    private String model;//型号

    private String ncId;//nc产品主键

    private String code;//nc产品编码

    private String customsClearanceId;//报关产品编码

    private String customsClearanceName;//报关产品名称

    private BigDecimal risetaxes;//增值税税率


    public ProductWare() {
    }

    public String getNcId() {
        return ncId;
    }

    public void setNcId(String ncId) {
        this.ncId = ncId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCustomsClearanceId() {
        return customsClearanceId;
    }

    public void setCustomsClearanceId(String customsClearanceId) {
        this.customsClearanceId = customsClearanceId;
    }

    public String getCustomsClearanceName() {
        return customsClearanceName;
    }

    public void setCustomsClearanceName(String customsClearanceName) {
        this.customsClearanceName = customsClearanceName;
    }

    public BigDecimal getRisetaxes() {
        return risetaxes;
    }

    public void setRisetaxes(BigDecimal risetaxes) {
        this.risetaxes = risetaxes;
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

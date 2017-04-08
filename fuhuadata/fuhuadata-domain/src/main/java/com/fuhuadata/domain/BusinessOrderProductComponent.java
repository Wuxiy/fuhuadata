package com.fuhuadata.domain;

import java.math.BigDecimal;

public class BusinessOrderProductComponent {
    private Integer id;

    private Integer businessProductId;

    private Integer productId;

    private Integer wareId;

    private Integer componentId;

    private String componentName;

    private BigDecimal consumption;

    private BigDecimal price;

    private BigDecimal cost;

    private String remark;

    public Integer getWareId() {
        return wareId;
    }

    public void setWareId(Integer wareId) {
        this.wareId = wareId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBusinessProductId() {
        return businessProductId;
    }

    public void setBusinessProductId(Integer businessProductId) {
        this.businessProductId = businessProductId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public BigDecimal getConsumption() {
        return consumption;
    }

    public void setConsumption(BigDecimal consumption) {
        this.consumption = consumption;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
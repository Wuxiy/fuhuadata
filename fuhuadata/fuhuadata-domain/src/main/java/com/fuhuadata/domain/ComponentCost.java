package com.fuhuadata.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.List;

/**
 * 成分价格
 * Created by intanswer on 2017/1/17.
 */
public class ComponentCost {

    private Integer costId;

    private Integer componentId;

    private String componentName;//成分名称

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date priceEnd;//价格有效期

    private String unitCost;//单价

    private String consumption;//单耗

    private Integer productCategoryId;//产品第三层分类目录id

    private String suitableProduct;//适用产品

    private String remarks;//备注

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

    public String getConsumption() {
        return consumption;
    }

    public void setConsumption(String consumption) {
        this.consumption = consumption == null ? null : consumption.trim();
    }

    public String getSuitableProduct() {
        return suitableProduct;
    }

    public void setSuitableProduct(String suitableProduct) {
        this.suitableProduct = suitableProduct;
    }

    public Date getPriceEnd() {
        return priceEnd;
    }

    public void setPriceEnd(Date priceEnd) {
        this.priceEnd = priceEnd;
    }

    public String getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(String unitCost) {
        this.unitCost = unitCost;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Integer getCostId() {
        return costId;
    }

    public void setCostId(Integer costId) {
        this.costId = costId;
    }

    public static class ComponentCostWrapper {

        private List<ComponentCost> componentCosts;

        public List<ComponentCost> getComponentCosts() {
            return componentCosts;
        }

        public void setComponentCosts(List<ComponentCost> componentCosts) {
            this.componentCosts = componentCosts;
        }
    }
}

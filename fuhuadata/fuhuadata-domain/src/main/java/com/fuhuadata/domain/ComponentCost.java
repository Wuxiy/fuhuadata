package com.fuhuadata.domain;

import com.fuhuadata.util.DateJsonDeserializer;
import com.fuhuadata.util.DateJsonSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

/**
 * 成分价格
 * Created by intanswer on 2017/1/17.
 */
public class ComponentCost {
    private Integer componentId;

    private String componentName;//成分名称

    private Date priceEnd;//价格有效期

    private String unitCost;//单价

    private String consumption;//单耗

    private String suitableProduct;//试用产品

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

    @JsonSerialize(using= DateJsonSerializer.class)
    public Date getPriceEnd() {
        return priceEnd;
    }

    @JsonDeserialize(using= DateJsonDeserializer.class)
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
}

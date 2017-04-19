package com.fuhuadata.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 添加订单产品时根据产品及其规格查询产品基本信息返回实体
 * Created by hexingfu on 2017/4/11.
 */
public class ProductWareVo implements Serializable{

    private Integer productId;
    /**产品规格id**/
    private Integer wareId;
    /**报关产品编码**/
    private String customsClearanceId;
    /**报关产品名称**/
    private String customsClearanceName;
    //规格
    private String specification;
    //型号
    private String model;
    //主计量单位
    private String measurement;
    //单位耗用比例
    private BigDecimal unitUseRate;

    public BigDecimal getUnitUseRate() {
        return unitUseRate;
    }

    public void setUnitUseRate(BigDecimal unitUseRate) {
        this.unitUseRate = unitUseRate;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getWareId() {
        return wareId;
    }

    public void setWareId(Integer wareId) {
        this.wareId = wareId;
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

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }
}

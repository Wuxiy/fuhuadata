package com.fuhuadata.domain.task;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 同步product_ware
 * Created by hexingfu on 2017/5/9.
 */
public class SyncWare implements Serializable
{
    private Integer wareId;
    private Integer productInfoId;
    private String ncId;
    private String code;
    //报关产品编码
    private String customsClearanceId;
    //customs_clearance_name
    private String customsClearanceName;
    //增值税税率
    private BigDecimal risetaxes;
    //出口退税率
    private BigDecimal exportaxesback;
    //规格
    private String specification;
    //型号
    private String model;
    //单位耗用比例
    private BigDecimal unitUseRate;

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

    public BigDecimal getExportaxesback() {
        return exportaxesback;
    }

    public void setExportaxesback(BigDecimal exportaxesback) {
        this.exportaxesback = exportaxesback;
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

    public BigDecimal getUnitUseRate() {
        return unitUseRate;
    }

    public void setUnitUseRate(BigDecimal unitUseRate) {
        this.unitUseRate = unitUseRate;
    }
}

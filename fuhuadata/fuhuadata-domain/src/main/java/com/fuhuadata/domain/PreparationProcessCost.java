package com.fuhuadata.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 制剂加工成本
 * Created by intanswer on 2017/1/17.
 */
public class PreparationProcessCost {
    private Integer mcostId;

    private Integer type;//人工费或者杂费（0：人工费，1：杂费）

    private String costTerm;//主材规格

    private String unitCost;//单价

    private Date priceEnd;//价格有效期

    private String processFactory;//加工厂

    private BigDecimal charges;//水电气费

    private BigDecimal profit; //利润

    private BigDecimal managementFee;//管理费

    private BigDecimal tax;//税金

    private BigDecimal totalCost;  //费用合计

    private String remarks;//备注

    public PreparationProcessCost() {
    }


    public Integer getMcostId() {
        return mcostId;
    }

    public void setMcostId(Integer mcostId) {
        this.mcostId = mcostId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCostTerm() {
        return costTerm;
    }

    public void setCostTerm(String costTerm) {
        this.costTerm = costTerm;
    }

    public String getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(String unitCost) {
        this.unitCost = unitCost;
    }

    public Date getPriceEnd() {
        return priceEnd;
    }

    public void setPriceEnd(Date priceEnd) {
        this.priceEnd = priceEnd;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    public BigDecimal getCharges() {
        return charges;
    }

    public void setCharges(BigDecimal charges) {
        this.charges = charges;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public BigDecimal getManagementFee() {
        return managementFee;
    }

    public void setManagementFee(BigDecimal managementFee) {
        this.managementFee = managementFee;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public String getProcessFactory() {
        return processFactory;
    }

    public void setProcessFactory(String processFactory) {
        this.processFactory = processFactory;
    }
}

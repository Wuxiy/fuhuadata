package com.fuhuadata.domain.query;


import java.math.BigDecimal;
import java.sql.Date;

/**
 * 制剂加工成本
 * Created by intanswer on 2017/1/17.
 */
public class PreparationProcessCostQuery extends PageBase {

    private Integer mcostId;

    private Integer type;//水剂颗粒剂类型

    private String costTerm;//瓶型或费用型

    private String unitCost;//单价

    private Date priceEnd;//价格有效期

    private BigDecimal processFactory;//加工产

    private BigDecimal charges;//水电气费

    private BigDecimal profit; //利润

    private BigDecimal managementFee;//管理费

    private BigDecimal tax;//税金

    private BigDecimal totalCost;  //费用合计

    private String remarks;//备注

    private String searchKey;

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

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public BigDecimal getProcessFactory() {
        return processFactory;
    }

    public void setProcessFactory(BigDecimal processFactory) {
        this.processFactory = processFactory;
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
}

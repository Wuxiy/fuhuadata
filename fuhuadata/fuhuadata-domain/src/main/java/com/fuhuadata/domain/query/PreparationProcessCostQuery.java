package com.fuhuadata.domain.query;

import com.fuhuadata.domain.query.PageBase;

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
}

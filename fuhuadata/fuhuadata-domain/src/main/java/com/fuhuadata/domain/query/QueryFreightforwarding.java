package com.fuhuadata.domain.query;

import java.math.BigDecimal;

/**
 * @author wangbo
 * @date 2017-01-16 15:25:40
 */
public class QueryFreightforwarding extends PageBase {

    /**
     * 仓库id
     */
    private Integer warehouseId;

    /**
     * 采购方案编号
     */
    private String purchasePlanCode;

    /**
     * 项目名称
     */
    private String entryName;

    /**
     * 竞标价格
     */
    private BigDecimal bidPrice;

    /**
     * 项目竞标最低价格
     */
    private BigDecimal lowestBidPrice;

    /**
     * 是否中标
     */
    private Integer isBid;

    /**
     * 是否接受调价
     */
    private Integer isModifyPrice;

    /**
     * 是否恶意竞标
     */
    private Integer maliciousBid;

    public String getPurchasePlanCode() {
        return purchasePlanCode;
    }

    public void setPurchasePlanCode(String purchasePlanCode) {
        this.purchasePlanCode = purchasePlanCode;
    }

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public BigDecimal getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(BigDecimal bidPrice) {
        this.bidPrice = bidPrice;
    }

    public BigDecimal getLowestBidPrice() {
        return lowestBidPrice;
    }

    public void setLowestBidPrice(BigDecimal lowestBidPrice) {
        this.lowestBidPrice = lowestBidPrice;
    }

    public Integer getIsBid() {
        return isBid;
    }

    public void setIsBid(Integer isBid) {
        this.isBid = isBid;
    }

    public Integer getIsModifyPrice() {
        return isModifyPrice;
    }

    public void setIsModifyPrice(Integer isModifyPrice) {
        this.isModifyPrice = isModifyPrice;
    }

    public Integer getMaliciousBid() {
        return maliciousBid;
    }

    public void setMaliciousBid(Integer maliciousBid) {
        this.maliciousBid = maliciousBid;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }
}
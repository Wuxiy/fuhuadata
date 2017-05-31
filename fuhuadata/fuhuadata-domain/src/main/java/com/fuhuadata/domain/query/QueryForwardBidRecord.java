package com.fuhuadata.domain.query;

/**
 *  竞标记录
 * Created by wuxiy on 2017/5/26.
 */
public class QueryForwardBidRecord extends PageBase {
    /**
     * 货代id
     */
    private Integer freightforwardingId;

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
     * 是否中标
     */
    private Integer isBid;

    /**
     * 是否恶意竞标
     */
    private Integer maliciousBid;

    /**
     * 是否接受调价
     */
    private Integer isModifyPrice;

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

    public Integer getIsBid() {
        return isBid;
    }

    public void setIsBid(Integer isBid) {
        this.isBid = isBid;
    }

    public Integer getMaliciousBid() {
        return maliciousBid;
    }

    public void setMaliciousBid(Integer maliciousBid) {
        this.maliciousBid = maliciousBid;
    }

    public Integer getIsModifyPrice() {
        return isModifyPrice;
    }

    public void setIsModifyPrice(Integer isModifyPrice) {
        this.isModifyPrice = isModifyPrice;
    }

    public Integer getFreightforwardingId() {
        return freightforwardingId;
    }

    public void setFreightforwardingId(Integer freightforwardingId) {
        this.freightforwardingId = freightforwardingId;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }
}

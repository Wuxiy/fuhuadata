package com.fuhuadata.domain.query;

/**
 * 货代订单记录
 * Created by wuxiy on 2017/5/26.
 */
public class QueryForwardingOrderRecord extends PageBase {

    /**
     * 货代物流id
     */
    private Integer freightforwardingId;

    /**
     * 仓库id
     */
    private Integer warehouseId;

    /**
     * 进仓编号
     */
    private String entryCode;

    /**
     * 货代名称
     */
    private String forwardingName;

    /**
     * 对应外销合同号
     */
    private String exportContractNumber;

    /**
     * 仓库name
     */
    private String  warehouseName;

    public String getEntryCode() {
        return entryCode;
    }

    public void setEntryCode(String entryCode) {
        this.entryCode = entryCode;
    }

    public String getForwardingName() {
        return forwardingName;
    }

    public void setForwardingName(String forwardingName) {
        this.forwardingName = forwardingName;
    }

    public String getExportContractNumber() {
        return exportContractNumber;
    }

    public void setExportContractNumber(String exportContractNumber) {
        this.exportContractNumber = exportContractNumber;
    }

    public Integer getFreightforwardingId() {
        return freightforwardingId;
    }

    public void setFreightforwardingId(Integer freightforwardingId) {
        this.freightforwardingId = freightforwardingId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }
}

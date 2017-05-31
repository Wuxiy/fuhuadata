package com.fuhuadata.domain.query;

import java.util.Date;

/**
 *  订单投诉记录
 * Created by wuxiy on 2017/5/26.
 */
public class QueryForwardingComplaintsRecord extends PageBase {

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
     * 投诉日期开始
     */
    private Date complaintDateStart;

    /**
     * 投诉日期结束
     */
    private Date complaintDateEnd;

    /**
     * 客户
     */
    private String customerName;

    /**
     * 产品名称
     */
    private String productName;

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

    public String getEntryCode() {
        return entryCode;
    }

    public void setEntryCode(String entryCode) {
        this.entryCode = entryCode;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getComplaintDateStart() {
        return complaintDateStart;
    }

    public void setComplaintDateStart(Date complaintDateStart) {
        this.complaintDateStart = complaintDateStart;
    }

    public Date getComplaintDateEnd() {
        return complaintDateEnd;
    }

    public void setComplaintDateEnd(Date complaintDateEnd) {
        this.complaintDateEnd = complaintDateEnd;
    }
}

package com.fuhuadata.domain.query;

/**
 * Created by hexingfu on 2017/3/18.
 */
public class QueryBusinessOrder {
    private String saleOrganizationId;//销售组织id
    private String ncOrderId;//nc系统合同号
    private String startTime;//查询合同签定时间开始范围
    private String endTime;//查询合同签定时间结束范围
    private Integer startRow;//分页起始行标
    private Integer pageSize;//分页步长

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSaleOrganizationId() {
        return saleOrganizationId;
    }

    public void setSaleOrganizationId(String saleOrganizationId) {
        this.saleOrganizationId = saleOrganizationId;
    }

    public String getNcOrderId() {
        return ncOrderId;
    }

    public void setNcOrderId(String ncOrderId) {
        this.ncOrderId = ncOrderId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}

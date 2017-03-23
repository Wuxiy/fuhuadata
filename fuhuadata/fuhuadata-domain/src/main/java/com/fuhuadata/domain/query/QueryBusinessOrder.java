package com.fuhuadata.domain.query;

/**
 * Created by hexingfu on 2017/3/18.
 */
public class QueryBusinessOrder {
    private String customerId;//客户id
    private String saleOrganizationId;//销售组织id
    private String ncOrderId;//nc系统合同号
    private String startTime;//查询合同签定时间开始范围
    private String endTime;//查询合同签定时间结束范围
    private Integer startRow;//分页起始行标
    private Integer pageSize;//分页步长
    private String orderBy;//排序
    private String sortFiled;//排序字段
    private int sortType;//排序方向，0：正序 1：倒序
    //订单状态  订单状态：-2：报价失败，-1：订单取消  0：报价中 1：已转化成订单 2：数据已上报到NC，3：已签约
    private String status;
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderBy() {
        if(sortFiled!=null && !sortFiled.equals("")){
            return sortFiled + (sortType==0 ? "asc" : "desc");
        }
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getSortFiled() {
        return sortFiled;
    }

    public void setSortFiled(String sortFiled) {
        this.sortFiled = sortFiled;
    }

    public int getSortType() {
        return sortType;
    }

    public void setSortType(int sortType) {
        this.sortType = sortType;
    }

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

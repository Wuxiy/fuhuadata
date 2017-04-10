package com.fuhuadata.domain.query;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by hexingfu on 2017/3/18.
 */
public class QueryBusinessOrder {

    /**地区id**/
    private String areaId;
    /**大区分类id**/
    private String areaClassId;
    private String orderId;//订单编号
    private String businessId;//商机编号
    private String customerId;//客户id
    private String customerName;//客户名称
    private Integer customerLevel;//客户类型
    private String enterpriseNature;//企业性质
    private String orderProduct;//订单产品
    private BigDecimal amountPayable;//合同总价
    private BigDecimal floorPrice;//合同成本价
    private String saleOrganizationId;//销售组织id
    private String saleOrganizationName;//销售组织name
    private String ncOrderId;//nc系统合同号
    private String country;//国家
    private Integer isComplaint;//是否投诉
    @JsonFormat(pattern = "yyyy-MM-DD")
    private Date dealTime;//合同时间
    private Integer isModifyPrice;//是否调价
    private BigDecimal netProfit;//利润

    private String salesManId;
    private String salesManName;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(Integer customerLevel) {
        this.customerLevel = customerLevel;
    }

    public String getEnterpriseNature() {
        return enterpriseNature;
    }

    public void setEnterpriseNature(String enterpriseNature) {
        this.enterpriseNature = enterpriseNature;
    }

    public String getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(String orderProduct) {
        this.orderProduct = orderProduct;
    }

    public BigDecimal getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(BigDecimal amountPayable) {
        this.amountPayable = amountPayable;
    }

    public BigDecimal getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(BigDecimal floorPrice) {
        this.floorPrice = floorPrice;
    }

    public String getSaleOrganizationName() {
        return saleOrganizationName;
    }

    public void setSaleOrganizationName(String saleOrganizationName) {
        this.saleOrganizationName = saleOrganizationName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public Integer getIsComplaint() {
        return isComplaint;
    }

    public void setIsComplaint(Integer isComplaint) {
        this.isComplaint = isComplaint;
    }

    public Integer getIsModifyPrice() {
        return isModifyPrice;
    }

    public void setIsModifyPrice(Integer isModifyPrice) {
        this.isModifyPrice = isModifyPrice;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaClassId() {
        return areaClassId;
    }

    public void setAreaClassId(String areaClassId) {
        this.areaClassId = areaClassId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public BigDecimal getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(BigDecimal netProfit) {
        this.netProfit = netProfit;
    }

    public String getSalesManId() {
        return salesManId;
    }

    public void setSalesManId(String salesManId) {
        this.salesManId = salesManId;
    }

    public String getSalesManName() {
        return salesManName;
    }

    public void setSalesManName(String salesManName) {
        this.salesManName = salesManName;
    }
}

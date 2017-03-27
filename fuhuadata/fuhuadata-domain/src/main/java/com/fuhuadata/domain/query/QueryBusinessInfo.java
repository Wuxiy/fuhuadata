package com.fuhuadata.domain.query;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by intanswer on 2017/3/24.
 */
public class QueryBusinessInfo {

    private int startRow;
    private int pageSize;

    private String businessId;//商机id

    private String customerId;//客户id

    private String businessName;//商机名称

    private String customerName;//客户名称

    private Integer businessFrom;//商机来源

    private Integer businessState;//商机状态

    private BigDecimal expectIncome;//预计收益

    private Date deadline;//预计截止时间

    private String intentionalProducts;//意向产品及购买

    private String businessDescribe;//商机描述

    private String businessRemarks;//商机备注

    private String failReason;//失败原因

    private Integer createUserId;//创建者id

    private String createUserName;//创建者姓名

    private Integer lastmodifyUserId;//上一次修改者id

    private String lastmodifyUserName;//上一次修改者姓名

    private Date createTime;//创建时间

    private Date modifyTime;//修改时间

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getBusinessFrom() {
        return businessFrom;
    }

    public void setBusinessFrom(Integer businessFrom) {
        this.businessFrom = businessFrom;
    }

    public Integer getBusinessState() {
        return businessState;
    }

    public void setBusinessState(Integer businessState) {
        this.businessState = businessState;
    }

    public BigDecimal getExpectIncome() {
        return expectIncome;
    }

    public void setExpectIncome(BigDecimal expectIncome) {
        this.expectIncome = expectIncome;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getIntentionalProducts() {
        return intentionalProducts;
    }

    public void setIntentionalProducts(String intentionalProducts) {
        this.intentionalProducts = intentionalProducts;
    }

    public String getBusinessDescribe() {
        return businessDescribe;
    }

    public void setBusinessDescribe(String businessDescribe) {
        this.businessDescribe = businessDescribe;
    }

    public String getBusinessRemarks() {
        return businessRemarks;
    }

    public void setBusinessRemarks(String businessRemarks) {
        this.businessRemarks = businessRemarks;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Integer getLastmodifyUserId() {
        return lastmodifyUserId;
    }

    public void setLastmodifyUserId(Integer lastmodifyUserId) {
        this.lastmodifyUserId = lastmodifyUserId;
    }

    public String getLastmodifyUserName() {
        return lastmodifyUserName;
    }

    public void setLastmodifyUserName(String lastmodifyUserName) {
        this.lastmodifyUserName = lastmodifyUserName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}

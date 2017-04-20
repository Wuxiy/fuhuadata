package com.fuhuadata.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商机信息
 * Created by intanswer on 2017/3/24.
 */
public class BusinessInfo {

    private String businessId;//商机id

    private String customerId;//客户id

    private String businessName;//商机名称

    private String customerName;//客户名称

    private String customerDutyParagraph;//客户税号

    private String enterprisePhone;//企业电话

    private String enterpriseEmail;//企业邮箱

    private String otherEnterpriseNature;//其他企业性质

    private String  zhongxinbaoNumber;//中信保编号

    private String registeredFunds;//注册资金

    private String  enterpriseNature;


    private String  fullEnterpriseNature;

    private Integer  customerLevel;

    private  Integer zhongxinbaoLevel;

    private String country;

    private  String linkmanName;

    private String linkPhone1;

    private String lemail;


    private Integer businessFrom;//商机来源，0展会，1门户网站，2农药店考察，3客户介绍，4主动联系，5其他

    private Integer businessState;//商机状态

    private BigDecimal expectIncome;//预计收益

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date deadline;//预计截止时间

    private String intentionalProducts;//意向产品及购买

    private String businessDescribe;//商机描述

    private String businessRemarks;//商机备注

    private String failReason;//失败原因

    private Integer createUserId;//创建者id

    private String createUserName;//创建者姓名

    private Integer lastmodifyUserId;//上一次修改者id

    private String lastmodifyUserName;//上一次修改者姓名

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;//创建时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;//修改时间

    public String getEnterprisePhone() {
        return enterprisePhone;
    }

    public void setEnterprisePhone(String enterprisePhone) {
        this.enterprisePhone = enterprisePhone;
    }

    public String getEnterpriseEmail() {
        return enterpriseEmail;
    }

    public void setEnterpriseEmail(String enterpriseEmail) {
        this.enterpriseEmail = enterpriseEmail;
    }

    public String getOtherEnterpriseNature() {
        return otherEnterpriseNature;
    }

    public void setOtherEnterpriseNature(String otherEnterpriseNature) {
        this.otherEnterpriseNature = otherEnterpriseNature;
    }

    public String getZhongxinbaoNumber() {
        return zhongxinbaoNumber;
    }

    public void setZhongxinbaoNumber(String zhongxinbaoNumber) {
        this.zhongxinbaoNumber = zhongxinbaoNumber;
    }

    public String getRegisteredFunds() {
        return registeredFunds;
    }

    public void setRegisteredFunds(String registeredFunds) {
        this.registeredFunds = registeredFunds;
    }

    public String getFullEnterpriseNature() {
        return fullEnterpriseNature;
    }

    public void setFullEnterpriseNature(String fullEnterpriseNature) {
        this.fullEnterpriseNature = fullEnterpriseNature;
    }

    public String getEnterpriseNature() {
        return enterpriseNature;
    }

    public void setEnterpriseNature(String enterpriseNature) {
        this.enterpriseNature = enterpriseNature;
    }

    public Integer getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(Integer customerLevel) {
        this.customerLevel = customerLevel;
    }

    public Integer getZhongxinbaoLevel() {
        return zhongxinbaoLevel;
    }

    public void setZhongxinbaoLevel(Integer zhongxinbaoLevel) {
        this.zhongxinbaoLevel = zhongxinbaoLevel;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLinkmanName() {
        return linkmanName;
    }

    public void setLinkmanName(String linkmanName) {
        this.linkmanName = linkmanName;
    }

    public String getLinkPhone1() {
        return linkPhone1;
    }

    public void setLinkPhone1(String linkPhone1) {
        this.linkPhone1 = linkPhone1;
    }

    public String getLemail() {
        return lemail;
    }

    public void setLemail(String lemail) {
        this.lemail = lemail;
    }

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

    public String getCustomerDutyParagraph() {
        return customerDutyParagraph;
    }

    public void setCustomerDutyParagraph(String customerDutyParagraph) {
        this.customerDutyParagraph = customerDutyParagraph;
    }
}

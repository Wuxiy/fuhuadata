package com.fuhuadata.vo;

import java.util.Date;

/**
 * 客户百科view
 * Created by intanswer on 2017/3/13.
 */
public class CustomerEncyVO {
    private String fullName;//企业全称

    private String shortName;//企业简称

    private String companyType;//企业类型

    private String customerArea;//所属片区

    private String country;//国家

    private String enterpriseNature;//企业性质

    private String registeredFund;//注册资金

    private String registeredAddr;//注册地址

    private String managementScope;//经营范围

    private String  encyId;//百科编号

    private String  customerId;

    private String isFull;//完整度

    private Integer createUserId;//创建人id

    private String createUserName;//创建人姓名

    private Date createTime;//创建时间

    private Integer lastmodifyUserId;//最后编辑人id

    private String lastmodifyUserName;//最后编辑人姓名

    private Date modifyTime;//最后编辑时间

    private String customField;//备注

    private String companyInfo;//企业简介

    private String developHis;//企业发展历程

    private String sallNetwork;//销售网络

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getCustomerArea() {
        return customerArea;
    }

    public void setCustomerArea(String customerArea) {
        this.customerArea = customerArea;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEnterpriseNature() {
        return enterpriseNature;
    }

    public void setEnterpriseNature(String enterpriseNature) {
        this.enterpriseNature = enterpriseNature;
    }

    public String getRegisteredAddr() {
        return registeredAddr;
    }

    public void setRegisteredAddr(String registeredAddr) {
        this.registeredAddr = registeredAddr;
    }

    public String getManagementScope() {
        return managementScope;
    }

    public void setManagementScope(String managementScope) {
        this.managementScope = managementScope;
    }

    public String getEncyId() {
        return encyId;
    }

    public void setEncyId(String encyId) {
        this.encyId = encyId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getIsFull() {
        return isFull;
    }

    public void setIsFull(String isFull) {
        this.isFull = isFull;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCustomField() {
        return customField;
    }

    public void setCustomField(String customField) {
        this.customField = customField;
    }

    public String getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    public String getDevelopHis() {
        return developHis;
    }

    public void setDevelopHis(String developHis) {
        this.developHis = developHis;
    }

    public String getSallNetwork() {
        return sallNetwork;
    }

    public void setSallNetwork(String sallNetwork) {
        this.sallNetwork = sallNetwork;
    }

    public String getRegisteredFund() {
        return registeredFund;
    }

    public void setRegisteredFund(String registeredFund) {
        this.registeredFund = registeredFund;
    }
}

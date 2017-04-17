package com.fuhuadata.vo;

/**
 * 表单选客户带出的客户信息（包含默认联系人）
 * Created by intanswer on 2017/4/7.
 */
public class CustomerBaseInfoLinkman {

    private String customerId;

    private String fullName;

    private String shortName;

    private Integer companyType;//企业类别 0：客户，1：竞对

    private String customerAreaId;

    private String customerArea;

    private Integer customerLevel;

    private String enterpriseNature;

    private String country;

    private String linkmanId;

    private String linkmanName;

    private String linkPhone1;

    private String linkPhone2;

    private String lemail;

    private String encyId;//百科id ,用于判断客户有无百科信息

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLinkmanId() {
        return linkmanId;
    }

    public void setLinkmanId(String linkmanId) {
        this.linkmanId = linkmanId;
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

    public String getLinkPhone2() {
        return linkPhone2;
    }

    public void setLinkPhone2(String linkPhone2) {
        this.linkPhone2 = linkPhone2;
    }

    public String getLemail() {
        return lemail;
    }

    public void setLemail(String lemail) {
        this.lemail = lemail;
    }

    public Integer getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
    }

    public String getCustomerAreaId() {
        return customerAreaId;
    }

    public void setCustomerAreaId(String customerAreaId) {
        this.customerAreaId = customerAreaId;
    }

    public String getCustomerArea() {
        return customerArea;
    }

    public void setCustomerArea(String customerArea) {
        this.customerArea = customerArea;
    }

    public String getEncyId() {
        return encyId;
    }

    public void setEncyId(String encyId) {
        this.encyId = encyId;
    }
}

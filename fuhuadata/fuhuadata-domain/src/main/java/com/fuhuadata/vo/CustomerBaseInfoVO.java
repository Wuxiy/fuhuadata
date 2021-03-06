package com.fuhuadata.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fuhuadata.domain.CustomerMakeProduct;

import java.util.Date;
import java.util.List;

/**
 * 客户基本信息view
 * Created by intanswer on 2017/3/14.
 */
public class CustomerBaseInfoVO {

    /**客户信息总id**/
    private String customerId;

    private String ncId;

    /**企业全称**/
    private String fullName;

    /**客户税号**/
    private String customerDutyParagraph;

    /**企业性质 1：工厂 2：分销商 3：经销商 4：终端客户 5：其他**/
    //多选1,2,3
    private String enterpriseNature;

    /**其他企业性质**/
    private String otherEnterpriceNature;

    /**企业简称**/
    private String shortName;

    /**企业类型,-1全部,0客户,1竞对**/
    private Integer companyType;

    /**地区id**/
    private String areaId;

    /**地区分类,例如北美洲**/
    private String area;

//    *国家分类id*
//    private String countryId;
//
//    *国家,例如美国*
//    private String country;

    /**
     * 销售组织id
     */
    private String  saleOrganizationId;
    /**
     * 销售组织
     */
    private String  saleOrganizationName;

    /**注册资金**/
    private String registeredFunds;

    /**注册地址**/
    private String registeredAddress;

    /**经营范围**/
    private String managementScope;

    /**中信保编号**/
    private String zhongxinbaoNumber;

    /**中信保信用评级,0未知,1:1A,2:2A,3:3A,4:4A**/
    private Integer zhongxinbaoLevel;

    /**备注**/
    private String remark;

    /**时区**/
    private String timezone;

    /**客户基本分类**/
    private String custclass;

    /**数据格式**/
    private String formatdoc;

    /**贸易国别**/
    private String countryzone;


    /**时区name**/
    private String timezoneName;

    /**客户基本分类name**/
    private String custclassName;

    /**数据格式name**/
    private String formatdocName;

    /**贸易国别name**/
    private String countryzoneName;

    /*潜在客户机会来源 1:展会，2：门户网站 3：农药店考察 4：客户介绍 5：主动联系 6：其他*/
    private Integer opportunitySource;
    /*其他机会来源*/
    private String otherOpportunity;

    /*机会描述*/
    private String opportunityDescrible;

    /**企业电话**/
    private String enterprisePhone;

    /**企业邮箱**/
    private String enterpriseEmail;

    /**企业信息完成度**/
    private String customerCompletion;

    /**创建者id**/
    private Integer lastmodifyUserId;

    /**1:战略客户,2:大客户 3:重要客户 4:一般客户 5:风险客户**/
    private Integer customerLevel;

    /**客户类型,1:合作 2:潜在 3:流失**/
    private Integer customerType;

    /**是否有中国分公司 0：无 1：有**/
    private  Integer hasChiCompany;

    /**是否有中方采购 0：无 1：有**/
    private  Integer hasChiPurchase;

    /**客户状态  0：流失 1：正常**/
    private Integer customerStatus;

    private String lossReason;

    /**资质文件保存路径**/
    private String qualificationsFileUrl;

    /**创建者姓名**/
    private String lastmodifyUserName;

    /**工厂位置**/
    private String factoryLocation;

    private String productLine;

    /**分销主要竞争对手**/
    private String majorCompetitors;

    /**创建时间**/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;


    /*百科信息*/
    private String encyId;//百科编号

    private String companyInfo;//企业简介

    private String isFull;//完整度

    private String developHis;//企业发展历程

    private String sellNetwork;//销售网络

    private String customField;//自定义信息json串

    private Integer lastmodifyUserIdEn;//最后编辑人id

    private String lastmodifyUserNameEn;//最后编辑人姓名


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTimeEn;//编辑时间

    /*产品产能*/
    private List<CustomerMakeProduct> customerMakeProduct;


    public String getSellNetwork() {
        return sellNetwork;
    }

    public void setSellNetwork(String sellNetwork) {
        this.sellNetwork = sellNetwork;
    }

    public String getDevelopHis() {
        return developHis;
    }

    public void setDevelopHis(String developHis) {
        this.developHis = developHis;
    }

    public String getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    public String getEncyId() {
        return encyId;
    }

    public void setEncyId(String encyId) {
        this.encyId = encyId;
    }


    public String getIsFull() {
        return isFull;
    }

    public void setIsFull(String isFull) {
        this.isFull = isFull;
    }

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

    public Integer getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }


    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRegisteredFunds() {
        return registeredFunds;
    }

    public void setRegisteredFunds(String registeredFunds) {
        this.registeredFunds = registeredFunds;
    }

    public String getRegisteredAddress() {
        return registeredAddress;
    }

    public void setRegisteredAddress(String registeredAddress) {
        this.registeredAddress = registeredAddress;
    }

    public String getManagementScope() {
        return managementScope;
    }

    public void setManagementScope(String managementScope) {
        this.managementScope = managementScope;
    }

    public String getZhongxinbaoNumber() {
        return zhongxinbaoNumber;
    }

    public void setZhongxinbaoNumber(String zhongxinbaoNumber) {
        this.zhongxinbaoNumber = zhongxinbaoNumber;
    }

    public Integer getZhongxinbaoLevel() {
        return zhongxinbaoLevel;
    }

    public void setZhongxinbaoLevel(Integer zhongxinbaoLevel) {
        this.zhongxinbaoLevel = zhongxinbaoLevel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getEnterprisePhone() {
        return enterprisePhone;
    }

    public void setEnterprisePhone(String enterprisePhone) {
        this.enterprisePhone = enterprisePhone;
    }


    public String getCustomField() {
        return customField;
    }

    public void setCustomField(String customField) {
        this.customField = customField;
    }

    public String getCustomerCompletion() {
        return customerCompletion;
    }

    public void setCustomerCompletion(String customerCompletion) {
        this.customerCompletion = customerCompletion;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEnterpriseEmail() {
        return enterpriseEmail;
    }

    public void setEnterpriseEmail(String enterpriseEmail) {
        this.enterpriseEmail = enterpriseEmail;
    }

    public Integer getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(Integer customerLevel) {
        this.customerLevel = customerLevel;
    }

    public Integer getHasChiCompany() {
        return hasChiCompany;
    }

    public void setHasChiCompany(Integer hasChiCompany) {
        this.hasChiCompany = hasChiCompany;
    }

    public Integer getHasChiPurchase() {
        return hasChiPurchase;
    }

    public void setHasChiPurchase(Integer hasChiPurchase) {
        this.hasChiPurchase = hasChiPurchase;
    }

    public Integer getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(Integer customerStatus) {
        this.customerStatus = customerStatus;
    }

    public String getQualificationsFileUrl() {
        return qualificationsFileUrl;
    }

    public void setQualificationsFileUrl(String qualificationsFileUrl) {
        this.qualificationsFileUrl = qualificationsFileUrl;
    }

    public String getFactoryLocation() {
        return factoryLocation;
    }

    public void setFactoryLocation(String factoryLocation) {
        this.factoryLocation = factoryLocation;
    }

    public String getMajorCompetitors() {
        return majorCompetitors;
    }

    public void setMajorCompetitors(String majorCompetitors) {
        this.majorCompetitors = majorCompetitors;
    }



    public Integer getLastmodifyUserIdEn() {
        return lastmodifyUserIdEn;
    }

    public void setLastmodifyUserIdEn(Integer lastmodifyUserIdEn) {
        this.lastmodifyUserIdEn = lastmodifyUserIdEn;
    }

    public String getLastmodifyUserNameEn() {
        return lastmodifyUserNameEn;
    }

    public void setLastmodifyUserNameEn(String lastmodifyUserNameEn) {
        this.lastmodifyUserNameEn = lastmodifyUserNameEn;
    }

    public Date getModifyTimeEn() {
        return modifyTimeEn;
    }

    public void setModifyTimeEn(Date modifyTimeEn) {
        this.modifyTimeEn = modifyTimeEn;
    }

    public Integer getOpportunitySource() {
        return opportunitySource;
    }

    public void setOpportunitySource(Integer opportunitySource) {
        this.opportunitySource = opportunitySource;
    }

    public String getOtherOpportunity() {
        return otherOpportunity;
    }

    public void setOtherOpportunity(String otherOpportunity) {
        this.otherOpportunity = otherOpportunity;
    }

    public String getOpportunityDescrible() {
        return opportunityDescrible;
    }

    public void setOpportunityDescrible(String opportunityDescrible) {
        this.opportunityDescrible = opportunityDescrible;
    }

    //public List<CustomerMakeProduct> getCustomerMakeProduct() {
    //    return customerMakeProduct;
    //}
    //
    //public void setCustomerMakeProduct(List<CustomerMakeProduct> customerMakeProduct) {
    //    this.customerMakeProduct = customerMakeProduct;
    //}


    public Integer getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
    }

    public List<CustomerMakeProduct> getCustomerMakeProduct() {
        return customerMakeProduct;
    }

    public void setCustomerMakeProduct(List<CustomerMakeProduct> customerMakeProduct) {
        this.customerMakeProduct = customerMakeProduct;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
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

    public String getEnterpriseNature() {
        return enterpriseNature;
    }

    public void setEnterpriseNature(String enterpriseNature) {
        this.enterpriseNature = enterpriseNature;
    }

    public String getOtherEnterpriceNature() {
        return otherEnterpriceNature;
    }

    public void setOtherEnterpriceNature(String otherEnterpriceNature) {
        this.otherEnterpriceNature = otherEnterpriceNature;
    }

    public String getLossReason() {
        return lossReason;
    }

    public void setLossReason(String lossReason) {
        this.lossReason = lossReason;
    }


    public String getNcId() {
        return ncId;
    }

    public void setNcId(String ncId) {
        this.ncId = ncId;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getCustclass() {
        return custclass;
    }

    public void setCustclass(String custclass) {
        this.custclass = custclass;
    }

    public String getFormatdoc() {
        return formatdoc;
    }

    public void setFormatdoc(String formatdoc) {
        this.formatdoc = formatdoc;
    }

    public String getCountryzone() {
        return countryzone;
    }

    public void setCountryzone(String countryzone) {
        this.countryzone = countryzone;
    }

    public String getTimezoneName() {
        return timezoneName;
    }

    public void setTimezoneName(String timezoneName) {
        this.timezoneName = timezoneName;
    }

    public String getCustclassName() {
        return custclassName;
    }

    public void setCustclassName(String custclassName) {
        this.custclassName = custclassName;
    }

    public String getFormatdocName() {
        return formatdocName;
    }

    public void setFormatdocName(String formatdocName) {
        this.formatdocName = formatdocName;
    }

    public String getCountryzoneName() {
        return countryzoneName;
    }

    public void setCountryzoneName(String countryzoneName) {
        this.countryzoneName = countryzoneName;
    }

    public String getCustomerDutyParagraph() {
        return customerDutyParagraph;
    }

    public void setCustomerDutyParagraph(String customerDutyParagraph) {
        this.customerDutyParagraph = customerDutyParagraph;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getSaleOrganizationId() {
        return saleOrganizationId;
    }

    public void setSaleOrganizationId(String saleOrganizationId) {
        this.saleOrganizationId = saleOrganizationId;
    }

    public String getSaleOrganizationName() {
        return saleOrganizationName;
    }

    public void setSaleOrganizationName(String saleOrganizationName) {
        this.saleOrganizationName = saleOrganizationName;
    }
}

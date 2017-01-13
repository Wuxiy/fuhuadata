package com.fuhuadata.domain.query;
import java.util.Date;

/**
 * @author wangbo
 * @date 2017-01-12 11:49:51
 */
public class QueryCustomerParent extends PageBase {

    /**客户信息总id**/
	private String customerId;
	
    /**企业全称**/
	private String fullName;
	
    /**企业简称**/
	private String shortName;
	
    /**企业类型,-1全部,0客户,1竞对**/
	private Integer customerType;
	
    /**地区id**/
	private Integer areaId;
	
    /**地区分类,例如北美洲**/
	private String area;
	
    /**国家分类id**/
	private Integer countryId;
	
    /**国家,例如美国**/
	private String country;
	
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
	
    /**百科备注**/
	private String parentRemarks;
	
    /**企业电话**/
	private String enterprisePhone;
	
    /**企业邮箱**/
	private String enterpriseEmaill;
	
    /**企业简介**/
	private String enterpriseProfile;
	
    /**发展历程**/
	private String developmentCourse;
	
    /**销售网络**/
	private String salesNetwork;
	
    /**自定义字段,json序列化字段**/
	private String customField;
	
    /**企业信息完成度**/
	private String customerCompletion;
	
    /**创建者id**/
	private Integer createUserId;
	
    /**创建者姓名**/
	private String createUserName;
	
    /**上一次修改者id**/
	private Integer lastmodifyUserId;
	
    /**上一次修改者姓名**/
	private String lastmodifyUserName;
	
    /**创建时间**/
	private Date createTime;
	
    /**修改时间**/
	private Date modifyTime;
	

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
	
	public Integer getAreaId() {
		return areaId;
	}
	
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	
	public String getArea() {
		return area;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	
	public Integer getCountryId() {
		return countryId;
	}
	
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
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
	
	public String getParentRemarks() {
		return parentRemarks;
	}
	
	public void setParentRemarks(String parentRemarks) {
		this.parentRemarks = parentRemarks;
	}
	
	public String getEnterprisePhone() {
		return enterprisePhone;
	}
	
	public void setEnterprisePhone(String enterprisePhone) {
		this.enterprisePhone = enterprisePhone;
	}
	
	public String getEnterpriseEmaill() {
		return enterpriseEmaill;
	}
	
	public void setEnterpriseEmaill(String enterpriseEmaill) {
		this.enterpriseEmaill = enterpriseEmaill;
	}
	
	public String getEnterpriseProfile() {
		return enterpriseProfile;
	}
	
	public void setEnterpriseProfile(String enterpriseProfile) {
		this.enterpriseProfile = enterpriseProfile;
	}
	
	public String getDevelopmentCourse() {
		return developmentCourse;
	}
	
	public void setDevelopmentCourse(String developmentCourse) {
		this.developmentCourse = developmentCourse;
	}
	
	public String getSalesNetwork() {
		return salesNetwork;
	}
	
	public void setSalesNetwork(String salesNetwork) {
		this.salesNetwork = salesNetwork;
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
	

}
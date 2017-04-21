package com.fuhuadata.domain.query;
import java.util.Date;

/**
 * @author wangbo
 * @date 2017-01-12 11:49:51
 */
public class QueryCustomerBaseInfo  {
	private int startRow;
	private int pageSize;
    /**客户信息总id**/
	private String customerId;
	
    /**企业全称**/
	private String fullName;

	/**企业性质 1：工厂 2：经销商 3：分销商 4：终端客户 5：其他**/
	private Integer enterpriseNature;

	/**1:战略客户,2:大客户 3:重要客户 4:一般客户 5:风险客户**/
	private Integer customerLevel;

	/*客户状态  0：流失 1：正常*/
	private Integer customerStatus;

    /**企业简称**/
	private String shortName;
	
    /**企业类型,-1全部,0客户,1竞对**/
	private Integer customerType;
	
    /**地区id**/
	private String areaId;
	
    /**地区分类,例如北美洲**/
	private String area;

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
	private String enterpriseEmail;
	
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
	//机会描述
	private String opportunityDescrible;

	//所属销售组织编码
	private String saleOrganizationId;
	//所属销售组织名称
	private String saleOrganizationName;
	//客户税号
	private String customerDutyParagraph;

	public String getCustomerDutyParagraph() {
		return customerDutyParagraph;
	}

	public void setCustomerDutyParagraph(String customerDutyParagraph) {
		this.customerDutyParagraph = customerDutyParagraph;
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

	public String getOpportunityDescrible() {
		return opportunityDescrible;
	}

	public void setOpportunityDescrible(String opportunityDescrible) {
		this.opportunityDescrible = opportunityDescrible;
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

	public Integer getEnterpriseNature() {
		return enterpriseNature;
	}

	public void setEnterpriseNature(Integer enterpriseNature) {
		this.enterpriseNature = enterpriseNature;
	}

	public Integer getCustomerLevel() {
		return customerLevel;
	}

	public void setCustomerLevel(Integer customerLevel) {
		this.customerLevel = customerLevel;
	}

	public Integer getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(Integer customerStatus) {
		this.customerStatus = customerStatus;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
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


	public String getEnterpriseEmail() {
		return enterpriseEmail;
	}

	public void setEnterpriseEmail(String enterpriseEmail) {
		this.enterpriseEmail = enterpriseEmail;
	}
}
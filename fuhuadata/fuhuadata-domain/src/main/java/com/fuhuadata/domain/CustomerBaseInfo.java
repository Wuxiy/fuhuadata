package com.fuhuadata.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author wangbo
 * @date 2017-01-12 11:49:51
 */
public class CustomerBaseInfo implements Serializable{

    /**客户信息总id**/
	private String customerId;

	private String ncId;

    /**企业全称**/
	private String fullName;


	/**企业简称**/
	private String shortName;

	private Integer companyType;//企业类型：0：客户，1：竞对

	/**地区id**/
	private Integer areaId;

	/**地区分类,例如北美洲**/
	private String area;

	/**国家分类id**/
	private String countryId;

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

    /**备注**/
	private String remark;

    /**企业电话**/
	private String enterprisePhone;

    /**企业邮箱**/
	private String enterpriseEmail;

	//企业百科信息

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

	/**1:战略客户,2:大客户 3:重要客户 4:一般客户 5:风险客户**/
	private Integer customerLevel;


	/**时区**/
	private String timezone;

	/**客户基本分类**/
	private String custclass;

	/**数据格式**/
	private String formatdoc;

	/**贸易国别**/
	private String countryzone;

	/**客户税号**/
	private String customerTax;


	/*活跃周期*/
	private Integer activePeriod;

	/**客户类型,1:合作 2:潜在 3:流失**/
	private Integer customerType;

	/**是否有中国分公司 0：无 1：有**/
	private  Integer hasChiCompany;


	/**是否有中方采购 0：无 1：有**/
	private  Integer hasChiPurchase;

	/**客户状态  0：流失 1：正常**/
	private Integer customerStatus;


	/**资质文件保存路径**/
	private String qualificationsFileUrl;

    /**创建者姓名**/
	private String createUserName;

	/**工厂位置**/
	private String factoryLocation;

	/**分销主要竞争对手**/
	private String majorCompetitors;

    /**上一次修改者id**/
	private Integer lastmodifyUserId;

	/**上一次修改者姓名**/
	private String lastmodifyUserName;

    /**创建时间**/
	private String createTime;

    /**修改时间**/
	private String modifyTime;
	/*合同总金额*/
	private BigDecimal totalMoney;
	/*已回款金额*/
	private BigDecimal payMoney;
	/*最低销售价*/
	private BigDecimal minPrice;
	/*维护费*/
	private BigDecimal maintenanceFee;
	/*净利润*/
	private BigDecimal netProfit;
	//客户流失原因
	private String lossReason;
	//潜在客户机会来源 1:展会，2：门户网站 3：农药店考察 4：客户介绍 5：主动联系 6：其他
	private Integer opportunitySource;
	//其他机会来源
	private String otherOpportunity;
	//机会描述
	private String opportunityDescrible;
	//默认联系人
	private String linkManName;
	//默认联系人email
	private String linkManEmail;
	//企业性质 id
	private String enterpriseNature;
	//企业性质集合名称，多个性质逗号分隔
	private String fullEnterpriseNature;
	//其他性质
	private String otherEnterpriseNature;
	//价格敏感度
	private String priceSensitivity;
	//忠诚度
	private String loyalty;
	//开始合作时间
	private String startCooperationTime;
	//合作时长（月）
	private Integer cooperationDuration;
	//采购季节
	private String purchasingSeason;

	//合作紧密度（福华是否独家供应） 0:否 1:是
	private Integer isFuhuaExclusive;
	//合作情况备注
	private String cooperationRemark;
	//产品线
	private String productionLine;

	private String encyId;// 百科id 用来判断客户是否有百科
	public CustomerBaseInfo() {
	}

	public String getOtherEnterpriseNature() {
		return otherEnterpriseNature;
	}

	public void setOtherEnterpriseNature(String otherEnterpriseNature) {
		this.otherEnterpriseNature = otherEnterpriseNature;
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

	public String getFullEnterpriseNature() {
		return fullEnterpriseNature;
	}

	public void setFullEnterpriseNature(String fullEnterpriseNature) {
		this.fullEnterpriseNature = fullEnterpriseNature;
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

	public String getEnterpriseEmail() {
		return enterpriseEmail;
	}

	public void setEnterpriseEmail(String enterpriseEmail) {
		this.enterpriseEmail = enterpriseEmail;
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

	public Integer getCustomerLevel() {
		return customerLevel;
	}

	public void setCustomerLevel(Integer customerLevel) {
		this.customerLevel = customerLevel;
	}

	public Integer getActivePeriod() {
		return activePeriod;
	}

	public void setActivePeriod(Integer activePeriod) {
		this.activePeriod = activePeriod;
	}

	public Integer getCustomerType() {
		return customerType;
	}

	public void setCustomerType(Integer customerType) {
		this.customerType = customerType;
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

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	public BigDecimal getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}

	public BigDecimal getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}

	public BigDecimal getMaintenanceFee() {
		return maintenanceFee;
	}

	public void setMaintenanceFee(BigDecimal maintenanceFee) {
		this.maintenanceFee = maintenanceFee;
	}

	public BigDecimal getNetProfit() {
		return netProfit;
	}

	public void setNetProfit(BigDecimal netProfit) {
		this.netProfit = netProfit;
	}

	public String getLossReason() {
		return lossReason;
	}

	public void setLossReason(String lossReason) {
		this.lossReason = lossReason;
	}

	public String getOpportunityDescrible() {
		return opportunityDescrible;
	}

	public void setOpportunityDescrible(String opportunityDescrible) {
		this.opportunityDescrible = opportunityDescrible;
	}

	public String getLinkManName() {
		return linkManName;
	}

	public void setLinkManName(String linkManName) {
		this.linkManName = linkManName;
	}

	public String getLinkManEmail() {
		return linkManEmail;
	}

	public void setLinkManEmail(String linkManEmail) {
		this.linkManEmail = linkManEmail;
	}

	public String getEnterpriseNature() {
		return enterpriseNature;
	}

	public void setEnterpriseNature(String enterpriseNature) {
		this.enterpriseNature = enterpriseNature;
	}


	public String getPriceSensitivity() {
		return priceSensitivity;
	}

	public void setPriceSensitivity(String priceSensitivity) {
		this.priceSensitivity = priceSensitivity;
	}

	public String getLoyalty() {
		return loyalty;
	}

	public void setLoyalty(String loyalty) {
		this.loyalty = loyalty;
	}

	public String getStartCooperationTime() {
		return startCooperationTime;
	}

	public void setStartCooperationTime(String startCooperationTime) {
		this.startCooperationTime = startCooperationTime;
	}

	public Integer getCooperationDuration() {
		return cooperationDuration;
	}

	public void setCooperationDuration(Integer cooperationDuration) {
		this.cooperationDuration = cooperationDuration;
	}

	public String getPurchasingSeason() {
		return purchasingSeason;
	}

	public void setPurchasingSeason(String purchasingSeason) {
		this.purchasingSeason = purchasingSeason;
	}

	public Integer getIsFuhuaExclusive() {
		return isFuhuaExclusive;
	}

	public void setIsFuhuaExclusive(Integer isFuhuaExclusive) {
		this.isFuhuaExclusive = isFuhuaExclusive;
	}

	public String getCooperationRemark() {
		return cooperationRemark;
	}

	public void setCooperationRemark(String cooperationRemark) {
		this.cooperationRemark = cooperationRemark;
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

	public String getProductionLine() {
		return productionLine;
	}

	public void setProductionLine(String productionLine) {
		this.productionLine = productionLine;
	}

	public Integer getCompanyType() {
		return companyType;
	}

	public void setCompanyType(Integer companyType) {
		this.companyType = companyType;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
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

	public String getEncyId() {
		return encyId;
	}

	public void setEncyId(String encyId) {
		this.encyId = encyId;
	}

	public String getCustomerTax() {
		return customerTax;
	}

	public void setCustomerTax(String customerTax) {
		this.customerTax = customerTax;
	}
}
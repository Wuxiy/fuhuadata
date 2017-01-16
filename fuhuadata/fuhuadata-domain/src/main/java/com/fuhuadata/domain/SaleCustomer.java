package com.fuhuadata.domain;

import java.util.Date;
import java.math.BigDecimal;

/**
 * @author wangbo
 * @date 2017-01-12 13:27:44
 */
public class SaleCustomer{

    /**主键id**/
	private String customerId;
	
    /**企业性质,0工厂,1经销商2,分销商3,终端客户4,其他，格式如下:[2][3]**/
	private String property;
	
    /**企业性质备注**/
	private String propertyRemarks;
	
    /**客户级别，0未知，1风险客户，2一般客户，3重要客户，4大客户，5战略客户**/
	private Integer customerLevel;
	
    /**客户状态，0潜在客户，1合作客户，2已流失**/
	private Integer customerState;
	
    /**客户流失备注**/
	private String lostRemarks;
	
    /**是否有中国分公司,0未知，1是，2否**/
	private Integer chinaBranchOffice;
	
    /**是否有中方采购合同，0未知，1是，2否**/
	private Integer chinaContract;
	
    /**资质文件,json数组格式**/
	private String qualificationDocuments;
	
    /**销售客户备注**/
	private String saleRemarks;
	
    /**机会来源类型**/
	private Integer opportunityType;
	
    /**机会来源说明**/
	private String opportunitySources;
	
    /**机会来源描述**/
	private String opportunityDescribe;
	
    /**价格铭感度**/
	private String priceSensitive;
	
    /**忠诚度**/
	private String loyalty;
	
    /**开始合作时间**/
	private Date cooperateTime;
	
    /**采购季节**/
	private String procurementSeason;
	
    /**紧密度**/
	private String affinity;
	
    /**活跃周期**/
	private String activePeriod;
	
    /**合作备注**/
	private String cooperateRemarks;
	
    /**客户总的销售额**/
	private BigDecimal totalSaleMoney;
	
    /**总的最低销售售价**/
	private BigDecimal lowestSaleMoney;
	
    /**总的维护费用**/
	private BigDecimal totalMaintenanceCosts;
	
    /**总利润**/
	private BigDecimal totalProfits;
	
    /**加工厂位置，类型为加工厂时**/
	private String factoryLocate;
	
    /**生产线，类型为加工厂时**/
	private String factoryProductLine;
	
    /**加工产品，json格式数据**/
	private String factoryProduct;
	
    /**单据要求，json格式**/
	private String documentRequire;
	
    /**对船公司要求**/
	private String shippingAgentRequire;
	
    /**装箱要求**/
	private String packageRequire;
	
    /**货物类型，0普通，1危险品**/
	private Integer goodsType;
	
    /**免用箱期**/
	private Integer mianxiangqi;
	
    /**免推期**/
	private Integer miantuiqi;
	
    /**是否可以转运，0是，1否**/
	private Integer transportFlag;
	
    /**是否可以分批出运，0是，1否**/
	private Integer batchFlag;
	
    /**交单地址要求，json格式**/
	private String presentationAddress;
	
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
	
	
	public SaleCustomer() {
	}
	
	public String getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getProperty() {
		return property;
	}
	
	public void setProperty(String property) {
		this.property = property;
	}
	
	public String getPropertyRemarks() {
		return propertyRemarks;
	}
	
	public void setPropertyRemarks(String propertyRemarks) {
		this.propertyRemarks = propertyRemarks;
	}
	
	public Integer getCustomerLevel() {
		return customerLevel;
	}
	
	public void setCustomerLevel(Integer customerLevel) {
		this.customerLevel = customerLevel;
	}
	
	public Integer getCustomerState() {
		return customerState;
	}
	
	public void setCustomerState(Integer customerState) {
		this.customerState = customerState;
	}
	
	public String getLostRemarks() {
		return lostRemarks;
	}
	
	public void setLostRemarks(String lostRemarks) {
		this.lostRemarks = lostRemarks;
	}
	
	public Integer getChinaBranchOffice() {
		return chinaBranchOffice;
	}
	
	public void setChinaBranchOffice(Integer chinaBranchOffice) {
		this.chinaBranchOffice = chinaBranchOffice;
	}
	
	public Integer getChinaContract() {
		return chinaContract;
	}
	
	public void setChinaContract(Integer chinaContract) {
		this.chinaContract = chinaContract;
	}
	
	public String getQualificationDocuments() {
		return qualificationDocuments;
	}
	
	public void setQualificationDocuments(String qualificationDocuments) {
		this.qualificationDocuments = qualificationDocuments;
	}
	
	public String getSaleRemarks() {
		return saleRemarks;
	}
	
	public void setSaleRemarks(String saleRemarks) {
		this.saleRemarks = saleRemarks;
	}
	
	public Integer getOpportunityType() {
		return opportunityType;
	}
	
	public void setOpportunityType(Integer opportunityType) {
		this.opportunityType = opportunityType;
	}
	
	public String getOpportunitySources() {
		return opportunitySources;
	}
	
	public void setOpportunitySources(String opportunitySources) {
		this.opportunitySources = opportunitySources;
	}
	
	public String getOpportunityDescribe() {
		return opportunityDescribe;
	}
	
	public void setOpportunityDescribe(String opportunityDescribe) {
		this.opportunityDescribe = opportunityDescribe;
	}
	
	public String getPriceSensitive() {
		return priceSensitive;
	}
	
	public void setPriceSensitive(String priceSensitive) {
		this.priceSensitive = priceSensitive;
	}
	
	public String getLoyalty() {
		return loyalty;
	}
	
	public void setLoyalty(String loyalty) {
		this.loyalty = loyalty;
	}
	
	public Date getCooperateTime() {
		return cooperateTime;
	}
	
	public void setCooperateTime(Date cooperateTime) {
		this.cooperateTime = cooperateTime;
	}
	
	public String getProcurementSeason() {
		return procurementSeason;
	}
	
	public void setProcurementSeason(String procurementSeason) {
		this.procurementSeason = procurementSeason;
	}
	
	public String getAffinity() {
		return affinity;
	}
	
	public void setAffinity(String affinity) {
		this.affinity = affinity;
	}
	
	public String getActivePeriod() {
		return activePeriod;
	}
	
	public void setActivePeriod(String activePeriod) {
		this.activePeriod = activePeriod;
	}
	
	public String getCooperateRemarks() {
		return cooperateRemarks;
	}
	
	public void setCooperateRemarks(String cooperateRemarks) {
		this.cooperateRemarks = cooperateRemarks;
	}
	
	public BigDecimal getTotalSaleMoney() {
		return totalSaleMoney;
	}
	
	public void setTotalSaleMoney(BigDecimal totalSaleMoney) {
		this.totalSaleMoney = totalSaleMoney;
	}
	
	public BigDecimal getLowestSaleMoney() {
		return lowestSaleMoney;
	}
	
	public void setLowestSaleMoney(BigDecimal lowestSaleMoney) {
		this.lowestSaleMoney = lowestSaleMoney;
	}
	
	public BigDecimal getTotalMaintenanceCosts() {
		return totalMaintenanceCosts;
	}
	
	public void setTotalMaintenanceCosts(BigDecimal totalMaintenanceCosts) {
		this.totalMaintenanceCosts = totalMaintenanceCosts;
	}
	
	public BigDecimal getTotalProfits() {
		return totalProfits;
	}
	
	public void setTotalProfits(BigDecimal totalProfits) {
		this.totalProfits = totalProfits;
	}
	
	public String getFactoryLocate() {
		return factoryLocate;
	}
	
	public void setFactoryLocate(String factoryLocate) {
		this.factoryLocate = factoryLocate;
	}
	
	public String getFactoryProductLine() {
		return factoryProductLine;
	}
	
	public void setFactoryProductLine(String factoryProductLine) {
		this.factoryProductLine = factoryProductLine;
	}
	
	public String getFactoryProduct() {
		return factoryProduct;
	}
	
	public void setFactoryProduct(String factoryProduct) {
		this.factoryProduct = factoryProduct;
	}
	
	public String getDocumentRequire() {
		return documentRequire;
	}
	
	public void setDocumentRequire(String documentRequire) {
		this.documentRequire = documentRequire;
	}
	
	public String getShippingAgentRequire() {
		return shippingAgentRequire;
	}
	
	public void setShippingAgentRequire(String shippingAgentRequire) {
		this.shippingAgentRequire = shippingAgentRequire;
	}
	
	public String getPackageRequire() {
		return packageRequire;
	}
	
	public void setPackageRequire(String packageRequire) {
		this.packageRequire = packageRequire;
	}
	
	public Integer getGoodsType() {
		return goodsType;
	}
	
	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}
	
	public Integer getMianxiangqi() {
		return mianxiangqi;
	}
	
	public void setMianxiangqi(Integer mianxiangqi) {
		this.mianxiangqi = mianxiangqi;
	}
	
	public Integer getMiantuiqi() {
		return miantuiqi;
	}
	
	public void setMiantuiqi(Integer miantuiqi) {
		this.miantuiqi = miantuiqi;
	}
	
	public Integer getTransportFlag() {
		return transportFlag;
	}
	
	public void setTransportFlag(Integer transportFlag) {
		this.transportFlag = transportFlag;
	}
	
	public Integer getBatchFlag() {
		return batchFlag;
	}
	
	public void setBatchFlag(Integer batchFlag) {
		this.batchFlag = batchFlag;
	}
	
	public String getPresentationAddress() {
		return presentationAddress;
	}
	
	public void setPresentationAddress(String presentationAddress) {
		this.presentationAddress = presentationAddress;
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
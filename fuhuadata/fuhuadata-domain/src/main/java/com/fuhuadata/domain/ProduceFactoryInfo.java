package com.fuhuadata.domain;

import java.util.Date;
import java.math.BigDecimal;

/**
 * @author wangbo
 * @date 2017-01-16 11:10:51
 */
public class ProduceFactoryInfo{

    /**工厂id**/
	private String customerId;
	
    /**联系人**/
	private String linkMan;
	
    /**联系电话**/
	private String linkPhone;
	
    /**邮箱**/
	private String email;
	
    /**开始合作时间，第一个订单的时间，后面计算总的合作时间**/
	private Date cooperateTime;
	
    /**生产许可证**/
	private String productionLicenses;
	
    /**农药登记证**/
	private String pesticideRegistration;
	
    /**排污许可证**/
	private String dischargePermit;
	
    /**工厂管理人员**/
	private String factoryManagePerson;
	
    /**综合评分**/
	private BigDecimal combinedScoring;
	
    /**产品信息**/
	private String productInfo;
	
    /**工厂备注**/
	private String factoryRemarks;
	
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
	
	
	public ProduceFactoryInfo() {
	}
	
	public String getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getLinkMan() {
		return linkMan;
	}
	
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	
	public String getLinkPhone() {
		return linkPhone;
	}
	
	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getCooperateTime() {
		return cooperateTime;
	}
	
	public void setCooperateTime(Date cooperateTime) {
		this.cooperateTime = cooperateTime;
	}
	
	public String getProductionLicenses() {
		return productionLicenses;
	}
	
	public void setProductionLicenses(String productionLicenses) {
		this.productionLicenses = productionLicenses;
	}
	
	public String getPesticideRegistration() {
		return pesticideRegistration;
	}
	
	public void setPesticideRegistration(String pesticideRegistration) {
		this.pesticideRegistration = pesticideRegistration;
	}
	
	public String getDischargePermit() {
		return dischargePermit;
	}
	
	public void setDischargePermit(String dischargePermit) {
		this.dischargePermit = dischargePermit;
	}
	
	public String getFactoryManagePerson() {
		return factoryManagePerson;
	}
	
	public void setFactoryManagePerson(String factoryManagePerson) {
		this.factoryManagePerson = factoryManagePerson;
	}
	
	public BigDecimal getCombinedScoring() {
		return combinedScoring;
	}
	
	public void setCombinedScoring(BigDecimal combinedScoring) {
		this.combinedScoring = combinedScoring;
	}
	
	public String getProductInfo() {
		return productInfo;
	}
	
	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}
	
	public String getFactoryRemarks() {
		return factoryRemarks;
	}
	
	public void setFactoryRemarks(String factoryRemarks) {
		this.factoryRemarks = factoryRemarks;
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
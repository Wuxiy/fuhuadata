package com.fuhuadata.domain;

import java.util.Date;
import java.math.BigDecimal;

/**
 * @author wangbo
 * @date 2017-01-16 15:25:40
 */
public class FreightforwardingInfo{

    /**货代id**/
	private String customerId;
	
    /**类型，0常规，1非常规，2自定**/
	private Integer type;
	
    /**社会信用代码**/
	private String creditCode;
	
    /**办公地址**/
	private String officeAddress;
	
    /**联系人**/
	private String linkMan;
	
    /**联系电话**/
	private String linkPhone;
	
    /**邮箱**/
	private String email;
	
    /**运输方式，方式id的json数组**/
	private String transportationMethods;
	
    /**货代备注**/
	private String freightForwardingRemarks;
	
    /**营业执照**/
	private String businessLicence;
	
    /**经营资格登记证**/
	private String registrationCertificate;
	
    /**合作时间**/
	private Date cooperateTime;
	
    /**综合评分**/
	private BigDecimal combinedScoring;
	
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
	
	
	public FreightforwardingInfo() {
	}
	
	public String getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public Integer getType() {
		return type;
	}
	
	public void setType(Integer type) {
		this.type = type;
	}
	
	public String getCreditCode() {
		return creditCode;
	}
	
	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}
	
	public String getOfficeAddress() {
		return officeAddress;
	}
	
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
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
	
	public String getTransportationMethods() {
		return transportationMethods;
	}
	
	public void setTransportationMethods(String transportationMethods) {
		this.transportationMethods = transportationMethods;
	}
	
	public String getFreightForwardingRemarks() {
		return freightForwardingRemarks;
	}
	
	public void setFreightForwardingRemarks(String freightForwardingRemarks) {
		this.freightForwardingRemarks = freightForwardingRemarks;
	}
	
	public String getBusinessLicence() {
		return businessLicence;
	}
	
	public void setBusinessLicence(String businessLicence) {
		this.businessLicence = businessLicence;
	}
	
	public String getRegistrationCertificate() {
		return registrationCertificate;
	}
	
	public void setRegistrationCertificate(String registrationCertificate) {
		this.registrationCertificate = registrationCertificate;
	}
	
	public Date getCooperateTime() {
		return cooperateTime;
	}
	
	public void setCooperateTime(Date cooperateTime) {
		this.cooperateTime = cooperateTime;
	}
	
	public BigDecimal getCombinedScoring() {
		return combinedScoring;
	}
	
	public void setCombinedScoring(BigDecimal combinedScoring) {
		this.combinedScoring = combinedScoring;
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
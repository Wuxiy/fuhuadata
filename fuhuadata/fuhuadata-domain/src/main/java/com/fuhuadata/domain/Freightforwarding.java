package com.fuhuadata.domain;

import java.util.Date;
import java.math.BigDecimal;

/**
 *  货代
 * @author wangbo
 * @date 2017-01-16 15:25:40
 */
public class Freightforwarding {

    /**货代id**/
	private String customerId;

	/**nc货代编码**/
	private String code;

	/**所属组织**/
	private String supplierClass;

	/**企业全称**/
	private String name;

	/**企业简称**/
	private String shortName;
	
    /**类型，0常规，1非常规，2自定**/
	private Integer type;
	
    /**社会信用代码**/
	private String creditCode;
	
    /**办公地址**/
	private String officeAddress;

	/**企业联系电话**/
	private String tel;

	/**合作时间**/
	private Date cooperateTime;

	/**注册资金**/
	private BigDecimal registerFund;

    /**联系人**/
	private String linkMan;
	
    /**联系电话**/
	private String linkPhone;
	
    /**邮箱**/
	private String email;

	/**注册地址**/
	private String registerAddr;
	
    /**运输方式，方式id的json数组**/
	private String transportationMethods;
	
    /**货代备注**/
	private String remarks;
	
    /**营业执照**/
	private String businessLicence;

	/**无船承运业务经营资格登记证 json数据**/
	private String  NVOCC;

	/**是否进入电子系统1：是 0：否**/
	private String enterElectronicSystem;
	
    /**经营资格登记证 json数据**/
	private String registrationCertificate;

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

	/**自定义字段**/
	private String customField;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSupplierClass() {
		return supplierClass;
	}

	public void setSupplierClass(String supplierClass) {
		this.supplierClass = supplierClass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public BigDecimal getRegisterFund() {
		return registerFund;
	}

	public void setRegisterFund(BigDecimal registerFund) {
		this.registerFund = registerFund;
	}

	public String getRegisterAddr() {
		return registerAddr;
	}

	public void setRegisterAddr(String registerAddr) {
		this.registerAddr = registerAddr;
	}

	public String getNVOCC() {
		return NVOCC;
	}

	public void setNVOCC(String NVOCC) {
		this.NVOCC = NVOCC;
	}

	public String getEnterElectronicSystem() {
		return enterElectronicSystem;
	}

	public void setEnterElectronicSystem(String enterElectronicSystem) {
		this.enterElectronicSystem = enterElectronicSystem;
	}

	public Freightforwarding() {
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


	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCustomField() {
		return customField;
	}

	public void setCustomField(String customField) {
		this.customField = customField;
	}
}
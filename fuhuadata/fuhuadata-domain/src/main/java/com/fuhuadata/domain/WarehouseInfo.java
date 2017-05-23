package com.fuhuadata.domain;

import java.util.Date;
import java.math.BigDecimal;

/** 货代仓库
 * @author wangbo
 * @date 2017-01-16 17:17:06
 */
public class WarehouseInfo{

    /**仓库id**/
	private String customerId;

	/**nc仓库编码**/
	private String code;

	/**所属组织**/
	private String org;

	/**企业全称**/
	private String name;

	/**企业简称**/
	private String shortName;

    /**类型，0常规，1非常规，2自定**/
	private Integer type;
	
    /**社会信用代码**/
	private String creditCode;

	/**注册资金**/
	private String registerFund;
	
    /**办公地址**/
	private String officeAddress;

	/**企业联系电话**/
	private String tel;
	
    /**联系人**/
	private String linkMan;
	
    /**联系电话**/
	private String linkPhone;
	
    /**邮箱**/
	private String email;

	/**注册地址**/
	private String registerAddr;
	
    /**仓库面积**/
	private String warehouseArea;
	
    /**是否危险，0否，1是**/
	private Integer isDangers;
	
    /**是否内装进港，0否，1是**/
	private Integer isInsideEntrance;
	
    /**仓库地址**/
	private String storaddr;
	
    /**仓库备注**/
	private String remarks;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
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

	public String getRegisterFund() {
		return registerFund;
	}

	public void setRegisterFund(String registerFund) {
		this.registerFund = registerFund;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRegisterAddr() {
		return registerAddr;
	}

	public void setRegisterAddr(String registerAddr) {
		this.registerAddr = registerAddr;
	}

	public String getStoraddr() {
		return storaddr;
	}

	public void setStoraddr(String storaddr) {
		this.storaddr = storaddr;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

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
	
	
	public WarehouseInfo() {
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
	
	public String getWarehouseArea() {
		return warehouseArea;
	}
	
	public void setWarehouseArea(String warehouseArea) {
		this.warehouseArea = warehouseArea;
	}
	
	public Integer getIsDangers() {
		return isDangers;
	}
	
	public void setIsDangers(Integer isDangers) {
		this.isDangers = isDangers;
	}
	
	public Integer getIsInsideEntrance() {
		return isInsideEntrance;
	}
	
	public void setIsInsideEntrance(Integer isInsideEntrance) {
		this.isInsideEntrance = isInsideEntrance;
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
package com.fuhuadata.domain;

import java.util.Date;

/**
 * @author wangbo
 * @date 2017-01-12 13:37:25
 */
public class CustomerSubcompanyInfo{

    /**客户子公司id**/
	private Integer customerSubId;
	
    /**客户id**/
	private String customerId;
	
    /**企业全称**/
	private String fullName;
	
    /**企业简称**/
	private String shortName;
	
    /**企业性质,0工厂,1经销商2,分销商3,终端客户4,其他，格式如下:[2][3]**/
	private String property;
	
    /**企业性质备注**/
	private String propertyRemarks;
	
    /**中信保编号**/
	private String zhongxinbaoNumber;
	
    /**中信保信用评级，0未知，1:1A，2:2A,3:3A,4:4A**/
	private Integer zhongxinbaoLevel;
	
    /**客户子公司备注**/
	private String customerSubRemarks;
	
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
	
	
	public CustomerSubcompanyInfo() {
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
	
	public String getCustomerSubRemarks() {
		return customerSubRemarks;
	}
	
	public void setCustomerSubRemarks(String customerSubRemarks) {
		this.customerSubRemarks = customerSubRemarks;
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


	public Integer getCustomerSubId() {
		return customerSubId;
	}

	public void setCustomerSubId(Integer customerSubId) {
		this.customerSubId = customerSubId;
	}
}
package com.fuhuadata.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fuhuadata.util.DateJsonDeserializer;
import com.fuhuadata.util.DateJsonSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;
import java.math.BigDecimal;

/**
 * @author wangbo
 * @date 2017-01-13 16:22:04
 */
public class CustomerVisitRecord{

    /**拜访记录id**/
	private Integer visitrecordId;
	
    /**客户id**/
	private String customerId;
	
    /**业务员id**/
	private Integer userId;
	
    /**业务员名称**/
	private String userName;


    /**开始时间**/
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date startTime;
	
    /**结束时间**/
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endTime;
	
    /**活动类型：0远程沟通，1出差拜访，2展会邀请，3工厂参观，4商务宴请，5其他（备注内容）**/
	private Integer activityType;
	
    /**活动类型备注**/
	private String activityRemarks;
	
    /**活动地址**/
	private String activityAddress;
	
    /**总的活动费用，单位元**/
	private BigDecimal activityExpense;
	
    /**拜访对象备注，json格式数据**/
	private String visitRemarks;
	
    /**活动摘要**/
	private String activitySummary;
	
    /**创建者id**/
	private Integer createUserId;
	
    /**创建者姓名**/
	private String createUserName;
	
    /**上一次修改者id**/
	private Integer lastmodifyUserId;
	
    /**上一次修改者姓名**/
	private String lastmodifyUserName;
	
    /**创建时间**/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	
    /**修改时间**/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modifyTime;
	
	
	public CustomerVisitRecord() {
	}
	
	public Integer getVisitrecordId() {
		return visitrecordId;
	}
	
	public void setVisitrecordId(Integer visitrecordId) {
		this.visitrecordId = visitrecordId;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public Integer getActivityType() {
		return activityType;
	}
	
	public void setActivityType(Integer activityType) {
		this.activityType = activityType;
	}
	
	public String getActivityRemarks() {
		return activityRemarks;
	}
	
	public void setActivityRemarks(String activityRemarks) {
		this.activityRemarks = activityRemarks;
	}
	
	public String getActivityAddress() {
		return activityAddress;
	}
	
	public void setActivityAddress(String activityAddress) {
		this.activityAddress = activityAddress;
	}
	
	public BigDecimal getActivityExpense() {
		return activityExpense;
	}
	
	public void setActivityExpense(BigDecimal activityExpense) {
		this.activityExpense = activityExpense;
	}

	public String getVisitRemarks() {
		return visitRemarks;
	}
	
	public void setVisitRemarks(String visitRemarks) {
		this.visitRemarks = visitRemarks;
	}
	
	public String getActivitySummary() {
		return activitySummary;
	}
	
	public void setActivitySummary(String activitySummary) {
		this.activitySummary = activitySummary;
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
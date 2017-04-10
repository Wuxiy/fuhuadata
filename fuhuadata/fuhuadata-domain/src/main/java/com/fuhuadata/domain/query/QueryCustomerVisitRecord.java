package com.fuhuadata.domain.query;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.math.BigDecimal;

/**
 * @author wangbo
 * @date 2017-01-13 16:22:04
 */
public class QueryCustomerVisitRecord{

	/**地区id**/
	private String areaId;
	/**大区分类id**/
	private String areaClassId;
    /**拜访记录id**/
	private Integer visitrecordId;
	
    /**客户id**/
	private String customerId;

	private String customerName;
	
    /**业务员id**/
	private Integer userId;
	
    /**业务员名称**/
	private String userName;
	
    /**开始时间**/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date startTime;
	
    /**结束时间**/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
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
	private Date createTime;
	
    /**修改时间**/
	private Date modifyTime;

	private Integer startRow;//分页起始行标
	private Integer pageSize;//分页步长
	private String orderBy;//排序
	private String sortFiled;//排序字段
	private int sortType;//排序方向，0：正序 1：倒序





	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getSortFiled() {
		return sortFiled;
	}

	public void setSortFiled(String sortFiled) {
		this.sortFiled = sortFiled;
	}

	public int getSortType() {
		return sortType;
	}

	public void setSortType(int sortType) {
		this.sortType = sortType;
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


	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getAreaClassId() {
		return areaClassId;
	}

	public void setAreaClassId(String areaClassId) {
		this.areaClassId = areaClassId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
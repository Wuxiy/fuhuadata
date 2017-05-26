package com.fuhuadata.domain.query;
import java.util.Date;
import java.math.BigDecimal;

/**
 *  货代评分
 * @author wangbo
 * @date 2017-01-16 16:22:49
 */
public class QueryForwardingScore extends PageBase {

    /**主键id**/
	private Integer id;
	
    /**货代id**/
	private String customerId;
	
    /**月份时间**/
	private String monthTime;
	
    /**客服得分**/
	private BigDecimal serviceScore;
	
    /**价格得分**/
	private BigDecimal priceScore;
	
    /**仓储得分**/
	private BigDecimal warehouseScore;
	
    /**投诉反馈得分**/
	private BigDecimal complaintsScore;
	
    /**总评分**/
	private BigDecimal totalScore;
	
    /**评价详情,json格式数据**/
	private String evaluationDetails;
	
    /**备注**/
	private String remarks;
	
    /**修改原因**/
	private String modifyReason;
	
    /**评价时间**/
	private Date evaluateTime;
	
    /**评价人id**/
	private Integer evaluateUserId;
	
    /**评价人名称**/
	private String evaluateUserName;
	
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
	

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getMonthTime() {
		return monthTime;
	}
	
	public void setMonthTime(String monthTime) {
		this.monthTime = monthTime;
	}
	
	public BigDecimal getServiceScore() {
		return serviceScore;
	}
	
	public void setServiceScore(BigDecimal serviceScore) {
		this.serviceScore = serviceScore;
	}
	
	public BigDecimal getPriceScore() {
		return priceScore;
	}
	
	public void setPriceScore(BigDecimal priceScore) {
		this.priceScore = priceScore;
	}
	
	public BigDecimal getWarehouseScore() {
		return warehouseScore;
	}
	
	public void setWarehouseScore(BigDecimal warehouseScore) {
		this.warehouseScore = warehouseScore;
	}
	
	public BigDecimal getComplaintsScore() {
		return complaintsScore;
	}
	
	public void setComplaintsScore(BigDecimal complaintsScore) {
		this.complaintsScore = complaintsScore;
	}
	
	public BigDecimal getTotalScore() {
		return totalScore;
	}
	
	public void setTotalScore(BigDecimal totalScore) {
		this.totalScore = totalScore;
	}
	
	public String getEvaluationDetails() {
		return evaluationDetails;
	}
	
	public void setEvaluationDetails(String evaluationDetails) {
		this.evaluationDetails = evaluationDetails;
	}
	
	public String getRemarks() {
		return remarks;
	}
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getModifyReason() {
		return modifyReason;
	}
	
	public void setModifyReason(String modifyReason) {
		this.modifyReason = modifyReason;
	}
	
	public Date getEvaluateTime() {
		return evaluateTime;
	}
	
	public void setEvaluateTime(Date evaluateTime) {
		this.evaluateTime = evaluateTime;
	}
	
	public Integer getEvaluateUserId() {
		return evaluateUserId;
	}
	
	public void setEvaluateUserId(Integer evaluateUserId) {
		this.evaluateUserId = evaluateUserId;
	}
	
	public String getEvaluateUserName() {
		return evaluateUserName;
	}
	
	public void setEvaluateUserName(String evaluateUserName) {
		this.evaluateUserName = evaluateUserName;
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
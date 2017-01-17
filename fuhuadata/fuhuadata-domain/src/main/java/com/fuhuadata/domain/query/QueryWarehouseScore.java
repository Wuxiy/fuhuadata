package com.fuhuadata.domain.query;
import java.util.Date;
import com.fuhuadata.domain.query.PageBase;

/**
 * @author wangbo
 * @date 2017-01-17 15:17:14
 */
public class QueryWarehouseScore extends PageBase {

    /**主键id**/
	private Integer id;
	
    /**仓库id**/
	private String customerId;
	
    /**月份时间**/
	private String monthTime;
	
    /**报表及时性评分**/
	private BigDecimal timeScore;
	
    /**报表准确性**/
	private BigDecimal accuracyScore;
	
    /**入库**/
	private BigDecimal storageScore;
	
    /**仓储**/
	private BigDecimal warehouseScore;
	
    /**换包装**/
	private BigDecimal packageScore;
	
    /**盘库**/
	private BigDecimal checkStockScore;
	
    /**总评分**/
	private BigDecimal totalScore;
	
    /**评价详情**/
	private String evaluationDetails;
	
    /**备注**/
	private String remarks;
	
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
	
	public BigDecimal getTimeScore() {
		return timeScore;
	}
	
	public void setTimeScore(BigDecimal timeScore) {
		this.timeScore = timeScore;
	}
	
	public BigDecimal getAccuracyScore() {
		return accuracyScore;
	}
	
	public void setAccuracyScore(BigDecimal accuracyScore) {
		this.accuracyScore = accuracyScore;
	}
	
	public BigDecimal getStorageScore() {
		return storageScore;
	}
	
	public void setStorageScore(BigDecimal storageScore) {
		this.storageScore = storageScore;
	}
	
	public BigDecimal getWarehouseScore() {
		return warehouseScore;
	}
	
	public void setWarehouseScore(BigDecimal warehouseScore) {
		this.warehouseScore = warehouseScore;
	}
	
	public BigDecimal getPackageScore() {
		return packageScore;
	}
	
	public void setPackageScore(BigDecimal packageScore) {
		this.packageScore = packageScore;
	}
	
	public BigDecimal getCheckStockScore() {
		return checkStockScore;
	}
	
	public void setCheckStockScore(BigDecimal checkStockScore) {
		this.checkStockScore = checkStockScore;
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
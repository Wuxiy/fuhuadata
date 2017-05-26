package com.fuhuadata.domain.mybatis.supplier;

import com.fuhuadata.domain.mybatis.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * 仓库评分
 */
@Table(name = "s_warehouse_score")
public class WarehouseScore extends BaseEntity<Integer>{
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 仓库id
     */
    @Column(name = "customer_id")
    private String customerId;

    /**
     * 月份时间
     */
    @Column(name = "month_time")
    private String monthTime;

    /**
     * 报表及时性评分
     */
    @Column(name = "time_score")
    private BigDecimal timeScore;

    /**
     * 报表准确性
     */
    @Column(name = "accuracy_score")
    private BigDecimal accuracyScore;

    /**
     * 入库
     */
    @Column(name = "storage_score")
    private BigDecimal storageScore;

    /**
     * 仓储
     */
    @Column(name = "warehouse_score")
    private BigDecimal warehouseScore;

    /**
     * 换包装
     */
    @Column(name = "package_score")
    private BigDecimal packageScore;

    /**
     * 盘库
     */
    @Column(name = "check_stock_score")
    private BigDecimal checkStockScore;

    /**
     * 总评分
     */
    @Column(name = "total_score")
    private BigDecimal totalScore;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 评价时间
     */
    @Column(name = "evaluate_time")
    private Date evaluateTime;

    /**
     * 评价人id
     */
    @Column(name = "evaluate_user_id")
    private Integer evaluateUserId;

    /**
     * 评价人名称
     */
    @Column(name = "evaluate_user_name")
    private String evaluateUserName;

    /**
     * 创建者id
     */
    @Column(name = "create_user_id")
    private Integer createUserId;

    /**
     * 创建者姓名
     */
    @Column(name = "create_user_name")
    private String createUserName;

    /**
     * 上一次修改者id
     */
    @Column(name = "lastmodify_user_id")
    private Integer lastmodifyUserId;

    /**
     * 上一次修改者姓名
     */
    @Column(name = "lastmodify_user_name")
    private String lastmodifyUserName;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 评价详情
     */
    @Column(name = "evaluation_details")
    private String evaluationDetails;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取仓库id
     *
     * @return customer_id - 仓库id
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * 设置仓库id
     *
     * @param customerId 仓库id
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    /**
     * 获取月份时间
     *
     * @return month_time - 月份时间
     */
    public String getMonthTime() {
        return monthTime;
    }

    /**
     * 设置月份时间
     *
     * @param monthTime 月份时间
     */
    public void setMonthTime(String monthTime) {
        this.monthTime = monthTime == null ? null : monthTime.trim();
    }

    /**
     * 获取报表及时性评分
     *
     * @return time_score - 报表及时性评分
     */
    public BigDecimal getTimeScore() {
        return timeScore;
    }

    /**
     * 设置报表及时性评分
     *
     * @param timeScore 报表及时性评分
     */
    public void setTimeScore(BigDecimal timeScore) {
        this.timeScore = timeScore;
    }

    /**
     * 获取报表准确性
     *
     * @return accuracy_score - 报表准确性
     */
    public BigDecimal getAccuracyScore() {
        return accuracyScore;
    }

    /**
     * 设置报表准确性
     *
     * @param accuracyScore 报表准确性
     */
    public void setAccuracyScore(BigDecimal accuracyScore) {
        this.accuracyScore = accuracyScore;
    }

    /**
     * 获取入库
     *
     * @return storage_score - 入库
     */
    public BigDecimal getStorageScore() {
        return storageScore;
    }

    /**
     * 设置入库
     *
     * @param storageScore 入库
     */
    public void setStorageScore(BigDecimal storageScore) {
        this.storageScore = storageScore;
    }

    /**
     * 获取仓储
     *
     * @return warehouse_score - 仓储
     */
    public BigDecimal getWarehouseScore() {
        return warehouseScore;
    }

    /**
     * 设置仓储
     *
     * @param warehouseScore 仓储
     */
    public void setWarehouseScore(BigDecimal warehouseScore) {
        this.warehouseScore = warehouseScore;
    }

    /**
     * 获取换包装
     *
     * @return package_score - 换包装
     */
    public BigDecimal getPackageScore() {
        return packageScore;
    }

    /**
     * 设置换包装
     *
     * @param packageScore 换包装
     */
    public void setPackageScore(BigDecimal packageScore) {
        this.packageScore = packageScore;
    }

    /**
     * 获取盘库
     *
     * @return check_stock_score - 盘库
     */
    public BigDecimal getCheckStockScore() {
        return checkStockScore;
    }

    /**
     * 设置盘库
     *
     * @param checkStockScore 盘库
     */
    public void setCheckStockScore(BigDecimal checkStockScore) {
        this.checkStockScore = checkStockScore;
    }

    /**
     * 获取总评分
     *
     * @return total_score - 总评分
     */
    public BigDecimal getTotalScore() {
        return totalScore;
    }

    /**
     * 设置总评分
     *
     * @param totalScore 总评分
     */
    public void setTotalScore(BigDecimal totalScore) {
        this.totalScore = totalScore;
    }

    /**
     * 获取备注
     *
     * @return remarks - 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     *
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 获取评价时间
     *
     * @return evaluate_time - 评价时间
     */
    public Date getEvaluateTime() {
        return evaluateTime;
    }

    /**
     * 设置评价时间
     *
     * @param evaluateTime 评价时间
     */
    public void setEvaluateTime(Date evaluateTime) {
        this.evaluateTime = evaluateTime;
    }

    /**
     * 获取评价人id
     *
     * @return evaluate_user_id - 评价人id
     */
    public Integer getEvaluateUserId() {
        return evaluateUserId;
    }

    /**
     * 设置评价人id
     *
     * @param evaluateUserId 评价人id
     */
    public void setEvaluateUserId(Integer evaluateUserId) {
        this.evaluateUserId = evaluateUserId;
    }

    /**
     * 获取评价人名称
     *
     * @return evaluate_user_name - 评价人名称
     */
    public String getEvaluateUserName() {
        return evaluateUserName;
    }

    /**
     * 设置评价人名称
     *
     * @param evaluateUserName 评价人名称
     */
    public void setEvaluateUserName(String evaluateUserName) {
        this.evaluateUserName = evaluateUserName == null ? null : evaluateUserName.trim();
    }

    /**
     * 获取创建者id
     *
     * @return create_user_id - 创建者id
     */
    public Integer getCreateUserId() {
        return createUserId;
    }

    /**
     * 设置创建者id
     *
     * @param createUserId 创建者id
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 获取创建者姓名
     *
     * @return create_user_name - 创建者姓名
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 设置创建者姓名
     *
     * @param createUserName 创建者姓名
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * 获取上一次修改者id
     *
     * @return lastmodify_user_id - 上一次修改者id
     */
    public Integer getLastmodifyUserId() {
        return lastmodifyUserId;
    }

    /**
     * 设置上一次修改者id
     *
     * @param lastmodifyUserId 上一次修改者id
     */
    public void setLastmodifyUserId(Integer lastmodifyUserId) {
        this.lastmodifyUserId = lastmodifyUserId;
    }

    /**
     * 获取上一次修改者姓名
     *
     * @return lastmodify_user_name - 上一次修改者姓名
     */
    public String getLastmodifyUserName() {
        return lastmodifyUserName;
    }

    /**
     * 设置上一次修改者姓名
     *
     * @param lastmodifyUserName 上一次修改者姓名
     */
    public void setLastmodifyUserName(String lastmodifyUserName) {
        this.lastmodifyUserName = lastmodifyUserName == null ? null : lastmodifyUserName.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取评价详情
     *
     * @return evaluation_details - 评价详情
     */
    public String getEvaluationDetails() {
        return evaluationDetails;
    }

    /**
     * 设置评价详情
     *
     * @param evaluationDetails 评价详情
     */
    public void setEvaluationDetails(String evaluationDetails) {
        this.evaluationDetails = evaluationDetails == null ? null : evaluationDetails.trim();
    }
}
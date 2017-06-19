package com.fuhuadata.domain.mybatis.supplier;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fuhuadata.domain.mybatis.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * 货代评分
 */
@Table(name = "s_forwarding_score")
public class ForwardingScore extends BaseEntity<Integer> {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 货代id
     */
    @Column(name = "freightforwarding_id")
    private Integer forwardingId;

    /**
     * 月份时间
     */
    @Column(name = "month_time")
    private String monthTime;

    /**
     * 客服得分
     */
    @Column(name = "service_score")
    private BigDecimal serviceScore;

    /**
     * 价格得分
     */
    @Column(name = "price_score")
    private BigDecimal priceScore;

    /**
     * 仓储得分
     */
    @Column(name = "warehouse_score")
    private BigDecimal warehouseScore;

    /**
     * 投诉反馈得分
     */
    @Column(name = "complaints_score")
    private BigDecimal complaintsScore;

    /**
     * 总评分
     */
    @Column(name = "total_score")
    private BigDecimal totalScore;

    /**
     * 评价详情,json格式数据
     */
    @Column(name = "evaluation_details")
    private String evaluationDetails;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 修改原因
     */
    @Column(name = "modify_reason")
    private String modifyReason;

    /**
     * 评价时间
     */
    @Column(name = "evaluate_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;

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
     * 获取客服得分
     *
     * @return service_score - 客服得分
     */
    public BigDecimal getServiceScore() {
        return serviceScore;
    }

    /**
     * 设置客服得分
     *
     * @param serviceScore 客服得分
     */
    public void setServiceScore(BigDecimal serviceScore) {
        this.serviceScore = serviceScore;
    }

    /**
     * 获取价格得分
     *
     * @return price_score - 价格得分
     */
    public BigDecimal getPriceScore() {
        return priceScore;
    }

    /**
     * 设置价格得分
     *
     * @param priceScore 价格得分
     */
    public void setPriceScore(BigDecimal priceScore) {
        this.priceScore = priceScore;
    }

    /**
     * 获取仓储得分
     *
     * @return warehouse_score - 仓储得分
     */
    public BigDecimal getWarehouseScore() {
        return warehouseScore;
    }

    /**
     * 设置仓储得分
     *
     * @param warehouseScore 仓储得分
     */
    public void setWarehouseScore(BigDecimal warehouseScore) {
        this.warehouseScore = warehouseScore;
    }

    /**
     * 获取投诉反馈得分
     *
     * @return complaints_score - 投诉反馈得分
     */
    public BigDecimal getComplaintsScore() {
        return complaintsScore;
    }

    /**
     * 设置投诉反馈得分
     *
     * @param complaintsScore 投诉反馈得分
     */
    public void setComplaintsScore(BigDecimal complaintsScore) {
        this.complaintsScore = complaintsScore;
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
     * 获取评价详情,json格式数据
     *
     * @return evaluation_details - 评价详情,json格式数据
     */
    public String getEvaluationDetails() {
        return evaluationDetails;
    }

    /**
     * 设置评价详情,json格式数据
     *
     * @param evaluationDetails 评价详情,json格式数据
     */
    public void setEvaluationDetails(String evaluationDetails) {
        this.evaluationDetails = evaluationDetails == null ? null : evaluationDetails.trim();
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
     * 获取修改原因
     *
     * @return modify_reason - 修改原因
     */
    public String getModifyReason() {
        return modifyReason;
    }

    /**
     * 设置修改原因
     *
     * @param modifyReason 修改原因
     */
    public void setModifyReason(String modifyReason) {
        this.modifyReason = modifyReason == null ? null : modifyReason.trim();
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

    public Integer getForwardingId() {
        return forwardingId;
    }

    public void setForwardingId(Integer forwardingId) {
        this.forwardingId = forwardingId;
    }
}
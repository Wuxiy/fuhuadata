package com.fuhuadata.domain.mybatis.supplier;

import com.fuhuadata.domain.mybatis.BaseEntity;

import java.math.BigDecimal;
import javax.persistence.*;

/**
 * 货代评价表关联表
 */
@Table(name = "s_forwarding_evaluation_score_relation")
public class ForwardingEvaluationScoreRelation extends BaseEntity<Integer> {
    /**
     * 关联表主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    /**
//     * 评价详情项主键
//     */
//    @Column(name = "term_id")
//    private Integer termId;

    /**
     * 货代物流评分表主键
     */
    @Column(name = "forwarding_score_id")
    private Integer forwardingScoreId;

    /**
     * 评价项分值选项主键
     */
    @Column(name = "evaluation_value_id")
    private Integer evaluationValueId;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 得分
     */
    private BigDecimal score;

    /**
     * 关联分值(针对操作规范)
     */
    @Column(name = "multi_value")
    private BigDecimal multiValue;


    /**
     * 评价项id（每一行）
     */
    @Column(name = "evaluation_item_id")
    private Integer evaluationItemId;

    /**
     * 获取关联表主键
     *
     * @return id - 关联表主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置关联表主键
     *
     * @param id 关联表主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取货代物流评分表主键
     *
     * @return forwarding_score_id - 货代物流评分表主键
     */
    public Integer getForwardingScoreId() {
        return forwardingScoreId;
    }

    /**
     * 设置货代物流评分表主键
     *
     * @param forwardingScoreId 货代物流评分表主键
     */
    public void setForwardingScoreId(Integer forwardingScoreId) {
        this.forwardingScoreId = forwardingScoreId;
    }

    /**
     * 获取评价项分值选项主键
     *
     * @return evaluation_value_id - 评价项分值选项主键
     */
    public Integer getEvaluationValueId() {
        return evaluationValueId;
    }

    /**
     * 设置评价项分值选项主键
     *
     * @param evaluationValueId 评价项分值选项主键
     */
    public void setEvaluationValueId(Integer evaluationValueId) {
        this.evaluationValueId = evaluationValueId;
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
     * 获取得分
     *
     * @return score - 得分
     */
    public BigDecimal getScore() {
        return score;
    }

    /**
     * 设置得分
     *
     * @param score 得分
     */
    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public BigDecimal getMultiValue() {
        return multiValue;
    }

    public void setMultiValue(BigDecimal multiValue) {
        this.multiValue = multiValue;
    }

    public Integer getEvaluationItemId() {
        return evaluationItemId;
    }

    public void setEvaluationItemId(Integer evaluationItemId) {
        this.evaluationItemId = evaluationItemId;
    }
}
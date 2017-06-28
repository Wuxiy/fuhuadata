package com.fuhuadata.domain.mybatis.supplier;

import com.fuhuadata.domain.mybatis.BaseEntity;

import java.math.BigDecimal;
import javax.persistence.*;

/**
 * 仓库评价得分表
 */
@Table(name = "s_warehouse_evaluation_score_relation")
public class WarehouseEvaluationScoreRelation extends BaseEntity<Integer> {
    /**
     * 关联表主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 仓库评分表主键
     */
    @Column(name = "warehouse_score_id")
    private Integer warehouseScoreId;

//    /**
//     * 评价详情项主键
//     */
//    @Column(name = "score_item_id")
//    private Integer scoreItemId;

    /**
     * 评价项分值选项id主键
     */
    @Column(name = "evaluation_value_id")
    private Integer evaluationValueId;

    /**
     * 评价项每行id
     */
    @Column(name = "evaluation_item_id")
    private Integer evaluationItemId;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 得分
     */
    private BigDecimal score;

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
     * 获取仓库评分表主键
     *
     * @return warehouse_score_id - 仓库评分表主键
     */
    public Integer getWarehouseScoreId() {
        return warehouseScoreId;
    }

    /**
     * 设置仓库评分表主键
     *
     * @param warehouseScoreId 仓库评分表主键
     */
    public void setWarehouseScoreId(Integer warehouseScoreId) {
        this.warehouseScoreId = warehouseScoreId;
    }

    /**
     * 获取评价项分值选项id主键
     *
     * @return evaluation_value_id - 评价项分值选项id主键
     */
    public Integer getEvaluationValueId() {
        return evaluationValueId;
    }

    /**
     * 设置评价项分值选项id主键
     *
     * @param evaluationValueId 评价项分值选项id主键
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

    public Integer getEvaluationItemId() {
        return evaluationItemId;
    }

    public void setEvaluationItemId(Integer evaluationItemId) {
        this.evaluationItemId = evaluationItemId;
    }
}
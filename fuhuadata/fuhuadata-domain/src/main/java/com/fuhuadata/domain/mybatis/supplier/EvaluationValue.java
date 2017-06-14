package com.fuhuadata.domain.mybatis.supplier;

import com.fuhuadata.domain.mybatis.BaseEntity;

import java.math.BigDecimal;
import javax.persistence.*;

/**
 * 选项分值表
 */
@Table(name = "s_evaluation_value")
public class EvaluationValue extends BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 评价指标类型  0 加工厂  1：货代  2： 仓库
     */
    private Integer type;

    /**
     * 评价详情项id
     */
    @Column(name = "evaluation_item_id")
    private Integer evaluationItemId;

    @Column(name = "option_name")
    private String optionName;

    private BigDecimal value;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取评价指标类型  0 加工厂  1：货代  2： 仓库
     *
     * @return type - 评价指标类型  0 加工厂  1：货代  2： 仓库
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置评价指标类型  0 加工厂  1：货代  2： 仓库
     *
     * @param type 评价指标类型  0 加工厂  1：货代  2： 仓库
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取评价详情项id
     *
     * @return evaluation_item_id - 评价详情项id
     */
    public Integer getEvaluationItemId() {
        return evaluationItemId;
    }

    /**
     * 设置评价详情项id
     *
     * @param evaluationItemId 评价详情项id
     */
    public void setEvaluationItemId(Integer evaluationItemId) {
        this.evaluationItemId = evaluationItemId;
    }

    /**
     * @return option_name
     */
    public String getOptionName() {
        return optionName;
    }

    /**
     * @param optionName
     */
    public void setOptionName(String optionName) {
        this.optionName = optionName == null ? null : optionName.trim();
    }

    /**
     * @return value
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * @param value
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
package com.fuhuadata.domain.mybatis.supplier;

import com.fuhuadata.domain.mybatis.BaseEntity;

import java.math.BigDecimal;
import javax.persistence.*;

/**
 * 得分选项表
 */
@Table(name = "s_score_term")
public class ScoreTerm extends BaseEntity<Integer> {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 评价指标类型  0 加工厂  1：货代  2： 仓库
     */
    private Integer type;

    /**
     * 一级指标
     */
    @Column(name = "first_level_index")
    private String firstLevelIndex;

    /**
     * 二级指标
     */
    @Column(name = "two_level_index")
    private String twoLevelIndex;

    /**
     * 三级指标
     */
    @Column(name = "three_level_index")
    private String threeLevelIndex;

    /**
     * 项显示顺序
     */
    @Column(name="item_order")
    private Integer itemOrder;

    /**
     * 选项满分值
     */
    @Column(name = "item_full_marks")
    private BigDecimal itemFullMarks;

    /**
     * 指标项id
     */
    @Transient
    private Integer evaluationItemId;

    /**
     * 选项
     */
    @Transient
    private String optionName;

    /**
     * 分值
     */
    @Transient
    private BigDecimal value;

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
     * 获取一级指标
     *
     * @return first_level_index - 一级指标
     */
    public String getFirstLevelIndex() {
        return firstLevelIndex;
    }

    /**
     * 设置一级指标
     *
     * @param firstLevelIndex 一级指标
     */
    public void setFirstLevelIndex(String firstLevelIndex) {
        this.firstLevelIndex = firstLevelIndex == null ? null : firstLevelIndex.trim();
    }

    /**
     * 获取二级指标
     *
     * @return two_level_index - 二级指标
     */
    public String getTwoLevelIndex() {
        return twoLevelIndex;
    }

    /**
     * 设置二级指标
     *
     * @param twoLevelIndex 二级指标
     */
    public void setTwoLevelIndex(String twoLevelIndex) {
        this.twoLevelIndex = twoLevelIndex == null ? null : twoLevelIndex.trim();
    }

    /**
     * 获取三级指标
     *
     * @return three_level_index - 三级指标
     */
    public String getThreeLevelIndex() {
        return threeLevelIndex;
    }

    /**
     * 设置三级指标
     *
     * @param threeLevelIndex 三级指标
     */
    public void setThreeLevelIndex(String threeLevelIndex) {
        this.threeLevelIndex = threeLevelIndex == null ? null : threeLevelIndex.trim();
    }

    /**
     * 获取选项满分值
     *
     * @return item_full_marks - 选项满分值
     */
    public BigDecimal getItemFullMarks() {
        return itemFullMarks;
    }

    /**
     * 设置选项满分值
     *
     * @param itemFullMarks 选项满分值
     */
    public void setItemFullMarks(BigDecimal itemFullMarks) {
        this.itemFullMarks = itemFullMarks;
    }

    public Integer getEvaluationItemId() {
        return evaluationItemId;
    }

    public void setEvaluationItemId(Integer evaluationItemId) {
        this.evaluationItemId = evaluationItemId;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Integer getItemOrder() {
        return itemOrder;
    }

    public void setItemOrder(Integer itemOrder) {
        this.itemOrder = itemOrder;
    }
}
package com.fuhuadata.domain.supplier;

import com.fuhuadata.domain.mybatis.BaseEntity;

import javax.persistence.*;
import java.beans.IntrospectionException;

/**
 * 加工厂评价表项
 */
@Table(name = "s_factory_eva_item")
public class FactoryEvaItem extends BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 指标名称
     */
    @Column(name = "target_name")
    private String targetName;

    /**
     * 总分
     */
    private Short score;

    /**
     * 备注
     */
    private String remark;

    /**
     * 排序
     */
    private Short index;

    /**
     * 评分
     */
    @Transient
    private Short evaScore;

    /**
     * 指标备注
     */
    @Transient
    private String evaRemark;

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
     * 获取指标名称
     *
     * @return target_name - 指标名称
     */
    public String getTargetName() {
        return targetName;
    }

    /**
     * 设置指标名称
     *
     * @param targetName 指标名称
     */
    public void setTargetName(String targetName) {
        this.targetName = targetName == null ? null : targetName.trim();
    }

    /**
     * 获取总分
     *
     * @return score - 总分
     */
    public Short getScore() {
        return score;
    }

    /**
     * 设置总分
     *
     * @param score 总分
     */
    public void setScore(Short score) {
        this.score = score;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Short getIndex() {
        return index;
    }

    public void setIndex(Short index) {
        this.index = index;
    }

    public Short getEvaScore() {
        return evaScore;
    }

    public void setEvaScore(Short evaScore) {
        this.evaScore = evaScore;
    }

    public String getEvaRemark() {
        return evaRemark;
    }

    public void setEvaRemark(String evaRemark) {
        this.evaRemark = evaRemark;
    }

    public static void main(String[] args) throws IntrospectionException {

        printProperties(FactoryEvaItem.class, "fei.");

    }
}
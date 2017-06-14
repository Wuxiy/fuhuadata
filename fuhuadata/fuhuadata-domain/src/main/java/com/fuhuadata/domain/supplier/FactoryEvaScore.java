package com.fuhuadata.domain.supplier;

import com.fuhuadata.domain.mybatis.BaseEntity;

import javax.persistence.*;

/**
 * 加工厂评价分值表
 */
@Table(name = "s_factory_eva_score")
public class FactoryEvaScore extends BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 订单id
     */
    @Column(name = "order_id")
    private Integer orderId;

    /**
     * 表项id
     */
    @Column(name = "item_id")
    private Integer itemId;

    /**
     * 评分
     */
    private Short score;

    /**
     * 备注
     */
    private String remark;

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
     * 获取订单id
     *
     * @return order_id - 订单id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 设置订单id
     *
     * @param orderId 订单id
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取表项id
     *
     * @return item_id - 表项id
     */
    public Integer getItemId() {
        return itemId;
    }

    /**
     * 设置表项id
     *
     * @param itemId 表项id
     */
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    /**
     * 获取评分
     *
     * @return score - 评分
     */
    public Short getScore() {
        return score;
    }

    /**
     * 设置评分
     *
     * @param score 评分
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
}
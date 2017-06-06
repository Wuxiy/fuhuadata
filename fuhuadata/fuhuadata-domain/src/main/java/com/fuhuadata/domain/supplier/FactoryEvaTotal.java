package com.fuhuadata.domain.supplier;

import com.fuhuadata.domain.mybatis.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Table(name = "s_factory_eva_total")
public class FactoryEvaTotal extends BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 订单id
     */
    @Column(name = "order_id")
    private Integer orderId;

    /**
     * 综合评分
     */
    @Column(name = "total_score")
    private Short totalScore;

    /**
     * 备注
     */
    private String remark;

    /**
     * 评分明细
     */
    @Transient
    private List<FactoryEvaItem> items;

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
     * 获取综合评分
     *
     * @return total_score - 综合评分
     */
    public Short getTotalScore() {
        return totalScore;
    }

    /**
     * 设置综合评分
     *
     * @param totalScore 综合评分
     */
    public void setTotalScore(Short totalScore) {
        this.totalScore = totalScore;
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

    public List<FactoryEvaItem> getItems() {
        return items;
    }

    public void setItems(List<FactoryEvaItem> items) {
        this.items = items;
    }
}
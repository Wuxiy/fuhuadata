package com.fuhuadata.domain.mybatis;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "customer_purchase_supplier")
public class CustomerPurchaseSupplier extends BaseEntity<Integer> {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 采购产品id
     */
    @Column(name = "purchase_id")
    private Integer purchaseId;

    /**
     * 标准产品id
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 供应商名称
     */
    private String name;

    /**
     * 年采购量
     */
    private Integer amount;

    /**
     * 平均单价
     */
    @Column(name = "price_average")
    private BigDecimal priceAverage;

    /**
     * 主计量单位
     */
    private String measurement;

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
     * 获取供应商名称
     *
     * @return name - 供应商名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置供应商名称
     *
     * @param name 供应商名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取年采购量
     *
     * @return amount - 年采购量
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * 设置年采购量
     *
     * @param amount 年采购量
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * 获取平均单价
     *
     * @return price_average - 平均单价
     */
    public BigDecimal getPriceAverage() {
        return priceAverage;
    }

    /**
     * 设置平均单价
     *
     * @param priceAverage 平均单价
     */
    public void setPriceAverage(BigDecimal priceAverage) {
        this.priceAverage = priceAverage;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }
}
package com.fuhuadata.domain.supplier;

import com.fuhuadata.domain.mybatis.BaseEntity;

import javax.persistence.*;
import java.beans.IntrospectionException;

@Table(name = "s_factory_product_addr")
public class ProduceFactoryProductAddr extends BaseEntity<Integer> {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 加工厂产品id
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 产品地址
     */
    private String addr;

    /**
     * 产能单位
     */
    @Column(name = "capacity_unit")
    private String capacityUnit;

    /**
     * 备注
     */
    private String remark;

    /**
     * 产能
     */
    private String capacity;

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
     * 获取加工厂产品id
     *
     * @return product_id - 加工厂产品id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置加工厂产品id
     *
     * @param productId 加工厂产品id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取产品地址
     *
     * @return addr - 产品地址
     */
    public String getAddr() {
        return addr;
    }

    /**
     * 设置产品地址
     *
     * @param addr 产品地址
     */
    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    /**
     * 获取产能单位
     *
     * @return capacity_unit - 产能单位
     */
    public String getCapacityUnit() {
        return capacityUnit;
    }

    /**
     * 设置产能单位
     *
     * @param capacityUnit 产能单位
     */
    public void setCapacityUnit(String capacityUnit) {
        this.capacityUnit = capacityUnit == null ? null : capacityUnit.trim();
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

    /**
     * 获取产能
     *
     * @return capacity - 产能
     */
    public String getCapacity() {
        return capacity;
    }

    /**
     * 设置产能
     *
     * @param capacity 产能
     */
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public static void main(String[] args) throws IntrospectionException {
        printProperties(ProduceFactoryProductAddr.class, "pfpa.");
    }
}
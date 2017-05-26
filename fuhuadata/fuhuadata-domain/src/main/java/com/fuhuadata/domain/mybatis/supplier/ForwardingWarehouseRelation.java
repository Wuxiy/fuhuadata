package com.fuhuadata.domain.mybatis.supplier;

import com.fuhuadata.domain.mybatis.BaseEntity;

import javax.persistence.*;

/**
 *  货代评分
 */
@Table(name = "s_forwarding_warehouse_relation")
public class ForwardingWarehouseRelation extends BaseEntity<Integer> {
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
    private String freightforwardingId;

    /**
     * 仓库id
     */
    @Column(name = "warehouse_id")
    private String warehouseId;

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
     * 获取货代id
     *
     * @return freightforwarding_id - 货代id
     */
    public String getFreightforwardingId() {
        return freightforwardingId;
    }

    /**
     * 设置货代id
     *
     * @param freightforwardingId 货代id
     */
    public void setFreightforwardingId(String freightforwardingId) {
        this.freightforwardingId = freightforwardingId == null ? null : freightforwardingId.trim();
    }

    /**
     * 获取仓库id
     *
     * @return warehouse_id - 仓库id
     */
    public String getWarehouseId() {
        return warehouseId;
    }

    /**
     * 设置仓库id
     *
     * @param warehouseId 仓库id
     */
    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId == null ? null : warehouseId.trim();
    }
}
package com.fuhuadata.domain.customs;

import com.fuhuadata.domain.mybatis.BaseEntity;

import javax.persistence.*;

@Table(name = "customs_product")
public class CustomsProduct extends BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 1：水剂，2：颗粒剂，3：原药
     */
    @Column(name = "type_id")
    private Integer typeId;

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
     * 获取产品名称
     *
     * @return name - 产品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置产品名称
     *
     * @param name 产品名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取1：水剂，2：颗粒剂，3：原药
     *
     * @return type_id - 1：水剂，2：颗粒剂，3：原药
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * 设置1：水剂，2：颗粒剂，3：原药
     *
     * @param typeId 1：水剂，2：颗粒剂，3：原药
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
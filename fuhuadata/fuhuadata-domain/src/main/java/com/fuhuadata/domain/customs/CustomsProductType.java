package com.fuhuadata.domain.customs;

import com.fuhuadata.domain.mybatis.BaseEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "customs_product_type")
public class CustomsProductType extends BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 产品类型名称
     */
    private String name;

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
     * 获取产品类型名称
     *
     * @return name - 产品类型名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置产品类型名称
     *
     * @param name 产品类型名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
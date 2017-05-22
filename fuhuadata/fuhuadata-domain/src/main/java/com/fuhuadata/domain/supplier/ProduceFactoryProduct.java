package com.fuhuadata.domain.supplier;

import com.fuhuadata.domain.mybatis.BaseEntity;

import javax.persistence.*;

@Table(name = "s_factory_product")
public class ProduceFactoryProduct extends BaseEntity<Integer> {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 加工厂id
     */
    @Column(name = "factory_id")
    private Integer factoryId;

    /**
     * 商品品类id
     */
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 商品品类名称
     */
    private String category;

    /**
     * 产品（物料）名称id
     */
    @Column(name = "cmaterial_id")
    private String cmaterialId;

    /**
     * 备注
     */
    private String remark;

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
     * 获取加工厂id
     *
     * @return factory_id - 加工厂id
     */
    public Integer getFactoryId() {
        return factoryId;
    }

    /**
     * 设置加工厂id
     *
     * @param factoryId 加工厂id
     */
    public void setFactoryId(Integer factoryId) {
        this.factoryId = factoryId;
    }

    /**
     * 获取商品品类id
     *
     * @return category_id - 商品品类id
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置商品品类id
     *
     * @param categoryId 商品品类id
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取商品品类名称
     *
     * @return category - 商品品类名称
     */
    public String getCategory() {
        return category;
    }

    /**
     * 设置商品品类名称
     *
     * @param category 商品品类名称
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    /**
     * 获取产品（物料）名称id
     *
     * @return cmaterial_id - 产品（物料）名称id
     */
    public String getCmaterialId() {
        return cmaterialId;
    }

    /**
     * 设置产品（物料）名称id
     *
     * @param cmaterialId 产品（物料）名称id
     */
    public void setCmaterialId(String cmaterialId) {
        this.cmaterialId = cmaterialId == null ? null : cmaterialId.trim();
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
package com.fuhuadata.domain.supplier;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuhuadata.domain.mybatis.BaseEntity;

import javax.persistence.*;
import java.beans.IntrospectionException;
import java.util.List;

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
     * 产品（物料）名称
     */
    @Transient
    private String cmaterialName;

    /**
     * 质量
     */
    private Byte quality;

    /**
     * 规格
     */
    @Transient
    private String specification;

    /**
     * 总产能
     */
    private String capacity;

    /**
     * 总产能单位
     */
    @Column(name = "capacity_unit")
    private String capacityUnit;

    /**
     * 备注
     */
    private String remark;

    /**
     * 产品厂址
     */
    @Transient
    private List<ProduceFactoryProductAddr> productAddrs;

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

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity == null ? null : capacity.trim();
    }

    public String getCapacityUnit() {
        return capacityUnit;
    }

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

    public List<ProduceFactoryProductAddr> getProductAddrs() {
        return productAddrs;
    }

    public void setProductAddrs(List<ProduceFactoryProductAddr> productAddrs) {
        this.productAddrs = productAddrs;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getCmaterialName() {
        return cmaterialName;
    }

    public void setCmaterialName(String cmaterialName) {
        this.cmaterialName = cmaterialName;
    }

    public static void main(String[] args) throws IntrospectionException, JsonProcessingException {
//        printProperties(ProduceFactoryProduct.class, "pfp.");

        ProduceFactoryProduct product = new ProduceFactoryProduct();
        System.out.println(JSON.toJSONString(product, SerializerFeature.WriteMapNullValue));

        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(product);
        System.out.println(s);
    }

    public Byte getQuality() {
        return quality;
    }

    public void setQuality(Byte quality) {
        this.quality = quality;
    }
}
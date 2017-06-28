package com.fuhuadata.domain.customs;

import com.fuhuadata.domain.mybatis.BaseEntity;

import javax.persistence.*;
import java.util.regex.Pattern;

@Table(name = "customs_product_rule")
public class CustomsProductRule extends BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 海关数据产品id
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 1：全词匹配；2：模糊匹配
     */
    @Column(name = "name_type")
    private Byte nameType;

    /**
     * 匹配的产品名称，当存在多个模糊匹配词语时，用英文逗号（,）隔开
     */
    private String name;

    /**
     * java产品名称正则匹配规则
     */
    @Transient
    private Pattern namePattern;

    /**
     * 1：全词匹配；2：模糊匹配
     */
    @Column(name = "spec_type")
    private Byte specType;

    /**
     * 匹配的产品规格，当存在多个模糊匹配词语时，用英文逗号（,）隔开
     */
    private String spec;

    /**
     * 产品规格正则匹配规则
     */
    @Transient
    private Pattern specPattern;

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
     * 获取海关数据产品id
     *
     * @return product_id - 海关数据产品id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置海关数据产品id
     *
     * @param productId 海关数据产品id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取1：全词匹配；2：模糊匹配
     *
     * @return name_type - 1：全词匹配；2：模糊匹配
     */
    public Byte getNameType() {
        return nameType;
    }

    /**
     * 设置1：全词匹配；2：模糊匹配
     *
     * @param nameType 1：全词匹配；2：模糊匹配
     */
    public void setNameType(Byte nameType) {
        this.nameType = nameType;
    }

    /**
     * 获取匹配的产品名称，当存在多个模糊匹配词语时，用英文逗号（,）隔开
     *
     * @return name - 匹配的产品名称，当存在多个模糊匹配词语时，用英文逗号（,）隔开
     */
    public String getName() {
        return name;
    }

    /**
     * 设置匹配的产品名称，当存在多个模糊匹配词语时，用英文逗号（,）隔开
     *
     * @param name 匹配的产品名称，当存在多个模糊匹配词语时，用英文逗号（,）隔开
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取1：全词匹配；2：模糊匹配
     *
     * @return spec_type - 1：全词匹配；2：模糊匹配
     */
    public Byte getSpecType() {
        return specType;
    }

    /**
     * 设置1：全词匹配；2：模糊匹配
     *
     * @param specType 1：全词匹配；2：模糊匹配
     */
    public void setSpecType(Byte specType) {
        this.specType = specType;
    }

    /**
     * 获取匹配的产品规格，当存在多个模糊匹配词语时，用英文逗号（,）隔开
     *
     * @return spec - 匹配的产品规格，当存在多个模糊匹配词语时，用英文逗号（,）隔开
     */
    public String getSpec() {
        return spec;
    }

    /**
     * 设置匹配的产品规格，当存在多个模糊匹配词语时，用英文逗号（,）隔开
     *
     * @param spec 匹配的产品规格，当存在多个模糊匹配词语时，用英文逗号（,）隔开
     */
    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    public Pattern getNamePattern() {
        return namePattern;
    }

    public void setNamePattern(Pattern namePattern) {
        this.namePattern = namePattern;
    }

    public Pattern getSpecPattern() {
        return specPattern;
    }

    public void setSpecPattern(Pattern specPattern) {
        this.specPattern = specPattern;
    }
}
package com.fuhuadata.domain.mybatis;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "p_areaclass")
public class AreaClass extends BaseEntity<Integer> {

    /**
     * 大区划分
     */
    @Id
    @Column(name = "areaclass_id")
    private Integer areaclassId;

    private String name;

    /**
     * 获取大区划分
     *
     * @return areaclass_id - 大区划分
     */
    public Integer getAreaclassId() {
        return areaclassId;
    }

    /**
     * 设置大区划分
     *
     * @param areaclassId 大区划分
     */
    public void setAreaclassId(Integer areaclassId) {
        this.areaclassId = areaclassId;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Override
    public void setId(Integer id) {
        this.areaclassId = id;
    }

    @Override
    public Integer getId() {
        return this.areaclassId;
    }
}
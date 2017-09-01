package com.fuhuadata.homesales.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fuhuadata.domain.mybatis.BaseEntity;
import com.fuhuadata.domain.plugin.Treeable;

import javax.persistence.*;

@Table(name = "h_area")
public class Area extends BaseEntity<Integer> implements Treeable<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 地区名称
     */
    private String name;

    /**
     * 上级id
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 所有的上级id，使用逗号分隔
     */
    @Column(name = "parent_ids")
    private String parentIds;

    /**
     * 权重
     */
    private Integer weight;

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
     * 获取地区名称
     *
     * @return name - 地区名称
     */
    public String getName() {
        return name;
    }

    @Override
    public String getIcon() {
        return null;
    }

    @Override
    public void setIcon(String icon) {

    }

    /**
     * 设置地区名称
     *
     * @param name 地区名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取上级id
     *
     * @return parent_id - 上级id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置上级id
     *
     * @param parentId 上级id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取所有的上级id，使用逗号分隔
     *
     * @return parent_ids - 所有的上级id，使用逗号分隔
     */
    public String getParentIds() {
        return parentIds;
    }

    /**
     * 设置所有的上级id，使用逗号分隔
     *
     * @param parentIds 所有的上级id，使用逗号分隔
     */
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds == null ? null : parentIds.trim();
    }

    @JsonIgnore
    @Override
    public String getSeparator() {
        return ",";
    }

    @Override
    public String makeSelfAsNewParentIds() {
        return null;
    }

    /**
     * 获取权重
     *
     * @return weight - 权重
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * 设置权重
     *
     * @param weight 权重
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @JsonIgnore
    @Override
    public boolean isRoot() {
        return false;
    }

    @JsonIgnore
    @Override
    public boolean isLeaf() {
        return false;
    }

    @JsonIgnore
    @Override
    public boolean isHasChildren() {
        return false;
    }

    @JsonIgnore
    @Override
    public String getRootDefaultIcon() {
        return null;
    }

    @JsonIgnore
    @Override
    public String getBranchDefaultIcon() {
        return null;
    }

    @JsonIgnore
    @Override
    public String getLeafDefaultIcon() {
        return null;
    }
}
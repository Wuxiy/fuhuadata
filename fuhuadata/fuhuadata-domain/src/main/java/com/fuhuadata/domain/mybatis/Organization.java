package com.fuhuadata.domain.mybatis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fuhuadata.domain.plugin.Treeable;

import javax.persistence.*;
import java.util.Date;

@Table(name = "p_organization")
public class Organization extends BaseEntity<Integer> implements Treeable<String> {
    /**
     * 组织id
     */
    @Id
    @Column(name = "org_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orgId;

    /**
     * 父级id
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 组织名称
     */
    private String name;

    /**
     * 组织编码
     */
    @Column(name = "code")
    private String code;

    @Column(name = "nc_id")
    private String ncId;

    /**
     * 是否是销售组织 0：否 1：是
     */
    @Column(name = "is_sale_role")
    private Byte isSaleRole;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取组织id
     *
     * @return org_id - 组织id
     */
    public Integer getOrgId() {
        return orgId;
    }

    /**
     * 设置组织id
     *
     * @param orgId 组织id
     */
    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    /**
     * 获取父级id
     *
     * @return parent_id - 父级id
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父级id
     *
     * @param parentId 父级id
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @JsonIgnore
    @Override
    public String getParentIds() {
        return null;
    }

    @Override
    public void setParentIds(String parentIds) {

    }

    @Override
    public String getSeparator() {
        return null;
    }

    @JsonIgnore
    @Override
    public String makeSelfAsNewParentIds() {
        return null;
    }

    @JsonIgnore
    @Override
    public Integer getWeight() {
        return null;
    }

    @Override
    public void setWeight(Integer weight) {

    }

    @JsonIgnore
    @Override
    public boolean isRoot() {
        return getParentId() == null || getParentId().equals("~");
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

    @Override
    public String getRootDefaultIcon() {
        return null;
    }

    @Override
    public String getBranchDefaultIcon() {
        return null;
    }

    @Override
    public String getLeafDefaultIcon() {
        return null;
    }

    /**
     * 获取组织名称
     *
     * @return name - 组织名称
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
     * 设置组织名称
     *
     * @param name 组织名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return nc_id
     */
    public String getNcId() {
        return ncId;
    }

    /**
     * @param ncId
     */
    public void setNcId(String ncId) {
        this.ncId = ncId == null ? null : ncId.trim();
    }

    /**
     * 获取是否是销售组织 0：否 1：是
     *
     * @return is_sale_role - 是否是销售组织 0：否 1：是
     */
    public Byte getIsSaleRole() {
        return isSaleRole;
    }

    /**
     * 设置是否是销售组织 0：否 1：是
     *
     * @param isSaleRole 是否是销售组织 0：否 1：是
     */
    public void setIsSaleRole(Byte isSaleRole) {
        this.isSaleRole = isSaleRole;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JsonIgnore
    @Override
    public void setId(Integer id) {
        this.orgId = id;
    }

    @Override
    public Integer getId() {
        return this.orgId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
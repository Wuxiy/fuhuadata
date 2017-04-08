package com.fuhuadata.domain.mybatis;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fuhuadata.domain.plugin.Treeable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "p_role")
public class Role extends BaseEntity<Integer> implements Treeable<Integer> {
    /**
     * 角色id
     */
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    /**
     * 组织id
     */
    @Column(name = "org_id")
    private Integer orgId;

    /**
     * 组织名称
     */
    @Transient
    private String orgName;

    /**
     * 上级角色id
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 上级角色名称
     */
    @Transient
    private String parentName;

    /**
     * 上级角色ids
     */
    @Column(name = "parent_ids")
    private String parentIds;

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String name;

    /**
     * 角色顺序
     */
    @Column(name = "weight")
    private Integer weight;

    /**
     * 启用状态
     */
    @Column(name = "is_enable")
    private Byte enable;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time")
    private Date createTime;

    @Transient
    private List<UserAccount> users;

    /**
     * 获取角色id
     *
     * @return role_id - 角色id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置角色id
     *
     * @param roleId 角色id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

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
     * 获取上级角色id
     *
     * @return parent_id - 上级角色id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置上级角色id
     *
     * @param parentId 上级角色id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取上级角色ids
     *
     * @return parent_ids - 上级角色ids
     */
    public String getParentIds() {
        return parentIds;
    }

    /**
     * 设置上级角色ids
     *
     * @param parentIds 上级角色ids
     */
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds == null ? null : parentIds.trim();
    }

    @JsonIgnore
    @Override
    public String getSeparator() {
        return ",";
    }

    @JsonIgnore
    @Override
    public String makeSelfAsNewParentIds() {
        return getParentIds() + getId() + getSeparator();
    }

    @JsonIgnore
    @Override
    public Integer getWeight() {
        return this.weight;
    }

    @Override
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

    /**
     * 获取角色名称
     *
     * @return role_name - 角色名称
     */
    public String getName() {
        return name;
    }

    @JsonIgnore
    @Override
    public String getIcon() {
        return null;
    }

    @Override
    public void setIcon(String icon) {

    }

    /**
     * 设置角色名称
     *
     * @param name 角色名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    @Override
    public void setId(Integer id) {
        this.roleId = id;
    }

    @JsonIgnore
    @Override
    public Integer getId() {
        return this.roleId;
    }

    public Byte getEnable() {
        return enable;
    }

    public void setEnable(Byte enable) {
        this.enable = enable;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<UserAccount> getUsers() {
        return users;
    }

    public void setUsers(List<UserAccount> users) {
        this.users = users;
    }
}
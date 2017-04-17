package com.fuhuadata.domain.mybatis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fuhuadata.domain.plugin.Treeable;

import javax.persistence.*;
import java.util.List;

@Table(name = "p_menu")
public class Menu extends BaseEntity<Integer> implements Treeable<Integer> {
    /**
     * 菜单ID
     */
    @Id
    @Column(name = "menu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer menuId;

    /**
     * 菜单标识
     */
    @Column(name = "identity")
    private String identity;

    /**
     * 上级菜单ID
     */
    @Column(name = "parent_id")
    private Integer parentId;

    @Transient
    private String parentName;

    /**
     * 上级菜单ids
     */
    @Column(name = "parent_ids")
    private String parentIds;

    /**
     * 菜单名称
     */
    @Column(name = "menu_name")
    private String name;

    /**
     * 页面路径
     */
    private String url;

    /**
     * 备注
     */
    private String backup;

    /**
     * 启用状态
     */
    private Byte enablestate;

    /**
     * 菜单顺序
     */
    @Column(name = "order_index")
    private Integer orderIndex;

    /**
     * 角色权限
     */
    @Transient
    private RoleAuthority roleAuthority;

    /**
     * 菜单关联的按钮
     */
    @Transient
    private List<Button> buttons;

    @Override
    public void setId(Integer id) {
        this.menuId = id;
    }

    @JsonIgnore
    @Override
    public Integer getId() {
        return menuId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @JsonIgnore
    @Override
    public String getIcon() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setIcon(String icon) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getBackup() {
        return backup;
    }

    public void setBackup(String backup) {
        this.backup = backup == null ? null : backup.trim();
    }

    public Byte getEnablestate() {
        return enablestate;
    }

    public void setEnablestate(Byte enablestate) {
        this.enablestate = enablestate;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    @JsonIgnore
    @Override
    public String getSeparator() {
        return ",";
    }

    @Override
    public String makeSelfAsNewParentIds() {
        return getParentIds() + getId() + getSeparator();
    }

    @JsonIgnore
    @Override
    public Integer getWeight() {
        return this.orderIndex;
    }

    @Override
    public void setWeight(Integer weight) {
        this.orderIndex = weight;
    }

    @JsonIgnore
    @Override
    public boolean isRoot() {
        return getParentId() != null && getParentId() == 0;
    }

    @JsonIgnore
    @Override
    public boolean isLeaf() {
        return !isRoot() && !isHasChildren();
    }

    @JsonIgnore
    @Override
    public boolean isHasChildren() {
        throw new UnsupportedOperationException("Not supported yet.");
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

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public RoleAuthority getRoleAuthority() {
        return roleAuthority;
    }

    public void setRoleAuthority(RoleAuthority roleAuthority) {
        this.roleAuthority = roleAuthority;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}
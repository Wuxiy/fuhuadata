package com.fuhuadata.domain.mybatis;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fuhuadata.util.StringUtil;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Table(name = "p_role_authority")
public class RoleAuthority extends BaseEntity<Integer> {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 权限类型 1:菜单 2：按钮
     */
    @Column(name = "resource_type")
    private Byte resourceType;

    /**
     * 菜单id
     */
    @Column(name = "resource_id")
    private Integer resourceId;

    /**
     * 名称
     */
    @Transient
    private String resourceName;

    /**
     * 菜单
     */
    @Transient
    private Menu menu;

    /**
     * 授权人id
     */
    @Column(name = "auth_user_id")
    private Integer authUserId;

    /**
     * 授权人姓名
     */
    @Column(name = "auth_user_name")
    private String authUserName;

    /**
     * 授权时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "auth_time")
    private Date authTime;

    /**
     * 功能权限 id 列表
     */
    @Column(name = "permission_ids")
    private String permissionIds;

    /**
     * 功能权限 id 的 set 集合
     */
    @Transient
    private Set<Integer> permissionIdsSet;

    /**
     * 菜单对应的功能按钮
     */
    @Transient
    private List<Button> buttons;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

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
     * 获取权限类型 1:菜单 2：按钮
     *
     * @return resource_type - 权限类型 1:菜单 2：按钮
     */
    public Byte getResourceType() {
        return resourceType;
    }

    /**
     * 设置权限类型 1:菜单 2：按钮
     *
     * @param resourceType 权限类型 1:菜单 2：按钮
     */
    public void setResourceType(Byte resourceType) {
        this.resourceType = resourceType;
    }

    /**
     * 获取菜单id
     *
     * @return resource_id - 菜单id
     */
    public Integer getResourceId() {
        return resourceId;
    }

    /**
     * 设置菜单id
     *
     * @param resourceId 菜单id
     */
    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * 获取授权人id
     *
     * @return auth_user_id - 授权人id
     */
    public Integer getAuthUserId() {
        return authUserId;
    }

    /**
     * 设置授权人id
     *
     * @param authUserId 授权人id
     */
    public void setAuthUserId(Integer authUserId) {
        this.authUserId = authUserId;
    }

    /**
     * 获取授权人姓名
     *
     * @return auth_user_name - 授权人姓名
     */
    public String getAuthUserName() {
        return authUserName;
    }

    /**
     * 设置授权人姓名
     *
     * @param authUserName 授权人姓名
     */
    public void setAuthUserName(String authUserName) {
        this.authUserName = authUserName == null ? null : authUserName.trim();
    }

    /**
     * 获取授权时间
     *
     * @return auth_time - 授权时间
     */
    public Date getAuthTime() {
        return authTime;
    }

    /**
     * 设置授权时间
     *
     * @param authTime 授权时间
     */
    public void setAuthTime(Date authTime) {
        this.authTime = authTime;
    }

    public String getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(String permissionIds) {
        this.permissionIds = permissionIds;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Set<Integer> getPermissionIdsSet() {
        if (permissionIdsSet != null) {
            return permissionIdsSet;
        }

        generatePermissionSet();
        return this.permissionIdsSet;
    }

    private void generatePermissionSet() {
        this.permissionIdsSet = StringUtil.splitToTypeSet(this.permissionIds, ",", Integer.class);
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
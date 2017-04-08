package com.fuhuadata.domain.mybatis;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "p_user_role")
public class UserRole extends BaseEntity<Integer> {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户编码，同步 nc 系统
     */
    @Transient
    private String ncId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    @Transient
    private UserAccount user;

    /**
     * 用户名称
     */
    @Transient
    private String userName;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private Integer roleId;

    @Transient
    private Role role;

    /**
     * 角色名称
     */
    @Transient
    private String roleName;

    /**
     * 生效时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "begin_time")
    private Date beginTime;

    /**
     * 失效时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 授权人id
     */
    @Column(name = "auth_user_id")
    private Integer authUserId;

    /**
     * 授权人
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
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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
     * 获取授权人
     *
     * @return auth_user_name - 授权人
     */
    public String getAuthUserName() {
        return authUserName;
    }

    /**
     * 设置授权人
     *
     * @param authUserName 授权人
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

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNcId() {
        return ncId;
    }

    public void setNcId(String ncId) {
        this.ncId = ncId;
    }

    public UserAccount getUser() {
        return user;
    }

    public void setUser(UserAccount user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
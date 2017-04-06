package com.fuhuadata.domain.mybatis;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "p_user_account")
public class UserAccount extends BaseEntity<Integer> {
    /**
     * 用户id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 登录名
     */
    @Column(name = "login_name")
    private String loginName;

    /**
     * 密码
     */
    @Column(name = "login_password")
    private String loginPassword;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 出生日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthdate;

    /**
     * 用户编码
     */
    private String code;

    /**
     * 所属集团
     */
    @Column(name = "pk_group")
    private String pkGroup;

    /**
     * 所属组织
     */
    @Column(name = "pk_org")
    private String pkOrg;

    /**
     * NC人员主键
     */
    @Column(name = "pk_psndoc")
    private String pkPsndoc;

    /**
     * 最后修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "last_modify_time")
    private Date lastModifyTime;

    /**
     * 地区
     */
    @Transient
    private List<AreaCode> areas;

    /**
     * 获取用户id
     *
     * @return id - 用户id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户id
     *
     * @param id 用户id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取登录名
     *
     * @return login_name - 登录名
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置登录名
     *
     * @param loginName 登录名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * 获取密码
     *
     * @return login_password - 密码
     */
    public String getLoginPassword() {
        return loginPassword;
    }

    /**
     * 设置密码
     *
     * @param loginPassword 密码
     */
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取出生日期
     *
     * @return birthdate - 出生日期
     */
    public Date getBirthdate() {
        return birthdate;
    }

    /**
     * 设置出生日期
     *
     * @param birthdate 出生日期
     */
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * 获取用户编码
     *
     * @return code - 用户编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置用户编码
     *
     * @param code 用户编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取所属集团
     *
     * @return pk_group - 所属集团
     */
    public String getPkGroup() {
        return pkGroup;
    }

    /**
     * 设置所属集团
     *
     * @param pkGroup 所属集团
     */
    public void setPkGroup(String pkGroup) {
        this.pkGroup = pkGroup == null ? null : pkGroup.trim();
    }

    /**
     * 获取所属组织
     *
     * @return pk_org - 所属组织
     */
    public String getPkOrg() {
        return pkOrg;
    }

    /**
     * 设置所属组织
     *
     * @param pkOrg 所属组织
     */
    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg == null ? null : pkOrg.trim();
    }

    /**
     * 获取NC人员主键
     *
     * @return pk_psndoc - NC人员主键
     */
    public String getPkPsndoc() {
        return pkPsndoc;
    }

    /**
     * 设置NC人员主键
     *
     * @param pkPsndoc NC人员主键
     */
    public void setPkPsndoc(String pkPsndoc) {
        this.pkPsndoc = pkPsndoc == null ? null : pkPsndoc.trim();
    }

    /**
     * 获取最后修改时间
     *
     * @return last_modify_time - 最后修改时间
     */
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    /**
     * 设置最后修改时间
     *
     * @param lastModifyTime 最后修改时间
     */
    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public List<AreaCode> getAreas() {
        return areas;
    }

    public void setAreas(List<AreaCode> areas) {
        this.areas = areas;
    }
}
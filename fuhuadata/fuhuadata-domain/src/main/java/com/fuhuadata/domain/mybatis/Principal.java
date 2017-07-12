package com.fuhuadata.domain.mybatis;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * <p>User: wangjie
 * <p>Date: 4/15/2017
 */
public class Principal implements Serializable {

    private static final long serialVersionUID = 3545925183380433692L;

    private Integer id; // 编号
    private String code;// code
    private String loginName; // 登录名
    private String name; // 姓名
    private boolean passwordChange;// 密码是否需更改

    public Principal(UserAccount userAccount) {
        this.id = userAccount.getId();
        this.code = userAccount.getCode();
        this.loginName = userAccount.getLoginName();
        this.name = userAccount.getName();
        this.passwordChange = StringUtils.isBlank(userAccount.getLastPassword());
    }

    public Integer getId() {
        return id;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getName() {
        return name;
    }

    public boolean isPasswordChange() {
        return passwordChange;
    }

    public void setPasswordChange(boolean passwordChange) {
        this.passwordChange = passwordChange;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

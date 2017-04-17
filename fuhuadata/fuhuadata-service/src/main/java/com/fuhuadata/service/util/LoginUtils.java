package com.fuhuadata.service.util;

import com.fuhuadata.domain.mybatis.Principal;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * <p>User: wangjie
 * <p>Date: 4/15/2017
 */
public class LoginUtils {

    /**
     * 获取 Shiro Subject 对象
     * @return
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 获取登录信息
     * @return
     */
    public static Principal getPrincipal() {
        return (Principal) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 获取登录用户 id
     * @return
     */
    public static Integer getLoginId() {
        return getPrincipal().getId();
    }

    /**
     * 获取登录账户
     * @return
     */
    public static String getLoginAccount() {
        return getPrincipal().getLoginName();
    }

    /**
     * 获取登录用户名称
     * @return
     */
    public static String getLoginName() {
        return getPrincipal().getName();
    }
}

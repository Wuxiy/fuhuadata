package com.fuhuadata.domain.mybatis;

import javax.persistence.*;
import java.util.Date;

@Table(name = "p_user_login_log")
public class UserLoginLog extends BaseEntity<Integer> {
    /**
     * 日志id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 登录code
     */
    @Column(name = "login_code")
    private String loginCode;

    /**
     * 用户主机地址
     */
    private String host;

    /**
     * 系统主机地址
     */
    @Column(name = "system_host")
    private String systemHost;

    /**
     * 用户浏览器类型
     */
    @Column(name = "user_agent")
    private String userAgent;

    /**
     * 登录时间
     */
    @Column(name = "login_time")
    private Date loginTime;

    /**
     * 获取日志id
     *
     * @return id - 日志id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置日志id
     *
     * @param id 日志id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取登录code
     *
     * @return login_code - 登录code
     */
    public String getLoginCode() {
        return loginCode;
    }

    /**
     * 设置登录code
     *
     * @param loginCode 登录code
     */
    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode;
    }

    /**
     * 获取用户主机地址
     *
     * @return host - 用户主机地址
     */
    public String getHost() {
        return host;
    }

    /**
     * 设置用户主机地址
     *
     * @param host 用户主机地址
     */
    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    /**
     * 获取系统主机地址
     *
     * @return system_host - 系统主机地址
     */
    public String getSystemHost() {
        return systemHost;
    }

    /**
     * 设置系统主机地址
     *
     * @param systemHost 系统主机地址
     */
    public void setSystemHost(String systemHost) {
        this.systemHost = systemHost == null ? null : systemHost.trim();
    }

    /**
     * 获取用户浏览器类型
     *
     * @return user_agent - 用户浏览器类型
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * 设置用户浏览器类型
     *
     * @param userAgent 用户浏览器类型
     */
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent == null ? null : userAgent.trim();
    }

    /**
     * 获取登录时间
     *
     * @return login_time - 登录时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 设置登录时间
     *
     * @param loginTime 登录时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}
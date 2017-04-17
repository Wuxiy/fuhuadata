package com.fuhuadata.shiro.web.filter.authc;

import com.fuhuadata.domain.mybatis.Principal;
import com.fuhuadata.service.mybatis.UserService;
import com.fuhuadata.service.util.UserLogUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>User: wangjie
 * <p>Date: 4/7/2017
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

    @Autowired
    UserService userService;

    /**
     * 保存在session中当前用户的属性key
     */
    private String userSessionParam;

    /**
     * 默认登录成功跳转地址
     */
    private String defaultSuccessUrl;

    public String getUserSessionParam() {
        return userSessionParam;
    }

    public void setUserSessionParam(String userSessionParam) {
        this.userSessionParam = userSessionParam;
    }

    public String getDefaultSuccessUrl() {
        return defaultSuccessUrl;
    }

    public void setDefaultSuccessUrl(String defaultSuccessUrl) {
        this.defaultSuccessUrl = defaultSuccessUrl;
    }

    @Override
    protected void setFailureAttribute(ServletRequest request, AuthenticationException ae) {
        request.setAttribute(getFailureKeyAttribute(), ae);
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        logLoginAndUpdateUserAccessTime(request, response);
        addUserToSession(subject);
        return super.onLoginSuccess(token, subject, request, response);
    }

    private void logLoginAndUpdateUserAccessTime(ServletRequest request, ServletResponse response) {
        UserLogUtils.saveLoginLog((HttpServletRequest) request);
        updateUserAccessTime(request, response);
    }

    /**
     * 添加当前登录用户信息到 Session 中
     *
     * @param subject
     */
    protected void addUserToSession(Subject subject) {
        // 登录成功后把当前用户写入 session
        if (StringUtils.isNotBlank(getUserSessionParam())) {
            Session session = subject.getSession();
            session.setAttribute(getUserSessionParam(), subject.getPrincipal());
        }
    }

    /**
     * 更新会员最近登录时间
     */
    protected void updateUserAccessTime(ServletRequest request, ServletResponse response) {
        Subject subject = getSubject(request, response);
        userService.updateUserLoginInfo((Principal) subject.getPrincipal(), (HttpServletRequest) request);
    }

    /**
     * 登录成功后根据不同会员类型跳转不同地址
     *
     * @return
     */
    @Override
    public String getSuccessUrl() {
        return getDefaultSuccessUrl();
    }

}

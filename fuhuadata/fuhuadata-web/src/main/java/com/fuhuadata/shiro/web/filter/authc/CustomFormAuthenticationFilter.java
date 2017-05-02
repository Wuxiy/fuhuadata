package com.fuhuadata.shiro.web.filter.authc;

import com.fuhuadata.domain.mybatis.Principal;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.UserService;
import com.fuhuadata.service.util.MessageUtils;
import com.fuhuadata.service.util.UserLogUtils;
import com.fuhuadata.web.util.WebUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Locale;

/**
 * <p>User: wangjie
 * <p>Date: 4/7/2017
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

    private static final Logger log = LoggerFactory.getLogger(CustomFormAuthenticationFilter.class);

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
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (isLoginRequest(request, response)) {
            if (isLoginSubmission(request, response)) {
                if (log.isTraceEnabled()) {
                    log.trace("Login submission detected.  Attempting to execute login.");
                }
                return executeLogin(request, response);
            } else {
                if (log.isTraceEnabled()) {
                    log.trace("Login page view.");
                }
                //allow them to see the login page ;)
                return true;
            }
        } else {
            if (log.isTraceEnabled()) {
                log.trace("Attempting to access a path which requires authentication.  Forwarding to the " +
                        "Authentication url [" + getLoginUrl() + "]");
            }

            return onRequiredAuthentication(request, response);
        }

    }

    protected boolean onRequiredAuthentication(ServletRequest request, ServletResponse response) throws IOException {
        if (WebUtils.isAjax((HttpServletRequest) request)) {
            if (log.isDebugEnabled()) {
                log.debug("Ajax 请求，返回 JSON 数据");
            }

            String localMessage = getLocalMessage((HttpServletRequest) request, "user.session.timeout");
            ResultPojo resultPojo = new ResultPojo(-1, localMessage);

            WebUtils.writeResponse(response, resultPojo);
            return false;
        } else {
            if (log.isDebugEnabled()) {
                log.debug("正常请求，跳转到登录页面");
            }

            saveRequestAndRedirectToLogin(request, response);
            return false;
        }
    }

    private String getLocalMessage(HttpServletRequest request, String code) {
        Locale locale = RequestContextUtils.getLocale(request);
        return MessageUtils.message(code, locale);
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

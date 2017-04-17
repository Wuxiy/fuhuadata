package com.fuhuadata.shiro.web.filter.user;

import com.fuhuadata.domain.mybatis.Principal;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 判断登录用户是否需要强制更改密码
 * <p>User: wangjie
 * <p>Date: 4/15/2017
 */
public class PasswordChangeFilter extends AccessControlFilter {

    private String passwordChangeUrl;

    public String getPasswordChangeUrl() {
        return passwordChangeUrl;
    }

    public void setPasswordChangeUrl(String passwordChangeUrl) {
        this.passwordChangeUrl = passwordChangeUrl;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        return !isPasswordChange(request, response, mappedValue) || onPasswordChange(request, response);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        return false;
    }

    private boolean isPasswordChange(ServletRequest request, ServletResponse response, Object mappedValue) {
        Subject subject = getSubject(request, response);
        if (subject.getPrincipal() == null) {
            return false;
        }
        Principal principal = (Principal) subject.getPrincipal();
        return principal.isPasswordChange();
    }

    private boolean onPasswordChange(ServletRequest request, ServletResponse response) throws IOException {
        saveRequestAndRedirectToChangePassword(request, response);
        return false;
    }

    private void saveRequestAndRedirectToChangePassword(ServletRequest request, ServletResponse response) throws IOException {
        saveRequest(request);
        redirectToChangePassword(request, response);
    }

    private void redirectToChangePassword(ServletRequest request, ServletResponse response) throws IOException {
        String passwordChangeUrl = getPasswordChangeUrl();
        WebUtils.issueRedirect(request, response, passwordChangeUrl);
    }
}

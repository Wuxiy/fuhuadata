package com.fuhuadata.service.util;

import com.fuhuadata.domain.mybatis.Principal;
import com.fuhuadata.domain.mybatis.UserLoginLog;
import com.fuhuadata.service.mybatis.UserLoginLogService;
import org.apache.shiro.SecurityUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * <p>User: wangjie
 * <p>Date: 4/8/2017
 */
public class UserLogUtils {

    private static UserLoginLogService loginLogService = SpringUtils.getBean(UserLoginLogService.class);

    public static void saveLoginLog(HttpServletRequest request) {
        Principal principal = getPrincipal();

        Integer id = principal.getId();
        String loginName = principal.getLoginName();
        String ipAddr = IpUtils.getIpAddr(request);
        String userAgent = request.getHeader("User-Agent");

        UserLoginLog loginLog = new UserLoginLog();
        loginLog.setLoginCode(loginName);
        loginLog.setHost(ipAddr);
        loginLog.setUserAgent(userAgent);
        loginLog.setLoginTime(new Date());

        loginLogService.save(loginLog);
    }

    private static Principal getPrincipal() {
        return (Principal) SecurityUtils.getSubject().getPrincipal();
    }
}

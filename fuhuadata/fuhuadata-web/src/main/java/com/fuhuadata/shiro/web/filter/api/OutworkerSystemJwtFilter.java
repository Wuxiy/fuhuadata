package com.fuhuadata.shiro.web.filter.api;

import com.alibaba.fastjson.JSON;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.outworker.jwt.JwtService;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.MimeTypeUtils;
import org.springframework.util.PathMatcher;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 7/24/2017
 */
public class OutworkerSystemJwtFilter extends AccessControlFilter {

    Logger logger = LoggerFactory.getLogger(getClass());

    public static final String DEFAULT_TOKEN_HEADER_NAME = "Access-Token";

    private final PathMatcher pathMatcher = new AntPathMatcher();

    private String tokenHeaderName = DEFAULT_TOKEN_HEADER_NAME;

    private List<String> apiWhiteUrls = new ArrayList<>();

    @Resource
    private JwtService jwtService;

    public String getTokenHeaderName() {
        return tokenHeaderName;
    }

    public void setTokenHeaderName(String tokenHeaderName) {
        this.tokenHeaderName = tokenHeaderName;
    }

    public List<String> getApiWhiteUrls() {
        return apiWhiteUrls;
    }

    public void setApiWhiteUrls(List<String> apiWhiteUrls) {
        this.apiWhiteUrls = apiWhiteUrls;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        HttpServletRequest httpRequest = WebUtils.toHttp(request);
        HttpServletResponse httpResponse = WebUtils.toHttp(response);
        String currentUrl = getPathWithinApplication(request);

        // 访问的资源是否存在和允许
        boolean isAllowed = false;
        for (String whiteUrl : apiWhiteUrls) {
            if (pathMatcher.match(whiteUrl, currentUrl)) {
                isAllowed = true;
                break;
            }
        }

        if (!isAllowed) {
            Result<Boolean> result = Result.newResult(false);
            result.setCode(HttpStatus.NOT_FOUND.value());
            result.setMessage("访问的资源不存在");
            writeAsJson(httpResponse, HttpStatus.NOT_FOUND, result.getResultPojo());
            return false;
        }

        // 是否是登录请求
        if (isLoginRequest(request, response)) {
            return true;
        }

        // 是否存在 jwt token
        String jwt = httpRequest.getHeader(getTokenHeaderName());
        if (StringUtils.isEmpty(jwt)) {
            Result<Boolean> result = Result.newResult(false);
            result.setCode(HttpStatus.UNAUTHORIZED.value());
            result.setMessage("未提供访问access-token");
            writeAsJson(httpResponse, HttpStatus.UNAUTHORIZED, result.getResultPojo());
            return false;
        }

        // 存在 jwt token，验证其合法性
        Claims claimsJws;
        try {
            claimsJws = jwtService.parseJwt(jwt);
        } catch (Exception e) {// 解析失败
            logger.error("jwt解析失败,登录失败", e);
            Result<String> result = Result.newResult(false);
            result.setCode(HttpStatus.UNAUTHORIZED.value());
            result.setMessage("登录异常或登录状态已过期");
            writeAsJson(httpResponse, HttpStatus.UNAUTHORIZED, result.getResultPojo());
            return false;
        }

        return true;

    }

    private void writeAsJson(HttpServletResponse response, HttpStatus httpStatus, Object result) {

        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType(MimeTypeUtils.APPLICATION_JSON_VALUE);
            response.setStatus(httpStatus.value());
            PrintWriter writer = response.getWriter();
            writer.print(JSON.toJSONString(result));
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        return false;
    }

}

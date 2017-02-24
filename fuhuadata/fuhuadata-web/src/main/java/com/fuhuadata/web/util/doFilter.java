package com.fuhuadata.web.util;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhangxiang on 2017/2/13.
 */
public class doFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) req;
        HttpServletResponse response=(HttpServletResponse) res;
        StringBuffer url=request.getRequestURL();
        String path=url.toString();
        System.out.println("进入拦截器...");
        if(path.endsWith("index.jsp")|| path.endsWith("login.action")||path.endsWith("*.do")) {
            if (path.endsWith("index.jsp") || path.endsWith("login.action")) {
                chain.doFilter(req, res);
                System.out.println("pass...");
                return;
            }
            System.out.println("访问登录后页面");
            Cookie[] cookies = request.getCookies();
            Cookie loggedIn=null;
            for (Cookie cookie : cookies) {
                if ("loggedIn".equals(cookie.getName())) {
                    loggedIn=cookie;
                }
            }
            if (loggedIn==null) {
                System.out.println("返回登录页面!!!.......");
                String p = request.getContextPath();
                String login = p + "/index.jsp";
                response.sendRedirect(login);
                return;
            }
        }
        chain.doFilter(req,res);

    }

    @Override
    public void destroy() {

    }
}

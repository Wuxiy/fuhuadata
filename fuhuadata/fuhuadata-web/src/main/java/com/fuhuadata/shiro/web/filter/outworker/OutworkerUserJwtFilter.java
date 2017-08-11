package com.fuhuadata.shiro.web.filter.outworker;

import io.jsonwebtoken.Claims;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>User: wangjie
 * <p>Date: 7/31/2017
 */
public class OutworkerUserJwtFilter extends OutworkerBaseJwtFilter {

    @Override
    protected boolean onLoginSuccess(Claims claims, HttpServletRequest request, HttpServletResponse response) {

        String subject = claims.getSubject();
        request.setAttribute("userId", subject);

        return true;
    }
}

package com.fuhuadata.web.util;

import com.alibaba.fastjson.JSON;
import com.fuhuadata.constant.Consts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p>User: wangjie
 * <p>Date: 5/2/2017
 */
public class WebUtils {

    private static Logger logger = LoggerFactory.getLogger(WebUtils.class);

    /**
     * 判断是否是 ajax 请求
     * @param request
     * @return
     */
    public static boolean isAjax(HttpServletRequest request) {
        String requestedWithHeader = request.getHeader("X-Requested-With");
        return "XMLHttpRequest".equals(requestedWithHeader);
    }

    public static void writeResponse(ServletResponse response, Object result) throws IOException {

        PrintWriter out = null;
        try {
            response.setCharacterEncoding(Consts.ENCODING);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);

            out = response.getWriter();
            out.write(JSON.toJSONString(result));
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }

    public static void writeStatusResponse(HttpServletResponse response, HttpStatus status, Object result)
            throws IOException {

        PrintWriter out = null;
        try {
            response.setCharacterEncoding(Consts.ENCODING);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setStatus(status.value());

            out = response.getWriter();
            out.write(JSON.toJSONString(result));
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }
}

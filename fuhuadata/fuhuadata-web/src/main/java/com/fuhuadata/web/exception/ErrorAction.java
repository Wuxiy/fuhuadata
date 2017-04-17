package com.fuhuadata.web.exception;

import com.fuhuadata.web.exception.entity.ExceptionResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>User: wangjie
 * <p>Date: 4/17/2017
 */
@RequestMapping("/error")
@Controller
public class ErrorAction {

    @RequestMapping("404")
    public ModelAndView error404(
            HttpServletRequest request) {
        Throwable exception = (Throwable) request.getAttribute("javax.servlet.error.exception");

        ModelAndView mv = new ModelAndView("common/404");
        mv.addObject("error", exception);

        return mv;
    }

    @RequestMapping("400")
    public ModelAndView error400(HttpServletRequest request) {
        Throwable exception = (Throwable) request.getAttribute("javax.servlet.error.exception");

        ModelAndView mv = new ModelAndView("common/400");
        mv.addObject("error", ExceptionResponse.from(exception));

        return mv;
    }

    @RequestMapping("500")
    public ModelAndView error500(HttpServletRequest request) {
        Throwable exception = (Throwable) request.getAttribute("javax.servlet.error.exception");

        ModelAndView mv = new ModelAndView("common/error");
        mv.addObject("error", exception);

        return mv;
    }
}

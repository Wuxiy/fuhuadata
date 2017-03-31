package com.fuhuadata.web.springmvc;

import com.fuhuadata.web.util.SystemLogAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Member;

/**
 * Created by Think on 2017/3/29.
 */
@Controller
@RequestMapping("/businessOrderProduct/*")
public class BusinessOrderProductAction {

    @RequestMapping(value="/intoProductBasicInfoRequire",method = RequestMethod.GET)
    @SystemLogAnnotation(module = " ",methods = " ")
    public ModelAndView intoProductBasicInfoRequire(String orderId){
        return new ModelAndView("salesStatistics/productBasicInfoRequire").addObject("orderId",orderId);
    }

    @RequestMapping(value="/intoProductProcCompRequire",method = RequestMethod.GET)
    @SystemLogAnnotation(module = " ",methods = " ")
    public ModelAndView intoProductProcCompRequire(String orderId){
        return new ModelAndView("salesStatistics/productProcCompRequire").addObject("orderId",orderId);
    }

}

package com.fuhuadata.web.springmvc;

import com.fuhuadata.web.util.SystemLogAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hexingfu on 2017/3/8.
 */
@Controller
@RequestMapping("/customerBaseInfo/*")
public class CustomerBaseInfoAction {
    @RequestMapping("/customerListPageInit")
    @SystemLogAnnotation(module = "customerInfo-customerList",methods = "into")
    public ModelAndView init(){

        return new ModelAndView();
    }
}

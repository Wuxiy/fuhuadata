package com.fuhuadata.web.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Think on 2017/3/29.
 */
@Controller
@RequestMapping("/businessOrder")
public class BusinessOrderAction {


    @RequestMapping("/intoBusinessOrder")
    public ModelAndView intoBusinessOrder(){
        return new ModelAndView("salesStatistics/placeOrder");
    }
}

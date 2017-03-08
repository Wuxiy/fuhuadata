package com.fuhuadata.web.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
/**
 * Created by young on 2017/3/3.
 */

@RequestMapping("/saleProcess/*")
public class saleProcessAction {
    /**
     * 销售流程列表
     * @return
     */
    @RequestMapping(value = "/saleProcessList",method = RequestMethod.GET)
    public ModelAndView saleProcessList(){return new ModelAndView("salesStatistics/saleProcessList");}

}

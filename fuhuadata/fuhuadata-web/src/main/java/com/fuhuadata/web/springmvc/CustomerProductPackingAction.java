package com.fuhuadata.web.springmvc;


import com.fuhuadata.web.util.SystemLogAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 客户产品包装要求action
 * Created by wuxi on 2017/1/13.
 */

@Controller
@RequestMapping("/customerProductPacking/*")
public class CustomerProductPackingAction {

    /**
     * 客户产品包装要求列表
     * @return
     */
    @SuppressWarnings("unused")
    @RequestMapping(value="/customerProductPackingList",method=RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-客户产品包装要求",methods = "包装要求列表")
    public ModelAndView customerProductPackingList(){return new ModelAndView("knowledgeBase/customerProductPackingList");}

    /**
     * 新增客户产品包装详情
     * @return
     */
    @RequestMapping(value="/infocustomerProductPacking",method=RequestMethod.GET)
    public ModelAndView infocustomerProductPacking(){return new ModelAndView("knowledgeBase/customerProductPackingInfo");}

}

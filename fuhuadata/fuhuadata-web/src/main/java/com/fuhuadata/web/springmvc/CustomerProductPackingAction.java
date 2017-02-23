package com.fuhuadata.web.springmvc;


import com.fuhuadata.domain.ExhibitionInfo;
import com.fuhuadata.domain.query.ExhibitionInfoQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.ExhibitionInfoService;
import com.fuhuadata.web.util.DateUtil;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Date;
import java.text.ParseException;
import java.util.List;

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

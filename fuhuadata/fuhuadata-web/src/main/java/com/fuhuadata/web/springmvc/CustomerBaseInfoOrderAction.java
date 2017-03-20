package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.query.QueryBusinessOrder;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.BusinessOrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hexingfu on 2017/3/18.
 */
@Controller
@RequestMapping("customerBaseInfoOrder/*")
public class CustomerBaseInfoOrderAction {

    private static final Logger log = Logger.getLogger(CustomerBaseInfoOrderAction.class);

    @Autowired
    private BusinessOrderService businessOrderService;

    @RequestMapping("/entrance")
    public ModelAndView entrance(String customerId){
        //初始化销售组织
        return new ModelAndView().addObject("customerId",customerId);
    }


    @ResponseBody
    @RequestMapping("/count")
    public ResultPojo count(QueryBusinessOrder qbo){
        ResultPojo pojo = new ResultPojo();
        pojo.setData(businessOrderService.count(qbo));
        return pojo;
    }

    @ResponseBody
    @RequestMapping("/getListByPage")
    public ResultPojo getListByPage(QueryBusinessOrder qbo){
        ResultPojo pojo = new ResultPojo();
        pojo.setData(businessOrderService.getOrderLisPageByQuery(qbo));
        return pojo;
    }
}

package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.query.QueryBusinessOrder;
import com.fuhuadata.domain.query.QueryOrganization;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.BusinessOrderService;
import com.fuhuadata.service.OrganizationService;
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
    @Autowired
    private OrganizationService organizationService;

    @RequestMapping("/entrance")
    public ModelAndView entrance(String customerId,String customerType,String fullName){
        return new ModelAndView("customerInfo/customerOrderInfo")
                .addObject("customerType",customerType)
                .addObject("fullName",fullName)
                .addObject("customerId",customerId);
    }

    @ResponseBody
    @RequestMapping("/initSaleOrganizationTree")
    public ResultPojo initSaleOrganizationTree(){
        QueryOrganization qoz = new QueryOrganization();
        qoz.setIsSaleRole(1);
        ResultPojo pojo = new ResultPojo();
        pojo.setData(organizationService.getOrganizationTreeByQuery(qoz));
        return pojo;
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

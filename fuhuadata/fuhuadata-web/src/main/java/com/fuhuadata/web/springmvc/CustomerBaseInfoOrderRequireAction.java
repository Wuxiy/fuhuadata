package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.CustomerProductArchivesService;
import com.fuhuadata.service.util.LoginUtils;
import com.fuhuadata.web.util.CustomerUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hexingfu on 2017/3/23.
 * 客户信息-订单默认要求
 */
@Controller
@RequestMapping("/customerBaseInfoOrderRequire")
public class CustomerBaseInfoOrderRequireAction {

    private static Logger log = Logger.getLogger(CustomerBaseInfoOrderRequireAction.class);

    @Autowired
    private CustomerProductArchivesService customerProductArchivesService;

    /**
     * 订单默认要求-单据要求入口
     * @param customerId
     * @return
     */
    @RequestMapping("/billRequireEntrance")
    public ModelAndView billRequireEntrance(String customerId,String customerType,String fullName){

        Subject subject = LoginUtils.getSubject();
        subject.checkPermission(CustomerUtils.getCustomerPermissonPrefix(customerType) + ":orre:view");

        return new ModelAndView("customerInfo/customerBillRequire")
                .addObject("customerType",customerType)
                .addObject("fullName",fullName)
                .addObject("customerId",customerId);
    }

    /**
     * 订单默认要求-订舱出运要求入口
     * @param customerId
     * @return
     */
    @RequestMapping("/transportRequireEntrance")
    public ModelAndView transportRequireEntrance(String customerId,String customerType,String fullName){
        return new ModelAndView("customerInfo/customerTransportRequire")
                .addObject("customerType",customerType)
                .addObject("fullName",fullName)
                .addObject("customerId",customerId);
    }
    @ResponseBody
    @RequestMapping("/getBillRequireList")
    public ResultPojo getBillRequireList(String customerId){
        ResultPojo pojo = new ResultPojo();
        pojo.setData(customerProductArchivesService.getCustomerBillRequirement(customerId));
        return pojo;
    }

    @ResponseBody
    @RequestMapping("/getTransportRequireList")
    public ResultPojo getTransportRequireList(String customerId){
        ResultPojo pojo = new ResultPojo();
        pojo.setData(customerProductArchivesService.getCustomerTransportRequirement(customerId));
        return pojo;
    }
}

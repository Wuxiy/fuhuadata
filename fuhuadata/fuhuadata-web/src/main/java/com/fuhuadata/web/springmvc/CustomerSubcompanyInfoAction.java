package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.CustomerSubcompanyInfo;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.CustomerSubcompanyInfoService;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by intanswer on 2017/3/23.
 */

@Controller
@RequestMapping("/customerSubcompanyInfo/*")
public class CustomerSubcompanyInfoAction {

    private static final Log log = LogFactory.getLog(CustomerSubcompanyInfoAction.class);

    @Autowired
    private CustomerSubcompanyInfoService customerSubcompanyInfoService;


    @RequestMapping(value = "/intoCustomerSubcompanyInfo",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "customerInfo-CustomerSubcompanyInfo",methods = "into")
    public ModelAndView intoCustomerSubcompanyInfo(){
        return new ModelAndView("customerInfo/customerAnotherNamer");
    }


    /**
     * list
     * @param customerId
     * @return
     */
    @RequestMapping(value="/getCustomerSubcompanyInfosByCustomerId",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "customerInfo-CustomerSubcompanyInfo",methods = "getByCustomerId")
    @ResponseBody
    public ResultPojo getCustomerSubcompanyInfosByCustomerId(String customerId){
        Result<List<CustomerSubcompanyInfo>> result = new Result<List<CustomerSubcompanyInfo>>();
        try{
            result=customerSubcompanyInfoService.getCustomerSubcompanyInfoByCustomerId(customerId);
        }catch(Exception e){
            result.setSuccess(false);
            log.error("根据id获取客户子公司列表错误",e);
        }
        return result.getResultPojo();
    }


    /**
     * get by id
     * @param customerSubId
     * @return
     */
    @RequestMapping(value="/getCustomerSubcompanyInfoById",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "customerInfo-CustomerSubcompanyInfo",methods = "getById")
    @ResponseBody
    public ResultPojo getCustomerSubcompanyInfoById(int customerSubId){
        Result<CustomerSubcompanyInfo> result = new Result<CustomerSubcompanyInfo>();
        try{
            result=customerSubcompanyInfoService.getCustomerSubcompanyInfoById(customerSubId);
        }catch(Exception e){
            result.setSuccess(false);
            log.error("根据id获取子公司详情错误",e);
        }
        return result.getResultPojo();
    }

    /**
     * do add
     * @param customerSubcompanyInfo
     * @return
     */
    @RequestMapping(value="/addCustomerSubcompanyInfo",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "customerInfo-CustomerSubcompanyInfo",methods = "doAdd")
    @ResponseBody
    public ResultPojo addCustomerSubcompanyInfo(@RequestBody CustomerSubcompanyInfo customerSubcompanyInfo){
        Result<CustomerSubcompanyInfo> result = new Result<CustomerSubcompanyInfo>();
        try{
            result=customerSubcompanyInfoService.addCustomerSubcompanyInfo(customerSubcompanyInfo);
        }catch(Exception e){
            result.setSuccess(false);
            log.error("新增客户子公司错误",e);
        }
        return result.getResultPojo();
    }
}

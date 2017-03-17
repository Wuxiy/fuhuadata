package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.CustomerLinkman;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.CustomerLinkmanService;
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
 * 客户联系人action
 * Created by intanswer on 2017/3/16.
 */
@Controller
@RequestMapping("/customerLinkman/*" )
public class CustomerLinkmanAction {
    private static final Log log = LogFactory.getLog(CustomerLinkmanAction.class);
    @Autowired
    private CustomerLinkmanService customerLinkmanService;

    @RequestMapping(value="/intoCustomerLinkmanInfo",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "customerInfo-customerContacts",methods = "into")
    public ModelAndView intoCustomerLinkmanInfo(){
        return new ModelAndView("customerInfo/customerContacts");
    }

    /**
     *
     * @param customerId
     * @return
     */
    @RequestMapping(value="/getCustomerLinkmanByCustomerId",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "customerInfo-customerContacts",methods = "getCustomerLinkmanByCustomerId")
    @ResponseBody
    public ResultPojo getCustomerLinkmanByCustomerId(String customerId){
        try{
            Result<List<CustomerLinkman>> result = customerLinkmanService.getCustomerLinkmanByCustomerId(customerId);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("根据客户id获取客户联系人列表错误",e);
        }
        return null;

    }

    /**
     * delete
     * @param id
     * @return
     */
    @RequestMapping(value="deleteById",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "customerInfo-customerContacts",methods = "deleteById")
    @ResponseBody
    public ResultPojo deleteById(String id){
        Result result = new Result();
        try{
            result=customerLinkmanService.deleteCustomerLinkmanById(id);
        }catch(Exception e){
            log.error("根据id删除客户联系人错误",e);
        }
        return result.getResultPojo();
    }

    @RequestMapping(value="updateById",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "customerInfo-customerContacts",methods = "updateById")
    public ResultPojo updateCustomerLinkmanById(@RequestBody CustomerLinkman customerLinkman){
        Result result = new Result();
        try{
            String id = customerLinkman.getLinkmanId();
            result=customerLinkmanService.updateCustomerLinkmanById(id,customerLinkman);
        }catch(Exception e){
            log.error("根据id更新客户联系人信息错误",e);
        }
        return result.getResultPojo();
    }



}

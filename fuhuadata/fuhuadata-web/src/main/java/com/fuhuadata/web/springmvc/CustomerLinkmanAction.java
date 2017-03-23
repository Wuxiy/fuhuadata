package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.CustomerLinkman;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.CustomerLinkmanService;
import com.fuhuadata.vo.CustomerLinkmanVO;
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

    @RequestMapping(value="/intoCustomerLinkmanList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "customerInfo-customerContacts",methods = "into")
    public ModelAndView intoCustomerLinkmanList(){
        return new ModelAndView("customerInfo/customerContacts");
    }

    /**
     * get by customerId
     * @param customerId
     * @return
     */
    @RequestMapping(value="/getCustomerLinkmanByCustomerId",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "customerInfo-customerContacts",methods = "getCustomerLinkmanByCustomerId")
    @ResponseBody
    public ResultPojo getCustomerLinkmanByCustomerId(String customerId){
        System.out.println(customerId);
        try{
            Result<List<CustomerLinkman>> result = customerLinkmanService.getCustomerLinkmanByCustomerId(customerId);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("根据客户id获取客户联系人列表错误",e);
        }
        return null;

    }

    /**
     * 进入新增页
     * @param
     * @return
     */
    @RequestMapping(value = "intoCustomerLinkmanAdd",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "customerInfo-customerContacts",methods = "intoCustomerLinkmanAdd")
    public ModelAndView intoCustomerLinkmanAdd(){
        ModelAndView model = new ModelAndView("customerInfo/customerContactsAdd");
        return model;
    }

    /**
     * add
     * @param customerLinkman
     * @return
     */
    @RequestMapping(value="add",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "customerInfo-customerContacts",methods = "addCustomerLinkman")
    @ResponseBody
    public ResultPojo addCustomerLinkmanById(@RequestBody CustomerLinkman customerLinkman){
        Result result = new Result();
        try{
            result=customerLinkmanService.addCustomerLinkman(customerLinkman);
        }catch(Exception e){
            log.error("新增联系人错误",e);
        }
        return result.getResultPojo();
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

    /**
     * update
     * @param customerLinkman
     * @return
     */
    @RequestMapping(value="updateById",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "customerInfo-customerContacts",methods = "updateById")
    @ResponseBody
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

    /**
     * 进入详情页
     * @param
     * @return
     */
    @RequestMapping(value = "intoCustomerLinkmanInfo",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "customerInfo-customerContacts",methods = "intoCustomerLinkmanInfo")
    public ModelAndView intoCustomerLinkmanInfo(){
        ModelAndView model = new ModelAndView("customerInfo/customerContactsInfo");
        return model;
    }

    /**
     * 详情页
     * @param linkmanId
     * @return
     */
    @RequestMapping(value="getCustomerLinkmanDetailsById",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "customerInfo-customerContacts",methods = "getCustomerLinkmanDetailsById")
    @ResponseBody
    public ResultPojo getCustomerLinkmanDetailsById(String linkmanId){
        Result<CustomerLinkmanVO> result = new Result<CustomerLinkmanVO>();
        try{
            result=customerLinkmanService.getCustomerLinkmanDetailsById(linkmanId);
        }catch(Exception e){
            log.error("根据联系人id获取详情失败",e);
        }
        return result.getResultPojo();
    }

    /**
     * 获取默认联系人
     * @param customerId
     * @return
     */
    @RequestMapping(value="getCustomerLinkmanDefaultByCustomerId",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "customerInfo-customerContacts",methods = "getCustomerLinkmanDefaultByCustomerId")
    @ResponseBody
    public ResultPojo getCustomerLinkmanDefaultByCustomerId(String customerId){
        Result<CustomerLinkman> result = new Result<CustomerLinkman>();
        try{
            result=customerLinkmanService.getCustomerLinkmanDefaultByCustomerId(customerId);
        }catch(Exception e){
            log.error("根据客户id获取默认联系人错误",e);
        }
        if(result.getResultPojo().getData()==null){
            result.getResultPojo().setMessage("当前客户无默认联系人,请设置默认联系人");
        }
        else{
            result.getResultPojo().setMessage("当前客户已有默认联系人，确认更换？");
        }
        return result.getResultPojo();
    }

}

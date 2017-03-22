package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.CustomerVisitRecord;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.CustomerVisitRecordService;
import com.fuhuadata.vo.CustomerVisitRecordVO;
import com.fuhuadata.vo.VisitRecordVO;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 客户拜访记录
 * Created by intanswer on 2017/3/20.
 */
@Controller
@RequestMapping("/customerVisitRecord/*")
public class CustomerVisitRecordAction {
    private final static Log log = LogFactory.getLog(CustomerVisitRecordAction.class);
    @Resource
    private CustomerVisitRecordService customerVisitRecordService;


    /**
     * into
     * @param customerId
     * @return
     */
    @RequestMapping(value="/intoCustomerVisitRecord",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "CustomerInfo-CustomerVisitRecord",methods = "intoCustomerVisitRecord")
    public ModelAndView intoCustomerVisitRecord(String customerId){
       return new ModelAndView("customerInfo/customerCommunicationRecord");
    }

    /**
     * 根据客户id获取沟通记录
     * @param customerId
     * @return
     */
    @RequestMapping(value="/getCustomerVisitRecordByCustomerId",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "CustomerInfo-CustomerVisitRecord",methods = "getByCustomerId")
    @ResponseBody
    public ResultPojo getCustomerVisitRecordByCustomerId(String customerId){
        Result<List<VisitRecordVO>> result = new Result<List<VisitRecordVO>>();
        try{
            result = customerVisitRecordService.getCustomerVisitRecordByCustomerId(customerId);
        }catch(Exception e){
            result.setSuccess(false);
            log.error("根据客户id获取联系人详情错误",e);
        }
        return result.getResultPojo();
    }

    /**
     * add
     * @param
     * @return
     */
    @RequestMapping(value="/addCustomerVisitRecord",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "CustomerInfo-CustomerVisitRecord",methods = "addCustomerVisitRecord")
    @ResponseBody
    public ResultPojo addCustomerVisitRecord(@RequestBody CustomerVisitRecordVO customerVisitRecordVO){
        Result result = new Result();
        try{
             result=customerVisitRecordService.addVisitRecord(customerVisitRecordVO);
        }catch(Exception e){
            result.setSuccess(false);
            log.error("新增客户记录错误",e);
        }
        return result.getResultPojo();
    }




}


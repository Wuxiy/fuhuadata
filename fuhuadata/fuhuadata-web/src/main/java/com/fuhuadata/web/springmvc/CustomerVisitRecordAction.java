package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.query.QueryCustomerVisitRecord;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.CustomerVisitRecordService;
import com.fuhuadata.vo.CustomerVisitRecordVO;
import com.fuhuadata.vo.VisitRecordVO;
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

import javax.annotation.Resource;
import javax.management.Query;
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
     * @return
     */
    @RequestMapping(value="/intocustomerVisitRecordList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "customerInfo-customerVisitRecord",methods = "into")
    public ModelAndView intocustomerVisitRecordList(String customerId,String customerType,String fullName){
        return new ModelAndView("customerInfo/customerVisitRecordList")
                .addObject("customerType",customerType)
                .addObject("fullName",fullName)
                .addObject("customerId",customerId);
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

    /**
     * into customer maintenance
     * @return
     */
    @RequestMapping(value="/intoCustomerMaintenance",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "salesStatistics-CustomerMaintenance",methods = "intoCustomerMaintenance")
    public ModelAndView intoCustomerMaintenance(String customerId,String customerType,String fullName){
        return new ModelAndView("salesStatistics/customerMaintain")
                .addObject("customerType",customerType)
                .addObject("fullName",fullName)
                .addObject("customerId",customerId);
    }


    /**
     *  customer maintenance list
     * @param queryCustomerVisitRecord
     * @return
     */
    @RequestMapping(value="/getCustomerVisitRecordByPage",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "salesStatistics-CustomerMaintenance",methods = "getCustomerVisitRecordByPage")
    @ResponseBody
    public ResultPojo getCustomerVisitRecordByPage(@RequestBody QueryCustomerVisitRecord queryCustomerVisitRecord){
        Result<List<QueryCustomerVisitRecord>> result = new Result<List<QueryCustomerVisitRecord>>();
        try{
            result = customerVisitRecordService.getCustomerVisitRecordsByPage(queryCustomerVisitRecord);
        }catch(Exception e){
            result.setSuccess(false);
            log.error("分页条件查询客户维护记录列表失败",e);
        }
        return result.getResultPojo();
    }



    /**
     *  customer maintenance count
     * @param queryCustomerVisitRecord
     * @return
     */
    @RequestMapping(value="/count",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "salesStatistics-CustomerMaintenance",methods = "count")
    @ResponseBody
    public ResultPojo count(@RequestBody QueryCustomerVisitRecord queryCustomerVisitRecord){
        Result<Integer> result = new Result<Integer>();
        try{
            result = customerVisitRecordService.count(queryCustomerVisitRecord);
        }catch(Exception e){
            result.setSuccess(false);
            log.error("分页条件查询客户维护记录数量失败",e);
        }
        return result.getResultPojo();
    }




}


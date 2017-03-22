package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.CustomerVisitRecord;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.CustomerVisitRecordService;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
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
    @RequestMapping(value="/intocustomerVisitRecordList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "customerInfo-customerVisitRecord",methods = "into")
    public ModelAndView intocustomerVisitRecordList(){
        return new ModelAndView("customerInfo/customerVisitRecordList");
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
        Result<List<CustomerVisitRecord>> result = new Result<List<CustomerVisitRecord>>();
        try{
            result = customerVisitRecordService.getCustomerVisitRecordByCustomerId(customerId);
        }catch(Exception e){
            result.setSuccess(false);
            log.error("根据客户id获取联系人详情错误",e);
        }
        return result.getResultPojo();
    }


}


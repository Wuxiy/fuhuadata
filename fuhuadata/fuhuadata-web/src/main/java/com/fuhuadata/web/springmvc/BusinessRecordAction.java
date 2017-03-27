package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.BusinessRecord;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.BusinessRecordService;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 商机跟进记录
 * Created by intanswer on 2017/3/25.
 */
@Controller
@RequestMapping("/businessRecord/*")
public class BusinessRecordAction {
    @Autowired
    private BusinessRecordService businessRecordService;

    @RequestMapping(value = "/doAddBusinessRecord",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "salesStatistics-businessRecord",methods = "doAdd")
    @ResponseBody
    public ResultPojo doAddBusinessRecord(@RequestBody BusinessRecord businessRecord){
        Result<BusinessRecord> result = new Result<BusinessRecord>();
        try{
            result = businessRecordService.addBusinessRecord(businessRecord);
        }catch(Exception e){
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    @RequestMapping(value = "/getBusinessRecordByBusinessId",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "salesStatistics-businessRecord",methods = "getByBusinessId")
    @ResponseBody
    public ResultPojo getBusinessRecordByBusinessId(String businessId){
        Result<List<BusinessRecord>> result = new Result<List<BusinessRecord>>();
        try{
            result = businessRecordService.getBusinessRecordByBusinessId(businessId);
        }catch(Exception e){
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

}

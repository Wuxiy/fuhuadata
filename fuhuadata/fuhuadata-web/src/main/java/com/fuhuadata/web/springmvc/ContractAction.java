package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.ContractService;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * NC合同
 * Created by wuxi on 2017/4/13.
 */
@Controller
@RequestMapping("/contract")
public class ContractAction {
    @Autowired
    private ContractService contractService;

    @RequestMapping(value = "/synchronousContractStatistics",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "contract",methods = "synchronousContractStatistics")
    @ResponseBody
    public ResultPojo synchronousContractStatistics() {
        Result result = new Result();
        try{
            result = contractService.synchronousContractStatistics();
        }catch(Exception e){
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

}

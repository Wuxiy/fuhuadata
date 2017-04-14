package com.fuhuadata.service.impl;

import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.ContractManager;
import com.fuhuadata.service.ContractService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * NC合同 统计字段同步
 * Created by intanswer on 2017/4/13.
 */
public class ContractServiceImpl implements ContractService {
    private final static Log log = LogFactory.getLog(ContractServiceImpl.class);
    @Autowired
    private ContractManager contractManager;
    @Override
    public Result synchronousContractStatistics() {
        Result result = new Result();
        try{
            result.setSuccess(contractManager.synchronousContractStatistics());
        }catch(Exception e ){
            result.setSuccess(false);
            log.error("同步NC合同统计数据错误",e);
        }
        return result;
    }
}

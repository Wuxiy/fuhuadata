package com.fuhuadata.service.impl;

import com.fuhuadata.domain.BusinessRecord;
import com.fuhuadata.domain.query.QueryBusinessRecord;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.BusinessRecordManager;
import com.fuhuadata.service.BusinessRecordService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by intanswer on 2017/3/25.
 */
public class BusinessRecordServiceImpl implements BusinessRecordService{
    private static final Log log = LogFactory.getLog(BusinessRecordServiceImpl.class);

    @Autowired
    private BusinessRecordManager businessRecordManager;
    @Override
    public Result<BusinessRecord> addBusinessRecord(BusinessRecord businessRecord) {
        Result<BusinessRecord> result = new Result<BusinessRecord>();
        try{
            result.addDefaultModel("BusinessRecord",businessRecordManager.addBusinessRecord(businessRecord));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("新增商机跟进记录出错",e);
        }
        return result;
    }

    @Override
    public Result updateBusinessRecordById(BusinessRecord businessRecord) {
        Result result = new Result();
        try{
            result.setSuccess(businessRecordManager.updateBusinessRecordById(businessRecord));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("更新商机跟进记录错误",e);
        }
        return result;
    }

    @Override
    public Result deleteBusinessRecordById(int id) {
        Result result = new Result();
        try{
            result.setSuccess(businessRecordManager.deleteBusinessRecordById(id));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("根据id删除商机跟进记录错误",e);
        }
        return result;
    }

    @Override
    public Result<BusinessRecord> getBusinessRecordById(int id) {
        Result<BusinessRecord> result = new Result<BusinessRecord>();
        try{
            result.addDefaultModel("BusinessRecord",businessRecordManager.getBusinessRecordById(id));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("根据id获取商机跟进记录错误",e);
        }
        return result;
    }

    @Override
    public Result<List<BusinessRecord>> getBusinessRecordByBusinessId(String businessId) {
        Result<List<BusinessRecord>> result = new Result<List<BusinessRecord>>();
        try{
            result.addDefaultModel("BusinessRecords",businessRecordManager.getBusinessRecordByBusinessId(businessId));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("根据商机id获取商机跟进记录列表错误",e);
        }
        return result;
    }

    @Override
    public Result<List<BusinessRecord>> getBusinessRecordByQuery(QueryBusinessRecord queryBusinessRecord) {
        Result<List<BusinessRecord>> result = new Result<List<BusinessRecord>>();
        try{
            result.addDefaultModel("BusinessRecords",businessRecordManager.getBusinessRecordByQuery(queryBusinessRecord));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("条件查询商机跟进记录列表错误",e);
        }
        return result;
    }

    @Override
    public Result<Integer> count(QueryBusinessRecord queryBusinessRecord) {
        Result<Integer> result = new Result<Integer>();
        try{
            result.addDefaultModel(businessRecordManager.count(queryBusinessRecord));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("条件查询商机跟进记录数量错误",e);
        }
        return result;
    }
}

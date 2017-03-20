package com.fuhuadata.service.impl;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.service.CustomerVisitRecordService;
import com.fuhuadata.manager.CustomerVisitRecordManager;
import com.fuhuadata.domain.CustomerVisitRecord;
import com.fuhuadata.domain.query.QueryCustomerVisitRecord;
import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.io.Serializable;

/**
 * @author wangbo
 * @date 2017-01-13 16:22:04
 */
public class CustomerVisitRecordServiceImpl implements CustomerVisitRecordService {

	private static final Log log= LogFactory.getLog(CustomerVisitRecordServiceImpl.class);
	@Resource
    private CustomerVisitRecordManager customerVisitRecordManager;
    public Result<CustomerVisitRecord> addCustomerVisitRecord(CustomerVisitRecord customerVisitRecord) {
		Result<CustomerVisitRecord> result = new Result<CustomerVisitRecord>();
		try {
			result.addDefaultModel(customerVisitRecordManager.addCustomerVisitRecord(customerVisitRecord));			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result updateCustomerVisitRecordById(int visitrecord_id, CustomerVisitRecord customerVisitRecord) {
		Result result = new Result();
		try {
			result.setSuccess(customerVisitRecordManager.updateCustomerVisitRecordById(visitrecord_id, customerVisitRecord));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result deleteCustomerVisitRecordById(int visitrecord_id) {
		Result result = new Result();
		try {
			result.setSuccess(customerVisitRecordManager.deleteCustomerVisitRecordById(visitrecord_id));
		} catch(Exception e) {
			result.setSuccess(false);
			log.error("",e);
		}
		return result;
    }

	@Override
	public Result<List<CustomerVisitRecord>> getCustomerVisitRecordByCustomerId(String customerId) {
		Result<List<CustomerVisitRecord>> result = new Result<List<CustomerVisitRecord>>();
		try {
			result.addDefaultModel("CustomerVisitRecords", customerVisitRecordManager.getCustomerVisitRecordByCustomerId(customerId));
		} catch(Exception e) {
			result.setSuccess(false);
			log.error("根据客户id获取沟通记录错误",e);
		}
		return result;
	}

	@Override
	public Result<List<CustomerVisitRecord>> getCustomerVisitRecordByLinkmanId(String linkmanId) {
		Result<List<CustomerVisitRecord>> result = new Result<List<CustomerVisitRecord>>();
		try {
			result.addDefaultModel("CustomerVisitRecords", customerVisitRecordManager.getCustomerVisitRecordByLinkmanId(linkmanId));
		} catch(Exception e) {
			result.setSuccess(false);
			log.error("根据联系人id获取沟通记录错误",e);
		}
		return result;
	}

	public Result<List<CustomerVisitRecord>> getCustomerVisitRecordsByQuery(QueryCustomerVisitRecord queryCustomerVisitRecord) {
		Result<List<CustomerVisitRecord>> result = new Result<List<CustomerVisitRecord>>();
		try {
			result.addDefaultModel("${!className}s", customerVisitRecordManager.getCustomerVisitRecordsByQuery(queryCustomerVisitRecord));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<CustomerVisitRecord> getCustomerVisitRecordById(int visitrecord_id) {
		Result<CustomerVisitRecord> result = new Result<CustomerVisitRecord>();
		try {		
		    CustomerVisitRecord  customerVisitRecord = customerVisitRecordManager.getCustomerVisitRecordById(visitrecord_id);
		    if(customerVisitRecord == null){
				result.setSimpleErrorMsg(0, "当前数据不存在，请重试");
			}else{
				result.addDefaultModel("CustomerVisitRecord", customerVisitRecord);
			}
			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    

    public Result<List<CustomerVisitRecord>> getCustomerVisitRecordsByPage(QueryCustomerVisitRecord queryCustomerVisitRecord) {
		Result<List<CustomerVisitRecord>> result = new Result<List<CustomerVisitRecord>>();
		try {		
			result = customerVisitRecordManager.getCustomerVisitRecordsByPage(queryCustomerVisitRecord);
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<Integer> count(QueryCustomerVisitRecord queryCustomerVisitRecord) {
		Result<Integer> result = new Result<Integer>();
		try {	
			result.addDefaultModel(customerVisitRecordManager.count(queryCustomerVisitRecord));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
	
}
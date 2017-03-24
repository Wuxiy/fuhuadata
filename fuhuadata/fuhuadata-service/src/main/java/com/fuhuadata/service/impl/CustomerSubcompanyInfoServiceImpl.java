package com.fuhuadata.service.impl;
import java.util.List;

import com.fuhuadata.domain.CustomerBaseInfo;
import com.fuhuadata.domain.query.QueryCustomerSubcompanyInfo;
import com.fuhuadata.domain.CustomerSubcompanyInfo;
import com.fuhuadata.manager.CustomerBaseInfoManager;
import com.fuhuadata.service.CustomerSubcompanyInfoService;
import com.fuhuadata.manager.CustomerSubcompanyInfoManager;
import com.fuhuadata.domain.query.Result;
import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.io.Serializable;

/**
 * @author wangbo
 * @date 2017-01-12 13:37:25
 */
public class CustomerSubcompanyInfoServiceImpl implements CustomerSubcompanyInfoService {
	private static final Log log = LogFactory.getLog(CustomerSubcompanyInfoServiceImpl.class);
	
	@Resource
    private CustomerSubcompanyInfoManager customerSubcompanyInfoManager;
	@Resource
	private CustomerBaseInfoManager customerBaseInfoManager;
    public Result<CustomerSubcompanyInfo> addCustomerSubcompanyInfo(CustomerSubcompanyInfo customerSubcompanyInfo) {
		Result<CustomerSubcompanyInfo> result = new Result<CustomerSubcompanyInfo>();
		try {
			result.addDefaultModel(customerSubcompanyInfoManager.addCustomerSubcompanyInfo(customerSubcompanyInfo));			
		} catch(Exception e) {;
			result.setSuccess(false);
			log.error("新增客户子公司错误",e);
		}
		return result;
    }
    
    public Result updateCustomerSubcompanyInfoById(int customer_sub_id, CustomerSubcompanyInfo customerSubcompanyInfo) {
		Result result = new Result();
		try {
			result.setSuccess(customerSubcompanyInfoManager.updateCustomerSubcompanyInfoById(customer_sub_id, customerSubcompanyInfo));
		} catch(Exception e) {
			result.setSuccess(false);
			log.error("根据id更新子公司错误",e);
		}
		return result;
    }

	@Override
	public Result<List<CustomerSubcompanyInfo>> getCustomerSubcompanyInfoByCustomerId(String customerId) {
		Result<List<CustomerSubcompanyInfo>> result = new Result<List<CustomerSubcompanyInfo>>();
		try{
			result.addDefaultModel("CustomerSubcompanyInfos",customerSubcompanyInfoManager.getCustomerSubcompanyInfoByCustomerId(customerId));
		}catch(Exception e){
			result.setSuccess(false);
			log.error("根据客户ID获取子公司列表错误",e);
		}
		return result;
	}

	public Result deleteCustomerSubcompanyInfoById(int customer_sub_id) {
		Result result = new Result();
		try {
			result.setSuccess(customerSubcompanyInfoManager.deleteCustomerSubcompanyInfoById(customer_sub_id));
		} catch(Exception e) {
			result.setSuccess(false);
			log.error("根据id删除客户子公司信息错误",e);
		}
		return result;
    }	
    	
    public Result<List<CustomerSubcompanyInfo>> getCustomerSubcompanyInfosByQuery(QueryCustomerSubcompanyInfo queryCustomerSubcompanyInfo) {
		Result<List<CustomerSubcompanyInfo>> result = new Result<List<CustomerSubcompanyInfo>>();
		try {
			result.addDefaultModel("${!className}s", customerSubcompanyInfoManager.getCustomerSubcompanyInfosByQuery(queryCustomerSubcompanyInfo));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<CustomerSubcompanyInfo> getCustomerSubcompanyInfoById(int customer_sub_id) {
		Result<CustomerSubcompanyInfo> result = new Result<CustomerSubcompanyInfo>();
		try {		
		    CustomerSubcompanyInfo  customerSubcompanyInfo = customerSubcompanyInfoManager.getCustomerSubcompanyInfoById(customer_sub_id);
		    if(customerSubcompanyInfo == null){
				result.setSimpleErrorMsg(0, "当前数据不存在，请重试");
			}else{
				result.addDefaultModel("CustomerSubcompanyInfo", customerSubcompanyInfo);
			}
		} catch(Exception e) {
			result.setSuccess(false);
			log.error("根据id获取子公司详情错误",e);
		}
		return result;	
    }
    

    public Result<List<CustomerSubcompanyInfo>> getCustomerSubcompanyInfosByPage(QueryCustomerSubcompanyInfo queryCustomerSubcompanyInfo) {
		Result<List<CustomerSubcompanyInfo>> result = new Result<List<CustomerSubcompanyInfo>>();
		try {		
			result = customerSubcompanyInfoManager.getCustomerSubcompanyInfosByPage(queryCustomerSubcompanyInfo);
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<Integer> count(QueryCustomerSubcompanyInfo queryCustomerSubcompanyInfo) {
		Result<Integer> result = new Result<Integer>();
		try {	
			result.addDefaultModel(customerSubcompanyInfoManager.count(queryCustomerSubcompanyInfo));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }

}
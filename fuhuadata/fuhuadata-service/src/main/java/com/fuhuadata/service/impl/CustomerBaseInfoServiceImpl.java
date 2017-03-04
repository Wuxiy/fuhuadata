package com.fuhuadata.service.impl;
import com.fuhuadata.domain.CustomerBaseInfo;
import com.fuhuadata.manager.CustomerBaseInfoManager;
import java.util.List;

import com.fuhuadata.domain.query.QueryCustomerBaseInfo;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.service.CustomerBaseInfoService;
import javax.annotation.Resource;

/**
 * @author wangbo
 * @date 2017-01-12 11:49:51
 */
public class CustomerBaseInfoServiceImpl implements CustomerBaseInfoService {
	
	@Resource
    private CustomerBaseInfoManager customerParentManager;
    public Result<CustomerBaseInfo> addCustomerParent(CustomerBaseInfo customerParent) {
		Result<CustomerBaseInfo> result = new Result<CustomerBaseInfo>();
		try {
			result.addDefaultModel(customerParentManager.addCustomerParent(customerParent));			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result updateCustomerParentById(String customer_id, CustomerBaseInfo customerParent) {
		Result result = new Result();
		try {
			result.setSuccess(customerParentManager.updateCustomerParentById(customer_id, customerParent));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result deleteCustomerParentById(String customer_id) {
		Result result = new Result();
		try {
			result.setSuccess(customerParentManager.deleteCustomerParentById(customer_id));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }	
    	
    public Result<List<CustomerBaseInfo>> getCustomerParentsByQuery(QueryCustomerBaseInfo queryCustomerParent) {
		Result<List<CustomerBaseInfo>> result = new Result<List<CustomerBaseInfo>>();
		try {
			result.addDefaultModel("${!className}s", customerParentManager.getCustomerParentsByQuery(queryCustomerParent));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<CustomerBaseInfo> getCustomerParentById(String customer_id) {
		Result<CustomerBaseInfo> result = new Result<CustomerBaseInfo>();
		try {		
		    CustomerBaseInfo customerParent = customerParentManager.getCustomerParentById(customer_id);
		    if(customerParent == null){
				result.setSimpleErrorMsg(0, "当前数据不存在，请重试");
			}else{
				result.addDefaultModel("CustomerBaseInfo", customerParent);
			}
			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    

    public Result<List<CustomerBaseInfo>> getCustomerParentsByPage(QueryCustomerBaseInfo queryCustomerParent) {
		Result<List<CustomerBaseInfo>> result = new Result<List<CustomerBaseInfo>>();
		try {		
			result = customerParentManager.getCustomerParentsByPage(queryCustomerParent);
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<Integer> count(QueryCustomerBaseInfo queryCustomerParent) {
		Result<Integer> result = new Result<Integer>();
		try {	
			result.addDefaultModel(customerParentManager.count(queryCustomerParent));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
	
}
package com.fuhuadata.service.impl;
import com.fuhuadata.manager.CustomerParentManager;
import java.util.List;
import com.fuhuadata.domain.CustomerParent;
import com.fuhuadata.domain.query.QueryCustomerParent;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.service.CustomerBaseInfoService;
import javax.annotation.Resource;

/**
 * @author wangbo
 * @date 2017-01-12 11:49:51
 */
public class CustomerParentServiceImpl implements CustomerBaseInfoService {
	
	@Resource
    private CustomerParentManager customerParentManager;
    public Result<CustomerParent> addCustomerParent(CustomerParent customerParent) {
		Result<CustomerParent> result = new Result<CustomerParent>();
		try {
			result.addDefaultModel(customerParentManager.addCustomerParent(customerParent));			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result updateCustomerParentById(String customer_id, CustomerParent customerParent) {
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
    	
    public Result<List<CustomerParent>> getCustomerParentsByQuery(QueryCustomerParent queryCustomerParent) {
		Result<List<CustomerParent>> result = new Result<List<CustomerParent>>();
		try {
			result.addDefaultModel("${!className}s", customerParentManager.getCustomerParentsByQuery(queryCustomerParent));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<CustomerParent> getCustomerParentById(String customer_id) {
		Result<CustomerParent> result = new Result<CustomerParent>();
		try {		
		    CustomerParent  customerParent = customerParentManager.getCustomerParentById(customer_id);
		    if(customerParent == null){
				result.setSimpleErrorMsg(0, "当前数据不存在，请重试");
			}else{
				result.addDefaultModel("CustomerParent", customerParent);
			}
			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    

    public Result<List<CustomerParent>> getCustomerParentsByPage(QueryCustomerParent queryCustomerParent) {
		Result<List<CustomerParent>> result = new Result<List<CustomerParent>>();
		try {		
			result = customerParentManager.getCustomerParentsByPage(queryCustomerParent);
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<Integer> count(QueryCustomerParent queryCustomerParent) {
		Result<Integer> result = new Result<Integer>();
		try {	
			result.addDefaultModel(customerParentManager.count(queryCustomerParent));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
	
}
package com.fuhuadata.service.impl;
import java.util.List;
import com.fuhuadata.domain.query.QueryCustomerSubcompanyInfo;
import com.fuhuadata.domain.CustomerSubcompanyInfo;
import com.fuhuadata.service.CustomerSubcompanyInfoService;
import com.fuhuadata.manager.CustomerSubcompanyInfoManager;
import com.fuhuadata.domain.query.Result;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.io.Serializable;

/**
 * @author wangbo
 * @date 2017-01-12 13:37:25
 */
@Component
public class CustomerSubcompanyInfoServiceImpl implements CustomerSubcompanyInfoService {
	
	@Resource
    private CustomerSubcompanyInfoManager customerSubcompanyInfoManager;
    public Result<CustomerSubcompanyInfo> addCustomerSubcompanyInfo(CustomerSubcompanyInfo customerSubcompanyInfo) {
		Result<CustomerSubcompanyInfo> result = new Result<CustomerSubcompanyInfo>();
		try {
			result.addDefaultModel(customerSubcompanyInfoManager.addCustomerSubcompanyInfo(customerSubcompanyInfo));			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result updateCustomerSubcompanyInfoById(String customer_sub_id, CustomerSubcompanyInfo customerSubcompanyInfo) {
		Result result = new Result();
		try {
			result.setSuccess(customerSubcompanyInfoManager.updateCustomerSubcompanyInfoById(customer_sub_id, customerSubcompanyInfo));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result deleteCustomerSubcompanyInfoById(String customer_sub_id) {
		Result result = new Result();
		try {
			result.setSuccess(customerSubcompanyInfoManager.deleteCustomerSubcompanyInfoById(customer_sub_id));
		} catch(Exception e) {
			result.setSuccess(false);
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
    	
    public Result<CustomerSubcompanyInfo> getCustomerSubcompanyInfoById(String customer_sub_id) {
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
package com.fuhuadata.service.impl;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.CustomerProductInfo;
import com.fuhuadata.service.CustomerProductInfoService;
import com.fuhuadata.domain.query.QueryCustomerProductInfo;
import com.fuhuadata.manager.CustomerProductInfoManager;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author wangbo
 * @date 2017-02-03 15:51:13
 */
@Component
public class CustomerProductInfoServiceImpl implements CustomerProductInfoService {
	
	@Resource
    private CustomerProductInfoManager customerProductInfoManager;
    public Result<CustomerProductInfo> addCustomerProductInfo(CustomerProductInfo customerProductInfo) {
		Result<CustomerProductInfo> result = new Result<CustomerProductInfo>();
		try {
			result.addDefaultModel(customerProductInfoManager.addCustomerProductInfo(customerProductInfo));			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result updateCustomerProductInfoById(int customer_product_id, CustomerProductInfo customerProductInfo) {
		Result result = new Result();
		try {
			result.setSuccess(customerProductInfoManager.updateCustomerProductInfoById(customer_product_id, customerProductInfo));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result deleteCustomerProductInfoById(int customer_product_id) {
		Result result = new Result();
		try {
			result.setSuccess(customerProductInfoManager.deleteCustomerProductInfoById(customer_product_id));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }	
    	
    public Result<List<CustomerProductInfo>> getCustomerProductInfosByQuery(QueryCustomerProductInfo queryCustomerProductInfo) {
		Result<List<CustomerProductInfo>> result = new Result<List<CustomerProductInfo>>();
		try {
			result.addDefaultModel("${!className}s", customerProductInfoManager.getCustomerProductInfosByQuery(queryCustomerProductInfo));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<CustomerProductInfo> getCustomerProductInfoById(int customer_product_id) {
		Result<CustomerProductInfo> result = new Result<CustomerProductInfo>();
		try {		
		    CustomerProductInfo  customerProductInfo = customerProductInfoManager.getCustomerProductInfoById(customer_product_id);
		    if(customerProductInfo == null){
				result.setSimpleErrorMsg(0, "当前数据不存在，请重试");
			}else{
				result.addDefaultModel("CustomerProductInfo", customerProductInfo);
			}
			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    

    public Result<List<CustomerProductInfo>> getCustomerProductInfosByPage(QueryCustomerProductInfo queryCustomerProductInfo) {
		Result<List<CustomerProductInfo>> result = new Result<List<CustomerProductInfo>>();
		try {		
			result = customerProductInfoManager.getCustomerProductInfosByPage(queryCustomerProductInfo);
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<Integer> count(QueryCustomerProductInfo queryCustomerProductInfo) {
		Result<Integer> result = new Result<Integer>();
		try {	
			result.addDefaultModel(customerProductInfoManager.count(queryCustomerProductInfo));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
	
}
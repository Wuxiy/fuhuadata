package com.fuhuadata.service.impl;
import com.fuhuadata.dao.CustomerPurchaseProductDao;
import com.fuhuadata.manager.CustomerPurchaseProductManager;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.CustomerPurchaseProduct;
import com.fuhuadata.domain.query.QueryCustomerPurchaseProduct;
import com.fuhuadata.service.CustomerPurchaseProductService;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.io.Serializable;

/**
 * @author wangbo
 * @date 2017-01-12 13:51:34
 */
public class CustomerPurchaseProductServiceImpl implements CustomerPurchaseProductService {
	
	@Resource
    private CustomerPurchaseProductManager customerPurchaseProductManager;
	@Autowired
	private CustomerPurchaseProductDao customerPurchaseProductDao;

    public Result<CustomerPurchaseProduct> addCustomerPurchaseProduct(CustomerPurchaseProduct customerPurchaseProduct) {
		Result<CustomerPurchaseProduct> result = new Result<CustomerPurchaseProduct>();
		try {
			result.addDefaultModel(customerPurchaseProductManager.addCustomerPurchaseProduct(customerPurchaseProduct));			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
	public boolean batchInsert( List<CustomerPurchaseProduct> customerPurchaseProducts){
		return customerPurchaseProductDao.batchInsert(customerPurchaseProducts);
	}
    public Result updateCustomerPurchaseProductById(int id, CustomerPurchaseProduct customerPurchaseProduct) {
		Result result = new Result();
		try {
			result.setSuccess(customerPurchaseProductManager.updateCustomerPurchaseProductById(id, customerPurchaseProduct));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result deleteCustomerPurchaseProductById(int id) {
		Result result = new Result();
		try {
			result.setSuccess(customerPurchaseProductManager.deleteCustomerPurchaseProductById(id));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }	
    	
    public Result<List<CustomerPurchaseProduct>> getCustomerPurchaseProductsByQuery(QueryCustomerPurchaseProduct queryCustomerPurchaseProduct) {
		Result<List<CustomerPurchaseProduct>> result = new Result<List<CustomerPurchaseProduct>>();
		try {
			result.addDefaultModel("${!className}s", customerPurchaseProductManager.getCustomerPurchaseProductsByQuery(queryCustomerPurchaseProduct));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<CustomerPurchaseProduct> getCustomerPurchaseProductById(int id) {
		Result<CustomerPurchaseProduct> result = new Result<CustomerPurchaseProduct>();
		try {		
		    CustomerPurchaseProduct  customerPurchaseProduct = customerPurchaseProductManager.getCustomerPurchaseProductById(id);
		    if(customerPurchaseProduct == null){
				result.setSimpleErrorMsg(0, "当前数据不存在，请重试");
			}else{
				result.addDefaultModel("CustomerPurchaseProduct", customerPurchaseProduct);
			}
			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    

    public Result<List<CustomerPurchaseProduct>> getCustomerPurchaseProductsByPage(QueryCustomerPurchaseProduct queryCustomerPurchaseProduct) {
		Result<List<CustomerPurchaseProduct>> result = new Result<List<CustomerPurchaseProduct>>();
		try {		
			result = customerPurchaseProductManager.getCustomerPurchaseProductsByPage(queryCustomerPurchaseProduct);
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<Integer> count(QueryCustomerPurchaseProduct queryCustomerPurchaseProduct) {
		Result<Integer> result = new Result<Integer>();
		try {	
			result.addDefaultModel(customerPurchaseProductManager.count(queryCustomerPurchaseProduct));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
	
}
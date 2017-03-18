package com.fuhuadata.service.impl;
import java.util.List;

import com.fuhuadata.dao.CustomerSaleProductDao;
import com.fuhuadata.domain.query.QueryCustomerSaleProduct;
import com.fuhuadata.service.CustomerSaleProductService;
import com.fuhuadata.manager.CustomerSaleProductManager;
import com.fuhuadata.domain.CustomerSaleProduct;
import com.fuhuadata.domain.query.Result;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.io.Serializable;

/**
 * @author wangbo
 * @date 2017-01-12 13:41:04
 */
public class CustomerSaleProductServiceImpl implements CustomerSaleProductService {
	
	@Resource
    private CustomerSaleProductManager customerSaleProductManager;
	@Autowired
	private CustomerSaleProductDao customerSaleProductDao;
    public Result<CustomerSaleProduct> addCustomerSaleProduct(CustomerSaleProduct customerSaleProduct) {
		Result<CustomerSaleProduct> result = new Result<CustomerSaleProduct>();
		try {
			result.addDefaultModel(customerSaleProductManager.addCustomerSaleProduct(customerSaleProduct));			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }

	@Override
	public boolean batchInsert(List<CustomerSaleProduct> customerSaleProducts) {
		return customerSaleProductDao.batchInsert(customerSaleProducts);
	}

	public Result updateCustomerSaleProductById(int id, CustomerSaleProduct customerSaleProduct) {
		Result result = new Result();
		try {
			result.setSuccess(customerSaleProductManager.updateCustomerSaleProductById(id, customerSaleProduct));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result deleteCustomerSaleProductById(int id) {
		Result result = new Result();
		try {
			result.setSuccess(customerSaleProductManager.deleteCustomerSaleProductById(id));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }	
    	
    public Result<List<CustomerSaleProduct>> getCustomerSaleProductsByQuery(QueryCustomerSaleProduct queryCustomerSaleProduct) {
		Result<List<CustomerSaleProduct>> result = new Result<List<CustomerSaleProduct>>();
		try {
			result.addDefaultModel("${!className}s", customerSaleProductManager.getCustomerSaleProductsByQuery(queryCustomerSaleProduct));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<CustomerSaleProduct> getCustomerSaleProductById(int id) {
		Result<CustomerSaleProduct> result = new Result<CustomerSaleProduct>();
		try {		
		    CustomerSaleProduct  customerSaleProduct = customerSaleProductManager.getCustomerSaleProductById(id);
		    if(customerSaleProduct == null){
				result.setSimpleErrorMsg(0, "当前数据不存在，请重试");
			}else{
				result.addDefaultModel("CustomerSaleProduct", customerSaleProduct);
			}
			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    

    public Result<List<CustomerSaleProduct>> getCustomerSaleProductsByPage(QueryCustomerSaleProduct queryCustomerSaleProduct) {
		Result<List<CustomerSaleProduct>> result = new Result<List<CustomerSaleProduct>>();
		try {		
			result = customerSaleProductManager.getCustomerSaleProductsByPage(queryCustomerSaleProduct);
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<Integer> count(QueryCustomerSaleProduct queryCustomerSaleProduct) {
		Result<Integer> result = new Result<Integer>();
		try {	
			result.addDefaultModel(customerSaleProductManager.count(queryCustomerSaleProduct));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
	
}
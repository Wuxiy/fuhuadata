package com.fuhuadata.manager.impl;
import java.util.List;
import com.fuhuadata.domain.query.QueryCustomerSaleProduct;
import com.fuhuadata.dao.CustomerSaleProductDao;
import com.fuhuadata.manager.CustomerSaleProductManager;
import com.fuhuadata.domain.CustomerSaleProduct;
import com.fuhuadata.domain.query.Result;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

/**
 * @author wangbo
 * @date 2017-01-12 13:41:04
 */
public class CustomerSaleProductManagerImpl implements CustomerSaleProductManager {

	@Resource
    private CustomerSaleProductDao customerSaleProductDao;
    

    public CustomerSaleProduct addCustomerSaleProduct(CustomerSaleProduct customerSaleProduct) {
    	return customerSaleProductDao.addCustomerSaleProduct(customerSaleProduct);
    }
    
    public boolean updateCustomerSaleProductById(int id, CustomerSaleProduct customerSaleProduct) {
    	return customerSaleProductDao.updateCustomerSaleProductById(id, customerSaleProduct) == 1 ? true : false;
    }
    
	public List<CustomerSaleProduct> getCustomerSaleProductsByQuery(QueryCustomerSaleProduct queryCustomerSaleProduct) {
		return customerSaleProductDao.getCustomerSaleProductsByQuery(queryCustomerSaleProduct);
	}

    public boolean deleteCustomerSaleProductById(int id) {
    	return customerSaleProductDao.deleteCustomerSaleProductById(id) == 1 ? true : false;
    }
    
    
    public List<CustomerSaleProduct> getAllCustomerSaleProducts() {
    	return customerSaleProductDao.getAllCustomerSaleProducts();
    }
    	
    public Result<List<CustomerSaleProduct>> getCustomerSaleProductsByPage(QueryCustomerSaleProduct queryCustomerSaleProduct) {
		Result<List<CustomerSaleProduct>> result = new Result<List<CustomerSaleProduct>>();
		int totalItem = customerSaleProductDao.count(queryCustomerSaleProduct);
		;
		if (totalItem > 0) {
			result.addDefaultModel("CustomerSaleProducts", customerSaleProductDao.getCustomerSaleProductsByPage(queryCustomerSaleProduct));		
		} else {
			result.addDefaultModel("CustomerSaleProducts", new ArrayList<CustomerSaleProduct>());
		}
		
		result.setPageSize(queryCustomerSaleProduct.getPageSize());
		result.setIndex(queryCustomerSaleProduct.getIndex());
		result.setTotalItem(totalItem);
		
		return result;
    }
    	
    	
    public CustomerSaleProduct getCustomerSaleProductById(int id) {
    	return customerSaleProductDao.getCustomerSaleProductById(id);
    }
    

    public int count(QueryCustomerSaleProduct queryCustomerSaleProduct) {
    	return customerSaleProductDao.count(queryCustomerSaleProduct);
    }
    
}
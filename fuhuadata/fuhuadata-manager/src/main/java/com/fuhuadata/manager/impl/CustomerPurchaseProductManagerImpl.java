package com.fuhuadata.manager.impl;
import com.fuhuadata.manager.CustomerPurchaseProductManager;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.dao.CustomerPurchaseProductDao;
import com.fuhuadata.domain.CustomerPurchaseProduct;
import com.fuhuadata.domain.query.QueryCustomerPurchaseProduct;
import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author wangbo
 * @date 2017-01-12 13:51:34
 */
public class CustomerPurchaseProductManagerImpl implements CustomerPurchaseProductManager {

	@Resource
    private CustomerPurchaseProductDao customerPurchaseProductDao;
    

    public CustomerPurchaseProduct addCustomerPurchaseProduct(CustomerPurchaseProduct customerPurchaseProduct) {
    	return customerPurchaseProductDao.addCustomerPurchaseProduct(customerPurchaseProduct);
    }
    
    public boolean updateCustomerPurchaseProductById(int id, CustomerPurchaseProduct customerPurchaseProduct) {
    	return customerPurchaseProductDao.updateCustomerPurchaseProductById(id, customerPurchaseProduct) == 1 ? true : false;
    }
    
	public List<CustomerPurchaseProduct> getCustomerPurchaseProductsByQuery(QueryCustomerPurchaseProduct queryCustomerPurchaseProduct) {
		return customerPurchaseProductDao.getCustomerPurchaseProductsByQuery(queryCustomerPurchaseProduct);
	}

    public boolean deleteCustomerPurchaseProductById(int id) {
    	return customerPurchaseProductDao.deleteCustomerPurchaseProductById(id) == 1 ? true : false;
    }
    
    
    public List<CustomerPurchaseProduct> getAllCustomerPurchaseProducts() {
    	return customerPurchaseProductDao.getAllCustomerPurchaseProducts();
    }
    	
    public Result<List<CustomerPurchaseProduct>> getCustomerPurchaseProductsByPage(QueryCustomerPurchaseProduct queryCustomerPurchaseProduct) {
		Result<List<CustomerPurchaseProduct>> result = new Result<List<CustomerPurchaseProduct>>();
		int totalItem = customerPurchaseProductDao.count(queryCustomerPurchaseProduct);
		;
		if (totalItem > 0) {
			result.addDefaultModel("CustomerPurchaseProducts", customerPurchaseProductDao.getCustomerPurchaseProductsByPage(queryCustomerPurchaseProduct));		
		} else {
			result.addDefaultModel("CustomerPurchaseProducts", new ArrayList<CustomerPurchaseProduct>());
		}
		
		result.setPageSize(queryCustomerPurchaseProduct.getPageSize());
		result.setIndex(queryCustomerPurchaseProduct.getIndex());
		result.setTotalItem(totalItem);
		
		return result;
    }
    	
    	
    public CustomerPurchaseProduct getCustomerPurchaseProductById(int id) {
    	return customerPurchaseProductDao.getCustomerPurchaseProductById(id);
    }
    

    public int count(QueryCustomerPurchaseProduct queryCustomerPurchaseProduct) {
    	return customerPurchaseProductDao.count(queryCustomerPurchaseProduct);
    }
    
}
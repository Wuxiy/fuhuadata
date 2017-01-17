package com.fuhuadata.manager.impl;
import com.fuhuadata.manager.CustomerParentManager;
import java.util.List;
import com.fuhuadata.domain.CustomerParent;
import com.fuhuadata.dao.CustomerParentDao;
import com.fuhuadata.domain.query.QueryCustomerParent;
import com.fuhuadata.domain.query.Result;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

/**
 * @author wangbo
 * @date 2017-01-12 11:49:51
 */
public class CustomerParentManagerImpl implements CustomerParentManager {

	@Resource
    private CustomerParentDao customerParentDao;
    

    public CustomerParent addCustomerParent(CustomerParent customerParent) {
    	return customerParentDao.addCustomerParent(customerParent);
    }
    
    public boolean updateCustomerParentById(String customer_id, CustomerParent customerParent) {
    	return customerParentDao.updateCustomerParentById(customer_id, customerParent) == 1 ? true : false;
    }
    
	public List<CustomerParent> getCustomerParentsByQuery(QueryCustomerParent queryCustomerParent) {
		return customerParentDao.getCustomerParentsByQuery(queryCustomerParent);
	}

    public boolean deleteCustomerParentById(String customer_id) {
    	return customerParentDao.deleteCustomerParentById(customer_id) == 1 ? true : false;
    }
    
    
    public List<CustomerParent> getAllCustomerParents() {
    	return customerParentDao.getAllCustomerParents();
    }
    	
    public Result<List<CustomerParent>> getCustomerParentsByPage(QueryCustomerParent queryCustomerParent) {
		Result<List<CustomerParent>> result = new Result<List<CustomerParent>>();
		int totalItem = customerParentDao.count(queryCustomerParent);
		;
		if (totalItem > 0) {
			result.addDefaultModel("CustomerParents", customerParentDao.getCustomerParentsByPage(queryCustomerParent));		
		} else {
			result.addDefaultModel("CustomerParents", new ArrayList<CustomerParent>());
		}
		
		result.setPageSize(queryCustomerParent.getPageSize());
		result.setIndex(queryCustomerParent.getIndex());
		result.setTotalItem(totalItem);
		
		return result;
    }
    	
    	
    public CustomerParent getCustomerParentById(String customer_id) {
    	return customerParentDao.getCustomerParentById(customer_id);
    }
    

    public int count(QueryCustomerParent queryCustomerParent) {
    	return customerParentDao.count(queryCustomerParent);
    }
    
}
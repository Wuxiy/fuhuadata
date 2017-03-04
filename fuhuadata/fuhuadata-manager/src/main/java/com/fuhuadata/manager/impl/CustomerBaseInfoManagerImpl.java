package com.fuhuadata.manager.impl;
import com.fuhuadata.domain.CustomerBaseInfo;
import com.fuhuadata.manager.CustomerBaseInfoManager;
import java.util.List;

import com.fuhuadata.dao.CustomerBaseInfoDao;
import com.fuhuadata.domain.query.QueryCustomerParent;
import com.fuhuadata.domain.query.Result;
import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author wangbo
 * @date 2017-01-12 11:49:51
 */
public class CustomerBaseInfoManagerImpl implements CustomerBaseInfoManager {

	@Resource
    private CustomerBaseInfoDao customerParentDao;
    

    public CustomerBaseInfo addCustomerParent(CustomerBaseInfo customerParent) {
    	return customerParentDao.addCustomerParent(customerParent);
    }
    
    public boolean updateCustomerParentById(String customer_id, CustomerBaseInfo customerParent) {
    	return customerParentDao.updateCustomerParentById(customer_id, customerParent) == 1 ? true : false;
    }
    
	public List<CustomerBaseInfo> getCustomerParentsByQuery(QueryCustomerParent queryCustomerParent) {
		return customerParentDao.getCustomerParentsByQuery(queryCustomerParent);
	}

    public boolean deleteCustomerParentById(String customer_id) {
    	return customerParentDao.deleteCustomerParentById(customer_id) == 1 ? true : false;
    }
    
    
    public List<CustomerBaseInfo> getAllCustomerParents() {
    	return customerParentDao.getAllCustomerParents();
    }
    	
    public Result<List<CustomerBaseInfo>> getCustomerParentsByPage(QueryCustomerParent queryCustomerParent) {
		Result<List<CustomerBaseInfo>> result = new Result<List<CustomerBaseInfo>>();
		int totalItem = customerParentDao.count(queryCustomerParent);
		;
		if (totalItem > 0) {
			result.addDefaultModel("CustomerParents", customerParentDao.getCustomerParentsByPage(queryCustomerParent));		
		} else {
			result.addDefaultModel("CustomerParents", new ArrayList<CustomerBaseInfo>());
		}
		
		result.setPageSize(queryCustomerParent.getPageSize());
		result.setIndex(queryCustomerParent.getIndex());
		result.setTotalItem(totalItem);
		
		return result;
    }
    	
    	
    public CustomerBaseInfo getCustomerParentById(String customer_id) {
    	return customerParentDao.getCustomerParentById(customer_id);
    }
    

    public int count(QueryCustomerParent queryCustomerParent) {
    	return customerParentDao.count(queryCustomerParent);
    }
    
}
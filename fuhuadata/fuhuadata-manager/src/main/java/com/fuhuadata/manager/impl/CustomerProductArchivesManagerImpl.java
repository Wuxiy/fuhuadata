package com.fuhuadata.manager.impl;
import java.util.List;

import com.fuhuadata.domain.CustomerProductArchives;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.dao.CustomerProductArchivesDao;
import com.fuhuadata.domain.query.QueryCustomerProductArchives;
import com.fuhuadata.manager.CustomerProductArchivesManager;

import com.fuhuadata.vo.CustomerProductPackagingArchives;

import java.util.ArrayList;

/**
 * @author wangbo
 * @date 2017-02-03 15:51:13
 */
public class CustomerProductArchivesManagerImpl implements CustomerProductArchivesManager {

    private CustomerProductArchivesDao customerProductInfoDao;
    

    public CustomerProductArchives addCustomerProductInfo(CustomerProductArchives customerProductArchives) {
    	return customerProductInfoDao.addCustomerProductInfo(customerProductArchives);
    }
    
    public boolean updateCustomerProductInfoById(int customer_product_id, CustomerProductArchives customerProductArchives) {
    	return customerProductInfoDao.updateCustomerProductInfoById(customer_product_id, customerProductArchives) == 1 ? true : false;
    }
    
	public List<CustomerProductArchives> getCustomerProductInfosByQuery(QueryCustomerProductArchives queryCustomerProductArchives) {
		return customerProductInfoDao.getCustomerProductInfosByQuery(queryCustomerProductArchives);
	}

    public boolean deleteCustomerProductInfoById(int customer_product_id) {
    	return customerProductInfoDao.deleteCustomerProductInfoById(customer_product_id) == 1 ? true : false;
    }

	@Override
	public List<CustomerProductPackagingArchives> getCustomerProductPackagingArchives(CustomerProductPackagingArchives cppa) {
		return customerProductInfoDao.getCustomerProductPackagingArchives(cppa);
	}
	public int countCustomerProductPackagingArchives(CustomerProductPackagingArchives cppa){
    	return customerProductInfoDao.countCustomerProductPackagingArchives(cppa);
	}

	public List<CustomerProductPackagingArchives> getCustomerProductPackingArchivesById(String customerId){
    	return customerProductInfoDao.getCustomerProductPackingArchivesById(customerId);
	}

	public List<CustomerProductArchives> getAllCustomerProductInfos() {
    	return customerProductInfoDao.getAllCustomerProductInfos();
    }
    	
    public Result<List<CustomerProductArchives>> getCustomerProductInfosByPage(QueryCustomerProductArchives queryCustomerProductArchives) {
		Result<List<CustomerProductArchives>> result = new Result<List<CustomerProductArchives>>();
		int totalItem = customerProductInfoDao.count(queryCustomerProductArchives);
		;
		if (totalItem > 0) {
			result.addDefaultModel("CustomerProductInfos", customerProductInfoDao.getCustomerProductInfosByPage(queryCustomerProductArchives));
		} else {
			result.addDefaultModel("CustomerProductInfos", new ArrayList<CustomerProductArchives>());
		}
		
		result.setPageSize(queryCustomerProductArchives.getPageSize());
		result.setIndex(queryCustomerProductArchives.getIndex());
		result.setTotalItem(totalItem);
		
		return result;
    }
    	
    	
    public CustomerProductArchives getCustomerProductInfoById(int customer_product_id) {
    	return customerProductInfoDao.getCustomerProductInfoById(customer_product_id);
    }
    

    public int count(QueryCustomerProductArchives queryCustomerProductArchives) {
    	return customerProductInfoDao.count(queryCustomerProductArchives);
    }

	public void setCustomerProductInfoDao(CustomerProductArchivesDao customerProductInfoDao) {
		this.customerProductInfoDao = customerProductInfoDao;
	}

	public CustomerProductArchivesDao getCustomerProductInfoDao(){
    	return this.customerProductInfoDao;
	}
}
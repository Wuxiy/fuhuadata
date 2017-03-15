package com.fuhuadata.manager.impl;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.dao.CustomerProductInfoDao;
import com.fuhuadata.domain.CustomerProductInfo;
import com.fuhuadata.domain.query.QueryCustomerProductInfo;
import com.fuhuadata.manager.CustomerProductInfoManager;
import javax.annotation.Resource;

import com.fuhuadata.vo.CustomerProductPackagingArchives;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

/**
 * @author wangbo
 * @date 2017-02-03 15:51:13
 */
public class CustomerProductInfoManagerImpl implements CustomerProductInfoManager {

    private CustomerProductInfoDao customerProductInfoDao;
    

    public CustomerProductInfo addCustomerProductInfo(CustomerProductInfo customerProductInfo) {
    	return customerProductInfoDao.addCustomerProductInfo(customerProductInfo);
    }
    
    public boolean updateCustomerProductInfoById(int customer_product_id, CustomerProductInfo customerProductInfo) {
    	return customerProductInfoDao.updateCustomerProductInfoById(customer_product_id, customerProductInfo) == 1 ? true : false;
    }
    
	public List<CustomerProductInfo> getCustomerProductInfosByQuery(QueryCustomerProductInfo queryCustomerProductInfo) {
		return customerProductInfoDao.getCustomerProductInfosByQuery(queryCustomerProductInfo);
	}

    public boolean deleteCustomerProductInfoById(int customer_product_id) {
    	return customerProductInfoDao.deleteCustomerProductInfoById(customer_product_id) == 1 ? true : false;
    }

	@Override
	public List<CustomerProductPackagingArchives> getCustomerProductPackagingArchives() {
		return customerProductInfoDao.getCustomerProductPackagingArchives();
	}

	public List<CustomerProductPackagingArchives> getCustomerProductPackingArchivesById(String customerId){
    	return customerProductInfoDao.getCustomerProductPackingArchivesById(customerId);
	}

	public List<CustomerProductInfo> getAllCustomerProductInfos() {
    	return customerProductInfoDao.getAllCustomerProductInfos();
    }
    	
    public Result<List<CustomerProductInfo>> getCustomerProductInfosByPage(QueryCustomerProductInfo queryCustomerProductInfo) {
		Result<List<CustomerProductInfo>> result = new Result<List<CustomerProductInfo>>();
		int totalItem = customerProductInfoDao.count(queryCustomerProductInfo);
		;
		if (totalItem > 0) {
			result.addDefaultModel("CustomerProductInfos", customerProductInfoDao.getCustomerProductInfosByPage(queryCustomerProductInfo));		
		} else {
			result.addDefaultModel("CustomerProductInfos", new ArrayList<CustomerProductInfo>());
		}
		
		result.setPageSize(queryCustomerProductInfo.getPageSize());
		result.setIndex(queryCustomerProductInfo.getIndex());
		result.setTotalItem(totalItem);
		
		return result;
    }
    	
    	
    public CustomerProductInfo getCustomerProductInfoById(int customer_product_id) {
    	return customerProductInfoDao.getCustomerProductInfoById(customer_product_id);
    }
    

    public int count(QueryCustomerProductInfo queryCustomerProductInfo) {
    	return customerProductInfoDao.count(queryCustomerProductInfo);
    }

	public void setCustomerProductInfoDao(CustomerProductInfoDao customerProductInfoDao) {
		this.customerProductInfoDao = customerProductInfoDao;
	}

	public CustomerProductInfoDao getCustomerProductInfoDao(){
    	return this.customerProductInfoDao;
	}
}
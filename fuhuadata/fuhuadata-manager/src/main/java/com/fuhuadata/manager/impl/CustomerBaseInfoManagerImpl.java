package com.fuhuadata.manager.impl;
import com.fuhuadata.domain.CustomerBaseInfo;
import com.fuhuadata.manager.CustomerBaseInfoManager;
import java.util.List;

import com.fuhuadata.dao.CustomerBaseInfoDao;
import com.fuhuadata.domain.query.QueryCustomerBaseInfo;
import com.fuhuadata.domain.query.Result;
import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author wangbo
 * @date 2017-01-12 11:49:51
 */
public class CustomerBaseInfoManagerImpl implements CustomerBaseInfoManager {

	@Resource
    private CustomerBaseInfoDao customerBaseInfoDao;
    

    public CustomerBaseInfo addCustomerBaseInfo(CustomerBaseInfo customerBaseInfo) {
    	return customerBaseInfoDao.addCustomerBaseInfo(customerBaseInfo);
    }
    
    public boolean updateCustomerBaseInfoById(String customer_id, CustomerBaseInfo customerBaseInfo) {
    	return customerBaseInfoDao.updateCustomerBaseInfoById(customer_id, customerBaseInfo) == 1 ? true : false;
    }
    
	public List<CustomerBaseInfo> getCustomerBaseInfoByQuery(QueryCustomerBaseInfo queryCustomerBaseInfo) {
		return customerBaseInfoDao.getCustomerBaseInfosByQuery(queryCustomerBaseInfo);
	}

    public boolean deleteCustomerBaseInfoById(String customer_id) {
    	return customerBaseInfoDao.deleteCustomerBaseInfoById(customer_id) == 1 ? true : false;
    }
    
    
    public List<CustomerBaseInfo> getAllCustomerBaseInfos() {
    	return customerBaseInfoDao.getAllCustomerBaseInfos();
    }
    	
    public Result<List<CustomerBaseInfo>> getCustomerBaseInfoByPage(QueryCustomerBaseInfo queryCustomerBaseInfo) {
		Result<List<CustomerBaseInfo>> result = new Result<List<CustomerBaseInfo>>();
		int totalItem = customerBaseInfoDao.count(queryCustomerBaseInfo);
		;
		if (totalItem > 0) {
			result.addDefaultModel("CustomerBaseInfos", customerBaseInfoDao.getCustomerBaseInfoByPage(queryCustomerBaseInfo));
		} else {
			result.addDefaultModel("CustomerBaseInfos", new ArrayList<CustomerBaseInfo>());
		}
		
		result.setPageSize(queryCustomerBaseInfo.getPageSize());
		result.setIndex(queryCustomerBaseInfo.getIndex());
		result.setTotalItem(totalItem);
		
		return result;
    }
    	
    	
    public CustomerBaseInfo getCustomerBaseInfoById(String customer_id) {
    	return customerBaseInfoDao.getCustomerBaseInfoById(customer_id);
    }
    

    public int count(QueryCustomerBaseInfo queryCustomerBaseInfo) {
    	return customerBaseInfoDao.count(queryCustomerBaseInfo);
    }
    
}
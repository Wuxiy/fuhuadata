package com.fuhuadata.manager.impl;
import java.util.List;


import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.QueryCustomerLinkman;
import com.fuhuadata.manager.CustomerLinkmanManager;
import com.fuhuadata.dao.CustomerLinkmanDao;
import com.fuhuadata.domain.CustomerLinkman;
import com.fuhuadata.util.StringUtil;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author wangbo
 * @date 2017-01-13 16:10:56
 */
public class CustomerLinkmanManagerImpl implements CustomerLinkmanManager {

	@Resource
    private CustomerLinkmanDao customerLinkmanDao;
    

    public CustomerLinkman addCustomerLinkman(CustomerLinkman customerLinkman) {
    	//设置字符串主键
    	String linkmanId = customerLinkmanDao.getMaxLinkmanIdByCustomerId(customerLinkman.getCustomerId());
    	customerLinkman.setLinkmanId(StringUtil.increment(linkmanId,3));
    	return customerLinkmanDao.addCustomerLinkman(customerLinkman);
    }
    
    public boolean updateCustomerLinkmanById(String linkman_id, CustomerLinkman customerLinkman) {
    	return customerLinkmanDao.updateCustomerLinkmanById(linkman_id, customerLinkman) == 1 ? true : false;
    }
    
	public List<CustomerLinkman> getCustomerLinkmansByQuery(QueryCustomerLinkman queryCustomerLinkman) {
		return customerLinkmanDao.getCustomerLinkmansByQuery(queryCustomerLinkman);
	}

    public boolean deleteCustomerLinkmanById(String linkman_id) {
    	return customerLinkmanDao.deleteCustomerLinkmanById(linkman_id) == 1 ? true : false;
    }
    
    
    public List<CustomerLinkman> getAllCustomerLinkmans() {
    	return customerLinkmanDao.getAllCustomerLinkmans();
    }
    	
    public Result<List<CustomerLinkman>> getCustomerLinkmansByPage(QueryCustomerLinkman queryCustomerLinkman) {
		Result<List<CustomerLinkman>> result = new Result<List<CustomerLinkman>>();
		int totalItem = customerLinkmanDao.count(queryCustomerLinkman);
		;
		if (totalItem > 0) {
			result.addDefaultModel("CustomerLinkmans", customerLinkmanDao.getCustomerLinkmansByPage(queryCustomerLinkman));		
		} else {
			result.addDefaultModel("CustomerLinkmans", new ArrayList<CustomerLinkman>());
		}
		
		result.setPageSize(queryCustomerLinkman.getPageSize());
		result.setIndex(queryCustomerLinkman.getIndex());
		result.setTotalItem(totalItem);
		
		return result;
    }
    	
    	
    public CustomerLinkman getCustomerLinkmanById(String linkman_id) {
    	return customerLinkmanDao.getCustomerLinkmanById(linkman_id);
    }

	@Override
	public CustomerLinkman getCustomerLinkmanDefaultByCustomerId(String customerId) {
		return customerLinkmanDao.getCustomerLinkmanDefaultByCustomerId(customerId);
	}

	@Override
	public List<CustomerLinkman> getCustomerLinkmanByCustomerId(String customerId) {
		return customerLinkmanDao.getCustomerLinkmanByCustomerId(customerId);
	}


	public int count(QueryCustomerLinkman queryCustomerLinkman) {
    	return customerLinkmanDao.count(queryCustomerLinkman);
    }
    
}
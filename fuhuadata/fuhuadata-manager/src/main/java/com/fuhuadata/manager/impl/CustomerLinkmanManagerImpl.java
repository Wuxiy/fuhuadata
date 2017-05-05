package com.fuhuadata.manager.impl;
import java.util.List;


import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.QueryCustomerLinkman;
import com.fuhuadata.manager.CustomerLinkmanManager;
import com.fuhuadata.dao.CustomerLinkmanDao;
import com.fuhuadata.domain.CustomerLinkman;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author wangbo
 * @date 2017-01-13 16:10:56
 */
public class CustomerLinkmanManagerImpl implements CustomerLinkmanManager {

	@Resource
    private CustomerLinkmanDao customerLinkmanDao;



	/**
	 *  do add
	 * @param customerLinkman
	 * @return
	 */
	@Transactional
    public CustomerLinkman addCustomerLinkman(CustomerLinkman customerLinkman) {
		try {
			CustomerLinkman customerLinkmandefault = customerLinkmanDao.getCustomerLinkmanDefaultByCustomerId(customerLinkman.getCustomerId());
			if (customerLinkmandefault != null && customerLinkman.getIsDefault() == 1) {
				customerLinkmandefault.setIsDefault(0);
				customerLinkmanDao.updateCustomerLinkmanById(customerLinkmandefault.getLinkmanId(), customerLinkmandefault);
				customerLinkman = customerLinkmanDao.addCustomerLinkman(customerLinkman);
			} else if (customerLinkmandefault == null) {
				customerLinkman.setIsDefault(1);
				customerLinkman = customerLinkmanDao.addCustomerLinkman(customerLinkman);
			} else {
				customerLinkman = customerLinkmanDao.addCustomerLinkman(customerLinkman);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
    	return customerLinkman;
    }

    @Transactional
    public boolean updateCustomerLinkmanById(String linkman_id, CustomerLinkman customerLinkman) {
    		boolean flag = false;
			CustomerLinkman customerLinkmandefault = customerLinkmanDao.getCustomerLinkmanDefaultByCustomerId(customerLinkman.getCustomerId());
			if (customerLinkmandefault != null && customerLinkman.getIsDefault() == 1) {
				customerLinkmandefault.setIsDefault(0);
				customerLinkmanDao.updateCustomerLinkmanById(customerLinkmandefault.getLinkmanId(), customerLinkmandefault);
				flag = customerLinkmanDao.updateCustomerLinkmanById(linkman_id, customerLinkman) == 1 ? true : false;
			} else if (customerLinkmandefault == null || customerLinkman.getLinkmanId() == customerLinkmandefault.getLinkmanId()) {
				customerLinkman.setIsDefault(1);
				flag = customerLinkmanDao.updateCustomerLinkmanById(linkman_id, customerLinkman) == 1 ? true : false;
			} else {
				flag = customerLinkmanDao.updateCustomerLinkmanById(linkman_id, customerLinkman) == 1 ? true : false;
			}
			return flag;

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
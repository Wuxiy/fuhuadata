package com.fuhuadata.manager.impl;
import java.util.List;

import com.fuhuadata.dao.CustomerBaseInfoDao;
import com.fuhuadata.dao.CustomerSubcompanyInfoDao;
import com.fuhuadata.domain.CustomerEnterpriceNature;
import com.fuhuadata.domain.query.QueryCustomerSubcompanyInfo;
import com.fuhuadata.domain.CustomerSubcompanyInfo;
import com.fuhuadata.manager.CustomerSubcompanyInfoManager;
import com.fuhuadata.domain.query.Result;
import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * @author wangbo
 * @date 2017-01-12 13:37:25
 */
public class CustomerSubcompanyInfoManagerImpl implements CustomerSubcompanyInfoManager {

	@Resource
    private CustomerSubcompanyInfoDao customerSubcompanyInfoDao;

	@Resource
	private CustomerBaseInfoDao customerBaseInfoDao;


	@Transactional
    public CustomerSubcompanyInfo addCustomerSubcompanyInfo(CustomerSubcompanyInfo customerSubcompanyInfo,List<CustomerEnterpriceNature> list) {
		if(list!=null&&list.size()>0) {
			customerBaseInfoDao.batchAddNature(list);
		}
    	return customerSubcompanyInfoDao.addCustomerSubcompanyInfo(customerSubcompanyInfo);

    }

    @Transactional
    public boolean updateCustomerSubcompanyInfoById(List<CustomerEnterpriceNature> list, CustomerSubcompanyInfo customerSubcompanyInfo) {
		boolean flag = false;
		customerBaseInfoDao.deleteCustomerEnterpriceNatureByCustomerId(String.valueOf(customerSubcompanyInfo.getCustomerSubId()));
		customerBaseInfoDao.batchAddNature(list);
		flag = customerSubcompanyInfoDao.updateCustomerSubcompanyInfoById(customerSubcompanyInfo.getCustomerSubId(), customerSubcompanyInfo)==1?true:false;
		return flag;
    }
    
	public List<CustomerSubcompanyInfo> getCustomerSubcompanyInfosByQuery(QueryCustomerSubcompanyInfo queryCustomerSubcompanyInfo) {
		return customerSubcompanyInfoDao.getCustomerSubcompanyInfosByQuery(queryCustomerSubcompanyInfo);
	}

    public boolean deleteCustomerSubcompanyInfoById(int customer_sub_id) {
    	return customerSubcompanyInfoDao.deleteCustomerSubcompanyInfoById(customer_sub_id) == 1 ? true : false;
    }
    
    
    public List<CustomerSubcompanyInfo> getAllCustomerSubcompanyInfos() {
    	return customerSubcompanyInfoDao.getAllCustomerSubcompanyInfos();
    }
    	
    public Result<List<CustomerSubcompanyInfo>> getCustomerSubcompanyInfosByPage(QueryCustomerSubcompanyInfo queryCustomerSubcompanyInfo) {
		Result<List<CustomerSubcompanyInfo>> result = new Result<List<CustomerSubcompanyInfo>>();
		int totalItem = customerSubcompanyInfoDao.count(queryCustomerSubcompanyInfo);
		;
		if (totalItem > 0) {
			result.addDefaultModel("CustomerSubcompanyInfos", customerSubcompanyInfoDao.getCustomerSubcompanyInfosByPage(queryCustomerSubcompanyInfo));		
		} else {
			result.addDefaultModel("CustomerSubcompanyInfos", new ArrayList<CustomerSubcompanyInfo>());
		}
		
		result.setPageSize(queryCustomerSubcompanyInfo.getPageSize());
		result.setIndex(queryCustomerSubcompanyInfo.getIndex());
		result.setTotalItem(totalItem);
		
		return result;
    }
    	
    	
    public CustomerSubcompanyInfo getCustomerSubcompanyInfoById(int customer_sub_id) {
    	return customerSubcompanyInfoDao.getCustomerSubcompanyInfoById(customer_sub_id);
    }

	/**
	 * 根据客户id获取子公司列表
	 * @param customerId
	 * @return
	 */
	@Override
	public List<CustomerSubcompanyInfo> getCustomerSubcompanyInfoByCustomerId(String customerId) {
		return customerSubcompanyInfoDao.getCustomerSubcompanyInfoByCustomerId(customerId);
	}


	public int count(QueryCustomerSubcompanyInfo queryCustomerSubcompanyInfo) {
    	return customerSubcompanyInfoDao.count(queryCustomerSubcompanyInfo);
    }


    
}
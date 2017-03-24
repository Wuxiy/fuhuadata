package com.fuhuadata.manager.impl;
import java.util.List;

import com.fuhuadata.dao.CustomerBaseInfoDao;
import com.fuhuadata.dao.CustomerSubcompanyInfoDao;
import com.fuhuadata.domain.CustomerBaseInfo;
import com.fuhuadata.domain.CustomerEnterpriceNature;
import com.fuhuadata.domain.query.QueryCustomerSubcompanyInfo;
import com.fuhuadata.domain.CustomerSubcompanyInfo;
import com.fuhuadata.manager.CustomerSubcompanyInfoManager;
import com.fuhuadata.domain.query.Result;
import javax.annotation.Resource;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.sun.xml.internal.fastinfoset.algorithm.FloatEncodingAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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

	@Autowired
	private SqlMapClient sqlMapClient;
    

    public CustomerSubcompanyInfo addCustomerSubcompanyInfo(CustomerSubcompanyInfo customerSubcompanyInfo) {
    	return customerSubcompanyInfoDao.addCustomerSubcompanyInfo(customerSubcompanyInfo);
    }
    
    public boolean updateCustomerSubcompanyInfoById(List<CustomerEnterpriceNature> list, CustomerSubcompanyInfo customerSubcompanyInfo) {
    	boolean flag = false;
    	try{
    		sqlMapClient.startTransaction();
    		customerBaseInfoDao.deleteCustomerEnterpriceNatureByCustomerId(customerSubcompanyInfo.getCustomerId());
    		customerBaseInfoDao.batchAddNature(list);
			flag = customerSubcompanyInfoDao.updateCustomerSubcompanyInfoById(customerSubcompanyInfo.getCustomerSubId(), customerSubcompanyInfo)==1?true:false;
			sqlMapClient.commitTransaction();
		}catch(Exception e){
    		e.printStackTrace();
		}
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
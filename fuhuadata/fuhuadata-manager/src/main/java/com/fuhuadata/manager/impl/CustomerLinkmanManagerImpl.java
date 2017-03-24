package com.fuhuadata.manager.impl;
import java.util.LinkedHashMap;
import java.util.List;


import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.QueryCustomerLinkman;
import com.fuhuadata.manager.CustomerLinkmanManager;
import com.fuhuadata.dao.CustomerLinkmanDao;
import com.fuhuadata.domain.CustomerLinkman;
import com.fuhuadata.util.StringUtil;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.engine.mapping.sql.Sql;
import com.sun.scenario.effect.impl.state.LinearConvolveKernel;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * @author wangbo
 * @date 2017-01-13 16:10:56
 */
public class CustomerLinkmanManagerImpl implements CustomerLinkmanManager {

	@Resource
    private CustomerLinkmanDao customerLinkmanDao;

	@Autowired
	private SqlMapClient sqlMapClient;
    

    public CustomerLinkman addCustomerLinkman(CustomerLinkman customerLinkman) {
    	//设置字符串主键
    	String linkmanId = customerLinkmanDao.getMaxLinkmanIdByCustomerId(customerLinkman.getCustomerId());
    	customerLinkman.setLinkmanId(StringUtil.increment(linkmanId,3));
    	return customerLinkmanDao.addCustomerLinkman(customerLinkman);
    }
    
    public boolean updateCustomerLinkmanById(String linkman_id, CustomerLinkman customerLinkman) {
    	boolean flag = false;
    	try{
			sqlMapClient.startTransaction();//事务开始
			CustomerLinkman customerLinkmandefault = customerLinkmanDao.getCustomerLinkmanDefaultByCustomerId(customerLinkman.getCustomerId());
			if(customerLinkmandefault!=null&&customerLinkman.getIsDefault()==1){
				customerLinkmandefault.setIsDefault(0);
				System.out.println(customerLinkmandefault.getIsDefault());
				customerLinkmanDao.updateCustomerLinkmanById(customerLinkmandefault.getLinkmanId(),customerLinkmandefault);
				flag=customerLinkmanDao.updateCustomerLinkmanById(linkman_id,customerLinkman)==1?true:false;
			}
			else if(customerLinkmandefault==null||customerLinkman.getLinkmanId()==customerLinkmandefault.getLinkmanId()) {
				customerLinkman.setIsDefault(1);
				flag = customerLinkmanDao.updateCustomerLinkmanById(linkman_id, customerLinkman) == 1 ? true : false;
			}
			 else{
				flag=customerLinkmanDao.updateCustomerLinkmanById(linkman_id,customerLinkman)==1?true:false;
			}
			sqlMapClient.commitTransaction();//事务提交

		}catch(Exception e){
    		e.printStackTrace();
    		try{
				sqlMapClient.getCurrentConnection().rollback();//事务回滚
			}catch(Exception e2){
    			e2.printStackTrace();
			}
		}finally {
			try {
				sqlMapClient.endTransaction();//事务结束
			}catch(Exception e3){
				e3.printStackTrace();
			}
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
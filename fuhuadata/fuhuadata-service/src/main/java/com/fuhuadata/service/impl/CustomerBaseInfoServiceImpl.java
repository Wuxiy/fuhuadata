package com.fuhuadata.service.impl;
import com.fuhuadata.dao.CustomerBaseInfoDao;
import com.fuhuadata.domain.CountCustomersOrderProduct;
import com.fuhuadata.domain.CustomerBaseInfo;
import com.fuhuadata.manager.CustomerBaseInfoManager;
import java.util.List;

import com.fuhuadata.domain.query.QueryCustomerBaseInfo;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.service.CustomerBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author wangbo
 * @date 2017-01-12 11:49:51
 */
public class CustomerBaseInfoServiceImpl implements CustomerBaseInfoService {

	@Autowired
    private CustomerBaseInfoManager customerBaseInfoManager;

    public Result<CustomerBaseInfo> addCustomerBaseInfo(CustomerBaseInfo customerBaseInfo) {
		Result<CustomerBaseInfo> result = new Result<CustomerBaseInfo>();
		try {
			result.addDefaultModel(customerBaseInfoManager.addCustomerBaseInfo(customerBaseInfo));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }

    public Result updateCustomerBaseInfoById(String customer_id, CustomerBaseInfo customerBaseInfo) {
		Result result = new Result();
		try {
			result.setSuccess(customerBaseInfoManager.updateCustomerBaseInfoById(customer_id, customerBaseInfo));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }

    public Result deleteCustomerBaseInfoById(String customer_id) {
		Result result = new Result();
		try {
			result.setSuccess(customerBaseInfoManager.deleteCustomerBaseInfoById(customer_id));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }

    public Result<List<CustomerBaseInfo>> getCustomerBaseInfoByQuery(QueryCustomerBaseInfo queryCustomerBaseInfo) {
		Result<List<CustomerBaseInfo>> result = new Result<List<CustomerBaseInfo>>();
		try {
			result.addDefaultModel("${!className}s", customerBaseInfoManager.getCustomerBaseInfoByQuery(queryCustomerBaseInfo));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }

    public Result<CustomerBaseInfo> getCustomerBaseInfoById(String customer_id) {
		Result<CustomerBaseInfo> result = new Result<CustomerBaseInfo>();
		try {
		    CustomerBaseInfo customerBaseInfo = customerBaseInfoManager.getCustomerBaseInfoById(customer_id);
		    if(customerBaseInfo == null){
				result.setSimpleErrorMsg(0, "当前数据不存在，请重试");
			}else{
				result.addDefaultModel("CustomerBaseInfo", customerBaseInfo);
			}

		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }


    public Result<List<CustomerBaseInfo>> getCustomerBaseInfoByPage(QueryCustomerBaseInfo queryCustomerBaseInfo) {
		Result<List<CustomerBaseInfo>> result = new Result<List<CustomerBaseInfo>>();
		try {
			result = customerBaseInfoManager.getCustomerBaseInfoByPage(queryCustomerBaseInfo);
		} catch(Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
		}
		return result;
    }

    public Result<Integer> count(QueryCustomerBaseInfo queryCustomerBaseInfo) {
		Result<Integer> result = new Result<Integer>();
		try {
			result.addDefaultModel(customerBaseInfoManager.count(queryCustomerBaseInfo));
		} catch(Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		return result;	
    }

	public List<CountCustomersOrderProduct> countOrderProduct(String customerId) {
		return customerBaseInfoManager.countOrderProduct(customerId);
	}
}
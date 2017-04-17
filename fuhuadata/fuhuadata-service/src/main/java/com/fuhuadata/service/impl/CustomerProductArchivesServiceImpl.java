package com.fuhuadata.service.impl;
import java.util.List;

import com.fuhuadata.dao.CustomerProductArchivesDao;
import com.fuhuadata.domain.CustomerProductArchives;
import com.fuhuadata.domain.query.QueryCustomerProductArchives;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.service.CustomerProductArchivesService;
import com.fuhuadata.manager.CustomerProductArchivesManager;

import com.fuhuadata.util.JsonUtils;
import com.fuhuadata.vo.CustomerProductPackagingArchives;
import com.fuhuadata.vo.DocumentaryVo;
import com.fuhuadata.vo.PackingRequireVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wangbo
 * @date 2017-02-03 15:51:13
 */
public class CustomerProductArchivesServiceImpl implements CustomerProductArchivesService {

	@Autowired
    private CustomerProductArchivesManager customerProductInfoManager;
	@Autowired
	private CustomerProductArchivesDao customerProductArchivesDao;
    private static final Log log = LogFactory.getLog(CustomerProductArchivesServiceImpl.class);
    public Result<CustomerProductArchives> addCustomerProductInfo(CustomerProductArchives customerProductArchives) {
		Result<CustomerProductArchives> result = new Result<CustomerProductArchives>();
		try {
			result.addDefaultModel(customerProductInfoManager.addCustomerProductInfo(customerProductArchives));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result updateCustomerProductInfoById(int customer_product_id, CustomerProductArchives customerProductArchives) {
		Result result = new Result();
		try {
			result.setSuccess(customerProductInfoManager.updateCustomerProductInfoById(customer_product_id, customerProductArchives));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result deleteCustomerProductInfoById(int customer_product_id) {
		Result result = new Result();
		try {
			result.setSuccess(customerProductInfoManager.deleteCustomerProductInfoById(customer_product_id));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }

	@Override
	public Result<List<CustomerProductPackagingArchives>> getCustomerProductPackagingArchives() {
    	Result<List<CustomerProductPackagingArchives>> result = new Result<List<CustomerProductPackagingArchives>>();
    	try{
    		result.addDefaultModel("CustomerProductPackagingArchives",customerProductInfoManager.getCustomerProductPackagingArchives());

		}catch(Exception e){
    		result.setSuccess(false);
    		log.error("获取客户产品包装要求错误",e);
		}
		return result;
	}

	public Result<List<CustomerProductPackagingArchives>> getCustomerProductPackagingArchivesById(String customerId) {
		Result<List<CustomerProductPackagingArchives>> result = new Result<List<CustomerProductPackagingArchives>>();
		try{
			result.addDefaultModel("CustomerProductPackagingArchives",customerProductInfoManager.getCustomerProductPackingArchivesById(customerId));
		}catch(Exception e){
			result.setSuccess(false);
			log.error("获取客户产品包装要求错误",e);
		}
		return result;
	}

	public Result<List<CustomerProductArchives>> getCustomerProductInfosByQuery(QueryCustomerProductArchives queryCustomerProductArchives) {
		Result<List<CustomerProductArchives>> result = new Result<List<CustomerProductArchives>>();
		try {
			result.addDefaultModel("${!className}s", customerProductInfoManager.getCustomerProductInfosByQuery(queryCustomerProductArchives));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<CustomerProductArchives> getCustomerProductInfoById(int customer_product_id) {
		Result<CustomerProductArchives> result = new Result<CustomerProductArchives>();
		try {		
		    CustomerProductArchives customerProductArchives = customerProductInfoManager.getCustomerProductInfoById(customer_product_id);
		    if(customerProductArchives == null){
				result.setSimpleErrorMsg(0, "当前数据不存在，请重试");
			}else{
				result.addDefaultModel("QueryCustomerProductArchives", customerProductArchives);
			}
			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    

    public Result<List<CustomerProductArchives>> getCustomerProductInfosByPage(QueryCustomerProductArchives queryCustomerProductArchives) {
		Result<List<CustomerProductArchives>> result = new Result<List<CustomerProductArchives>>();
		try {		
			result = customerProductInfoManager.getCustomerProductInfosByPage(queryCustomerProductArchives);
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<Integer> count(QueryCustomerProductArchives queryCustomerProductArchives) {
		Result<Integer> result = new Result<Integer>();
		try {	
			result.addDefaultModel(customerProductInfoManager.count(queryCustomerProductArchives));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }

	@Override
	public List<CustomerProductArchives> getCustomerBillRequirement(String customerId) {
		List<CustomerProductArchives> list = customerProductArchivesDao.getCustomerBillRequirement(customerId);
		if(list!=null && list.size()>0){
			for(CustomerProductArchives cp:list){
				cp.setDocumentaryVo(JsonUtils.toObject(DocumentaryVo.class,cp.getDocumentaryRequire()));
			}
		}
		return list;
	}

	@Override
	public List<CustomerProductArchives> getCustomerTransportRequirement(String customerId) {
		List<CustomerProductArchives> list = customerProductArchivesDao.getCustomerTransportRequirement(customerId);
		if(list!=null && list.size()>0){
			for(CustomerProductArchives cp:list){
				cp.setPackingRequireVo(JsonUtils.toObject(PackingRequireVo.class,cp.getPackageRequire()));
			}
		}
		return list;
	}
}
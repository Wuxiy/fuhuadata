package com.fuhuadata.service.impl;
import java.util.List;

import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.CustomerVisitRecordManager;
import com.fuhuadata.service.CustomerLinkmanService;
import com.fuhuadata.domain.query.QueryCustomerLinkman;
import com.fuhuadata.manager.CustomerLinkmanManager;
import com.fuhuadata.domain.CustomerLinkman;
import javax.annotation.Resource;

import com.fuhuadata.vo.CustomerLinkmanVO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author wangbo
 * @date 2017-01-13 16:10:56
 */
public class CustomerLinkmanServiceImpl implements CustomerLinkmanService {
	private static final Log log = LogFactory.getLog(CustomerLinkmanServiceImpl.class);
	@Resource
    private CustomerLinkmanManager customerLinkmanManager;

	@Resource
	private CustomerVisitRecordManager customerVisitRecordManager;

	/**
	 * 新增客户联系人
	 * @param customerLinkman
	 * @return
	 */
    public Result<CustomerLinkman> addCustomerLinkman(CustomerLinkman customerLinkman) {
		Result<CustomerLinkman> result = new Result<CustomerLinkman>();
		try {
			//判断客户有无默认联系人
			CustomerLinkman customerLinkmanDefault=customerLinkmanManager.getCustomerLinkmanDefaultByCustomerId(customerLinkman.getCustomerId());
			//默认联系人替换
			if(customerLinkmanDefault!=null&&customerLinkman.getIsDefault()==1){
				customerLinkmanDefault.setIsDefault(0);
				customerLinkmanManager.updateCustomerLinkmanById(customerLinkmanDefault.getLinkmanId(),customerLinkmanDefault);
			}
			else if(customerLinkmanDefault==null&&customerLinkman.getIsDefault()==0) {
				result.setMessage("必须为该客户设置默认联系人");
				result.setCode(0);
				return result;
			}
			result.addDefaultModel(customerLinkmanManager.addCustomerLinkman(customerLinkman));
		} catch(Exception e) {
			result.setSuccess(false);
			log.error("新增客户联系人错误",e);
		}
		return result;
    }
    
    public Result updateCustomerLinkmanById(String linkman_id, CustomerLinkman customerLinkman) {
		Result result = new Result();
		try {
			result.setSuccess(customerLinkmanManager.updateCustomerLinkmanById(linkman_id, customerLinkman));
		} catch(Exception e) {
			result.setSuccess(false);
			log.error("根据id更新联系人信息错误",e);
		}
		return result;
    }
    
    public Result deleteCustomerLinkmanById(String linkman_id) {
		Result result = new Result();
		try {
			result.setSuccess(customerLinkmanManager.deleteCustomerLinkmanById(linkman_id));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }	
    	
    public Result<List<CustomerLinkman>> getCustomerLinkmansByQuery(QueryCustomerLinkman queryCustomerLinkman) {
		Result<List<CustomerLinkman>> result = new Result<List<CustomerLinkman>>();
		try {
			result.addDefaultModel("${!className}s", customerLinkmanManager.getCustomerLinkmansByQuery(queryCustomerLinkman));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<CustomerLinkman> getCustomerLinkmanById(String linkman_id) {
		Result<CustomerLinkman> result = new Result<CustomerLinkman>();
		try {		
		    CustomerLinkman  customerLinkman = customerLinkmanManager.getCustomerLinkmanById(linkman_id);
		    if(customerLinkman == null){
				result.setSimpleErrorMsg(0, "当前数据不存在，请重试");
			}else{
				result.addDefaultModel("CustomerLinkman", customerLinkman);
			}
			
		} catch(Exception e) {
			result.setSuccess(false);
			log.error("根据客户id获取联系人错误",e);
		}
		return result;	
    }

	@Override
	public Result<CustomerLinkmanVO> getCustomerLinkmanDetailsById(String linkmanId) {
    	Result<CustomerLinkmanVO> result = new Result<CustomerLinkmanVO>();
    	CustomerLinkmanVO customerLinkmanVO = new CustomerLinkmanVO();
    	try{
    		customerLinkmanVO.setCustomerLinkman(customerLinkmanManager.getCustomerLinkmanById(linkmanId));

		}catch(Exception e){
    		result.setSuccess(false);
    		log.error("根据联系人id获取详情错误",e);
		}
		try {
			customerLinkmanVO.setVisitRecordVOS(customerVisitRecordManager.getCustomerVisitRecordByLinkmanId(linkmanId));
			result.addDefaultModel("CustomerLinkmanDetails",customerLinkmanVO);
		}catch(Exception e){
			result.setSuccess(false);
			log.error("根据联系人id获取沟通记录错误",e);
		}
		return result;
	}

	/**
	 * 查询客户联系人列表
	 * @param customerId
	 * @return
	 */
	@Override
	public Result<List<CustomerLinkman>> getCustomerLinkmanByCustomerId(String customerId) {
		Result<List<CustomerLinkman>> result = new Result<List<CustomerLinkman>>();
		try {
			result.addDefaultModel("customerLinkmen",customerLinkmanManager.getCustomerLinkmanByCustomerId(customerId)) ;
		} catch(Exception e) {
			result.setSuccess(false);
			log.error("error",e);
		}
		return result;
	}

	@Override
	public Result<CustomerLinkman> getCustomerLinkmanDefaultByCustomerId(String customerId) {
		Result<CustomerLinkman> result = new Result<CustomerLinkman>();
		try {
			result.addDefaultModel(customerLinkmanManager.getCustomerLinkmanDefaultByCustomerId(customerId));
		} catch(Exception e) {
			result.setSuccess(false);
			log.error("根据客户ID查找默认联系人错误",e);
		}
		return result;
	}


	public Result<List<CustomerLinkman>> getCustomerLinkmansByPage(QueryCustomerLinkman queryCustomerLinkman) {
		Result<List<CustomerLinkman>> result = new Result<List<CustomerLinkman>>();
		try {		
			result = customerLinkmanManager.getCustomerLinkmansByPage(queryCustomerLinkman);
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<Integer> count(QueryCustomerLinkman queryCustomerLinkman) {
		Result<Integer> result = new Result<Integer>();
		try {	
			result.addDefaultModel(customerLinkmanManager.count(queryCustomerLinkman));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
	
}
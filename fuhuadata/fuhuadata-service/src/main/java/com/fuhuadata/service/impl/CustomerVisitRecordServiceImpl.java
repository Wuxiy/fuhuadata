package com.fuhuadata.service.impl;
import java.security.interfaces.RSAKey;
import java.util.Arrays;
import java.util.List;

import com.fuhuadata.dao.RecordLinkmanDao;
import com.fuhuadata.domain.RecordLinkman;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.RecordLinkmanManager;
import com.fuhuadata.service.CustomerVisitRecordService;
import com.fuhuadata.manager.CustomerVisitRecordManager;
import com.fuhuadata.domain.CustomerVisitRecord;
import com.fuhuadata.domain.query.QueryCustomerVisitRecord;
import javax.annotation.Resource;
import javax.management.Query;

import com.fuhuadata.vo.CustomerVisitRecordVO;
import com.fuhuadata.vo.VisitRecordVO;
import jdk.jfr.events.ExceptionThrownEvent;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author wangbo
 * @date 2017-01-13 16:22:04
 */
public class CustomerVisitRecordServiceImpl implements CustomerVisitRecordService {

	private static final Log log= LogFactory.getLog(CustomerVisitRecordServiceImpl.class);
	@Resource
    private CustomerVisitRecordManager customerVisitRecordManager;
	@Resource
	private RecordLinkmanManager recordLinkmanManager;
    public Result<CustomerVisitRecord> addCustomerVisitRecord(CustomerVisitRecord customerVisitRecord) {
		Result<CustomerVisitRecord> result = new Result<CustomerVisitRecord>();
		try {
			result.addDefaultModel(customerVisitRecordManager.addCustomerVisitRecord(customerVisitRecord));			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }

	/**
	 * 客户沟通记录新增
	 * @param customerVisitRecordVO
	 * @return
	 */
	@Override
	public Result addVisitRecord(CustomerVisitRecordVO customerVisitRecordVO) {
    	Result result = new Result();
		CustomerVisitRecord addCustomerVisitRecord = new CustomerVisitRecord();
		boolean flag = false;
		try {
			try {

				CustomerVisitRecord customerVisitRecord = customerVisitRecordVO.getCustomerVisitRecord();
				addCustomerVisitRecord = customerVisitRecordManager.addCustomerVisitRecord(customerVisitRecord);
			} catch (Exception e) {
				result.setSuccess(false);
				log.error("新增客户沟通记录错误", e);
			}
			try {
				if (addCustomerVisitRecord != null) {
					flag = true;
					RecordLinkman[] recordLinkman = customerVisitRecordVO.getRecordLinkmen();
					for (int i = 0; i < recordLinkman.length; i++) {
						recordLinkman[i].setVisitRecordId(addCustomerVisitRecord.getVisitrecordId());
						recordLinkman[i].setActivityExpens(addCustomerVisitRecord.getActivityExpense());
						recordLinkman[i].setCreateUserId(addCustomerVisitRecord.getCreateUserId());
						recordLinkman[i].setCreateUserName(addCustomerVisitRecord.getCreateUserName());
						recordLinkman[i].setCreateUserName(addCustomerVisitRecord.getCreateUserName());
						recordLinkman[i].setCreateTime(addCustomerVisitRecord.getCreateTime());
						recordLinkman[i].setModifyTime(addCustomerVisitRecord.getModifyTime());
						recordLinkman[i].setLastmodifyUserId(addCustomerVisitRecord.getLastmodifyUserId());
						recordLinkman[i].setLastmodifyUserName(addCustomerVisitRecord.getLastmodifyUserName());
					}
					flag = recordLinkmanManager.addRecordLinkmen(Arrays.asList(recordLinkman));
				}
			} catch (Exception e) {
				result.setSuccess(false);
				log.error("新增联系人沟通记录错误", e);
			}
		}catch(Exception e){
			result.setSuccess(false);
			log.error("新增沟通记录错误",e);
		}
		result.setSuccess(flag);
		return result;
	}

	public Result updateCustomerVisitRecordById(int visitrecord_id, CustomerVisitRecord customerVisitRecord) {
		Result result = new Result();
		try {
			result.setSuccess(customerVisitRecordManager.updateCustomerVisitRecordById(visitrecord_id, customerVisitRecord));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result deleteCustomerVisitRecordById(int visitrecord_id) {
		Result result = new Result();
		try {
			result.setSuccess(customerVisitRecordManager.deleteCustomerVisitRecordById(visitrecord_id));
		} catch(Exception e) {
			result.setSuccess(false);
			log.error("",e);
		}
		return result;
    }

	@Override
	public Result<List<VisitRecordVO>> getCustomerVisitRecordByCustomerId(String customerId) {
		Result<List<VisitRecordVO>> result = new Result<List<VisitRecordVO>>();
		try {
			result.addDefaultModel("CustomerVisitRecords", customerVisitRecordManager.getCustomerVisitRecordByCustomerId(customerId));
		} catch(Exception e) {
			result.setSuccess(false);
			log.error("根据客户id获取沟通记录错误",e);
		}
		return result;
	}

	@Override
	public Result<List<VisitRecordVO>> getCustomerVisitRecordByLinkmanId(String linkmanId) {
		Result<List<VisitRecordVO>> result = new Result<List<VisitRecordVO>>();
		try {
			result.addDefaultModel("LinkmanVisitRecords", customerVisitRecordManager.getCustomerVisitRecordByLinkmanId(linkmanId));
		} catch(Exception e) {
			result.setSuccess(false);
			log.error("根据联系人id获取沟通记录错误",e);
		}
		return result;
	}

	public Result<List<CustomerVisitRecord>> getCustomerVisitRecordsByQuery(QueryCustomerVisitRecord queryCustomerVisitRecord) {
		Result<List<CustomerVisitRecord>> result = new Result<List<CustomerVisitRecord>>();
		try {
			result.addDefaultModel("${!className}s", customerVisitRecordManager.getCustomerVisitRecordsByQuery(queryCustomerVisitRecord));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<CustomerVisitRecord> getCustomerVisitRecordById(int visitrecord_id) {
		Result<CustomerVisitRecord> result = new Result<CustomerVisitRecord>();
		try {		
		    CustomerVisitRecord  customerVisitRecord = customerVisitRecordManager.getCustomerVisitRecordById(visitrecord_id);
		    if(customerVisitRecord == null){
				result.setSimpleErrorMsg(0, "当前数据不存在，请重试");
			}else{
				result.addDefaultModel("CustomerVisitRecord", customerVisitRecord);
			}
			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    

    public Result<List<QueryCustomerVisitRecord>> getCustomerVisitRecordsByPage(QueryCustomerVisitRecord queryCustomerVisitRecord) {
		Result<List<QueryCustomerVisitRecord>> result = new Result<List<QueryCustomerVisitRecord>>();
		try {		
			result.addDefaultModel("CustomerVisitRecords",customerVisitRecordManager.getCustomerVisitRecordsByPage(queryCustomerVisitRecord)) ;
		} catch(Exception e) {
			result.setSuccess(false);
			log.error("分页条件获取客户维护记录出错",e);
		}
		return result;	
    }
    	
    public Result<Integer> count(QueryCustomerVisitRecord queryCustomerVisitRecord) {
		Result<Integer> result = new Result<Integer>();
		try {	
			result.addDefaultModel(customerVisitRecordManager.count(queryCustomerVisitRecord));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
	
}
package com.fuhuadata.manager.impl;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.dao.CustomerVisitRecordDao;
import com.fuhuadata.manager.CustomerVisitRecordManager;
import com.fuhuadata.domain.CustomerVisitRecord;
import com.fuhuadata.domain.query.QueryCustomerVisitRecord;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

/**
 * @author wangbo
 * @date 2017-01-13 16:22:04
 */
public class CustomerVisitRecordManagerImpl implements CustomerVisitRecordManager {

	@Resource
    private CustomerVisitRecordDao customerVisitRecordDao;
    

    public CustomerVisitRecord addCustomerVisitRecord(CustomerVisitRecord customerVisitRecord) {
    	return customerVisitRecordDao.addCustomerVisitRecord(customerVisitRecord);
    }
    
    public boolean updateCustomerVisitRecordById(int visitrecord_id, CustomerVisitRecord customerVisitRecord) {
    	return customerVisitRecordDao.updateCustomerVisitRecordById(visitrecord_id, customerVisitRecord) == 1 ? true : false;
    }
    
	public List<CustomerVisitRecord> getCustomerVisitRecordsByQuery(QueryCustomerVisitRecord queryCustomerVisitRecord) {
		return customerVisitRecordDao.getCustomerVisitRecordsByQuery(queryCustomerVisitRecord);
	}

    public boolean deleteCustomerVisitRecordById(int visitrecord_id) {
    	return customerVisitRecordDao.deleteCustomerVisitRecordById(visitrecord_id) == 1 ? true : false;
    }
    
    
    public List<CustomerVisitRecord> getAllCustomerVisitRecords() {
    	return customerVisitRecordDao.getAllCustomerVisitRecords();
    }
    	
    public Result<List<CustomerVisitRecord>> getCustomerVisitRecordsByPage(QueryCustomerVisitRecord queryCustomerVisitRecord) {
		Result<List<CustomerVisitRecord>> result = new Result<List<CustomerVisitRecord>>();
		int totalItem = customerVisitRecordDao.count(queryCustomerVisitRecord);
		;
		if (totalItem > 0) {
			result.addDefaultModel("CustomerVisitRecords", customerVisitRecordDao.getCustomerVisitRecordsByPage(queryCustomerVisitRecord));		
		} else {
			result.addDefaultModel("CustomerVisitRecords", new ArrayList<CustomerVisitRecord>());
		}
		
		result.setPageSize(queryCustomerVisitRecord.getPageSize());
		result.setIndex(queryCustomerVisitRecord.getIndex());
		result.setTotalItem(totalItem);
		
		return result;
    }
    	
    	
    public CustomerVisitRecord getCustomerVisitRecordById(int visitrecord_id) {
    	return customerVisitRecordDao.getCustomerVisitRecordById(visitrecord_id);
    }
    

    public int count(QueryCustomerVisitRecord queryCustomerVisitRecord) {
    	return customerVisitRecordDao.count(queryCustomerVisitRecord);
    }
    
}
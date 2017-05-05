package com.fuhuadata.manager.impl;
import java.util.List;

import com.fuhuadata.dao.RecordLinkmanDao;
import com.fuhuadata.dao.CustomerVisitRecordDao;
import com.fuhuadata.domain.RecordLinkman;
import com.fuhuadata.domain.query.QueryRecordLinkman;
import com.fuhuadata.manager.CustomerVisitRecordManager;
import com.fuhuadata.domain.CustomerVisitRecord;
import com.fuhuadata.domain.query.QueryCustomerVisitRecord;
import javax.annotation.Resource;

import com.fuhuadata.vo.CustomerVisitRecordLinkman;
import com.fuhuadata.vo.CustomerVisitRecordVO;
import com.fuhuadata.vo.VisitRecordVO;

/**
 * @author wangbo
 * @date 2017-01-13 16:22:04
 */
public class CustomerVisitRecordManagerImpl implements CustomerVisitRecordManager {

	@Resource
    private CustomerVisitRecordDao customerVisitRecordDao;

	@Resource
	private RecordLinkmanDao recordLinkmanDao;
    

    public CustomerVisitRecord addCustomerVisitRecord(CustomerVisitRecord customerVisitRecord) {
    	return customerVisitRecordDao.addCustomerVisitRecord(customerVisitRecord);
    }

	@Override
	public boolean addVisitRecord(CustomerVisitRecordVO customerVisitRecordVO) {
		return false;
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
    	
    public List<QueryCustomerVisitRecord> getCustomerVisitRecordsByPage(QueryCustomerVisitRecord queryCustomerVisitRecord) {
		return customerVisitRecordDao.getCustomerVisitRecordsByPage(queryCustomerVisitRecord);
    }

    public CustomerVisitRecordLinkman getCustomerVisitRecordById(int visitrecord_id) {
		CustomerVisitRecordLinkman customerVisitRecordLinkman = new CustomerVisitRecordLinkman();
		QueryRecordLinkman queryRecordLinkman = new QueryRecordLinkman();
		queryRecordLinkman.setVisitRecordId(visitrecord_id+"");
		List<RecordLinkman> recordLinkmanList = recordLinkmanDao.getRecordLinkmansByQuery(queryRecordLinkman);
    	customerVisitRecordLinkman.setCustomerVisitRecord(customerVisitRecordDao.getCustomerVisitRecordById(visitrecord_id));
    	customerVisitRecordLinkman.setRecordLinkmanList(recordLinkmanList);
    	return customerVisitRecordLinkman;
    }

	@Override
	public List<VisitRecordVO> getCustomerVisitRecordByCustomerId(String customerId) {
		return customerVisitRecordDao.getCustomerVisitRecordByCustomerId(customerId);
	}

	@Override
	public List<VisitRecordVO> getCustomerVisitRecordByLinkmanId(String linkmanId) {
		return customerVisitRecordDao.getCustomerVisitRecordByLinkmanId(linkmanId);
	}


	public int count(QueryCustomerVisitRecord queryCustomerVisitRecord) {
    	return customerVisitRecordDao.count(queryCustomerVisitRecord);
    }
    
}
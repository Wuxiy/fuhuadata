package com.fuhuadata.manager.impl;

import com.fuhuadata.dao.BusinessRecordDao;
import com.fuhuadata.domain.BusinessRecord;
import com.fuhuadata.domain.query.QueryBusinessRecord;
import com.fuhuadata.manager.BusinessRecordManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by intanswer on 2017/3/25.
 */
public class BusinessRecordManagerImpl implements BusinessRecordManager  {

    @Autowired
    private BusinessRecordDao businessRecordDao;
    @Override
    public BusinessRecord addBusinessRecord(BusinessRecord businessRecord) {
        return businessRecordDao.addBusinessRecord(businessRecord);
    }

    @Override
    public boolean updateBusinessRecordById(BusinessRecord businessRecord) {
        return businessRecordDao.updateBusinessRecordById(businessRecord)==1?true : false;
    }

    @Override
    public boolean deleteBusinessRecordById(int id) {
        return businessRecordDao.deleteBusinessRecordById(id)==1?true :false;
    }

    @Override
    public BusinessRecord getBusinessRecordById(int id) {
        return businessRecordDao.getBusinessRecordById(id);
    }

    @Override
    public List<BusinessRecord> getBusinessRecordByBusinessId(String businessId) {
        return businessRecordDao.getBusinessRecordByBusinessId(businessId);
    }

    @Override
    public List<BusinessRecord> getBusinessRecordByQuery(QueryBusinessRecord queryBusinessRecord) {
        return businessRecordDao.getBusinessRecordByQuery(queryBusinessRecord);
    }

    @Override
    public int count(QueryBusinessRecord queryBusinessRecord) {
        return businessRecordDao.count(queryBusinessRecord);
    }
}

package com.fuhuadata.manager.impl;

import com.fuhuadata.dao.BusinessInfoDao;
import com.fuhuadata.dao.BusinessRecordDao;
import com.fuhuadata.domain.BusinessInfo;
import com.fuhuadata.domain.query.QueryBusinessInfo;
import com.fuhuadata.manager.BusinessInfoManager;
import com.fuhuadata.vo.BusinessInfoVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by intanswer on 2017/3/25.
 */
public class BusinessInfoManagerImpl implements BusinessInfoManager {

    @Autowired
    private BusinessInfoDao businessInfoDao;

    @Autowired
    private BusinessRecordDao businessRecordDao;
    @Override
    public BusinessInfo addBusinessInfo(BusinessInfo businessInfo) {
        return businessInfoDao.addBusinessInfo(businessInfo);
    }

    @Override
    public boolean updateBusinessInfoByBusinessId(BusinessInfo businessInfo) {
        return businessInfoDao.updateBusinessInfoByBusinessId(businessInfo)==1?true : false;
    }

    @Override
    public boolean deleteBusinessInfoByBusinessId(String businessId) {
        return businessInfoDao.deleteBusinessInfoByBusinessId(businessId)==1?true : false;
    }

    @Override
    public BusinessInfoVO getBusinessInfoByBusinessId(String businessId) {
        BusinessInfoVO businessInfoVO = new BusinessInfoVO();
        businessInfoVO.setBusinessInfo( businessInfoDao.getBusinessInfoByBusinessId(businessId));
        businessInfoVO.setBusinessRecords(businessRecordDao.getBusinessRecordByBusinessId(businessId));
        return businessInfoVO;

    }

    @Override
    public List<BusinessInfo> getBusinessInfoByCustomerId(String customerId) {
        return businessInfoDao.getBusinessInfoByCustomerId(customerId);
    }

    @Override
    public List<BusinessInfo> getBusinessInfoByQuery(QueryBusinessInfo queryBusinessInfo) {
        return businessInfoDao.getBusinessInfoByQuery(queryBusinessInfo);
    }

    @Override
    public List<QueryBusinessInfo> getBusinessInfoByPage(QueryBusinessInfo queryBusinessInfo) {
        return businessInfoDao.getBusinessInfoByPage(queryBusinessInfo);
    }

    @Override
    public int count(QueryBusinessInfo queryBusinessInfo) {
        return businessInfoDao.count(queryBusinessInfo);
    }
}

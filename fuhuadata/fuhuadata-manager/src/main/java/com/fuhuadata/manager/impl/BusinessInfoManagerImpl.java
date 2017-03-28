package com.fuhuadata.manager.impl;

import com.fuhuadata.dao.BusinessInfoDao;
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
    public BusinessInfo getBusinessInfoByBusinessId(String businessId) {
        return businessInfoDao.getBusinessInfoByBusinessId(businessId);
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
    public List<BusinessInfoVO> getBusinessInfoByPage(BusinessInfoVO businessInfoVO) {
        return businessInfoDao.getBusinessInfoByPage(businessInfoVO);
    }

    @Override
    public int count(BusinessInfoVO businessInfoVO) {
        return businessInfoDao.count(businessInfoVO);
    }
}

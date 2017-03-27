package com.fuhuadata.dao;

import com.fuhuadata.domain.BusinessInfo;
import com.fuhuadata.domain.query.QueryBusinessInfo;


import java.util.List;

/**
 * 商机信息dao
 * Created by intanswer on 2017/3/24.
 */
public interface BusinessInfoDao {
    public BusinessInfo addBusinessInfo(BusinessInfo businessInfo);

    public int updateBusinessInfoByBusinessId(BusinessInfo businessInfo);

    public int deleteBusinessInfoByBusinessId(String businessId);

    public BusinessInfo getBusinessInfoByBusinessId(String businessId);

    public List<BusinessInfo> getBusinessInfoByCustomerId(String customerId);

    public List<BusinessInfo> getBusinessInfoByQuery(QueryBusinessInfo queryBusinessInfo);

    public int count(QueryBusinessInfo queryBusinessInfo);
}

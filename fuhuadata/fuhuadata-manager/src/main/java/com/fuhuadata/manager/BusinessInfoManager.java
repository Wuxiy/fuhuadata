package com.fuhuadata.manager;

import com.fuhuadata.domain.BusinessInfo;
import com.fuhuadata.domain.query.QueryBusinessInfo;
import com.fuhuadata.vo.BusinessInfoVO;

import java.util.List;

/**
 * 商机信息manager
 * Created by intanswer on 2017/3/25.
 */
public  interface BusinessInfoManager {

    public BusinessInfo addBusinessInfo(BusinessInfo businessInfo);

    public boolean updateBusinessInfoByBusinessId(BusinessInfo businessInfo);

    public boolean deleteBusinessInfoByBusinessId(String businessId);

    public BusinessInfo getBusinessInfoByBusinessId(String businessId);

    public List<BusinessInfo> getBusinessInfoByCustomerId(String customerId);

    public List<BusinessInfo> getBusinessInfoByQuery(QueryBusinessInfo queryBusinessInfo);

    public List<BusinessInfoVO> getBusinessInfoByPage(BusinessInfoVO businessInfoVO);

    public int count(BusinessInfoVO businessInfoVO);

}

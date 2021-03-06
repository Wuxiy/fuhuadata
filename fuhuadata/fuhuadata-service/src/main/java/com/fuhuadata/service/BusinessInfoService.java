package com.fuhuadata.service;

import com.fuhuadata.domain.BusinessInfo;
import com.fuhuadata.domain.query.QueryBusinessInfo;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.vo.BusinessInfoVO;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by intanswer on 2017/3/25.
 */
public interface BusinessInfoService {
    public Result<BusinessInfo> addBusinessInfo(BusinessInfo businessInfo);

    public Result updateBusinessInfoByBusinessId(BusinessInfo businessInfo);

    public Result deleteBusinessInfoByBusinessId(String businessId);

    public Result<BusinessInfoVO> getBusinessInfoByBusinessId(String businessId);

    public Result<List<BusinessInfo>> getBusinessInfoByCustomerId(String customerId);

    public Result<List<BusinessInfo>> getBusinessInfoByQuery(QueryBusinessInfo queryBusinessInfo);

    public Result<List<QueryBusinessInfo>> getBusinessInfoByPage(QueryBusinessInfo queryBusinessInfo);

    public Result<Integer> count(QueryBusinessInfo queryBusinessInfo);
}

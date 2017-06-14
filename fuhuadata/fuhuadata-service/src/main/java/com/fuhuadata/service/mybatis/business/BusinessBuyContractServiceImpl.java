package com.fuhuadata.service.mybatis.business;

import com.fuhuadata.dao.mapper.business.BusinessBuyContractMapper;
import com.fuhuadata.domain.business.BusinessBuyContract;
import com.fuhuadata.domain.business.BusinessBuyContractQuery;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 6/13/2017
 */
@Service
public class BusinessBuyContractServiceImpl extends BaseServiceImpl<BusinessBuyContract, Integer>
        implements BusinessBuyContractService {

    private BusinessBuyContractMapper getBuyContractMapper() {
        return (BusinessBuyContractMapper) baseMapper;
    }

    @Override
    public List<BusinessBuyContract> listContrats(BusinessBuyContractQuery query) {

        return getBuyContractMapper().listContracts(query);
    }
}

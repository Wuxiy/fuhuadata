package com.fuhuadata.service.mybatis.business;

import com.fuhuadata.dao.mapper.business.BusinessOrgiContractMapper;
import com.fuhuadata.domain.business.BusinessOrgiContract;
import com.fuhuadata.domain.business.BusinessOrgiContractQuery;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 6/13/2017
 */
@Service
public class BusinessOrgiContractServiceImpl extends BaseServiceImpl<BusinessOrgiContract, Integer>
        implements BusinessOrgiContractService {

    private BusinessOrgiContractMapper getOrgiContractMapper() {
        return (BusinessOrgiContractMapper) baseMapper;
    }

    @Override
    public List<BusinessOrgiContract> listContracts(BusinessOrgiContractQuery query) {

        return getOrgiContractMapper().listContracts(query);
    }
}

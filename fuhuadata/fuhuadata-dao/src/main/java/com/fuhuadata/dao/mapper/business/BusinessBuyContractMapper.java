package com.fuhuadata.dao.mapper.business;

import com.fuhuadata.dao.mapper.BaseMapper;
import com.fuhuadata.domain.business.BusinessBuyContract;
import com.fuhuadata.domain.business.BusinessBuyContractQuery;

import java.util.List;

public interface BusinessBuyContractMapper extends BaseMapper<BusinessBuyContract, Integer> {

    List<BusinessBuyContract> listContracts(BusinessBuyContractQuery query);
}
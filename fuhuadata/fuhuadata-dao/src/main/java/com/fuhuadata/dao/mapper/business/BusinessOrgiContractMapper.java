package com.fuhuadata.dao.mapper.business;

import com.fuhuadata.dao.mapper.BaseMapper;
import com.fuhuadata.domain.business.BusinessOrgiContract;
import com.fuhuadata.domain.business.BusinessOrgiContractQuery;

import java.util.List;

public interface BusinessOrgiContractMapper extends BaseMapper<BusinessOrgiContract, Integer> {

    List<BusinessOrgiContract> listContracts(BusinessOrgiContractQuery query);
}
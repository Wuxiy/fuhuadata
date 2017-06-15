package com.fuhuadata.service.mybatis.business;

import com.fuhuadata.domain.business.BusinessOrgiContract;
import com.fuhuadata.domain.business.BusinessOrgiContractQuery;
import com.fuhuadata.service.mybatis.BaseService;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 6/13/2017
 */
public interface BusinessOrgiContractService extends BaseService<BusinessOrgiContract, Integer> {

    List<BusinessOrgiContract> listContracts(BusinessOrgiContractQuery query);
}

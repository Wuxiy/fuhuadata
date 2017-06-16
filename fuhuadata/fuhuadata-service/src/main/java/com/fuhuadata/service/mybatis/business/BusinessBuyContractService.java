package com.fuhuadata.service.mybatis.business;

import com.fuhuadata.domain.business.BusinessBuyContract;
import com.fuhuadata.domain.business.BusinessBuyContractQuery;
import com.fuhuadata.service.mybatis.BaseService;

import java.util.List;

/**
 * 采购合同
 * <p>User: wangjie
 * <p>Date: 6/13/2017
 */
public interface BusinessBuyContractService extends BaseService<BusinessBuyContract, Integer> {

    List<BusinessBuyContract> listContrats(BusinessBuyContractQuery query);
}

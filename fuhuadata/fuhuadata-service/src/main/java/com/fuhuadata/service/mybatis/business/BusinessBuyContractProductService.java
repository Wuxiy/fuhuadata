package com.fuhuadata.service.mybatis.business;

import com.fuhuadata.domain.business.BusinessBuyContractProduct;
import com.fuhuadata.service.mybatis.BaseService;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 6/13/2017
 */
public interface BusinessBuyContractProductService extends BaseService<BusinessBuyContractProduct, Integer> {

    List<BusinessBuyContractProduct> listProducts(String pkContract);
}

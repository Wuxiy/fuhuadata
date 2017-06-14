package com.fuhuadata.service.mybatis.business;

import com.fuhuadata.dao.mapper.business.BusinessBuyContractProductMapper;
import com.fuhuadata.domain.business.BusinessBuyContractProduct;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 6/13/2017
 */
@Service
public class BusinessBuyContractProductServiceImpl extends BaseServiceImpl<BusinessBuyContractProduct, Integer>
        implements BusinessBuyContractProductService {

    private BusinessBuyContractProductMapper getProductMapper() {
        return (BusinessBuyContractProductMapper) baseMapper;
    }

    @Override
    public List<BusinessBuyContractProduct> listProducts(String pkContract) {

        return getProductMapper().listProducts(pkContract);
    }
}

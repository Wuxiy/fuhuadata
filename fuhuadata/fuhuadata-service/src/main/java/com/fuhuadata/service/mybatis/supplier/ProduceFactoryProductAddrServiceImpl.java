package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.dao.supplier.ProduceFactoryProductAddrMapper;
import com.fuhuadata.domain.supplier.ProduceFactoryProductAddr;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>User: wangjie
 * <p>Date: 5/23/2017
 */
@Service
public class ProduceFactoryProductAddrServiceImpl extends BaseServiceImpl<ProduceFactoryProductAddr, Integer>
        implements ProduceFactoryProductAddrService {

    public ProduceFactoryProductAddrMapper getProduceFactoryProduceAddrMapper() {
        return (ProduceFactoryProductAddrMapper) baseMapper;
    }


}

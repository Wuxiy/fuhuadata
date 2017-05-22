package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.dao.supplier.ProduceFactoryProduceAddrMapper;
import com.fuhuadata.domain.supplier.ProduceFactoryProduceAddr;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>User: wangjie
 * <p>Date: 5/23/2017
 */
@Service
public class ProduceFactoryProduceAddrServiceImpl extends BaseServiceImpl<ProduceFactoryProduceAddr, Integer>
        implements ProduceFactoryProduceAddrService {

    public ProduceFactoryProduceAddrMapper getProduceFactoryProduceAddrMapper() {
        return (ProduceFactoryProduceAddrMapper) baseMapper;
    }


}

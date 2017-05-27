package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.dao.supplier.ProduceFactoryProductAddrMapper;
import com.fuhuadata.domain.supplier.ProduceFactoryProductAddr;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Optional;

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


    @Override
    public int saveProductAddrs(List<ProduceFactoryProductAddr> addrs) {

        if (CollectionUtils.isEmpty(addrs)) {
            return 0;
        }

        return saveList(addrs);
    }

    @Override
    public int updateProductAddrs(List<ProduceFactoryProductAddr> addrs) {

        if (CollectionUtils.isEmpty(addrs)) {
            return 0;
        }

        return update(addrs);
    }

    @Override
    public void saveOrUpdate(List<ProduceFactoryProductAddr> productAddrs) {

        Optional.ofNullable(productAddrs).ifPresent(addrs -> addrs.forEach(this::saveOrUpdateSelective));
    }

    @Override
    public void deleteProductAddrByProductId(Integer productId) {

        if (null == productId) {
            return;
        }

        Example example = newExample();
        example.createCriteria()
                .andEqualTo("productId", productId);

        delete(example);
    }

}

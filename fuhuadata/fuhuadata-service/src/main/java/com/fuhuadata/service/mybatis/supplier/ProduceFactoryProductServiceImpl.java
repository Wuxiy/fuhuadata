package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.dao.supplier.ProduceFactoryProductMapper;
import com.fuhuadata.domain.supplier.ProduceFactoryProduct;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>User: wangjie
 * <p>Date: 5/23/2017
 */
@Service
public class ProduceFactoryProductServiceImpl extends BaseServiceImpl<ProduceFactoryProduct, Integer>
        implements ProduceFactoryProductService {

    private ProduceFactoryProductMapper getProductMapper() {
        return (ProduceFactoryProductMapper) baseMapper;
    }

    @Override
    public ProduceFactoryProduct saveProduct(ProduceFactoryProduct product) {

        if (null == product) {
            return null;
        }

       save(product);

        return product;
    }

    @Override
    public ProduceFactoryProduct updateProduct(ProduceFactoryProduct product) {
        return null;
    }
}

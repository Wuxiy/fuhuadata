package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.domain.supplier.ProduceFactoryProduct;
import com.fuhuadata.service.mybatis.BaseService;

/**
 * 加工厂产品
 * <p>User: wangjie
 * <p>Date: 5/23/2017
 */
public interface ProduceFactoryProductService extends BaseService<ProduceFactoryProduct, Integer> {

    /**
     * 新增产品
     * @param product
     * @return
     */
    ProduceFactoryProduct saveProduct(ProduceFactoryProduct product);

    /**
     * 更新产品
     * @param product
     * @return
     */
    ProduceFactoryProduct updateProduct(ProduceFactoryProduct product);
}

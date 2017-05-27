package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.domain.supplier.ProduceFactoryProduct;
import com.fuhuadata.service.mybatis.BaseService;

import java.util.List;

/**
 * 加工厂产品
 * <p>User: wangjie
 * <p>Date: 5/23/2017
 */
public interface ProduceFactoryProductService extends BaseService<ProduceFactoryProduct, Integer> {

    /**
     * 获取加工厂产品
     * @param productId
     * @return
     */
    ProduceFactoryProduct getById(Integer productId);

    /**
     * 获取某加工厂产品
     * @param factoryId
     * @return
     */
    List<ProduceFactoryProduct> listProducts(Integer factoryId);

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

    /**
     * 删除加工厂下的产品
     * @param factoryId
     * @param productIds
     */
    void deleteProducts(Integer factoryId, List<Integer> productIds);
}

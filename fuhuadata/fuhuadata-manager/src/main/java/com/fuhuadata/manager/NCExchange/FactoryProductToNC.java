package com.fuhuadata.manager.NCExchange;

import com.fuhuadata.domain.supplier.ProduceFactoryProduct;

import java.util.List;

/**
 * Created by zhangxiang on 2017/6/7.
 */
public interface FactoryProductToNC {
    void sendFactoryProduct(List<ProduceFactoryProduct> factoryProducts) throws Exception;
}

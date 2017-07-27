package com.fuhuadata.manager.NCExchange;

import com.fuhuadata.domain.supplier.ProduceFactoryProduct;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangxiang on 2017/6/7.
 */
public interface FactoryProductToNC {
    Map sendFactoryProduct(List<ProduceFactoryProduct> factoryProducts) throws Exception;
}

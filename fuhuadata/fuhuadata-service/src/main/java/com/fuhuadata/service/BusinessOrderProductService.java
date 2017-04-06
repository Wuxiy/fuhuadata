package com.fuhuadata.service;

import com.fuhuadata.domain.BusinessOrderProduct;
import com.fuhuadata.domain.BusinessOrderProductComponent;

import java.util.List;

/**
 * Created by hexingfu on 2017/4/5.
 */
public interface BusinessOrderProductService {

    /**
     * 插入产品要求基本信息和产品成分及费用信息
     * @param businessOrderProduct
     * @return
     */
    int addBusinessOrderProduct(BusinessOrderProduct businessOrderProduct,List<BusinessOrderProductComponent> businessOrderProductComponents);
}

package com.fuhuadata.dao.supplier;

import com.fuhuadata.dao.mapper.BaseMapper;
import com.fuhuadata.domain.supplier.ProduceFactoryProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProduceFactoryProductMapper extends BaseMapper<ProduceFactoryProduct, Integer> {

    List<ProduceFactoryProduct> listFactoryProducts(@Param("factoryId") Integer factoryId);

    ProduceFactoryProduct getById(@Param("productId") Integer productId);
}
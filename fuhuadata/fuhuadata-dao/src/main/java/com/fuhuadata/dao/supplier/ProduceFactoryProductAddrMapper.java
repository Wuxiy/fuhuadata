package com.fuhuadata.dao.supplier;

import com.fuhuadata.dao.mapper.BaseMapper;
import com.fuhuadata.domain.supplier.ProduceFactoryProductAddr;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProduceFactoryProductAddrMapper extends BaseMapper<ProduceFactoryProductAddr, Integer> {

    List<ProduceFactoryProductAddr> listProductAddrs(@Param("productId") Integer productId);
}
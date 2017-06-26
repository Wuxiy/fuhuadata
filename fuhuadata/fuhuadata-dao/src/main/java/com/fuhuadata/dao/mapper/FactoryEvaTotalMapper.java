package com.fuhuadata.dao.mapper;


import com.fuhuadata.domain.supplier.FactoryEvaTotal;
import org.apache.ibatis.annotations.Param;

public interface FactoryEvaTotalMapper extends BaseMapper<FactoryEvaTotal, Integer> {

    Double getTotalScoreByPkSupplier(@Param("pkSupplier") String pkSupplier);
}
package com.fuhuadata.dao.supplier;

import com.fuhuadata.dao.mapper.BaseMapper;
import com.fuhuadata.domain.supplier.FactoryEvaItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FactoryEvaItemMapper extends BaseMapper<FactoryEvaItem, Integer> {

    List<FactoryEvaItem> listItemAndScoreByOrderId(@Param("orderId") Integer orderId);
}
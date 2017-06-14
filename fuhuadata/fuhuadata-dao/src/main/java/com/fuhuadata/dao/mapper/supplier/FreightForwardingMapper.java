package com.fuhuadata.dao.mapper.supplier;

import com.fuhuadata.dao.mapper.BaseMapper;
import com.fuhuadata.domain.mybatis.supplier.FreightForwarding;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FreightForwardingMapper extends BaseMapper<FreightForwarding,Integer> {

    List<FreightForwarding> getForwardingList();

    List<FreightForwarding> getForwardingListByWarehouseId(@Param("warehouseId") Integer warehouseId);
}
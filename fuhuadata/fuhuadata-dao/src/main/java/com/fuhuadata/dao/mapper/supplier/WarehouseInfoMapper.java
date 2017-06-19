package com.fuhuadata.dao.mapper.supplier;


import com.fuhuadata.dao.mapper.BaseMapper;
import com.fuhuadata.domain.mybatis.supplier.WarehouseInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WarehouseInfoMapper extends BaseMapper<WarehouseInfo,Integer> {
    List<WarehouseInfo> getListByForwardingId(@Param("forwardingId") Integer forwardingId);
}
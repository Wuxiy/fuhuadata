package com.fuhuadata.dao.mapper.supplier;

import com.fuhuadata.dao.mapper.BaseMapper;
import com.fuhuadata.domain.mybatis.supplier.WarehouseScore;

import java.math.BigDecimal;

public interface WarehouseScoreMapper extends BaseMapper<WarehouseScore,Integer> {
    BigDecimal getCombinedScoringByWarehouseId(Integer forwardingId);
}
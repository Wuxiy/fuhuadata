package com.fuhuadata.dao.mapper.supplier;

import com.fuhuadata.dao.mapper.BaseMapper;
import com.fuhuadata.domain.mybatis.supplier.ForwardingScore;

import java.math.BigDecimal;

public interface ForwardingScoreMapper extends BaseMapper<ForwardingScore,Integer> {
    BigDecimal getCombinedScoringByForwardingId(Integer forwardingId);
}
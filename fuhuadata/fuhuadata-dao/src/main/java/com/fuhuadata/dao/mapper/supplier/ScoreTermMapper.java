package com.fuhuadata.dao.mapper.supplier;

import com.fuhuadata.dao.mapper.BaseMapper;
import com.fuhuadata.domain.mybatis.supplier.ScoreTerm;

import java.util.List;

public interface ScoreTermMapper extends BaseMapper<ScoreTerm,Integer> {
    List<ScoreTerm> ScoreItemThree(Integer type);
    List<ScoreTerm> ScoreItemTwo(Integer type);
    List<ScoreTerm> ScoreItemFirst(Integer type);

}
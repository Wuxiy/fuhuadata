package com.fuhuadata.service.impl.mybatis.supplier;

import com.fuhuadata.dao.mapper.supplier.ScoreTermMapper;
import com.fuhuadata.domain.mybatis.supplier.ScoreTerm;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import com.fuhuadata.service.mybatis.supplier.ScoreTermService;

import java.util.List;

/**
 * Created by wuxiy on 2017/6/2.
 */
public class ScoreTermServiceImpl extends BaseServiceImpl<ScoreTerm,Integer> implements ScoreTermService{

    private ScoreTermMapper getScoreTermMapper(){
        return (ScoreTermMapper) baseMapper;
    }

    @Override
    public List<ScoreTerm> evaluationIndexItem(Integer type) {
        return getScoreTermMapper().evaluationIndexItem(type);
    }
}

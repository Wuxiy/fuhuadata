package com.fuhuadata.service.impl.mybatis.supplier;

import com.fuhuadata.domain.mybatis.supplier.ForwardingEvaluationScoreRelation;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import com.fuhuadata.service.mybatis.supplier.ForwardingEvaluationScoreRelationService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by wuxiy on 2017/6/8.
 */
@Service
public class ForwardingEvaluationScoreRelationServiceImpl extends BaseServiceImpl<ForwardingEvaluationScoreRelation,Integer> implements ForwardingEvaluationScoreRelationService {
    @Override
    public List<ForwardingEvaluationScoreRelation> listByScoreId(Integer scoreId) {
        if(scoreId ==null) return null;
        Example example = newExample();
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("forwardingScoreId",scoreId);
        return listByExample(example);
    }

    @Override
    public Integer deleteByScoreId(Integer scoreId) {
        if(scoreId ==null) return null;
        Example example = newExample();
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("forwardingScoreId",scoreId);
        return delete(example);
    }
}

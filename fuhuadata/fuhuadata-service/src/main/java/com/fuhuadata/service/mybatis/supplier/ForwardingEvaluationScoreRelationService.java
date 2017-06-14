package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.domain.mybatis.supplier.ForwardingEvaluationScoreRelation;
import com.fuhuadata.service.mybatis.BaseService;

import java.util.List;

/**
 *  货代评分关联表项
 * Created by wuxiy on 2017/6/8.
 */
public interface ForwardingEvaluationScoreRelationService extends BaseService<ForwardingEvaluationScoreRelation,Integer>{
    /**
     * 根据scoreId 获取评分详情
     * @param scoreId
     * @return
     */
    List<ForwardingEvaluationScoreRelation> listByScoreId(Integer scoreId);

    Integer deleteByScoreId(Integer scoreId);
}

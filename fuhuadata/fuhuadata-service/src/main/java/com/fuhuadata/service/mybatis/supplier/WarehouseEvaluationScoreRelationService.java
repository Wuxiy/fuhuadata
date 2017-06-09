package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.domain.mybatis.supplier.WarehouseEvaluationScoreRelation;
import com.fuhuadata.service.mybatis.BaseService;

import java.util.List;

/**
 *  仓库评分表
 * Created by wuxiy on 2017/6/8.
 */
public interface WarehouseEvaluationScoreRelationService extends BaseService<WarehouseEvaluationScoreRelation,Integer>{
    /**
     * 根据scoreId获取评分详情
     * @param scoreId
     * @return
     */
    List<WarehouseEvaluationScoreRelation> listByScoreId(Integer scoreId);

    /**
     * 根据scoreId删除评分详情
     * @param scoreId
     * @return
     */
    Integer deleteByScoreId(Integer scoreId);


}

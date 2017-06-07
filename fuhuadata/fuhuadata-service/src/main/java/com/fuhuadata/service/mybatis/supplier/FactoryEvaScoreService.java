package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.domain.supplier.FactoryEvaScore;
import com.fuhuadata.service.mybatis.BaseService;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 6/5/2017
 */
public interface FactoryEvaScoreService extends BaseService<FactoryEvaScore, Integer> {

    List<FactoryEvaScore> listByOrderId(Integer orderId);

    int saveOrUpdateScores(List<FactoryEvaScore> scores);

}

package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.domain.mybatis.supplier.ScoreTerm;
import com.fuhuadata.service.mybatis.BaseService;

import java.util.List;

/**
 * Created by wuxiy on 2017/6/2.
 */
public interface ScoreTermService extends BaseService<ScoreTerm, Integer> {

    List<ScoreTerm> evaluationIndexItem(Integer type);
}

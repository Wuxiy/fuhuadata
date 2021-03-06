package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.domain.mybatis.supplier.ForwardingEvaluationScoreRelation;
import com.fuhuadata.domain.mybatis.supplier.ForwardingScore;
import com.fuhuadata.domain.query.QueryForwardingScore;
import com.fuhuadata.service.mybatis.BaseService;
import com.fuhuadata.vo.Supplier.ScoreVO;
import com.github.pagehelper.PageInfo;


/**
 *  货代评分 service
 * Created by wuxiy on 2017/5/23.
 */
public interface ForwardingScoreService extends BaseService<ForwardingScore,Integer>{

    PageInfo<ForwardingScore> getForwardingScoreList(QueryForwardingScore query);

    int saveScore(ScoreVO<ForwardingScore,ForwardingEvaluationScoreRelation> scoreVO,String year,String month);
}

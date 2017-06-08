package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.domain.mybatis.supplier.ScoreTerm;
import com.fuhuadata.service.mybatis.BaseService;
import com.fuhuadata.vo.Supplier.ScoreTermsVO;

import java.util.List;

/**
 *  评分项
 * Created by wuxiy on 2017/6/2.
 */
public interface ScoreTermService extends BaseService<ScoreTerm, Integer> {

    /**
     * 获取评分项和评分值
     * @param type
     * @return
     */
    List<ScoreTermsVO> evaluationIndexItem(Integer type);
}

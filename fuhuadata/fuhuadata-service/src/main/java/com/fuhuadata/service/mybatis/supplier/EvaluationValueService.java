package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.domain.mybatis.supplier.EvaluationValue;
import com.fuhuadata.service.mybatis.BaseService;

import java.util.List;

/**
 *  评分项数值
 * Created by wuxiy on 2017/6/8.
 */
public interface EvaluationValueService extends BaseService<EvaluationValue,Integer> {

    /**
     * 根据type评分分值项汇总
     * @param type
     * @return
     */
    List<EvaluationValue> ListEvaluetionValueByType(Integer type);

}

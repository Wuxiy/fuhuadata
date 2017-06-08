package com.fuhuadata.service.impl.mybatis.supplier;

import com.fuhuadata.domain.mybatis.supplier.EvaluationValue;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import com.fuhuadata.service.mybatis.supplier.EvaluationValueService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by wuxiy on 2017/6/8.
 */
@Service
public class EvaluationValueServiceImpl extends BaseServiceImpl<EvaluationValue,Integer> implements EvaluationValueService {
    @Override
    public List<EvaluationValue> ListEvaluetionValueByType(Integer type) {
        if(type==null) return null;
        Example example = newExample();
        Example.Criteria criteria = example.createCriteria();
        if(type!=null){
            criteria.andEqualTo("type",type);
        }
        List<EvaluationValue> list = listByExample(example);
        return list;
    }
}

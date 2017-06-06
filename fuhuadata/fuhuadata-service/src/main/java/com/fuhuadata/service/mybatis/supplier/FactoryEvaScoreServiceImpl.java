package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.domain.supplier.FactoryEvaScore;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Collections;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 6/5/2017
 */
@Service
public class FactoryEvaScoreServiceImpl extends BaseServiceImpl<FactoryEvaScore, Integer>
        implements FactoryEvaScoreService {

    @Override
    public List<FactoryEvaScore> listByOrderId(Integer orderId) {

        if (null == orderId) {
            return Collections.emptyList();
        }

        Example example = newExample();
        example.createCriteria().andEqualTo("orderId", orderId);

        return listByExample(example);
    }

    @Override
    public int saveOrUpdateScores(List<FactoryEvaScore> scores) {

        if (CollectionUtils.isEmpty(scores)) {
            return 0;
        }

        scores.forEach(this::saveOrUpdateSelective);
        return scores.size();
    }
}

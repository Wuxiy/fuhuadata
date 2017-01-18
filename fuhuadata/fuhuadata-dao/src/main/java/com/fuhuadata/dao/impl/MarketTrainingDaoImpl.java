package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.MarketTrainingDao;
import com.fuhuadata.domain.MarketTraining;
import com.fuhuadata.domain.query.MarketTrainingQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by intanswer on 2017/1/12.
 */
public class MarketTrainingDaoImpl extends SqlMapClientTemplate implements MarketTrainingDao {
    public static final String ADD="MARKETTRAINING.ADD";
    public static final String GET_PAGE="MARKETTRAINING.GET-PAGE";
    public static final String COUNT="MARKETTRAINING.COUNT";

    @Override
    public MarketTraining addMartketTraining(MarketTraining marketTraining) {
        marketTraining.setTranId((Integer)this.insert(ADD,marketTraining));
        return marketTraining;
    }

    @Override
    public List<MarketTraining> getMarketTrainingsByPage(MarketTrainingQuery marketTrainingQuery) {
        return this.queryForList(GET_PAGE,marketTrainingQuery);
    }

    @Override
    public int count(MarketTrainingQuery marketTrainingQuery) {
        return ((Integer)this.queryForObject(COUNT,marketTrainingQuery)).intValue();
    }
}

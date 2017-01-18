package com.fuhuadata.dao;

import com.fuhuadata.domain.MarketTraining;
import com.fuhuadata.domain.query.MarketTrainingQuery;

import java.util.List;

/**
 * 营销培训dao
 * Created by intanswer on 2017/1/12.
 */
public interface MarketTrainingDao {

    public MarketTraining addMartketTraining(MarketTraining marketTraining);

    public List<MarketTraining> getMarketTrainingsByPage(MarketTrainingQuery marketTrainingQuery);

    public int count(MarketTrainingQuery marketTrainingQuery);
}

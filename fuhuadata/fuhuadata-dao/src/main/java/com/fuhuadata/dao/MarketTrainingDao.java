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

    public int updateMarketTrainingById(int id,MarketTraining marketTraining);

    public int deleteMarketTrainingById(int id);

    public MarketTraining getMarketTrainingById(int id);

    public List<MarketTraining> getAllMarketTrainings();

    public List<MarketTraining> getMarketTrainingsByPage(MarketTrainingQuery marketTrainingQuery);

    public List<MarketTraining> getMarketTrainingsByQuery(MarketTrainingQuery marketTrainingQuery);

    public int count(MarketTrainingQuery marketTrainingQuery);
}

package com.fuhuadata.service;

import com.fuhuadata.domain.MarketTraining;
import com.fuhuadata.domain.query.MarketTrainingQuery;
import com.fuhuadata.domain.query.Result;

import java.util.List;

/**
 * Created by intanswer on 2017/1/12.
 */
public interface MarketTrainingService {

    public Result<MarketTraining> addMarketTraining(MarketTraining marketTraining);

    public Result updateMarketTrainingById(int id,MarketTraining marketTraining);

    public Result deleteMarketTrainingById(int id);

    public Result getMarketTrainingById(int id);

    public Result<List<MarketTraining>> getAllMarketTrainings(MarketTrainingQuery marketTrainingQuery);

    public Result<List<MarketTraining>> getMarketTrainingsByPage(MarketTrainingQuery marketTrainingQuery);

    public Result<List<MarketTraining>> getMarketTrainingsByQuery(MarketTrainingQuery marketTrainingQuery);

    public Result<Integer> count(MarketTrainingQuery marketTrainingQuery);

}

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

    public Result<List<MarketTraining>> getMarketTrainingsByPage(MarketTrainingQuery marketTrainingQuery);

    public Result<Integer> count(MarketTrainingQuery marketTrainingQuery);

}

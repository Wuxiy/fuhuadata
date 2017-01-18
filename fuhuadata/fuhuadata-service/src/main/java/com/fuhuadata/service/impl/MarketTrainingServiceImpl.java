package com.fuhuadata.service.impl;

import com.fuhuadata.domain.MarketTraining;
import com.fuhuadata.domain.query.MarketTrainingQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.MarketTrainingManager;
import com.fuhuadata.service.MarketTrainingService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * Created by intanswer on 2017/1/12.
 */
public class MarketTrainingServiceImpl implements MarketTrainingService{
    private final static Log log= LogFactory.getLog(MarketTrainingServiceImpl.class);
    private MarketTrainingManager marketTrainingManager;

    @Override
    public Result<MarketTraining> addMarketTraining(MarketTraining marketTraining) {
        Result<MarketTraining> result = new Result<MarketTraining>();
        try {
            result.addDefaultModel(marketTrainingManager.addMarketTraining(marketTraining));
        } catch (Exception e) {
            result.setSuccess(false);
            log.error("添加营销培训信息失败",e);
        }
        return result;
    }

    @Override
    public Result<List<MarketTraining>> getMarketTrainingsByPage(MarketTrainingQuery marketTrainingQuery) {
        Result<List<MarketTraining>> result = new Result<List<MarketTraining>>();
        try {
         result=marketTrainingManager.getMarketTrainingsByPage(marketTrainingQuery);
        } catch (Exception e) {
            result.setSuccess(false);
            log.error("分页获取营销培训信息失败",e);
        }
        return result;
    }

    @Override
    public Result<Integer> count(MarketTrainingQuery marketTrainingQuery) {
        Result<Integer> result = new Result<Integer>();
        try {
            result.addDefaultModel(marketTrainingManager.count(marketTrainingQuery));
        } catch (Exception e) {
            result.setSuccess(false);
            log.error("查询营销培训数量失败",e);
        }
        return result;
    }
}

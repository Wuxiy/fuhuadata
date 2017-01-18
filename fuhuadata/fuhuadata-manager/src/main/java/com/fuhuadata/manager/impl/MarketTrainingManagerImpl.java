package com.fuhuadata.manager.impl;

import com.fuhuadata.dao.MarketTrainingDao;
import com.fuhuadata.domain.MarketTraining;
import com.fuhuadata.domain.query.MarketTrainingQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.MarketTrainingManager;

import java.util.List;

/**
 * Created by intanswer on 2017/1/12.
 */
public class MarketTrainingManagerImpl implements MarketTrainingManager {
    private MarketTrainingDao marketTrainingDao;
    @Override
    public MarketTraining addMarketTraining(MarketTraining marketTraining) {
        return marketTrainingDao.addMartketTraining(marketTraining);
    }

    @Override
    public Result<List<MarketTraining>> getMarketTrainingsByPage(MarketTrainingQuery marketTrainingQuery) {
        //事物操作封装返回结果
        Result<List<MarketTraining>> result = new Result<List<MarketTraining>>();
        int totalItem = marketTrainingDao.count(marketTrainingQuery);
        marketTrainingQuery.setTotalItem(totalItem);
        if(totalItem > 0){
            result.addDefaultModel("MarketTrainings",marketTrainingDao.getMarketTrainingsByPage(marketTrainingQuery));
        }else{
            //设置每页大小
            result.setPageSize(marketTrainingQuery.getPageSize());
            //设置当前页
            result.setIndex(marketTrainingQuery.getIndex());
            //设置总记录条数
            result.setTotalItem(totalItem);
        }
        return result;
    }

    @Override
    public int count(MarketTrainingQuery marketTrainingQuery) {
        return marketTrainingDao.count(marketTrainingQuery);
    }

    public MarketTrainingDao getMarketTrainingDao(){
        return this.marketTrainingDao;
    }
    public void setMarketTrainingDao(MarketTrainingDao marketTrainingDao){
        this.marketTrainingDao=marketTrainingDao;
    }
}
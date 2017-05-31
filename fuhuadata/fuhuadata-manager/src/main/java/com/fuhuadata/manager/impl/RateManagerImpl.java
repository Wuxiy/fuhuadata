package com.fuhuadata.manager.impl;

import com.fuhuadata.dao.RateDao;
import com.fuhuadata.domain.Rate;
import com.fuhuadata.domain.query.RateQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.RateManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 费率ManagerImpl
 * Created by young on 2017/2/9.
 */
public class RateManagerImpl implements RateManager{
    private RateDao rateDao;
    @Override
    public Rate addRate(Rate rate) {
        return rateDao.addRate(rate);
    }

    @Override
    public Rate getRateById(int id) {
        return rateDao.getRateById(id);
    }

    @Override
    public boolean updateRateById(int id, Rate rate) {
        return rateDao.updateRateById(id,rate) == 1 ? true:false;
    }

    @Override
    public boolean deleteRateById(int id) {
        return rateDao.deleteRateById(id) == 1 ? true : false;
    }

    @Override
    public List<Rate> getAllRate() {
        return null;
    }

    @Override
    public List<Rate> getRateByQuery(RateQuery rateQuery) {
        return rateDao.getRateByQuery(rateQuery);
    }

    @Override
    public Result<List<Rate>> getRatesByPage(RateQuery rateQuery) {
        Result<List<Rate>> result = new Result<List<Rate>>();
        int totalItem = rateDao.count(rateQuery);
        rateQuery.setTotalItem(totalItem);
        if(totalItem>0){
            result.addDefaultModel("Rates",rateDao.getRatesByPage(rateQuery));
        }else{
            result.addDefaultModel("Rates",new ArrayList<Rate>());
        }
        result.setPageSize(rateQuery.getPageSize());
        result.setIndex(rateQuery.getIndex());
        result.setTotalItem(totalItem);
        return result;
    }

    @Override
    public int count(RateQuery rateQuery) {
        return rateDao.count(rateQuery);
    }

    public RateDao getRateDao(){
        return this.rateDao;
    }
    public void setRateDao(RateDao rateDao) {
        this.rateDao = rateDao;
    }
}

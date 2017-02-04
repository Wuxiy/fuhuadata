package com.fuhuadata.manager.impl;

import com.fuhuadata.dao.FreightCostDao;
import com.fuhuadata.domain.FreightCost;
import com.fuhuadata.domain.query.FreightCostQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.FreightCostManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 运费成本Manager
 * Created by intanswer on 2017/1/18.
 */
public class FreightCostManagerImpl implements FreightCostManager{
    private FreightCostDao freightCostDao;
    @Override
    public FreightCost addFreightCost(FreightCost freightCost) {
        return freightCostDao.addFreightCost(freightCost);
    }

    @Override
    public boolean updateFreightCostById(int id, FreightCost freightCost) {
        return freightCostDao.updateFreightCostById(id,freightCost)==1 ? true: false;
    }

    @Override
    public boolean deleteFreightCostById(int id) {
        return freightCostDao.deleteFreightCostById(id) == 1 ? true:false;
    }

    @Override
    public Result<List<FreightCost>> getFreightCostsByPage(FreightCostQuery freightCostQuery) {
        Result<List<FreightCost>> result = new Result<List<FreightCost>>();
        int totalItem = freightCostDao.count(freightCostQuery);
        freightCostQuery.setTotalItem(totalItem);
        if (totalItem > 0) {
            result.addDefaultModel("FreightCosts", freightCostDao.getFreightCostsByPage(freightCostQuery));
        } else {
            result.addDefaultModel("FreightCosts", new ArrayList<FreightCost>());
        }

        result.setPageSize(freightCostQuery.getPageSize());
        result.setIndex(freightCostQuery.getIndex());
        result.setTotalItem(totalItem);
        return result;
    }

    @Override
    public int count(FreightCostQuery freightCostQuery) {
        return freightCostDao.count(freightCostQuery);
    }

    public FreightCostDao getFreightCostDao(){
        return freightCostDao;
    }

    public void setFreightCostDao(FreightCostDao freightCostDao) {
        this.freightCostDao = freightCostDao;
    }
}

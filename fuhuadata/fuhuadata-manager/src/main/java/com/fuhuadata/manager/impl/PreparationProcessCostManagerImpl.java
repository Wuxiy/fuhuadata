package com.fuhuadata.manager.impl;

import com.fuhuadata.dao.PreparationProcessCostDao;
import com.fuhuadata.domain.PreparationProcessCost;
import com.fuhuadata.domain.query.PreparationProcessCostQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.PreparationProcessCostManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 制剂加工成本manager
 * Created by intanswer on 2017/1/18.
 */
public class PreparationProcessCostManagerImpl implements PreparationProcessCostManager {
    private PreparationProcessCostDao preparationProcessCostDao;
    @Override
    public PreparationProcessCost addPreparationProcessCost(PreparationProcessCost preparationProcessCost) {
        return preparationProcessCostDao.addComponentCost(preparationProcessCost);
    }

    @Override
    public boolean updatePreparationProcessCostById(int id, PreparationProcessCost preparationProcessCost) {
        return preparationProcessCostDao.updatePreparationProcessCostById(id,preparationProcessCost) == 1 ? true:false;
    }

    @Override
    public boolean deletePreparationProcessCostByid(int id) {
        return preparationProcessCostDao.deleteComponentCostById(id) == 1 ? true : false;
    }

    @Override
    public Result<List<PreparationProcessCost>> getPreparationProcessCostsByPage(PreparationProcessCostQuery preparationProcessCostQuery) {
        Result<List<PreparationProcessCost>> result = new Result<List<PreparationProcessCost>>();
        int totalItem = preparationProcessCostDao.count(preparationProcessCostQuery);
        preparationProcessCostQuery.setTotalItem(totalItem);
        if(totalItem>0){
            result.addDefaultModel("PreparationProcessCosts",preparationProcessCostDao.getPreparationProcessCostsByPage(preparationProcessCostQuery));
        }else{
            result.addDefaultModel("PreparationProcessCosts",new ArrayList<PreparationProcessCost>());
        }
        result.setPageSize(preparationProcessCostQuery.getPageSize());
        result.setIndex(preparationProcessCostQuery.getIndex());
        result.setTotalItem(totalItem);
        return result;
    }

    @Override
    public int count(PreparationProcessCostQuery preparationProcessCostQuery) {
        return preparationProcessCostDao.count(preparationProcessCostQuery);
    }

    public PreparationProcessCostDao getPreparationProcessCostDao(){
        return this.preparationProcessCostDao;
    }
    public void setPreparationProcessCostDao(PreparationProcessCostDao preparationProcessCostDao) {
        this.preparationProcessCostDao = preparationProcessCostDao;
    }
}

package com.fuhuadata.manager.impl;

import com.fuhuadata.dao.IndustryDataDao;
import com.fuhuadata.domain.IndustryData;
import com.fuhuadata.domain.query.IndustryDataQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.IndustryDataManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by intanswer on 2017/1/23.
 */
public class IndustryDataManagerImpl implements IndustryDataManager {
    private IndustryDataDao industryDataDao;
    @Override
    public IndustryData addIndustryData(IndustryData industryData) {
        return industryDataDao.addIndustryData(industryData);
    }

    @Override
    public Result<List<IndustryData>> getIndustryDatasByPage(IndustryDataQuery industryDataQuery) {
        Result<List<IndustryData>> result = new Result<List<IndustryData>>();
        int totalItem = industryDataDao.count(industryDataQuery);
        industryDataQuery.setTotalItem(totalItem);
        if(totalItem > 0){
            result.addDefaultModel("IndustryDatas",industryDataDao.getIndustryDatasByPage(industryDataQuery));
        }else{
            result.addDefaultModel("IndustryDatas",new ArrayList<IndustryData>());
        }
        result.setPageSize(industryDataQuery.getPageSize());
        result.setIndex(industryDataQuery.getIndex());
        result.setTotalItem(totalItem);
         return result;
    }

    @Override
    public int count(IndustryDataQuery industryDataQuery) {
        return industryDataDao.count(industryDataQuery);
    }

    public IndustryDataDao getIndustryDataDao() {
        return industryDataDao;
    }

    public void setIndustryDataDao(IndustryDataDao industryDataDao) {
        this.industryDataDao = industryDataDao;
    }
}

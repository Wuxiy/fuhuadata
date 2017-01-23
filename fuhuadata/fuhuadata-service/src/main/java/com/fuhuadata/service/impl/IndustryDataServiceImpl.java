package com.fuhuadata.service.impl;

import com.fuhuadata.domain.IndustryData;
import com.fuhuadata.domain.query.IndustryDataQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.IndustryDataManager;
import com.fuhuadata.service.IndustryDataService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * 行业数据Service
 * Created by intanswer on 2017/1/23.
 */
public class IndustryDataServiceImpl implements IndustryDataService{
    private final static Log log= LogFactory.getLog(IndustryDataServiceImpl.class);
    private IndustryDataManager industryDataManager;

    @Override
    public Result<IndustryData> addIndustryData(IndustryData industryData) {
        Result<IndustryData> result = new Result<IndustryData>();
        try{
            result.addDefaultModel(industryDataManager.addIndustryData(industryData));

        }catch(Exception e){
            result.setSuccess(false);
            log.error("添加行业数据失败",e);
        }
        return result;
    }

    @Override
    public Result<List<IndustryData>> getIndustryDatasByPage(IndustryDataQuery industryDataQuery) {
        Result<List<IndustryData>> result = new Result<List<IndustryData>>();
        try{
            result=industryDataManager.getIndustryDatasByPage(industryDataQuery);

        }catch(Exception e){
            result.setSuccess(false);
            log.error("分页查询行业数据信息失败",e);
        }
        return result;
    }

    @Override
    public Result<Integer> count(IndustryDataQuery industryDataQuery) {
        Result<Integer> result = new Result<Integer>();
        try {
            result.addDefaultModel(industryDataManager.count(industryDataQuery));
        } catch (Exception e) {
            result.setSuccess(false);
            // 打印日志
            log.error("查询行业数据数量失败",e);
        }
        return result;
    }

    public IndustryDataManager getIndustryDataManager() {
        return industryDataManager;
    }

    public void setIndustryDataManager(IndustryDataManager industryDataManager) {
        this.industryDataManager = industryDataManager;
    }
}

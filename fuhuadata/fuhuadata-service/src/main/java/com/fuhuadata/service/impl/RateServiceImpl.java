package com.fuhuadata.service.impl;

import com.fuhuadata.domain.Rate;
import com.fuhuadata.domain.query.RateQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.RateManager;
import com.fuhuadata.service.RateService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * 费率ServiceImpl
 * Created by young on 2017/2/9.
 */
public class RateServiceImpl implements RateService{

    private static final Log log= LogFactory.getLog(RateServiceImpl.class);
    private RateManager rateManager;
    @Override
    public Result<Rate> addRate(Rate rate) {
        Result<Rate> result = new Result<Rate>();
        try{
            result.addDefaultModel(rateManager.addRate(rate));
        }catch (Exception e){
            result.setSuccess(false);
            //打印日志
            log.error("添加制剂加工成本信息错误",e);
        }
        return result;
    }

    @Override
    public Result updateRate(int id, Rate rate) {
        Result result = new Result();
        try{
            result.setSuccess(rateManager.updateRateById(id,rate));
        }catch (Exception e){
            result.setSuccess(false);
            //打印日志
            log.error("更新制剂加工成本信息错误",e);
        }
        return result;
    }

    @Override
    public Result deleteRate(int id) {
        Result result = new Result();
        try{
            result.setSuccess(rateManager.deleteRateById(id));
        }catch (Exception e){
            result.setSuccess(false);
            //打印日志
            log.error("删除制剂加工成本信息错误",e);
        }
        return result;
    }

    @Override
    public Result<List<Rate>> getRatesByPage(RateQuery rateQuery) {
        Result<List<Rate>> result = new Result<List<Rate>>();
        try{
            result= rateManager.getRatesByPage(rateQuery);
        }catch (Exception e){
            result.setSuccess(false);
            //打印日志
            log.error("分页获取制剂加工成本信息错误",e);
        }
        return result;
    }

    @Override
    public Result<Integer> count(RateQuery rateQuery) {
        Result<Integer> result = new Result<Integer>();
        try{
            result.addDefaultModel(rateManager.count(rateQuery));
        }catch (Exception e){
            result.setSuccess(false);
            //打印日志
            log.error("查询制剂加工成本数量错误",e);
        }
        return result;
    }


    public void setRateManager(RateManager rateManager) {
        this.rateManager = rateManager;
    }

    public RateManager getRateManager(){
        return rateManager;
    }

}

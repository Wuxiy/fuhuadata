package com.fuhuadata.service.impl;

import com.fuhuadata.domain.FreightCost;
import com.fuhuadata.domain.query.FreightCostQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.FreightCostManager;
import com.fuhuadata.service.FreightCostService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * Created by intanswer on 2017/1/18.
 */
public class FreightCostServiceImpl implements FreightCostService{
    private static final Log log= LogFactory.getLog(FreightCostServiceImpl.class);
    private FreightCostManager freightCostManager;
    @Override
    public Result<FreightCost> addFreightCost(FreightCost freightCost) {
        Result<FreightCost> result = new Result<FreightCost>();
        try{
            result.addDefaultModel(freightCostManager.addFreightCost(freightCost));
        }catch (Exception e){
            result.setSuccess(false);
            //打印日志
            log.error("添加运费成本错误",e);
        }
        return result;
    }

    @Override
    public Result updateFreightCostById(int id, FreightCost freightCost) {
        Result result = new Result();
        try{
            result.setSuccess(freightCostManager.updateFreightCostById(id,freightCost));
        }catch (Exception e){
            result.setSuccess(false);
            //打印日志
            log.error("修改运费成本错误",e);
        }
        return result;
    }

    @Override
    public Result deleteFreightCostById(int id) {
        Result result = new Result();
        try{
            result.setSuccess(freightCostManager.deleteFreightCostById(id));
        }catch (Exception e){
            result.setSuccess(false);
            //打印日志
            log.error("删除运费成本错误",e);
        }
        return result;
    }

    @Override
    public Result<List<FreightCost>> getFreightCostsByPage(FreightCostQuery freightCostQuery) {
        Result<List<FreightCost>> result = new Result<List<FreightCost>>();
        try{
            result=freightCostManager.getFreightCostsByPage(freightCostQuery);
        }catch (Exception e){
            result.setSuccess(false);
            //打印日志
            log.error("分页获取运费成本错误",e);
        }
        return result;
    }

    @Override
    public Result<List<FreightCost>> getFreightCostsByQuery(FreightCostQuery freightCostQuery) {
        Result<List<FreightCost>> result = new Result<List<FreightCost>>();
        try{
            result.addDefaultModel("FreightCosts",freightCostManager.getFreightCostsByQuery(freightCostQuery));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("查询运费成本信息错误",e);
        }
        return result;
    }

    @Override
    public Result<Integer> count(FreightCostQuery freightCostQuery) {
        Result<Integer> result = new Result<Integer>();
        try{
            result.addDefaultModel(freightCostManager.count(freightCostQuery));
        }catch (Exception e){
            result.setSuccess(false);
            //打印日志
            log.error("查询运费成本数量错误",e);
        }
        return result;
    }


    public void setFreightCostManager(FreightCostManager freightCostManager) {
        this.freightCostManager = freightCostManager;
    }

    public FreightCostManager getFreightCostManager(){
        return freightCostManager;
    }
}

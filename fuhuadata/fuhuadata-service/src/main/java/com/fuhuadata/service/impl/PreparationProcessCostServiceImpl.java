package com.fuhuadata.service.impl;

import com.fuhuadata.domain.PreparationProcessCost;
import com.fuhuadata.domain.query.PreparationProcessCostQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.PreparationProcessCostManager;
import com.fuhuadata.service.PreparationProcessCostService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * Created by intanswer on 2017/1/18.
 */
public class PreparationProcessCostServiceImpl implements PreparationProcessCostService {
    private static final Log log= LogFactory.getLog(PreparationProcessCostServiceImpl.class);
    private PreparationProcessCostManager preparationProcessCostManager;
    @Override
    public Result<PreparationProcessCost> addPreparationProcessCost(PreparationProcessCost preparationProcessCost) {
        Result<PreparationProcessCost> result = new Result<PreparationProcessCost>();
        try{
            result.addDefaultModel(preparationProcessCostManager.addPreparationProcessCost(preparationProcessCost));
        }catch (Exception e){
            result.setSuccess(false);
            //打印日志
            log.error("添加制剂加工成本信息错误",e);
        }
        return result;
    }

    @Override
    public Result updatePreparationProcessCost(int id, PreparationProcessCost preparationProcessCost) {
        Result result = new Result();
        try{
            result.setSuccess(preparationProcessCostManager.updatePreparationProcessCostById(id,preparationProcessCost));
        }catch (Exception e){
            result.setSuccess(false);
            //打印日志
            log.error("更新制剂加工成本信息错误",e);
        }
        return result;
    }

    @Override
    public Result deletePreparationProcessCost(int id) {
        Result result = new Result();
        try{
            result.setSuccess(preparationProcessCostManager.deletePreparationProcessCostByid(id));
        }catch (Exception e){
            result.setSuccess(false);
            //打印日志
            log.error("删除制剂加工成本信息错误",e);
        }
        return result;
    }

    @Override
    public Result<PreparationProcessCost> getPreparationProcessCostById(int id) {
        Result<PreparationProcessCost> result = new Result<PreparationProcessCost>();
        try {
            PreparationProcessCost preparationProcessCost = preparationProcessCostManager.getPreparationProcessCostById(id);
            if(preparationProcessCost == null){
                result.setSimpleErrorMsg(0, "当前制剂加工成本信息不存在，请重试");
            }else{
                result.addDefaultModel("PreparationProcessCosts", preparationProcessCost);
            }
        } catch (Exception e) {
            result.setSuccess(false);
            // 打印日志
            log.error("根据id获取制剂加工成本信息错误",e);
        }
        return result;
    }

    @Override
    public Result<List<PreparationProcessCost>> getPreparationProcessCostByQuery(PreparationProcessCostQuery preparationProcessCostQuery) {
        Result<List<PreparationProcessCost>> result = new Result<List<PreparationProcessCost>>();
        try {
            result.addDefaultModel("PreparationProcessCosts", preparationProcessCostManager.getPreparationProcessCostByQuery(preparationProcessCostQuery));
        } catch (Exception e) {
            result.setSuccess(false);
            // 打印日志
            log.error("查询制剂加工成本信息错误",e);
        }
        return result;
    }

    @Override
    public Result<List<PreparationProcessCost>> getPreparationProcessCostsByPage(PreparationProcessCostQuery preparationProcessCostQuery) {
        Result<List<PreparationProcessCost>> result = new Result<List<PreparationProcessCost>>();
        try{
            result= preparationProcessCostManager.getPreparationProcessCostsByPage(preparationProcessCostQuery);
        }catch (Exception e){
            result.setSuccess(false);
            //打印日志
            log.error("分页获取制剂加工成本信息错误",e);
        }
        return result;
    }

    @Override
    public Result<Integer> count(PreparationProcessCostQuery preparationProcessCostQuery) {
        Result<Integer> result = new Result<Integer>();
        try{
            result.addDefaultModel(preparationProcessCostManager.count(preparationProcessCostQuery));
        }catch (Exception e){
            result.setSuccess(false);
            //打印日志
            log.error("查询制剂加工成本数量错误",e);
        }
        return result;
    }


    public void setPreparationProcessCostManager(PreparationProcessCostManager preparationProcessCostManager) {
        this.preparationProcessCostManager = preparationProcessCostManager;
    }

    public PreparationProcessCostManager getPreparationProcessCostManager(){
        return preparationProcessCostManager;
    }
}

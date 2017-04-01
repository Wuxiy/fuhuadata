package com.fuhuadata.service.impl;

import com.fuhuadata.domain.ComponentCost;
import com.fuhuadata.domain.KProductComponent;
import com.fuhuadata.domain.query.ComponentCostQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.ComponentCostManager;
import com.fuhuadata.service.ComponentCostService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * Created by intanswer on 2017/1/18.
 */
public class ComponentCostServiceImpl implements ComponentCostService {
    private static final Log log= LogFactory.getLog(ComponentCostServiceImpl.class);
    private ComponentCostManager componentCostManager;

    @Override
    public Result<ComponentCost> addComponentCost(ComponentCost componentCost, List<KProductComponent> KProductComponents) {
        Result<ComponentCost> result = new Result<ComponentCost>();
        try{
            result.addDefaultModel(componentCostManager.addComponentCost(componentCost, KProductComponents));
        }catch (Exception e){
            result.setSuccess(false);
            //打印日志
            log.error("添加成分价格信息错误",e);
        }
        return result;
    }

    @Override
    public Result updateComponentCostById(ComponentCost componentCost,List<KProductComponent> KProductComponents) {
        Result result = new Result();
        try{
            result.setSuccess(componentCostManager.updateComponentCostById(componentCost, KProductComponents));
        }catch (Exception e){
            result.setSuccess(false);
            //打印日志
            log.error("更新成分价格信息错误",e);
        }
        return result;
    }

    @Override
    public Result deleteComponentCostById(int id) {
        Result result = new Result();
        try{
            result.setSuccess(componentCostManager.deleteComponentCostById(id));
        }catch (Exception e){
            result.setSuccess(false);
            //打印日志
            log.error("删除成分价格信息错误",e);
        }
        return result;
    }

    @Override
    public Result<ComponentCost> getComponentCostById(int id,int productCategoryId) {
        Result<ComponentCost> result = new Result<ComponentCost>();
        try {
            ComponentCost componentCost = componentCostManager.getComponentCostById(id,productCategoryId);
            if( componentCost== null){
                result.setSimpleErrorMsg(0, "当前成分价格数据不存在，请重试");
            }else{
                result.addDefaultModel("componentCosts", componentCost);
            }
        } catch (Exception e) {
            result.setSuccess(false);
            // 打印日志
            log.error("根据id获取成分价格信息错误",e);
        }
        return result;
    }

    @Override
    public Result<List<ComponentCost>> getComponentCostByQuery(ComponentCostQuery componentCostQuery) {
        Result<List<ComponentCost>> result = new Result<List<ComponentCost>>();
        try {
            result.addDefaultModel("ComponentCosts", componentCostManager.getComponentCostByQuery(componentCostQuery));
        } catch (Exception e) {
            result.setSuccess(false);
            // 打印日志
            log.error("查询成分价格信息错误",e);
        }
        return result;
    }

    @Override
    public Result<List<ComponentCost>> getComponentCostsByPage(ComponentCostQuery componentCostQuery) {
        Result<List<ComponentCost>> result = new Result<List<ComponentCost>>();
        try{
            result= componentCostManager.getComponentCostsByPage(componentCostQuery);
        }catch (Exception e){
            result.setSuccess(false);
            //打印日志
            log.error("分页获取成分价格信息错误",e);
        }
        return result;
    }

    @Override
    public Result<Integer> count(ComponentCostQuery componentCostQuery) {
        Result<Integer> result = new Result<Integer>();
        try{
            result.addDefaultModel(componentCostManager.count(componentCostQuery));
        }catch (Exception e){
            result.setSuccess(false);
            //打印日志
            log.error("查询成分价格数量错误",e);
        }
        return result;
    }


    public void setComponentCostManager(ComponentCostManager componentCostManager) {
        this.componentCostManager = componentCostManager;
    }

    public ComponentCostManager getComponentCostManager(){
        return componentCostManager;
    }
}

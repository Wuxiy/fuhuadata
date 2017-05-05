package com.fuhuadata.service.impl;

import com.fuhuadata.domain.ComponentCost;
import com.fuhuadata.domain.KProductComponent;
import com.fuhuadata.domain.query.ComponentCostQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.ComponentCostManager;
import com.fuhuadata.service.ComponentCostService;
import com.fuhuadata.vo.ComponentCostDO;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by intanswer on 2017/1/18.
 */
public class ComponentCostServiceImpl implements ComponentCostService {
    private static final Log log= LogFactory.getLog(ComponentCostServiceImpl.class);
    private ComponentCostManager componentCostManager;

    @Override
    public Result<ComponentCost> addComponentCost(ComponentCost componentCost, List<KProductComponent> KProductComponents) {
        Result<ComponentCost> result = new Result<ComponentCost>();
        //新增成分判断当前是否存在同名成分
        if(componentCostManager.getComponentCostByComponentName(componentCost.getComponentName())!=null) {
            result.setMessage("该成分已存在");
            result.setSuccess(true);
            return result;
        } else
               try {
                result.addDefaultModel(componentCostManager.addComponentCost(componentCost, KProductComponents));
            } catch (Exception e) {
                result.setSuccess(false);
                //打印日志
                log.error("添加成分价格信息错误", e);
            }
            result.setMessage("添加成功");
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

    @Transactional
    @Override
    public boolean deleteComponentCostByIds(List<Integer> costIds) {
        return componentCostManager.deleteComponentCostByIds(costIds);
    }

    @Override
    public boolean deleteCostByProductIds(List<Integer> componentIds) {
        for (Integer componentId : componentIds) {
            // 如果成分关联的产品为空，则删除该成分
            ComponentCostDO componentCostDO = componentCostManager.getComponentCostById(componentId);
            List<KProductComponent> kProductComponents = componentCostDO.getkProductComponents();
            if (null == kProductComponents || kProductComponents.size() == 0) {
                deleteComponentCostById(componentId);
            }
        }
        return true;
    }

    @Override
    public boolean deleteCompoentCost(List<ComponentCost> costs) {
        if (null == costs) {
            return false;
        }

        List<Integer> componentIds = Lists.newArrayList();
        Set<Integer> costIds = Sets.newHashSet();

        for (ComponentCost componentCost : costs) {
            costIds.add(componentCost.getComponentId());// 成分关联产品主键id
            componentIds.add(componentCost.getCostId());// 成分id
        }

        deleteComponentCostByIds(componentIds);
        deleteCostByProductIds(Lists.newArrayList(costIds));
        return true;
    }

    @Override
    public Result<ComponentCostDO> getComponentCostById(int id) {
        Result<ComponentCostDO> result = new Result<ComponentCostDO>();
        try {
            ComponentCostDO componentCostDO = componentCostManager.getComponentCostById(id);
            if( componentCostDO== null){
                result.setSimpleErrorMsg(0, "当前成分价格数据不存在，请重试");
            }else{
                result.addDefaultModel("componentCosts",componentCostDO);
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

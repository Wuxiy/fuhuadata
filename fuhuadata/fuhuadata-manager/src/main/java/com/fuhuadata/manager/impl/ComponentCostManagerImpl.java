package com.fuhuadata.manager.impl;

import com.fuhuadata.dao.ComponentCostDao;
import com.fuhuadata.domain.ComponentCost;
import com.fuhuadata.domain.KProductComponent;
import com.fuhuadata.domain.query.ComponentCostQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.ComponentCostManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 成分价格Manager
 * Created by intanswer on 2017/1/18.
 */
public class ComponentCostManagerImpl implements ComponentCostManager {
    private ComponentCostDao componentCostDao;
    @Override
    @Transactional
    public ComponentCost addComponentCost(ComponentCost componentCost, List<KProductComponent> KProductComponents) {
       ComponentCost addComponentCost = componentCostDao.addComponentCost(componentCost);
       for(int i = 0;i<KProductComponents.size();i++) {
           System.out.println(KProductComponents.get(i).getCategoryFullName());
           KProductComponents.get(i).setComponentId(componentCost.getComponentId());
       }
        componentCostDao.addSuitableProduct(KProductComponents);
        return addComponentCost;
    }

    @Override
    @Transactional
    public boolean updateComponentCostById(ComponentCost componentCost,List<KProductComponent> KProductComponents) {
        boolean flag = false;
        componentCostDao.deleteProductComponentCostById(componentCost.getComponentId());
        componentCostDao.addSuitableProduct(KProductComponents);
        flag= componentCostDao.updateComponentCostById(componentCost.getComponentId(),componentCost) == 1 ? true:false;
        return flag;
    }

    @Override
    public boolean deleteComponentCostById(int id) {
        return componentCostDao.deleteComponentCostById(id) ==1 ? true:false;
    }

    @Override
    public ComponentCost getComponentCostById(int id,int productCategoryId) {
        return componentCostDao.getComponentCostById(id,productCategoryId);
    }

    @Override
    public List<ComponentCost> getComponentCostByQuery(ComponentCostQuery componentCostQuery) {
        return componentCostDao.getComponentCostsByQuery(componentCostQuery);
    }

    @Override
    public Result<List<ComponentCost>> getComponentCostsByPage(ComponentCostQuery componentCostQuery) {
        Result<List<ComponentCost>> result = new Result<List<ComponentCost>>();
        int totalItem = componentCostDao.count(componentCostQuery);
        componentCostQuery.setTotalItem(totalItem);
        if (totalItem > 0) {
            result.addDefaultModel("ComponentCosts", componentCostDao.getComponentCostsByPage(componentCostQuery));
        } else {
            result.addDefaultModel("ComponentCosts", new ArrayList<ComponentCost>());
        }

        result.setPageSize(componentCostQuery.getPageSize());
        result.setIndex(componentCostQuery.getIndex());
        result.setTotalItem(totalItem);
        return result;
    }

    @Override
    public int count(ComponentCostQuery componentCostQuery) {
        return componentCostDao.count(componentCostQuery);
    }

    public ComponentCostDao getComponentCostDao(){
        return this.componentCostDao;
    }

    public void setComponentCostDao(ComponentCostDao componentCostDao) {
        this.componentCostDao = componentCostDao;
    }
}

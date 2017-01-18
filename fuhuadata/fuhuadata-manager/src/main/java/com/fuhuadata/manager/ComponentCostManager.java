package com.fuhuadata.manager;

import com.fuhuadata.domain.ComponentCost;
import com.fuhuadata.domain.query.ComponentCostQuery;
import com.fuhuadata.domain.query.Result;

import java.util.List;

/**
 * 成分价格Manager
 * Created by intanswer on 2017/1/17.
 */
public interface ComponentCostManager {

    public ComponentCost addComponentCost(ComponentCost componentCost);

    public boolean updateComponentCostById(int id, ComponentCost componentCost);

    public boolean deleteComponentCostById(int id);

    public Result<List<ComponentCost>> getComponentCostsByPage(ComponentCostQuery componentCostQuery);

    public int count(ComponentCostQuery componentCostQuery);
}

package com.fuhuadata.service;

import com.fuhuadata.domain.ComponentCost;
import com.fuhuadata.domain.query.ComponentCostQuery;
import com.fuhuadata.domain.query.Result;

import java.util.Iterator;
import java.util.List;

/**
 * 成分价格service
 * Created by intanswer on 2017/1/17.
 */
public interface ComponentCostService {
    public Result addComponentCost(ComponentCost componentCost);

    public Result updateComponentCostById(int id, ComponentCost componentCost);

    public Result deleteComponentCostById(int id);

    public Result<List<ComponentCost>> getComponentCostsByPage(ComponentCostQuery componentCostQuery);

    public Result<Integer> count(ComponentCostQuery componentCostQuery);
}

package com.fuhuadata.service;

import com.fuhuadata.domain.ComponentCost;
import com.fuhuadata.domain.KProductComponent;
import com.fuhuadata.domain.query.ComponentCostQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.vo.ComponentCostDO;

import java.util.List;

/**
 * 成分价格service
 * Created by intanswer on 2017/1/17.
 */
public interface ComponentCostService {
    public Result<ComponentCost> addComponentCost(ComponentCost componentCost, List<KProductComponent> KProductComponents);

    public Result updateComponentCostById(ComponentCost componentCost,List<KProductComponent> KProductComponents);

    public Result deleteComponentCostById(int id);

    boolean deleteComponentCostByIds(List<Integer> costIds);

    boolean deleteCostByProductIds(List<Integer> componentIds);

    boolean deleteCompoentCost(List<ComponentCost> costs);

    public Result<ComponentCostDO> getComponentCostById(int id);

    public Result<List<ComponentCost>> getComponentCostByQuery(ComponentCostQuery componentCostQuery);

    public Result<List<ComponentCost>> getComponentCostsByPage(ComponentCostQuery componentCostQuery);

    public Result<Integer> count(ComponentCostQuery componentCostQuery);
}

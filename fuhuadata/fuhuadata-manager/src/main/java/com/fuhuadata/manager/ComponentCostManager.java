package com.fuhuadata.manager;

import com.fuhuadata.domain.ComponentCost;
import com.fuhuadata.domain.KProductComponent;
import com.fuhuadata.domain.query.ComponentCostQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.vo.ComponentCostDO;
import com.fuhuadata.vo.ComponentCostVO;

import java.util.List;

/**
 * 成分价格Manager
 * Created by intanswer on 2017/1/17.
 */
public interface ComponentCostManager {

    public ComponentCost addComponentCost(ComponentCost componentCost, List<KProductComponent> KProductComponents);

    public boolean updateComponentCostById(ComponentCost componentCost,List<KProductComponent> KProductComponents);

    public boolean deleteComponentCostById(int id);

    boolean deleteComponentCostByIds(List<Integer> ids);

    public ComponentCostDO getComponentCostById(int id);

    public List<ComponentCost> getComponentCostByQuery(ComponentCostQuery componentCostQuery);

    public Result<List<ComponentCost>> getComponentCostsByPage(ComponentCostQuery componentCostQuery);

    public int count(ComponentCostQuery componentCostQuery);
}

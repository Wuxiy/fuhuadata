package com.fuhuadata.manager;

import com.fuhuadata.domain.PreparationProcessCost;
import com.fuhuadata.domain.query.PreparationProcessCostQuery;
import com.fuhuadata.domain.query.Result;

import java.util.List;

/**
 * 制剂加工成本Manager
 * Created by intanswer on 2017/1/17.
 */
public interface PreparationProcessCostManager {
    public PreparationProcessCost addPreparationProcessCost(PreparationProcessCost preparationProcessCost);

    public boolean updatePreparationProcessCostById(int id, PreparationProcessCost preparationProcessCost);

    public boolean deletePreparationProcessCostByid(int id);

    public PreparationProcessCost getPreparationProcessCostById( int id);

    public List<PreparationProcessCost> getPreparationProcessCostByQuery(PreparationProcessCostQuery preparationProcessCostQuery);

    public Result<List<PreparationProcessCost>> getPreparationProcessCostsByPage(PreparationProcessCostQuery preparationProcessCostQuery);

    public int count(PreparationProcessCostQuery preparationProcessCostQuery);
}

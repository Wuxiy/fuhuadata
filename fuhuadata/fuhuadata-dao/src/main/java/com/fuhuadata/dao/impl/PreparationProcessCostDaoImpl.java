package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.PreparationProcessCostDao;
import com.fuhuadata.domain.PreparationProcessCost;
import com.fuhuadata.domain.query.PreparationProcessCostQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by intanswer on 2017/1/18.
 */
public class PreparationProcessCostDaoImpl extends SqlMapClientTemplate implements PreparationProcessCostDao {

    public static final String ADD="PREPARATIONPROCESSCOST.ADD";
    public static final String UPDATE="PREPARATIONPROCESSCOST.UPDATE";
    public  static final String DELETE_BY_ID="PREPARATIONPROCESSCOST.DELETE-BY-ID";
    public static final String GET_PAGE="PREPARATIONPROCESSCOST.GET-PAGE";
    public static final String COUNT="PREPARATIONPROCESSCOST.COUNT";
    public static final String GET_BY_ID="PREPARATIONPROCESSCOST.GET-BY-ID";
    public static final String GET_BY_QUERY="PREPARATIONPROCESSCOST.GET-BY-QUERY";

    @Override
    public PreparationProcessCost addPreparationProcessCost(PreparationProcessCost preparationProcessCost) {
        preparationProcessCost.setMcostId((Integer) this.insert(ADD,preparationProcessCost));
        return preparationProcessCost;
    }

    @Override
    public int updatePreparationProcessCostById(int id, PreparationProcessCost preparationProcessCost) {
        preparationProcessCost.setMcostId(id);
        return this.update(UPDATE,preparationProcessCost);
    }

    @Override
    public PreparationProcessCost getPreparationProcessCostById(int id) {
        return (PreparationProcessCost)this.queryForObject(GET_BY_ID,id);
    }

    @Override
    public List<PreparationProcessCost> getPreparationProcessCostByQuery(PreparationProcessCostQuery preparationProcessCostQuery) {
        return this.queryForList(GET_BY_QUERY,preparationProcessCostQuery);
    }

    @Override
    public int deletePreparationProcessCostById(int id) {
        return this.delete(DELETE_BY_ID,id);
    }



    @Override
    public List<PreparationProcessCost> getPreparationProcessCostsByPage(PreparationProcessCostQuery preparationProcessCostQuery) {
        return this.queryForList(GET_PAGE,preparationProcessCostQuery);
    }

    @Override
    public int count(PreparationProcessCostQuery preparationProcessCostQuery) {
        return ((Integer) this.queryForObject(COUNT,preparationProcessCostQuery)).intValue();
    }
}

package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.ComponentCostDao;
import com.fuhuadata.domain.ComponentCost;
import com.fuhuadata.domain.query.ComponentCostQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * 成分价格DaoImpl
 * Created by intanswer on 2017/1/18.
 */
public class ComponentCostDaoImpl extends SqlMapClientTemplate implements ComponentCostDao {
    public static final String ADD="COMPONENTCOST.ADD";
    public static final String UPDATE="COMPONENTCOST.UPDATE";
    public  static final String DELETE_BY_ID="COMPONENTCOST.DELETE-BY-ID";
    public static final String GET_PAGE="COMPONENTCOST.GET-PAGE";
    public static final String COUNT="COMPONENTCOST.COUNT";


    @Override
    public ComponentCost addComponentCost(ComponentCost componentCost) {
        componentCost.setComponentId((Integer)this.insert(ADD,componentCost));
        return componentCost;
    }

    @Override
    public int updateComponentCostById(int id, ComponentCost componentCost) {
        componentCost.setComponentId(id);
        return this.update(UPDATE,componentCost);
    }

    @Override
    public int deleteComponentCostById(int id) {
        return this.delete(DELETE_BY_ID,id);
    }

    @Override
    public List<ComponentCost> getComponentCostsByPage(ComponentCostQuery componentCostQuery) {
        return this.queryForList(GET_PAGE,componentCostQuery);
    }

    @Override
    public int count(ComponentCostQuery componentCostQuery) {
        return ((Integer) this.queryForObject(COUNT,componentCostQuery)).intValue();
    }
}

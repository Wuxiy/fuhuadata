package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.ComponentCostDao;
import com.fuhuadata.domain.ComponentCost;
import com.fuhuadata.domain.KProductComponent;
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
    public static final String GET_BY_ID="COMPONENTCOST.GET-BY-ID";
    public static final String GET_BY_QUERY="COMPONENTCOST.GET-BY-QUERY";
    public static final String ADD_SUITABLE_PRODUCT="COMPONENTCOST.ADD-SUITABLE-PRODUCT";
    public static final String DELETE_PRODUCT_COMPONENT_ID_="COMPONENTCOST.DELETE-PRODUCT-COMPONENT-BY-ID";
    private static final String GET_PRODUCT_COMPONENT_BY_COMPONENT_ID="COMPONENTCOST.GET-PRODUCTCOMPONENT-BY-COMPONENT-ID";
    @Override
    public ComponentCost addComponentCost(ComponentCost componentCost) {
        componentCost.setComponentId((Integer)this.insert(ADD,componentCost));
        return componentCost;
    }

    @Override
    public int addSuitableProduct(List<KProductComponent> KProductComponents) {
        return this.update(ADD_SUITABLE_PRODUCT, KProductComponents);
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
    public int deleteProductComponentCostById(int componentId) {
        return this.delete(DELETE_PRODUCT_COMPONENT_ID_,componentId);
    }


    @Override
    public ComponentCost getComponentCostById(int id) {

        return  (ComponentCost) this.queryForObject(GET_BY_ID,id);
    }

    @Override
    public List<KProductComponent> getProductComponentByComponentId(int id) {
        return this.queryForList(GET_PRODUCT_COMPONENT_BY_COMPONENT_ID,id);
    }

    @Override
    public List<ComponentCost> getComponentCostsByQuery(ComponentCostQuery componentCostQuery) {
        return queryForList(GET_BY_QUERY,componentCostQuery);
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

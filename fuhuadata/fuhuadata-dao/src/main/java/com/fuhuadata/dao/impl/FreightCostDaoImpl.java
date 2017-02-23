package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.FreightCostDao;
import com.fuhuadata.domain.FreightCost;
import com.fuhuadata.domain.query.FreightCostQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * 运费成本DaoImpl
 * Created by intanswer on 2017/1/18.
 */
public class FreightCostDaoImpl extends SqlMapClientTemplate implements FreightCostDao {
    public static final String ADD="FREIGHTCOST.ADD";
    public static final String UPDATE="FREIGHTCOST.UPDATE";
    public  static final String DELETE_BY_ID="FREIGHTCOST.DELETE-BY-ID";
    public static final String GET_PAGE="FREIGHTCOST.GET-PAGE";
    public static final String COUNT="FREIGHTCOST.COUNT";
    public static final String GET_BY_QUERY="FREIGHTCOST.GET-BY-QUERY";
    public static final String GET_BY_ID="FREIGHTCOST.GET-BY-ID";
    @Override
    public FreightCost addFreightCost(FreightCost freightCost) {
        freightCost.setFreightId((Integer) this.insert(ADD,freightCost));
        return freightCost;
    }

    @Override
    public int updateFreightCostById(int id, FreightCost freightCost) {
        freightCost.setFreightId(id);
        return this.update(UPDATE,freightCost);
    }

    @Override
    public int deleteFreightCostById(int id) {
        return this.delete(DELETE_BY_ID,id);
    }

    @Override
    public FreightCost getFreightCostQueryById(int id) {
        return (FreightCost)this.queryForObject(GET_BY_ID,id);
    }

    @Override
    public List<FreightCost> getFreightCostsByPage(FreightCostQuery freightCostQuery) {
        return this.queryForList(GET_PAGE,freightCostQuery);
    }

    public List<FreightCost> getFreightCostByQuery(FreightCostQuery freightCostQuery){
        return this.queryForList(GET_BY_QUERY,freightCostQuery);
    }

    @Override
    public int count(FreightCostQuery freightCostQuery) {

        return ((Integer) this.queryForObject(COUNT,freightCostQuery)).intValue();
    }
}

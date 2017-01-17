package com.fuhuadata.dao.impl;
import java.util.List;
import com.fuhuadata.domain.query.QueryFreightforwardingWarehouseRelation;
import com.fuhuadata.dao.FreightforwardingWarehouseRelationDao;
import com.fuhuadata.domain.FreightforwardingWarehouseRelation;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
/**
 * @author wangbo
 * @date 2017-01-17 14:24:28
 */
@SuppressWarnings("unchecked")
public class FreightforwardingWarehouseRelationDaoImpl extends SqlMapClientTemplate implements FreightforwardingWarehouseRelationDao {

    public static final String ADD = "FREIGHTFORWARDINGWAREHOUSERELATION.ADD";
    public static final String UPDATE = "FREIGHTFORWARDINGWAREHOUSERELATION.UPDATE";
    public static final String DELETE_BY_ID = "FREIGHTFORWARDINGWAREHOUSERELATION.DELETE-BY-ID";
    public static final String GET_ALL = "FREIGHTFORWARDINGWAREHOUSERELATION.GET-ALL";
    public static final String GET_BY_QUERY = "FREIGHTFORWARDINGWAREHOUSERELATION.GET-BY-QUERY";
    public static final String GET_BY_ID = "FREIGHTFORWARDINGWAREHOUSERELATION.GET-BY-ID";
    public static final String GET_PAGE = "FREIGHTFORWARDINGWAREHOUSERELATION.GET-PAGE";
    public static final String COUNT = "FREIGHTFORWARDINGWAREHOUSERELATION.COUNT";
    
    public FreightforwardingWarehouseRelation addFreightforwardingWarehouseRelation(FreightforwardingWarehouseRelation freightforwardingWarehouseRelation) {
		freightforwardingWarehouseRelation.setId((Integer) this.insert(ADD, freightforwardingWarehouseRelation));
    	return freightforwardingWarehouseRelation;
    }
    
    public int updateFreightforwardingWarehouseRelationById(int id, FreightforwardingWarehouseRelation freightforwardingWarehouseRelation) {
    	freightforwardingWarehouseRelation.setId(id);
		return this.update(UPDATE, freightforwardingWarehouseRelation);
    }
    
    public int deleteFreightforwardingWarehouseRelationById(int id) {
    	return this.update(DELETE_BY_ID, id);
    }
    
    public List<FreightforwardingWarehouseRelation> getAllFreightforwardingWarehouseRelations() {
    	return this.queryForList(GET_ALL);
    }
    	
    public List<FreightforwardingWarehouseRelation> getFreightforwardingWarehouseRelationsByQuery(QueryFreightforwardingWarehouseRelation queryFreightforwardingWarehouseRelation) {
    	return this.queryForList(GET_BY_QUERY, queryFreightforwardingWarehouseRelation);
    }
    	
    public FreightforwardingWarehouseRelation getFreightforwardingWarehouseRelationById(int id) {
    	return (FreightforwardingWarehouseRelation) this.queryForObject(GET_BY_ID, id);
    }
    
    public List<FreightforwardingWarehouseRelation> getFreightforwardingWarehouseRelationsByPage(QueryFreightforwardingWarehouseRelation queryFreightforwardingWarehouseRelation) {
    	return this.queryForList(GET_PAGE, queryFreightforwardingWarehouseRelation);
    }
    	
    public int count(QueryFreightforwardingWarehouseRelation queryFreightforwardingWarehouseRelation) {
    	return ((Integer) this.queryForObject(COUNT, queryFreightforwardingWarehouseRelation)).intValue();
    }
}
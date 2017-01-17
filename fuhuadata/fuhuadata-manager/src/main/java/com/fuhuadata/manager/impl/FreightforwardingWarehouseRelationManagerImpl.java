package com.fuhuadata.manager.impl;
import java.util.List;
import com.fuhuadata.domain.query.QueryFreightforwardingWarehouseRelation;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.dao.FreightforwardingWarehouseRelationDao;
import com.fuhuadata.manager.FreightforwardingWarehouseRelationManager;
import com.fuhuadata.domain.FreightforwardingWarehouseRelation;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

/**
 * @author wangbo
 * @date 2017-01-17 14:24:28
 */
public class FreightforwardingWarehouseRelationManagerImpl implements FreightforwardingWarehouseRelationManager {

	@Resource
    private FreightforwardingWarehouseRelationDao freightforwardingWarehouseRelationDao;
    

    public FreightforwardingWarehouseRelation addFreightforwardingWarehouseRelation(FreightforwardingWarehouseRelation freightforwardingWarehouseRelation) {
    	return freightforwardingWarehouseRelationDao.addFreightforwardingWarehouseRelation(freightforwardingWarehouseRelation);
    }
    
    public boolean updateFreightforwardingWarehouseRelationById(int id, FreightforwardingWarehouseRelation freightforwardingWarehouseRelation) {
    	return freightforwardingWarehouseRelationDao.updateFreightforwardingWarehouseRelationById(id, freightforwardingWarehouseRelation) == 1 ? true : false;
    }
    
	public List<FreightforwardingWarehouseRelation> getFreightforwardingWarehouseRelationsByQuery(QueryFreightforwardingWarehouseRelation queryFreightforwardingWarehouseRelation) {
		return freightforwardingWarehouseRelationDao.getFreightforwardingWarehouseRelationsByQuery(queryFreightforwardingWarehouseRelation);
	}

    public boolean deleteFreightforwardingWarehouseRelationById(int id) {
    	return freightforwardingWarehouseRelationDao.deleteFreightforwardingWarehouseRelationById(id) == 1 ? true : false;
    }
    
    
    public List<FreightforwardingWarehouseRelation> getAllFreightforwardingWarehouseRelations() {
    	return freightforwardingWarehouseRelationDao.getAllFreightforwardingWarehouseRelations();
    }
    	
    public Result<List<FreightforwardingWarehouseRelation>> getFreightforwardingWarehouseRelationsByPage(QueryFreightforwardingWarehouseRelation queryFreightforwardingWarehouseRelation) {
		Result<List<FreightforwardingWarehouseRelation>> result = new Result<List<FreightforwardingWarehouseRelation>>();
		int totalItem = freightforwardingWarehouseRelationDao.count(queryFreightforwardingWarehouseRelation);
		;
		if (totalItem > 0) {
			result.addDefaultModel("FreightforwardingWarehouseRelations", freightforwardingWarehouseRelationDao.getFreightforwardingWarehouseRelationsByPage(queryFreightforwardingWarehouseRelation));		
		} else {
			result.addDefaultModel("FreightforwardingWarehouseRelations", new ArrayList<FreightforwardingWarehouseRelation>());
		}
		
		result.setPageSize(queryFreightforwardingWarehouseRelation.getPageSize());
		result.setIndex(queryFreightforwardingWarehouseRelation.getIndex());
		result.setTotalItem(totalItem);
		
		return result;
    }
    	
    	
    public FreightforwardingWarehouseRelation getFreightforwardingWarehouseRelationById(int id) {
    	return freightforwardingWarehouseRelationDao.getFreightforwardingWarehouseRelationById(id);
    }
    

    public int count(QueryFreightforwardingWarehouseRelation queryFreightforwardingWarehouseRelation) {
    	return freightforwardingWarehouseRelationDao.count(queryFreightforwardingWarehouseRelation);
    }
    
}
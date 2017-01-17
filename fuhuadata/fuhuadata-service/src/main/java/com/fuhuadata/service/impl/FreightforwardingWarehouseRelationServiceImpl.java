package com.fuhuadata.service.impl;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.QueryFreightforwardingWarehouseRelation;
import com.fuhuadata.service.FreightforwardingWarehouseRelationService;
import com.fuhuadata.manager.FreightforwardingWarehouseRelationManager;
import com.fuhuadata.domain.FreightforwardingWarehouseRelation;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;


/**
 * @author wangbo
 * @date 2017-01-17 14:24:28
 */
public class FreightforwardingWarehouseRelationServiceImpl implements FreightforwardingWarehouseRelationService {
	
	@Resource
    private FreightforwardingWarehouseRelationManager freightforwardingWarehouseRelationManager;
    public Result<FreightforwardingWarehouseRelation> addFreightforwardingWarehouseRelation(FreightforwardingWarehouseRelation freightforwardingWarehouseRelation) {
		Result<FreightforwardingWarehouseRelation> result = new Result<FreightforwardingWarehouseRelation>();
		try {
			result.addDefaultModel(freightforwardingWarehouseRelationManager.addFreightforwardingWarehouseRelation(freightforwardingWarehouseRelation));			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result updateFreightforwardingWarehouseRelationById(int id, FreightforwardingWarehouseRelation freightforwardingWarehouseRelation) {
		Result result = new Result();
		try {
			result.setSuccess(freightforwardingWarehouseRelationManager.updateFreightforwardingWarehouseRelationById(id, freightforwardingWarehouseRelation));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result deleteFreightforwardingWarehouseRelationById(int id) {
		Result result = new Result();
		try {
			result.setSuccess(freightforwardingWarehouseRelationManager.deleteFreightforwardingWarehouseRelationById(id));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }	
    	
    public Result<List<FreightforwardingWarehouseRelation>> getFreightforwardingWarehouseRelationsByQuery(QueryFreightforwardingWarehouseRelation queryFreightforwardingWarehouseRelation) {
		Result<List<FreightforwardingWarehouseRelation>> result = new Result<List<FreightforwardingWarehouseRelation>>();
		try {
			result.addDefaultModel("${!className}s", freightforwardingWarehouseRelationManager.getFreightforwardingWarehouseRelationsByQuery(queryFreightforwardingWarehouseRelation));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<FreightforwardingWarehouseRelation> getFreightforwardingWarehouseRelationById(int id) {
		Result<FreightforwardingWarehouseRelation> result = new Result<FreightforwardingWarehouseRelation>();
		try {		
		    FreightforwardingWarehouseRelation  freightforwardingWarehouseRelation = freightforwardingWarehouseRelationManager.getFreightforwardingWarehouseRelationById(id);
		    if(freightforwardingWarehouseRelation == null){
				result.setSimpleErrorMsg(0, "当前数据不存在，请重试");
			}else{
				result.addDefaultModel("FreightforwardingWarehouseRelation", freightforwardingWarehouseRelation);
			}
			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    

    public Result<List<FreightforwardingWarehouseRelation>> getFreightforwardingWarehouseRelationsByPage(QueryFreightforwardingWarehouseRelation queryFreightforwardingWarehouseRelation) {
		Result<List<FreightforwardingWarehouseRelation>> result = new Result<List<FreightforwardingWarehouseRelation>>();
		try {		
			result = freightforwardingWarehouseRelationManager.getFreightforwardingWarehouseRelationsByPage(queryFreightforwardingWarehouseRelation);
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<Integer> count(QueryFreightforwardingWarehouseRelation queryFreightforwardingWarehouseRelation) {
		Result<Integer> result = new Result<Integer>();
		try {	
			result.addDefaultModel(freightforwardingWarehouseRelationManager.count(queryFreightforwardingWarehouseRelation));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
	
}
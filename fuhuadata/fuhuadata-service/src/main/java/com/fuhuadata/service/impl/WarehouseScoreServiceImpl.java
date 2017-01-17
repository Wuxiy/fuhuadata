package com.fuhuadata.service.impl;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.service.WarehouseScoreService;
import com.fuhuadata.domain.WarehouseScore;
import com.fuhuadata.manager.WarehouseScoreManager;
import com.fuhuadata.domain.query.QueryWarehouseScore;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author wangbo
 * @date 2017-01-17 15:17:14
 */
public class WarehouseScoreServiceImpl implements WarehouseScoreService {
	
	@Resource
    private WarehouseScoreManager warehouseScoreManager;
    public Result<WarehouseScore> addWarehouseScore(WarehouseScore warehouseScore) {
		Result<WarehouseScore> result = new Result<WarehouseScore>();
		try {
			result.addDefaultModel(warehouseScoreManager.addWarehouseScore(warehouseScore));			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result updateWarehouseScoreById(int id, WarehouseScore warehouseScore) {
		Result result = new Result();
		try {
			result.setSuccess(warehouseScoreManager.updateWarehouseScoreById(id, warehouseScore));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result deleteWarehouseScoreById(int id) {
		Result result = new Result();
		try {
			result.setSuccess(warehouseScoreManager.deleteWarehouseScoreById(id));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }	
    	
    public Result<List<WarehouseScore>> getWarehouseScoresByQuery(QueryWarehouseScore queryWarehouseScore) {
		Result<List<WarehouseScore>> result = new Result<List<WarehouseScore>>();
		try {
			result.addDefaultModel("${!className}s", warehouseScoreManager.getWarehouseScoresByQuery(queryWarehouseScore));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<WarehouseScore> getWarehouseScoreById(int id) {
		Result<WarehouseScore> result = new Result<WarehouseScore>();
		try {		
		    WarehouseScore  warehouseScore = warehouseScoreManager.getWarehouseScoreById(id);
		    if(warehouseScore == null){
				result.setSimpleErrorMsg(0, "当前数据不存在，请重试");
			}else{
				result.addDefaultModel("WarehouseScore", warehouseScore);
			}
			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    

    public Result<List<WarehouseScore>> getWarehouseScoresByPage(QueryWarehouseScore queryWarehouseScore) {
		Result<List<WarehouseScore>> result = new Result<List<WarehouseScore>>();
		try {		
			result = warehouseScoreManager.getWarehouseScoresByPage(queryWarehouseScore);
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<Integer> count(QueryWarehouseScore queryWarehouseScore) {
		Result<Integer> result = new Result<Integer>();
		try {	
			result.addDefaultModel(warehouseScoreManager.count(queryWarehouseScore));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
	
}
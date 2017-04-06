package com.fuhuadata.manager.impl;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.WarehouseScore;
import com.fuhuadata.manager.WarehouseScoreManager;
import com.fuhuadata.dao.WarehouseScoreDao;
import com.fuhuadata.domain.query.QueryWarehouseScore;
import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author wangbo
 * @date 2017-01-17 15:17:14
 */
public class WarehouseScoreManagerImpl implements WarehouseScoreManager {

	@Resource
    private WarehouseScoreDao warehouseScoreDao;
    

    public WarehouseScore addWarehouseScore(WarehouseScore warehouseScore) {
    	return warehouseScoreDao.addWarehouseScore(warehouseScore);
    }
    
    public boolean updateWarehouseScoreById(int id, WarehouseScore warehouseScore) {
    	return warehouseScoreDao.updateWarehouseScoreById(id, warehouseScore) == 1 ? true : false;
    }
    
	public List<WarehouseScore> getWarehouseScoresByQuery(QueryWarehouseScore queryWarehouseScore) {
		return warehouseScoreDao.getWarehouseScoresByQuery(queryWarehouseScore);
	}

    public boolean deleteWarehouseScoreById(int id) {
    	return warehouseScoreDao.deleteWarehouseScoreById(id) == 1 ? true : false;
    }
    
    
    public List<WarehouseScore> getAllWarehouseScores() {
    	return warehouseScoreDao.getAllWarehouseScores();
    }
    	
    public Result<List<WarehouseScore>> getWarehouseScoresByPage(QueryWarehouseScore queryWarehouseScore) {
		Result<List<WarehouseScore>> result = new Result<List<WarehouseScore>>();
		int totalItem = warehouseScoreDao.count(queryWarehouseScore);
		;
		if (totalItem > 0) {
			result.addDefaultModel("WarehouseScores", warehouseScoreDao.getWarehouseScoresByPage(queryWarehouseScore));		
		} else {
			result.addDefaultModel("WarehouseScores", new ArrayList<WarehouseScore>());
		}
		
		result.setPageSize(queryWarehouseScore.getPageSize());
		result.setIndex(queryWarehouseScore.getIndex());
		result.setTotalItem(totalItem);
		
		return result;
    }
    	
    	
    public WarehouseScore getWarehouseScoreById(int id) {
    	return warehouseScoreDao.getWarehouseScoreById(id);
    }
    

    public int count(QueryWarehouseScore queryWarehouseScore) {
    	return warehouseScoreDao.count(queryWarehouseScore);
    }
    
}
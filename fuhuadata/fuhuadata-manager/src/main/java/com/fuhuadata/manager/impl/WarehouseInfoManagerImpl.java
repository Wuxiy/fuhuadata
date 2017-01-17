package com.fuhuadata.manager.impl;
import com.fuhuadata.dao.WarehouseInfoDao;
import java.util.List;
import com.fuhuadata.domain.WarehouseInfo;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.QueryWarehouseInfo;
import com.fuhuadata.manager.WarehouseInfoManager;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

/**
 * @author wangbo
 * @date 2017-01-16 17:17:06
 */
public class WarehouseInfoManagerImpl implements WarehouseInfoManager {

	@Resource
    private WarehouseInfoDao warehouseInfoDao;
    

    public WarehouseInfo addWarehouseInfo(WarehouseInfo warehouseInfo) {
    	return warehouseInfoDao.addWarehouseInfo(warehouseInfo);
    }
    
    public boolean updateWarehouseInfoById(String customer_id, WarehouseInfo warehouseInfo) {
    	return warehouseInfoDao.updateWarehouseInfoById(customer_id, warehouseInfo) == 1 ? true : false;
    }
    
	public List<WarehouseInfo> getWarehouseInfosByQuery(QueryWarehouseInfo queryWarehouseInfo) {
		return warehouseInfoDao.getWarehouseInfosByQuery(queryWarehouseInfo);
	}

    public boolean deleteWarehouseInfoById(String customer_id) {
    	return warehouseInfoDao.deleteWarehouseInfoById(customer_id) == 1 ? true : false;
    }
    
    
    public List<WarehouseInfo> getAllWarehouseInfos() {
    	return warehouseInfoDao.getAllWarehouseInfos();
    }
    	
    public Result<List<WarehouseInfo>> getWarehouseInfosByPage(QueryWarehouseInfo queryWarehouseInfo) {
		Result<List<WarehouseInfo>> result = new Result<List<WarehouseInfo>>();
		int totalItem = warehouseInfoDao.count(queryWarehouseInfo);
		;
		if (totalItem > 0) {
			result.addDefaultModel("WarehouseInfos", warehouseInfoDao.getWarehouseInfosByPage(queryWarehouseInfo));		
		} else {
			result.addDefaultModel("WarehouseInfos", new ArrayList<WarehouseInfo>());
		}
		
		result.setPageSize(queryWarehouseInfo.getPageSize());
		result.setIndex(queryWarehouseInfo.getIndex());
		result.setTotalItem(totalItem);
		
		return result;
    }
    	
    	
    public WarehouseInfo getWarehouseInfoById(String customer_id) {
    	return warehouseInfoDao.getWarehouseInfoById(customer_id);
    }
    

    public int count(QueryWarehouseInfo queryWarehouseInfo) {
    	return warehouseInfoDao.count(queryWarehouseInfo);
    }
    
}
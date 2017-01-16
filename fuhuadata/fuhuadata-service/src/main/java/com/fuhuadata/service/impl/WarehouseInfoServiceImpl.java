package com.fuhuadata.service.impl;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.WarehouseInfo;
import com.fuhuadata.service.WarehouseInfoService;
import com.fuhuadata.domain.query.QueryWarehouseInfo;
import com.fuhuadata.manager.WarehouseInfoManager;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author wangbo
 * @date 2017-01-16 17:17:06
 */
@Component
public class WarehouseInfoServiceImpl implements WarehouseInfoService {
	
	@Resource
    private WarehouseInfoManager warehouseInfoManager;
    public Result<WarehouseInfo> addWarehouseInfo(WarehouseInfo warehouseInfo) {
		Result<WarehouseInfo> result = new Result<WarehouseInfo>();
		try {
			result.addDefaultModel(warehouseInfoManager.addWarehouseInfo(warehouseInfo));			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result updateWarehouseInfoById(String customer_id, WarehouseInfo warehouseInfo) {
		Result result = new Result();
		try {
			result.setSuccess(warehouseInfoManager.updateWarehouseInfoById(customer_id, warehouseInfo));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result deleteWarehouseInfoById(String customer_id) {
		Result result = new Result();
		try {
			result.setSuccess(warehouseInfoManager.deleteWarehouseInfoById(customer_id));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }	
    	
    public Result<List<WarehouseInfo>> getWarehouseInfosByQuery(QueryWarehouseInfo queryWarehouseInfo) {
		Result<List<WarehouseInfo>> result = new Result<List<WarehouseInfo>>();
		try {
			result.addDefaultModel("${!className}s", warehouseInfoManager.getWarehouseInfosByQuery(queryWarehouseInfo));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<WarehouseInfo> getWarehouseInfoById(String customer_id) {
		Result<WarehouseInfo> result = new Result<WarehouseInfo>();
		try {		
		    WarehouseInfo  warehouseInfo = warehouseInfoManager.getWarehouseInfoById(customer_id);
		    if(warehouseInfo == null){
				result.setSimpleErrorMsg(0, "当前数据不存在，请重试");
			}else{
				result.addDefaultModel("WarehouseInfo", warehouseInfo);
			}
			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    

    public Result<List<WarehouseInfo>> getWarehouseInfosByPage(QueryWarehouseInfo queryWarehouseInfo) {
		Result<List<WarehouseInfo>> result = new Result<List<WarehouseInfo>>();
		try {		
			result = warehouseInfoManager.getWarehouseInfosByPage(queryWarehouseInfo);
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<Integer> count(QueryWarehouseInfo queryWarehouseInfo) {
		Result<Integer> result = new Result<Integer>();
		try {	
			result.addDefaultModel(warehouseInfoManager.count(queryWarehouseInfo));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
	
}
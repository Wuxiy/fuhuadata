package com.fuhuadata.manager.impl;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.QueryFreightforwardingInfo;
import com.fuhuadata.domain.FreightforwardingInfo;
import com.fuhuadata.dao.FreightforwardingInfoDao;
import com.fuhuadata.manager.FreightforwardingInfoManager;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

/**
 * @author wangbo
 * @date 2017-01-16 15:25:40
 */
public class FreightforwardingInfoManagerImpl implements FreightforwardingInfoManager {

	@Resource
    private FreightforwardingInfoDao freightforwardingInfoDao;
    

    public FreightforwardingInfo addFreightforwardingInfo(FreightforwardingInfo freightforwardingInfo) {
    	return freightforwardingInfoDao.addFreightforwardingInfo(freightforwardingInfo);
    }
    
    public boolean updateFreightforwardingInfoById(String customer_id, FreightforwardingInfo freightforwardingInfo) {
    	return freightforwardingInfoDao.updateFreightforwardingInfoById(customer_id, freightforwardingInfo) == 1 ? true : false;
    }
    
	public List<FreightforwardingInfo> getFreightforwardingInfosByQuery(QueryFreightforwardingInfo queryFreightforwardingInfo) {
		return freightforwardingInfoDao.getFreightforwardingInfosByQuery(queryFreightforwardingInfo);
	}

    public boolean deleteFreightforwardingInfoById(String customer_id) {
    	return freightforwardingInfoDao.deleteFreightforwardingInfoById(customer_id) == 1 ? true : false;
    }
    
    
    public List<FreightforwardingInfo> getAllFreightforwardingInfos() {
    	return freightforwardingInfoDao.getAllFreightforwardingInfos();
    }
    	
    public Result<List<FreightforwardingInfo>> getFreightforwardingInfosByPage(QueryFreightforwardingInfo queryFreightforwardingInfo) {
		Result<List<FreightforwardingInfo>> result = new Result<List<FreightforwardingInfo>>();
		int totalItem = freightforwardingInfoDao.count(queryFreightforwardingInfo);
		;
		if (totalItem > 0) {
			result.addDefaultModel("FreightforwardingInfos", freightforwardingInfoDao.getFreightforwardingInfosByPage(queryFreightforwardingInfo));		
		} else {
			result.addDefaultModel("FreightforwardingInfos", new ArrayList<FreightforwardingInfo>());
		}
		
		result.setPageSize(queryFreightforwardingInfo.getPageSize());
		result.setIndex(queryFreightforwardingInfo.getIndex());
		result.setTotalItem(totalItem);
		
		return result;
    }
    	
    	
    public FreightforwardingInfo getFreightforwardingInfoById(String customer_id) {
    	return freightforwardingInfoDao.getFreightforwardingInfoById(customer_id);
    }
    

    public int count(QueryFreightforwardingInfo queryFreightforwardingInfo) {
    	return freightforwardingInfoDao.count(queryFreightforwardingInfo);
    }
    
}
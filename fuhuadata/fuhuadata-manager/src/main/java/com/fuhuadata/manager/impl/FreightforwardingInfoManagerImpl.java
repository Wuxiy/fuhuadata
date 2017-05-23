package com.fuhuadata.manager.impl;
import java.util.List;

import com.fuhuadata.domain.Freightforwarding;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.QueryFreightforwardingInfo;
import com.fuhuadata.dao.FreightforwardingInfoDao;
import com.fuhuadata.manager.FreightforwardingInfoManager;
import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author wangbo
 * @date 2017-01-16 15:25:40
 */
public class FreightforwardingInfoManagerImpl implements FreightforwardingInfoManager {

	@Resource
    private FreightforwardingInfoDao freightforwardingInfoDao;
    

    public Freightforwarding addFreightforwardingInfo(Freightforwarding freightforwarding) {
    	return freightforwardingInfoDao.addFreightforwardingInfo(freightforwarding);
    }
    
    public boolean updateFreightforwardingInfoById(String customer_id, Freightforwarding freightforwarding) {
    	return freightforwardingInfoDao.updateFreightforwardingInfoById(customer_id, freightforwarding) == 1 ? true : false;
    }
    
	public List<Freightforwarding> getFreightforwardingInfosByQuery(QueryFreightforwardingInfo queryFreightforwardingInfo) {
		return freightforwardingInfoDao.getFreightforwardingInfosByQuery(queryFreightforwardingInfo);
	}

    public boolean deleteFreightforwardingInfoById(String customer_id) {
    	return freightforwardingInfoDao.deleteFreightforwardingInfoById(customer_id) == 1 ? true : false;
    }
    
    
    public List<Freightforwarding> getAllFreightforwardingInfos() {
    	return freightforwardingInfoDao.getAllFreightforwardingInfos();
    }
    	
    public Result<List<Freightforwarding>> getFreightforwardingInfosByPage(QueryFreightforwardingInfo queryFreightforwardingInfo) {
		Result<List<Freightforwarding>> result = new Result<List<Freightforwarding>>();
		int totalItem = freightforwardingInfoDao.count(queryFreightforwardingInfo);
		;
		if (totalItem > 0) {
			result.addDefaultModel("FreightforwardingInfos", freightforwardingInfoDao.getFreightforwardingInfosByPage(queryFreightforwardingInfo));		
		} else {
			result.addDefaultModel("FreightforwardingInfos", new ArrayList<Freightforwarding>());
		}
		
		result.setPageSize(queryFreightforwardingInfo.getPageSize());
		result.setIndex(queryFreightforwardingInfo.getIndex());
		result.setTotalItem(totalItem);
		
		return result;
    }
    	
    	
    public Freightforwarding getFreightforwardingInfoById(String customer_id) {
    	return freightforwardingInfoDao.getFreightforwardingInfoById(customer_id);
    }
    

    public int count(QueryFreightforwardingInfo queryFreightforwardingInfo) {
    	return freightforwardingInfoDao.count(queryFreightforwardingInfo);
    }
    
}
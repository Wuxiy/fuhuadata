package com.fuhuadata.manager.impl;
import com.fuhuadata.domain.query.QueryProduceFactoryInfo;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.ProduceFactoryInfoManager;
import com.fuhuadata.domain.ProduceFactoryInfo;
import com.fuhuadata.dao.ProduceFactoryInfoDao;
import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author wangbo
 * @date 2017-01-16 11:10:51
 */
public class ProduceFactoryInfoManagerImpl implements ProduceFactoryInfoManager {

	@Resource
    private ProduceFactoryInfoDao produceFactoryInfoDao;
    

    public ProduceFactoryInfo addProduceFactoryInfo(ProduceFactoryInfo produceFactoryInfo) {
    	return produceFactoryInfoDao.addProduceFactoryInfo(produceFactoryInfo);
    }
    
    public boolean updateProduceFactoryInfoById(String customer_id, ProduceFactoryInfo produceFactoryInfo) {
    	return produceFactoryInfoDao.updateProduceFactoryInfoById(customer_id, produceFactoryInfo) == 1 ? true : false;
    }
    
	public List<ProduceFactoryInfo> getProduceFactoryInfosByQuery(QueryProduceFactoryInfo queryProduceFactoryInfo) {
		return produceFactoryInfoDao.getProduceFactoryInfosByQuery(queryProduceFactoryInfo);
	}

    public boolean deleteProduceFactoryInfoById(String customer_id) {
    	return produceFactoryInfoDao.deleteProduceFactoryInfoById(customer_id) == 1 ? true : false;
    }
    
    
    public List<ProduceFactoryInfo> getAllProduceFactoryInfos() {
    	return produceFactoryInfoDao.getAllProduceFactoryInfos();
    }
    	
    public Result<List<ProduceFactoryInfo>> getProduceFactoryInfosByPage(QueryProduceFactoryInfo queryProduceFactoryInfo) {
		Result<List<ProduceFactoryInfo>> result = new Result<List<ProduceFactoryInfo>>();
		int totalItem = produceFactoryInfoDao.count(queryProduceFactoryInfo);
		;
		if (totalItem > 0) {
			result.addDefaultModel("ProduceFactoryInfos", produceFactoryInfoDao.getProduceFactoryInfosByPage(queryProduceFactoryInfo));		
		} else {
			result.addDefaultModel("ProduceFactoryInfos", new ArrayList<ProduceFactoryInfo>());
		}
		
		result.setPageSize(queryProduceFactoryInfo.getPageSize());
		result.setIndex(queryProduceFactoryInfo.getIndex());
		result.setTotalItem(totalItem);
		
		return result;
    }
    	
    	
    public ProduceFactoryInfo getProduceFactoryInfoById(String customer_id) {
    	return produceFactoryInfoDao.getProduceFactoryInfoById(customer_id);
    }
    

    public int count(QueryProduceFactoryInfo queryProduceFactoryInfo) {
    	return produceFactoryInfoDao.count(queryProduceFactoryInfo);
    }
    
}
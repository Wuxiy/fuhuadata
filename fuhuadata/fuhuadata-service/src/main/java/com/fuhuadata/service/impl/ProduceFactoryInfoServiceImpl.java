package com.fuhuadata.service.impl;
import com.fuhuadata.service.ProduceFactoryInfoService;
import com.fuhuadata.domain.query.QueryProduceFactoryInfo;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.ProduceFactoryInfoManager;
import com.fuhuadata.domain.ProduceFactoryInfo;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.io.Serializable;

/**
 * @author wangbo
 * @date 2017-01-16 11:10:51
 */
@Component
public class ProduceFactoryInfoServiceImpl implements ProduceFactoryInfoService {
	
	@Resource
    private ProduceFactoryInfoManager produceFactoryInfoManager;
    public Result<ProduceFactoryInfo> addProduceFactoryInfo(ProduceFactoryInfo produceFactoryInfo) {
		Result<ProduceFactoryInfo> result = new Result<ProduceFactoryInfo>();
		try {
			result.addDefaultModel(produceFactoryInfoManager.addProduceFactoryInfo(produceFactoryInfo));			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result updateProduceFactoryInfoById(String customer_id, ProduceFactoryInfo produceFactoryInfo) {
		Result result = new Result();
		try {
			result.setSuccess(produceFactoryInfoManager.updateProduceFactoryInfoById(customer_id, produceFactoryInfo));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result deleteProduceFactoryInfoById(String customer_id) {
		Result result = new Result();
		try {
			result.setSuccess(produceFactoryInfoManager.deleteProduceFactoryInfoById(customer_id));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }	
    	
    public Result<List<ProduceFactoryInfo>> getProduceFactoryInfosByQuery(QueryProduceFactoryInfo queryProduceFactoryInfo) {
		Result<List<ProduceFactoryInfo>> result = new Result<List<ProduceFactoryInfo>>();
		try {
			result.addDefaultModel("${!className}s", produceFactoryInfoManager.getProduceFactoryInfosByQuery(queryProduceFactoryInfo));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<ProduceFactoryInfo> getProduceFactoryInfoById(String customer_id) {
		Result<ProduceFactoryInfo> result = new Result<ProduceFactoryInfo>();
		try {		
		    ProduceFactoryInfo  produceFactoryInfo = produceFactoryInfoManager.getProduceFactoryInfoById(customer_id);
		    if(produceFactoryInfo == null){
				result.setSimpleErrorMsg(0, "当前数据不存在，请重试");
			}else{
				result.addDefaultModel("ProduceFactoryInfo", produceFactoryInfo);
			}
			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    

    public Result<List<ProduceFactoryInfo>> getProduceFactoryInfosByPage(QueryProduceFactoryInfo queryProduceFactoryInfo) {
		Result<List<ProduceFactoryInfo>> result = new Result<List<ProduceFactoryInfo>>();
		try {		
			result = produceFactoryInfoManager.getProduceFactoryInfosByPage(queryProduceFactoryInfo);
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<Integer> count(QueryProduceFactoryInfo queryProduceFactoryInfo) {
		Result<Integer> result = new Result<Integer>();
		try {	
			result.addDefaultModel(produceFactoryInfoManager.count(queryProduceFactoryInfo));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
	
}
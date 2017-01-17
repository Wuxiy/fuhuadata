package com.fuhuadata.service.impl;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.service.FreightforwardingInfoService;
import com.fuhuadata.domain.query.QueryFreightforwardingInfo;
import com.fuhuadata.domain.FreightforwardingInfo;
import com.fuhuadata.manager.FreightforwardingInfoManager;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author wangbo
 * @date 2017-01-16 15:25:40
 */
public class FreightforwardingInfoServiceImpl implements FreightforwardingInfoService {
	
	@Resource
    private FreightforwardingInfoManager freightforwardingInfoManager;
    public Result<FreightforwardingInfo> addFreightforwardingInfo(FreightforwardingInfo freightforwardingInfo) {
		Result<FreightforwardingInfo> result = new Result<FreightforwardingInfo>();
		try {
			result.addDefaultModel(freightforwardingInfoManager.addFreightforwardingInfo(freightforwardingInfo));			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result updateFreightforwardingInfoById(String customer_id, FreightforwardingInfo freightforwardingInfo) {
		Result result = new Result();
		try {
			result.setSuccess(freightforwardingInfoManager.updateFreightforwardingInfoById(customer_id, freightforwardingInfo));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result deleteFreightforwardingInfoById(String customer_id) {
		Result result = new Result();
		try {
			result.setSuccess(freightforwardingInfoManager.deleteFreightforwardingInfoById(customer_id));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }	
    	
    public Result<List<FreightforwardingInfo>> getFreightforwardingInfosByQuery(QueryFreightforwardingInfo queryFreightforwardingInfo) {
		Result<List<FreightforwardingInfo>> result = new Result<List<FreightforwardingInfo>>();
		try {
			result.addDefaultModel("${!className}s", freightforwardingInfoManager.getFreightforwardingInfosByQuery(queryFreightforwardingInfo));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<FreightforwardingInfo> getFreightforwardingInfoById(String customer_id) {
		Result<FreightforwardingInfo> result = new Result<FreightforwardingInfo>();
		try {		
		    FreightforwardingInfo  freightforwardingInfo = freightforwardingInfoManager.getFreightforwardingInfoById(customer_id);
		    if(freightforwardingInfo == null){
				result.setSimpleErrorMsg(0, "当前数据不存在，请重试");
			}else{
				result.addDefaultModel("FreightforwardingInfo", freightforwardingInfo);
			}
			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    

    public Result<List<FreightforwardingInfo>> getFreightforwardingInfosByPage(QueryFreightforwardingInfo queryFreightforwardingInfo) {
		Result<List<FreightforwardingInfo>> result = new Result<List<FreightforwardingInfo>>();
		try {		
			result = freightforwardingInfoManager.getFreightforwardingInfosByPage(queryFreightforwardingInfo);
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<Integer> count(QueryFreightforwardingInfo queryFreightforwardingInfo) {
		Result<Integer> result = new Result<Integer>();
		try {	
			result.addDefaultModel(freightforwardingInfoManager.count(queryFreightforwardingInfo));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
	
}
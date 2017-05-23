package com.fuhuadata.service.impl;
import java.util.List;

import com.fuhuadata.domain.Freightforwarding;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.service.FreightforwardingInfoService;
import com.fuhuadata.domain.query.QueryFreightforwardingInfo;
import com.fuhuadata.manager.FreightforwardingInfoManager;
import javax.annotation.Resource;

/**
 * @author wangbo
 * @date 2017-01-16 15:25:40
 */
public class FreightforwardingInfoServiceImpl implements FreightforwardingInfoService {
	
	@Resource
    private FreightforwardingInfoManager freightforwardingInfoManager;
    public Result<Freightforwarding> addFreightforwardingInfo(Freightforwarding freightforwarding) {
		Result<Freightforwarding> result = new Result<Freightforwarding>();
		try {
			result.addDefaultModel(freightforwardingInfoManager.addFreightforwardingInfo(freightforwarding));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result updateFreightforwardingInfoById(String customer_id, Freightforwarding freightforwarding) {
		Result result = new Result();
		try {
			result.setSuccess(freightforwardingInfoManager.updateFreightforwardingInfoById(customer_id, freightforwarding));
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
    	
    public Result<List<Freightforwarding>> getFreightforwardingInfosByQuery(QueryFreightforwardingInfo queryFreightforwardingInfo) {
		Result<List<Freightforwarding>> result = new Result<List<Freightforwarding>>();
		try {
			result.addDefaultModel("${!className}s", freightforwardingInfoManager.getFreightforwardingInfosByQuery(queryFreightforwardingInfo));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<Freightforwarding> getFreightforwardingInfoById(String customer_id) {
		Result<Freightforwarding> result = new Result<Freightforwarding>();
		try {		
		    Freightforwarding freightforwarding = freightforwardingInfoManager.getFreightforwardingInfoById(customer_id);
		    if(freightforwarding == null){
				result.setSimpleErrorMsg(0, "当前数据不存在，请重试");
			}else{
				result.addDefaultModel("Freightforwarding", freightforwarding);
			}
			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    

    public Result<List<Freightforwarding>> getFreightforwardingInfosByPage(QueryFreightforwardingInfo queryFreightforwardingInfo) {
		Result<List<Freightforwarding>> result = new Result<List<Freightforwarding>>();
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
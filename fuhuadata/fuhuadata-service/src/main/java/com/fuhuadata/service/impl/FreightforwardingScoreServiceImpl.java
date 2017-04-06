package com.fuhuadata.service.impl;
import com.fuhuadata.domain.FreightforwardingScore;
import com.fuhuadata.manager.FreightforwardingScoreManager;
import com.fuhuadata.domain.query.QueryFreightforwardingScore;
import com.fuhuadata.service.FreightforwardingScoreService;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import javax.annotation.Resource;

/**
 * @author wangbo
 * @date 2017-01-16 16:22:49
 */
public class FreightforwardingScoreServiceImpl implements FreightforwardingScoreService {
	
	@Resource
    private FreightforwardingScoreManager freightforwardingScoreManager;
    public Result<FreightforwardingScore> addFreightforwardingScore(FreightforwardingScore freightforwardingScore) {
		Result<FreightforwardingScore> result = new Result<FreightforwardingScore>();
		try {
			result.addDefaultModel(freightforwardingScoreManager.addFreightforwardingScore(freightforwardingScore));			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result updateFreightforwardingScoreById(int id, FreightforwardingScore freightforwardingScore) {
		Result result = new Result();
		try {
			result.setSuccess(freightforwardingScoreManager.updateFreightforwardingScoreById(id, freightforwardingScore));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result deleteFreightforwardingScoreById(int id) {
		Result result = new Result();
		try {
			result.setSuccess(freightforwardingScoreManager.deleteFreightforwardingScoreById(id));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }	
    	
    public Result<List<FreightforwardingScore>> getFreightforwardingScoresByQuery(QueryFreightforwardingScore queryFreightforwardingScore) {
		Result<List<FreightforwardingScore>> result = new Result<List<FreightforwardingScore>>();
		try {
			result.addDefaultModel("${!className}s", freightforwardingScoreManager.getFreightforwardingScoresByQuery(queryFreightforwardingScore));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<FreightforwardingScore> getFreightforwardingScoreById(int id) {
		Result<FreightforwardingScore> result = new Result<FreightforwardingScore>();
		try {		
		    FreightforwardingScore  freightforwardingScore = freightforwardingScoreManager.getFreightforwardingScoreById(id);
		    if(freightforwardingScore == null){
				result.setSimpleErrorMsg(0, "当前数据不存在，请重试");
			}else{
				result.addDefaultModel("FreightforwardingScore", freightforwardingScore);
			}
			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    

    public Result<List<FreightforwardingScore>> getFreightforwardingScoresByPage(QueryFreightforwardingScore queryFreightforwardingScore) {
		Result<List<FreightforwardingScore>> result = new Result<List<FreightforwardingScore>>();
		try {		
			result = freightforwardingScoreManager.getFreightforwardingScoresByPage(queryFreightforwardingScore);
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<Integer> count(QueryFreightforwardingScore queryFreightforwardingScore) {
		Result<Integer> result = new Result<Integer>();
		try {	
			result.addDefaultModel(freightforwardingScoreManager.count(queryFreightforwardingScore));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
	
}
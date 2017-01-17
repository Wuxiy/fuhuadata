package com.fuhuadata.manager.impl;
import com.fuhuadata.domain.FreightforwardingScore;
import com.fuhuadata.manager.FreightforwardingScoreManager;
import com.fuhuadata.domain.query.QueryFreightforwardingScore;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.dao.FreightforwardingScoreDao;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

/**
 * @author wangbo
 * @date 2017-01-16 16:22:49
 */
public class FreightforwardingScoreManagerImpl implements FreightforwardingScoreManager {

	@Resource
    private FreightforwardingScoreDao freightforwardingScoreDao;
    

    public FreightforwardingScore addFreightforwardingScore(FreightforwardingScore freightforwardingScore) {
    	return freightforwardingScoreDao.addFreightforwardingScore(freightforwardingScore);
    }
    
    public boolean updateFreightforwardingScoreById(int id, FreightforwardingScore freightforwardingScore) {
    	return freightforwardingScoreDao.updateFreightforwardingScoreById(id, freightforwardingScore) == 1 ? true : false;
    }
    
	public List<FreightforwardingScore> getFreightforwardingScoresByQuery(QueryFreightforwardingScore queryFreightforwardingScore) {
		return freightforwardingScoreDao.getFreightforwardingScoresByQuery(queryFreightforwardingScore);
	}

    public boolean deleteFreightforwardingScoreById(int id) {
    	return freightforwardingScoreDao.deleteFreightforwardingScoreById(id) == 1 ? true : false;
    }
    
    
    public List<FreightforwardingScore> getAllFreightforwardingScores() {
    	return freightforwardingScoreDao.getAllFreightforwardingScores();
    }
    	
    public Result<List<FreightforwardingScore>> getFreightforwardingScoresByPage(QueryFreightforwardingScore queryFreightforwardingScore) {
		Result<List<FreightforwardingScore>> result = new Result<List<FreightforwardingScore>>();
		int totalItem = freightforwardingScoreDao.count(queryFreightforwardingScore);
		;
		if (totalItem > 0) {
			result.addDefaultModel("FreightforwardingScores", freightforwardingScoreDao.getFreightforwardingScoresByPage(queryFreightforwardingScore));		
		} else {
			result.addDefaultModel("FreightforwardingScores", new ArrayList<FreightforwardingScore>());
		}
		
		result.setPageSize(queryFreightforwardingScore.getPageSize());
		result.setIndex(queryFreightforwardingScore.getIndex());
		result.setTotalItem(totalItem);
		
		return result;
    }
    	
    	
    public FreightforwardingScore getFreightforwardingScoreById(int id) {
    	return freightforwardingScoreDao.getFreightforwardingScoreById(id);
    }
    

    public int count(QueryFreightforwardingScore queryFreightforwardingScore) {
    	return freightforwardingScoreDao.count(queryFreightforwardingScore);
    }
    
}
package com.fuhuadata.dao.impl;
import com.fuhuadata.domain.FreightforwardingScore;
import com.fuhuadata.domain.query.QueryFreightforwardingScore;
import java.util.List;
import com.fuhuadata.dao.FreightforwardingScoreDao;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
/**
 * @author wangbo
 * @date 2017-01-16 16:22:49
 */
@SuppressWarnings("unchecked")
public class FreightforwardingScoreDaoImpl extends SqlMapClientTemplate implements FreightforwardingScoreDao {

    public static final String ADD = "FREIGHTFORWARDINGSCORE.ADD";
    public static final String UPDATE = "FREIGHTFORWARDINGSCORE.UPDATE";
    public static final String DELETE_BY_ID = "FREIGHTFORWARDINGSCORE.DELETE-BY-ID";
    public static final String GET_ALL = "FREIGHTFORWARDINGSCORE.GET-ALL";
    public static final String GET_BY_QUERY = "FREIGHTFORWARDINGSCORE.GET-BY-QUERY";
    public static final String GET_BY_ID = "FREIGHTFORWARDINGSCORE.GET-BY-ID";
    public static final String GET_PAGE = "FREIGHTFORWARDINGSCORE.GET-PAGE";
    public static final String COUNT = "FREIGHTFORWARDINGSCORE.COUNT";
    
    public FreightforwardingScore addFreightforwardingScore(FreightforwardingScore freightforwardingScore) {
		freightforwardingScore.setId((Integer) this.insert(ADD, freightforwardingScore));
    	return freightforwardingScore;
    }
    
    public int updateFreightforwardingScoreById(int id, FreightforwardingScore freightforwardingScore) {
    	freightforwardingScore.setId(id);
		return this.update(UPDATE, freightforwardingScore);
    }
    
    public int deleteFreightforwardingScoreById(int id) {
    	return this.update(DELETE_BY_ID, id);
    }
    
    public List<FreightforwardingScore> getAllFreightforwardingScores() {
    	return this.queryForList(GET_ALL);
    }
    	
    public List<FreightforwardingScore> getFreightforwardingScoresByQuery(QueryFreightforwardingScore queryFreightforwardingScore) {
    	return this.queryForList(GET_BY_QUERY, queryFreightforwardingScore);
    }
    	
    public FreightforwardingScore getFreightforwardingScoreById(int id) {
    	return (FreightforwardingScore) this.queryForObject(GET_BY_ID, id);
    }
    
    public List<FreightforwardingScore> getFreightforwardingScoresByPage(QueryFreightforwardingScore queryFreightforwardingScore) {
    	return this.queryForList(GET_PAGE, queryFreightforwardingScore);
    }
    	
    public int count(QueryFreightforwardingScore queryFreightforwardingScore) {
    	return ((Integer) this.queryForObject(COUNT, queryFreightforwardingScore)).intValue();
    }
}
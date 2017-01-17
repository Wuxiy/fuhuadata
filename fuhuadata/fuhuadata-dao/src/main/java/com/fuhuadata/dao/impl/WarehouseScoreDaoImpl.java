package com.fuhuadata.dao.impl;
import java.util.List;
import com.fuhuadata.domain.WarehouseScore;
import com.fuhuadata.dao.WarehouseScoreDao;
import com.fuhuadata.domain.query.QueryWarehouseScore;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import java.util.Map;
import java.io.Serializable;
/**
 * @author wangbo
 * @date 2017-01-17 15:17:14
 */
@SuppressWarnings("unchecked")
public class WarehouseScoreDaoImpl extends SqlMapClientTemplate implements WarehouseScoreDao {

    public static final String ADD = "WAREHOUSESCORE.ADD";
    public static final String UPDATE = "WAREHOUSESCORE.UPDATE";
    public static final String DELETE_BY_ID = "WAREHOUSESCORE.DELETE-BY-ID";
    public static final String GET_ALL = "WAREHOUSESCORE.GET-ALL";
    public static final String GET_BY_QUERY = "WAREHOUSESCORE.GET-BY-QUERY";
    public static final String GET_BY_ID = "WAREHOUSESCORE.GET-BY-ID";
    public static final String GET_PAGE = "WAREHOUSESCORE.GET-PAGE";
    public static final String COUNT = "WAREHOUSESCORE.COUNT";
    
    public WarehouseScore addWarehouseScore(WarehouseScore warehouseScore) {
		warehouseScore.setId((Integer) this.insert(ADD, warehouseScore));
    	return warehouseScore;
    }
    
    public int updateWarehouseScoreById(int id, WarehouseScore warehouseScore) {
    	warehouseScore.setId(id);
		return this.update(UPDATE, warehouseScore);
    }
    
    public int deleteWarehouseScoreById(int id) {
    	return this.update(DELETE_BY_ID, id);
    }
    
    public List<WarehouseScore> getAllWarehouseScores() {
    	return this.queryForList(GET_ALL);
    }
    	
    public List<WarehouseScore> getWarehouseScoresByQuery(QueryWarehouseScore queryWarehouseScore) {
    	return this.queryForList(GET_BY_QUERY, queryWarehouseScore);
    }
    	
    public WarehouseScore getWarehouseScoreById(int id) {
    	return (WarehouseScore) this.queryForObject(GET_BY_ID, id);
    }
    
    public List<WarehouseScore> getWarehouseScoresByPage(QueryWarehouseScore queryWarehouseScore) {
    	return this.queryForList(GET_PAGE, queryWarehouseScore);
    }
    	
    public int count(QueryWarehouseScore queryWarehouseScore) {
    	return ((Integer) this.queryForObject(COUNT, queryWarehouseScore)).intValue();
    }
}
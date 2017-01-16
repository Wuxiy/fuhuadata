package com.fuhuadata.dao.impl;
import com.fuhuadata.dao.WarehouseInfoDao;
import java.util.List;
import com.fuhuadata.domain.WarehouseInfo;
import com.fuhuadata.domain.query.QueryWarehouseInfo;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
/**
 * @author wangbo
 * @date 2017-01-16 17:17:06
 */
@SuppressWarnings("unchecked")
@Component
public class WarehouseInfoDaoImpl extends SqlMapClientTemplate implements WarehouseInfoDao {

    public static final String ADD = "WAREHOUSEINFO.ADD";
    public static final String UPDATE = "WAREHOUSEINFO.UPDATE";
    public static final String DELETE_BY_ID = "WAREHOUSEINFO.DELETE-BY-ID";
    public static final String GET_ALL = "WAREHOUSEINFO.GET-ALL";
    public static final String GET_BY_QUERY = "WAREHOUSEINFO.GET-BY-QUERY";
    public static final String GET_BY_ID = "WAREHOUSEINFO.GET-BY-ID";
    public static final String GET_PAGE = "WAREHOUSEINFO.GET-PAGE";
    public static final String COUNT = "WAREHOUSEINFO.COUNT";
    
    public WarehouseInfo addWarehouseInfo(WarehouseInfo warehouseInfo) {
		warehouseInfo.setCustomerId((String) this.insert(ADD, warehouseInfo));
    	return warehouseInfo;
    }
    
    public int updateWarehouseInfoById(String customer_id, WarehouseInfo warehouseInfo) {
    	warehouseInfo.setCustomerId(customer_id);
		return this.update(UPDATE, warehouseInfo);
    }
    
    public int deleteWarehouseInfoById(String customer_id) {
    	return this.update(DELETE_BY_ID, customer_id);
    }
    
    public List<WarehouseInfo> getAllWarehouseInfos() {
    	return this.queryForList(GET_ALL);
    }
    	
    public List<WarehouseInfo> getWarehouseInfosByQuery(QueryWarehouseInfo queryWarehouseInfo) {
    	return this.queryForList(GET_BY_QUERY, queryWarehouseInfo);
    }
    	
    public WarehouseInfo getWarehouseInfoById(String customer_id) {
    	return (WarehouseInfo) this.queryForObject(GET_BY_ID, customer_id);
    }
    
    public List<WarehouseInfo> getWarehouseInfosByPage(QueryWarehouseInfo queryWarehouseInfo) {
    	return this.queryForList(GET_PAGE, queryWarehouseInfo);
    }
    	
    public int count(QueryWarehouseInfo queryWarehouseInfo) {
    	return ((Integer) this.queryForObject(COUNT, queryWarehouseInfo)).intValue();
    }
}
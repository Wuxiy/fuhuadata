package com.fuhuadata.dao.impl;
import java.util.List;
import com.fuhuadata.domain.query.QueryFreightforwardingInfo;
import com.fuhuadata.domain.FreightforwardingInfo;
import com.fuhuadata.dao.FreightforwardingInfoDao;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
/**
 * @author wangbo
 * @date 2017-01-16 15:25:40
 */
@SuppressWarnings("unchecked")
public class FreightforwardingInfoDaoImpl extends SqlMapClientTemplate implements FreightforwardingInfoDao {

    public static final String ADD = "FREIGHTFORWARDINGINFO.ADD";
    public static final String UPDATE = "FREIGHTFORWARDINGINFO.UPDATE";
    public static final String DELETE_BY_ID = "FREIGHTFORWARDINGINFO.DELETE-BY-ID";
    public static final String GET_ALL = "FREIGHTFORWARDINGINFO.GET-ALL";
    public static final String GET_BY_QUERY = "FREIGHTFORWARDINGINFO.GET-BY-QUERY";
    public static final String GET_BY_ID = "FREIGHTFORWARDINGINFO.GET-BY-ID";
    public static final String GET_PAGE = "FREIGHTFORWARDINGINFO.GET-PAGE";
    public static final String COUNT = "FREIGHTFORWARDINGINFO.COUNT";
    
    public FreightforwardingInfo addFreightforwardingInfo(FreightforwardingInfo freightforwardingInfo) {
		freightforwardingInfo.setCustomerId((String) this.insert(ADD, freightforwardingInfo));
    	return freightforwardingInfo;
    }
    
    public int updateFreightforwardingInfoById(String customer_id, FreightforwardingInfo freightforwardingInfo) {
    	freightforwardingInfo.setCustomerId(customer_id);
		return this.update(UPDATE, freightforwardingInfo);
    }
    
    public int deleteFreightforwardingInfoById(String customer_id) {
    	return this.update(DELETE_BY_ID, customer_id);
    }
    
    public List<FreightforwardingInfo> getAllFreightforwardingInfos() {
    	return this.queryForList(GET_ALL);
    }
    	
    public List<FreightforwardingInfo> getFreightforwardingInfosByQuery(QueryFreightforwardingInfo queryFreightforwardingInfo) {
    	return this.queryForList(GET_BY_QUERY, queryFreightforwardingInfo);
    }
    	
    public FreightforwardingInfo getFreightforwardingInfoById(String customer_id) {
    	return (FreightforwardingInfo) this.queryForObject(GET_BY_ID, customer_id);
    }
    
    public List<FreightforwardingInfo> getFreightforwardingInfosByPage(QueryFreightforwardingInfo queryFreightforwardingInfo) {
    	return this.queryForList(GET_PAGE, queryFreightforwardingInfo);
    }
    	
    public int count(QueryFreightforwardingInfo queryFreightforwardingInfo) {
    	return ((Integer) this.queryForObject(COUNT, queryFreightforwardingInfo)).intValue();
    }
}
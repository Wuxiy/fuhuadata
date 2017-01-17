package com.fuhuadata.dao.impl;
import com.fuhuadata.domain.query.QueryProduceFactoryInfo;
import java.util.List;
import com.fuhuadata.domain.ProduceFactoryInfo;
import com.fuhuadata.dao.ProduceFactoryInfoDao;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import java.util.Map;
import java.io.Serializable;
/**
 * @author wangbo
 * @date 2017-01-16 11:10:51
 */
@SuppressWarnings("unchecked")
public class ProduceFactoryInfoDaoImpl extends SqlMapClientTemplate implements ProduceFactoryInfoDao {

    public static final String ADD = "PRODUCEFACTORYINFO.ADD";
    public static final String UPDATE = "PRODUCEFACTORYINFO.UPDATE";
    public static final String DELETE_BY_ID = "PRODUCEFACTORYINFO.DELETE-BY-ID";
    public static final String GET_ALL = "PRODUCEFACTORYINFO.GET-ALL";
    public static final String GET_BY_QUERY = "PRODUCEFACTORYINFO.GET-BY-QUERY";
    public static final String GET_BY_ID = "PRODUCEFACTORYINFO.GET-BY-ID";
    public static final String GET_PAGE = "PRODUCEFACTORYINFO.GET-PAGE";
    public static final String COUNT = "PRODUCEFACTORYINFO.COUNT";
    
    public ProduceFactoryInfo addProduceFactoryInfo(ProduceFactoryInfo produceFactoryInfo) {
		produceFactoryInfo.setCustomerId((String) this.insert(ADD, produceFactoryInfo));
    	return produceFactoryInfo;
    }
    
    public int updateProduceFactoryInfoById(String customer_id, ProduceFactoryInfo produceFactoryInfo) {
    	produceFactoryInfo.setCustomerId(customer_id);
		return this.update(UPDATE, produceFactoryInfo);
    }
    
    public int deleteProduceFactoryInfoById(String customer_id) {
    	return this.update(DELETE_BY_ID, customer_id);
    }
    
    public List<ProduceFactoryInfo> getAllProduceFactoryInfos() {
    	return this.queryForList(GET_ALL);
    }
    	
    public List<ProduceFactoryInfo> getProduceFactoryInfosByQuery(QueryProduceFactoryInfo queryProduceFactoryInfo) {
    	return this.queryForList(GET_BY_QUERY, queryProduceFactoryInfo);
    }
    	
    public ProduceFactoryInfo getProduceFactoryInfoById(String customer_id) {
    	return (ProduceFactoryInfo) this.queryForObject(GET_BY_ID, customer_id);
    }
    
    public List<ProduceFactoryInfo> getProduceFactoryInfosByPage(QueryProduceFactoryInfo queryProduceFactoryInfo) {
    	return this.queryForList(GET_PAGE, queryProduceFactoryInfo);
    }
    	
    public int count(QueryProduceFactoryInfo queryProduceFactoryInfo) {
    	return ((Integer) this.queryForObject(COUNT, queryProduceFactoryInfo)).intValue();
    }
}
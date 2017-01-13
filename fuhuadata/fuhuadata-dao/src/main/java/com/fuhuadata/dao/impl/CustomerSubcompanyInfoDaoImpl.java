package com.fuhuadata.dao.impl;
import java.util.List;
import com.fuhuadata.dao.CustomerSubcompanyInfoDao;
import com.fuhuadata.domain.query.QueryCustomerSubcompanyInfo;
import com.fuhuadata.domain.CustomerSubcompanyInfo;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import java.util.Map;
import java.io.Serializable;
/**
 * @author wangbo
 * @date 2017-01-12 13:37:25
 */
@SuppressWarnings("unchecked")
@Component
public class CustomerSubcompanyInfoDaoImpl extends SqlMapClientTemplate implements CustomerSubcompanyInfoDao {

    public static final String ADD = "CUSTOMERSUBCOMPANYINFO.ADD";
    public static final String UPDATE = "CUSTOMERSUBCOMPANYINFO.UPDATE";
    public static final String DELETE_BY_ID = "CUSTOMERSUBCOMPANYINFO.DELETE-BY-ID";
    public static final String GET_ALL = "CUSTOMERSUBCOMPANYINFO.GET-ALL";
    public static final String GET_BY_QUERY = "CUSTOMERSUBCOMPANYINFO.GET-BY-QUERY";
    public static final String GET_BY_ID = "CUSTOMERSUBCOMPANYINFO.GET-BY-ID";
    public static final String GET_PAGE = "CUSTOMERSUBCOMPANYINFO.GET-PAGE";
    public static final String COUNT = "CUSTOMERSUBCOMPANYINFO.COUNT";
    
    public CustomerSubcompanyInfo addCustomerSubcompanyInfo(CustomerSubcompanyInfo customerSubcompanyInfo) {
		customerSubcompanyInfo.setCustomerSubId((String) this.insert(ADD, customerSubcompanyInfo));
    	return customerSubcompanyInfo;
    }
    
    public int updateCustomerSubcompanyInfoById(String customer_sub_id, CustomerSubcompanyInfo customerSubcompanyInfo) {
    	customerSubcompanyInfo.setCustomerSubId(customer_sub_id);
		return this.update(UPDATE, customerSubcompanyInfo);
    }
    
    public int deleteCustomerSubcompanyInfoById(String customer_sub_id) {
    	return this.update(DELETE_BY_ID, customer_sub_id);
    }
    
    public List<CustomerSubcompanyInfo> getAllCustomerSubcompanyInfos() {
    	return this.queryForList(GET_ALL);
    }
    	
    public List<CustomerSubcompanyInfo> getCustomerSubcompanyInfosByQuery(QueryCustomerSubcompanyInfo queryCustomerSubcompanyInfo) {
    	return this.queryForList(GET_BY_QUERY, queryCustomerSubcompanyInfo);
    }
    	
    public CustomerSubcompanyInfo getCustomerSubcompanyInfoById(String customer_sub_id) {
    	return (CustomerSubcompanyInfo) this.queryForObject(GET_BY_ID, customer_sub_id);
    }
    
    public List<CustomerSubcompanyInfo> getCustomerSubcompanyInfosByPage(QueryCustomerSubcompanyInfo queryCustomerSubcompanyInfo) {
    	return this.queryForList(GET_PAGE, queryCustomerSubcompanyInfo);
    }
    	
    public int count(QueryCustomerSubcompanyInfo queryCustomerSubcompanyInfo) {
    	return ((Integer) this.queryForObject(COUNT, queryCustomerSubcompanyInfo)).intValue();
    }
}
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
public class CustomerSubcompanyInfoDaoImpl extends SqlMapClientTemplate implements CustomerSubcompanyInfoDao {

    public static final String ADD = "CUSTOMERSUBCOMPANYINFO.ADD";
    public static final String UPDATE = "CUSTOMERSUBCOMPANYINFO.UPDATE";
    public static final String DELETE_BY_ID = "CUSTOMERSUBCOMPANYINFO.DELETE-BY-ID";
    public static final String GET_ALL = "CUSTOMERSUBCOMPANYINFO.GET-ALL";
    public static final String GET_BY_QUERY = "CUSTOMERSUBCOMPANYINFO.GET-BY-QUERY";
    public static final String GET_BY_ID = "CUSTOMERSUBCOMPANYINFO.GET-BY-ID";
    public static final String GET_PAGE = "CUSTOMERSUBCOMPANYINFO.GET-PAGE";
    public static final String COUNT = "CUSTOMERSUBCOMPANYINFO.COUNT";
    public static final String  GET_BY_CUSTOMER_ID  = "CUSTOMERSUBCOMPANYINFO.GET-BY-CUSTOMER-ID";
    public static final String  GET_MAX_SUBID_BY_CUSTOMERID = "CUSTOMERSUBCOMPANYINFO.GET-MAX-SUBID-BY-CUSTOMERID";
    
    public CustomerSubcompanyInfo addCustomerSubcompanyInfo(CustomerSubcompanyInfo customerSubcompanyInfo) {
		customerSubcompanyInfo.setCustomerSubId((Integer) this.insert(ADD, customerSubcompanyInfo));
    	return customerSubcompanyInfo;
    }
    
    public int updateCustomerSubcompanyInfoById(int customer_sub_id, CustomerSubcompanyInfo customerSubcompanyInfo) {
    	customerSubcompanyInfo.setCustomerSubId(customer_sub_id);
		return this.update(UPDATE, customerSubcompanyInfo);
    }
    
    public int deleteCustomerSubcompanyInfoById(int customer_sub_id) {
    	return this.update(DELETE_BY_ID, customer_sub_id);
    }
    
    public List<CustomerSubcompanyInfo> getAllCustomerSubcompanyInfos() {
    	return this.queryForList(GET_ALL);
    }
    	
    public List<CustomerSubcompanyInfo> getCustomerSubcompanyInfosByQuery(QueryCustomerSubcompanyInfo queryCustomerSubcompanyInfo) {
    	return this.queryForList(GET_BY_QUERY, queryCustomerSubcompanyInfo);
    }
    	
    public CustomerSubcompanyInfo getCustomerSubcompanyInfoById(int customer_sub_id) {
    	return (CustomerSubcompanyInfo) this.queryForObject(GET_BY_ID, customer_sub_id);
    }

    @Override
    public String getMaxCustomerSubIdByCustomerId(String customerId) {
        return (String)this.queryForObject(GET_MAX_SUBID_BY_CUSTOMERID,customerId);
    }

    @Override
    public List<CustomerSubcompanyInfo> getCustomerSubcompanyInfoByCustomerId(String customerId) {
        return this.queryForList(GET_BY_CUSTOMER_ID,customerId);
    }

    public List<CustomerSubcompanyInfo> getCustomerSubcompanyInfosByPage(QueryCustomerSubcompanyInfo queryCustomerSubcompanyInfo) {
    	return this.queryForList(GET_PAGE, queryCustomerSubcompanyInfo);
    }
    	
    public int count(QueryCustomerSubcompanyInfo queryCustomerSubcompanyInfo) {
    	return ((Integer) this.queryForObject(COUNT, queryCustomerSubcompanyInfo)).intValue();
    }
}
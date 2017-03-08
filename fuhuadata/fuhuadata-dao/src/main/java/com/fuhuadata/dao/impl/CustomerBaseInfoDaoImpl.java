package com.fuhuadata.dao.impl;
import java.util.List;

import com.fuhuadata.domain.CustomerBaseInfo;
import com.fuhuadata.dao.CustomerBaseInfoDao;
import com.fuhuadata.domain.query.QueryCustomerBaseInfo;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

/**
 * @author wangbo
 * @date 2017-01-12 11:49:51
 */
@SuppressWarnings("unchecked")
public class CustomerBaseInfoDaoImpl extends SqlMapClientTemplate implements CustomerBaseInfoDao {

    public static final String ADD = "CUSTOMERBASEINFO.ADD";
    public static final String UPDATE = "CUSTOMERBASEINFO.UPDATE";
    public static final String DELETE_BY_ID = "CUSTOMERBASEINFO.DELETE-BY-ID";
    public static final String GET_ALL = "CUSTOMERBASEINFO.GET-ALL";
    public static final String GET_BY_QUERY = "CUSTOMERBASEINFO.GET-BY-QUERY";
    public static final String GET_BY_ID = "CUSTOMERBASEINFO.GET-BY-ID";
    public static final String GET_PAGE = "CUSTOMERBASEINFO.GET-PAGE";
    public static final String COUNT = "CUSTOMERBASEINFO.COUNT";
    
    public CustomerBaseInfo addCustomerParent(CustomerBaseInfo customerParent) {
		customerParent.setCustomerId((String) this.insert(ADD, customerParent));
    	return customerParent;
    }
    
    public int updateCustomerParentById(String customer_id, CustomerBaseInfo customerParent) {
    	customerParent.setCustomerId(customer_id);
		return this.update(UPDATE, customerParent);
}

    public int deleteCustomerParentById(String customer_id) {
    	return this.update(DELETE_BY_ID, customer_id);
    }
    
    public List<CustomerBaseInfo> getAllCustomerParents() {
    	return this.queryForList(GET_ALL);
    }
    	
    public List<CustomerBaseInfo> getCustomerParentsByQuery(QueryCustomerBaseInfo queryCustomerParent) {
    	return this.queryForList(GET_BY_QUERY, queryCustomerParent);
    }
    	
    public CustomerBaseInfo getCustomerParentById(String customer_id) {
    	return (CustomerBaseInfo) this.queryForObject(GET_BY_ID, customer_id);
    }
    
    public List<CustomerBaseInfo> getCustomerParentsByPage(QueryCustomerBaseInfo queryCustomerParent) {
    	return this.queryForList(GET_PAGE, queryCustomerParent);
    }

    public int count(QueryCustomerBaseInfo queryCustomerParent) {
    	return ((Integer) this.queryForObject(COUNT, queryCustomerParent)).intValue();
    }
}
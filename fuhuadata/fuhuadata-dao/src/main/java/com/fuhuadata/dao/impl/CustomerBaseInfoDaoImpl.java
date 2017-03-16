package com.fuhuadata.dao.impl;
import java.util.List;

import com.fuhuadata.domain.CountCustomersOrderProduct;
import com.fuhuadata.domain.CustomerBaseInfo;
import com.fuhuadata.dao.CustomerBaseInfoDao;
import com.fuhuadata.domain.query.QueryCustomerBaseInfo;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author wangbo
 * @date 2017-01-12 11:49:51
 */
public class CustomerBaseInfoDaoImpl extends SqlMapClientTemplate implements CustomerBaseInfoDao {

    public static final String ADD = "CUSTOMERBASEINFO.ADD";
    public static final String UPDATE = "CUSTOMERBASEINFO.UPDATE";
    public static final String DELETE_BY_ID = "CUSTOMERBASEINFO.DELETE-BY-ID";
    public static final String GET_ALL = "CUSTOMERBASEINFO.GET-ALL";
    public static final String GET_BY_QUERY = "CUSTOMERBASEINFO.GET-BY-QUERY";
    public static final String GET_BY_ID = "CUSTOMERBASEINFO.GET-BY-ID";
    public static final String GET_PAGE = "CUSTOMERBASEINFO.GET-PAGE";
    public static final String COUNT = "CUSTOMERBASEINFO.COUNT";
    public static final String COUNT_ORDER = "CUSTOMERBASEINFO.countOrderByCustomer";
    public static final String COUNT_ORDER_PRODUCT = "CUSTOMERBASEINFO.countOrderProduct";
    public static final String QUERY_COOPERATION = "CUSTOMERBASEINFO.queryCooperationByCid";
    public CustomerBaseInfo addCustomerBaseInfo(CustomerBaseInfo customerBaseInfo) {
		customerBaseInfo.setCustomerId((String) this.insert(ADD, customerBaseInfo));
    	return customerBaseInfo;
    }
    
    public int updateCustomerBaseInfoById(String customer_id, CustomerBaseInfo customerBaseInfo) {
    	customerBaseInfo.setCustomerId(customer_id);
		return this.update(UPDATE, customerBaseInfo);
}

    public int deleteCustomerBaseInfoById(String customer_id) {
    	return this.update(DELETE_BY_ID, customer_id);
    }
    
    public List<CustomerBaseInfo> getAllCustomerBaseInfos() {
    	return this.queryForList(GET_ALL);
    }
    	
    public List<CustomerBaseInfo> getCustomerBaseInfosByQuery(QueryCustomerBaseInfo queryCustomerBaseInfo) {
    	return this.queryForList(GET_BY_QUERY, queryCustomerBaseInfo);
    }
    	
    public CustomerBaseInfo getCustomerBaseInfoById(String customer_id) {
    	return (CustomerBaseInfo) this.queryForObject(GET_BY_ID, customer_id);
    }
    
    public List<CustomerBaseInfo> getCustomerBaseInfoByPage(QueryCustomerBaseInfo queryCustomerBaseInfo) {
    	return this.queryForList(GET_PAGE, queryCustomerBaseInfo);
    }

    public int count(QueryCustomerBaseInfo queryCustomerBaseInfo) {
    	return ((Integer) this.queryForObject(COUNT, queryCustomerBaseInfo)).intValue();
    }

    public CustomerBaseInfo countOrderByCustomer(String customerId) {
        try {
            return (CustomerBaseInfo)this.queryForObject(COUNT_ORDER,customerId);
        } catch (DataAccessException e) {
           e.printStackTrace();
        }
        return null;
    }

    public List<CountCustomersOrderProduct> countOrderProduct(String customerId) {
        try {
            return  this.queryForList(COUNT_ORDER_PRODUCT,customerId);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CustomerBaseInfo queryCooperationByCid(String customerId){
        try {
            return (CustomerBaseInfo)this.queryForObject(QUERY_COOPERATION,customerId);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
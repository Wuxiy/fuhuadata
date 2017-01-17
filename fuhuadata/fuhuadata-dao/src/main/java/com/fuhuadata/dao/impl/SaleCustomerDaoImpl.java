package com.fuhuadata.dao.impl;
import java.util.List;
import com.fuhuadata.domain.query.QuerySaleCustomer;
import com.fuhuadata.domain.SaleCustomer;
import com.fuhuadata.dao.SaleCustomerDao;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import java.util.Map;
import java.io.Serializable;
/**
 * @author wangbo
 * @date 2017-01-12 13:27:44
 */
@SuppressWarnings("unchecked")
public class SaleCustomerDaoImpl extends SqlMapClientTemplate implements SaleCustomerDao {

    public static final String ADD = "SALECUSTOMER.ADD";
    public static final String UPDATE = "SALECUSTOMER.UPDATE";
    public static final String DELETE_BY_ID = "SALECUSTOMER.DELETE-BY-ID";
    public static final String GET_ALL = "SALECUSTOMER.GET-ALL";
    public static final String GET_BY_QUERY = "SALECUSTOMER.GET-BY-QUERY";
    public static final String GET_BY_ID = "SALECUSTOMER.GET-BY-ID";
    public static final String GET_PAGE = "SALECUSTOMER.GET-PAGE";
    public static final String COUNT = "SALECUSTOMER.COUNT";
    
    public SaleCustomer addSaleCustomer(SaleCustomer saleCustomer) {
		saleCustomer.setCustomerId((String) this.insert(ADD, saleCustomer));
    	return saleCustomer;
    }
    
    public int updateSaleCustomerById(String customer_id, SaleCustomer saleCustomer) {
    	saleCustomer.setCustomerId(customer_id);
		return this.update(UPDATE, saleCustomer);
    }
    
    public int deleteSaleCustomerById(String customer_id) {
    	return this.update(DELETE_BY_ID, customer_id);
    }
    
    public List<SaleCustomer> getAllSaleCustomers() {
    	return this.queryForList(GET_ALL);
    }
    	
    public List<SaleCustomer> getSaleCustomersByQuery(QuerySaleCustomer querySaleCustomer) {
    	return this.queryForList(GET_BY_QUERY, querySaleCustomer);
    }
    	
    public SaleCustomer getSaleCustomerById(String customer_id) {
    	return (SaleCustomer) this.queryForObject(GET_BY_ID, customer_id);
    }
    
    public List<SaleCustomer> getSaleCustomersByPage(QuerySaleCustomer querySaleCustomer) {
    	return this.queryForList(GET_PAGE, querySaleCustomer);
    }
    	
    public int count(QuerySaleCustomer querySaleCustomer) {
    	return ((Integer) this.queryForObject(COUNT, querySaleCustomer)).intValue();
    }
}
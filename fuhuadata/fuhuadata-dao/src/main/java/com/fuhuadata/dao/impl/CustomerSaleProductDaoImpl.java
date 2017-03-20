package com.fuhuadata.dao.impl;
import java.util.List;

import com.fuhuadata.dao.BaseDao;
import com.fuhuadata.domain.query.QueryCustomerSaleProduct;
import com.fuhuadata.dao.CustomerSaleProductDao;
import com.fuhuadata.domain.CustomerSaleProduct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import java.util.Map;
import java.io.Serializable;
/**
 * @author wangbo
 * @date 2017-01-12 13:41:04
 */
@SuppressWarnings("unchecked")
public class CustomerSaleProductDaoImpl  implements CustomerSaleProductDao {

    public static final String ADD = "CUSTOMERSALEPRODUCT.ADD";
    public static final String UPDATE = "CUSTOMERSALEPRODUCT.UPDATE";
    public static final String DELETE_BY_ID = "CUSTOMERSALEPRODUCT.DELETE-BY-ID";
    public static final String GET_ALL = "CUSTOMERSALEPRODUCT.GET-ALL";
    public static final String GET_BY_QUERY = "CUSTOMERSALEPRODUCT.GET-BY-QUERY";
    public static final String GET_BY_ID = "CUSTOMERSALEPRODUCT.GET-BY-ID";
    public static final String GET_PAGE = "CUSTOMERSALEPRODUCT.GET-PAGE";
    public static final String COUNT = "CUSTOMERSALEPRODUCT.COUNT";
    @Autowired
    private SqlMapClientTemplate sqlMapClientTemplate;
    public CustomerSaleProduct addCustomerSaleProduct(CustomerSaleProduct customerSaleProduct) {
		customerSaleProduct.setId((Integer) sqlMapClientTemplate.insert(ADD, customerSaleProduct));
    	return customerSaleProduct;
    }

    public boolean batchInsert(List<CustomerSaleProduct> customerSaleProducts) {
       return BaseDao.batch(sqlMapClientTemplate,ADD,customerSaleProducts);
    }

    public int updateCustomerSaleProductById(int id, CustomerSaleProduct customerSaleProduct) {
    	customerSaleProduct.setId(id);
		return sqlMapClientTemplate.update(UPDATE, customerSaleProduct);
    }
    
    public int deleteCustomerSaleProductById(int id) {
    	return sqlMapClientTemplate.update(DELETE_BY_ID, id);
    }
    
    public List<CustomerSaleProduct> getAllCustomerSaleProducts() {
    	return sqlMapClientTemplate.queryForList(GET_ALL);
    }
    	
    public List<CustomerSaleProduct> getCustomerSaleProductsByQuery(QueryCustomerSaleProduct queryCustomerSaleProduct) {
    	return sqlMapClientTemplate.queryForList(GET_BY_QUERY, queryCustomerSaleProduct);
    }
    	
    public CustomerSaleProduct getCustomerSaleProductById(int id) {
    	return (CustomerSaleProduct) sqlMapClientTemplate.queryForObject(GET_BY_ID, id);
    }
    
    public List<CustomerSaleProduct> getCustomerSaleProductsByPage(QueryCustomerSaleProduct queryCustomerSaleProduct) {
    	return sqlMapClientTemplate.queryForList(GET_PAGE, queryCustomerSaleProduct);
    }
    	
    public int count(QueryCustomerSaleProduct queryCustomerSaleProduct) {
    	return ((Integer) sqlMapClientTemplate.queryForObject(COUNT, queryCustomerSaleProduct)).intValue();
    }
}
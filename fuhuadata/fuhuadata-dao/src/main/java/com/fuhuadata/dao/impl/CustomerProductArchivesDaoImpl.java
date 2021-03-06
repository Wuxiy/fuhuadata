package com.fuhuadata.dao.impl;
import java.util.HashMap;
import java.util.List;
import com.fuhuadata.dao.CustomerProductArchivesDao;
import com.fuhuadata.domain.CustomerProductArchives;
import com.fuhuadata.domain.query.QueryCustomerProductArchives;

import com.fuhuadata.vo.CustomerProductPackagingArchives;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
/**
 * 客户产品档案
 * @author wangbo
 * @date 2017-02-03 15:51:13
 */
@SuppressWarnings("unchecked")
public class CustomerProductArchivesDaoImpl extends SqlMapClientTemplate implements CustomerProductArchivesDao {

    public static final String ADD = "CUSTOMERPRODUCTARCHIVES.ADD";
    public static final String UPDATE = "CUSTOMERPRODUCTARCHIVES.UPDATE-BY-ID";
    public static final String DELETE_BY_ID = "CUSTOMERPRODUCTARCHIVES.DELETE-BY-ID";
    public static final String GET_ALL = "CUSTOMERPRODUCTARCHIVES.GET-ALL";
    public static final String GET_BY_QUERY = "CUSTOMERPRODUCTARCHIVES.GET-BY-QUERY";
    public static final String GET_BY_ID = "CUSTOMERPRODUCTARCHIVES.GET-BY-ID";
    public static final String GET_PAGE = "CUSTOMERPRODUCTARCHIVES.GET-PAGE";
    public static final String COUNT = "CUSTOMERPRODUCTARCHIVES.COUNT";
    public static final String GET_CUSTOMER_PRODUCT_PACKAGING="CUSTOMERPRODUCTARCHIVES.GET-CUSTOMER-PRODUCT-PACKAGING";
    public static final String COUNT_CUSTOMER_PRODUCT_PACKAGING="CUSTOMERPRODUCTARCHIVES.COUNT-CUSTOMER-PRODUCT-PACKAGING";
    public static final String GET_CUSTOMER_PRODUCT_REQUIRE_BY_ID="CUSTOMERPRODUCTARCHIVES.GET-CUSTOMER-PRODUCT-REQUIRE-BY-ID";
    public static final String GET_CUSTOMER_BILL_REQUIREMENT = "CUSTOMERPRODUCTARCHIVES.GET-CUSTOMER-BILL-REQUIREMENT";
    public static final String GET_CUSTOMER_TRANSPORT_REQUIREMENT = "CUSTOMERPRODUCTARCHIVES.GET-CUSTOMER-TRANSPORT-REQUIREMENT";
    public static final String ADD_ARCHIVES = "CUSTOMERPRODUCTARCHIVES.addArchives";
    public static final String UPDATE_ARCHIVES = "CUSTOMERPRODUCTARCHIVES.updateArchives";
    public static final String GET_CUSTOMER_PRODUCT_IDS="CUSTOMERPRODUCTARCHIVES.GET-CUSTOMER-PRODUCT-IDS";
    public CustomerProductArchives addCustomerProductInfo(CustomerProductArchives customerProductArchives) {
		customerProductArchives.setId((Integer) this.insert(ADD, customerProductArchives));
    	return customerProductArchives;
    }
    
    public int updateCustomerProductInfoById(int customer_product_id, CustomerProductArchives customerProductArchives) {
    	customerProductArchives.setId(customer_product_id);
		return this.update(UPDATE, customerProductArchives);
    }
    
    public int deleteCustomerProductInfoById(int customer_product_id) {
    	return this.update(DELETE_BY_ID, customer_product_id);
    }
    
    public List<CustomerProductArchives> getAllCustomerProductInfos() {
    	return this.queryForList(GET_ALL);
    }
    	
    public List<CustomerProductArchives> getCustomerProductInfosByQuery(QueryCustomerProductArchives queryCustomerProductArchives) {
    	return this.queryForList(GET_BY_QUERY, queryCustomerProductArchives);
    }
    	
    public CustomerProductArchives getCustomerProductInfoById(int customer_product_id) {
        return (CustomerProductArchives) this.queryForObject(GET_BY_ID, customer_product_id);
    }

    /**
     * 知识库-客户产品包装要求
     * @param cppa
     * @return
     */
    @Override
    public List<CustomerProductPackagingArchives> getCustomerProductPackagingArchives(CustomerProductPackagingArchives cppa) {
            return this.queryForList(GET_CUSTOMER_PRODUCT_PACKAGING,cppa);
    }

    /**
     * 知识库-客户包装要求count
     * @param cppa
     * @return
     */
    public int countCustomerProductPackagingArchives(CustomerProductPackagingArchives cppa){
        return (Integer) this.queryForObject(COUNT_CUSTOMER_PRODUCT_PACKAGING,cppa);
    }

    public List<CustomerProductPackagingArchives> getCustomerProductPackingArchivesById(String customerId){
        return this.queryForList(GET_CUSTOMER_PRODUCT_REQUIRE_BY_ID,customerId);
    }

    @Override
    public CustomerProductPackagingArchives getCustomerProductIds(int id) {
            return (CustomerProductPackagingArchives)this.queryForObject(GET_CUSTOMER_PRODUCT_IDS,id);
    }

    public List<CustomerProductArchives> getCustomerProductInfosByPage(QueryCustomerProductArchives queryCustomerProductArchives) {
    	return this.queryForList(GET_PAGE, queryCustomerProductArchives);
    }
    	
    public int count(QueryCustomerProductArchives queryCustomerProductArchives) {
    	return ((Integer) this.queryForObject(COUNT, queryCustomerProductArchives)).intValue();
    }

    @Override
    public List<CustomerProductArchives> getCustomerBillRequirement(String customerId) {
        return this.queryForList(GET_CUSTOMER_BILL_REQUIREMENT,customerId);
    }

    @Override
    public List<CustomerProductArchives> getCustomerTransportRequirement(String customerId) {
        return this.queryForList(GET_CUSTOMER_TRANSPORT_REQUIREMENT,customerId);
    }

    @Override
    public int addArchives(Integer businessProductId) {
        return (Integer)this.insert(ADD_ARCHIVES,businessProductId);
    }

    @Override
    public int updateArchives(Integer businessProductId) {
        return this.update(UPDATE_ARCHIVES,businessProductId);
    }
}
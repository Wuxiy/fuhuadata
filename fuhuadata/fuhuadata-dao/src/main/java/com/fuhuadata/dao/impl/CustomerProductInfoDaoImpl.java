package com.fuhuadata.dao.impl;
import java.util.List;
import com.fuhuadata.dao.CustomerProductInfoDao;
import com.fuhuadata.domain.CustomerProductInfo;
import com.fuhuadata.domain.query.QueryCustomerProductInfo;
import javax.annotation.Resource;

import com.fuhuadata.vo.CustomerBaseInfoVO;
import com.fuhuadata.vo.CustomerProductPackagingArchives;
import org.springframework.stereotype.Component;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
/**
 * @author wangbo
 * @date 2017-02-03 15:51:13
 */
@SuppressWarnings("unchecked")
public class CustomerProductInfoDaoImpl extends SqlMapClientTemplate implements CustomerProductInfoDao {

    public static final String ADD = "CUSTOMERPRODUCTINFO.ADD";
    public static final String UPDATE = "CUSTOMERPRODUCTINFO.UPDATE";
    public static final String DELETE_BY_ID = "CUSTOMERPRODUCTINFO.DELETE-BY-ID";
    public static final String GET_ALL = "CUSTOMERPRODUCTINFO.GET-ALL";
    public static final String GET_BY_QUERY = "CUSTOMERPRODUCTINFO.GET-BY-QUERY";
    public static final String GET_BY_ID = "CUSTOMERPRODUCTINFO.GET-BY-ID";
    public static final String GET_PAGE = "CUSTOMERPRODUCTINFO.GET-PAGE";
    public static final String COUNT = "CUSTOMERPRODUCTINFO.COUNT";
    public static final String GET_CUSTOMER_PRODUCT_PACKAGING="CUSTOMERPRODUCTINFO.GET-CUSTOMER-PRODUCT-PACKAGING";
    public static final String GET_CUSTOMER_PRODUCT_REQUIRE_BY_ID="CUSTOMERPRODUCTINFO.GET-CUSTOMER-PRODUCT-REQUIRE-BY-ID";
    
    public CustomerProductInfo addCustomerProductInfo(CustomerProductInfo customerProductInfo) {
		customerProductInfo.setCustomerProductId((Integer) this.insert(ADD, customerProductInfo));
    	return customerProductInfo;
    }
    
    public int updateCustomerProductInfoById(int customer_product_id, CustomerProductInfo customerProductInfo) {
    	customerProductInfo.setCustomerProductId(customer_product_id);
		return this.update(UPDATE, customerProductInfo);
    }
    
    public int deleteCustomerProductInfoById(int customer_product_id) {
    	return this.update(DELETE_BY_ID, customer_product_id);
    }
    
    public List<CustomerProductInfo> getAllCustomerProductInfos() {
    	return this.queryForList(GET_ALL);
    }
    	
    public List<CustomerProductInfo> getCustomerProductInfosByQuery(QueryCustomerProductInfo queryCustomerProductInfo) {
    	return this.queryForList(GET_BY_QUERY, queryCustomerProductInfo);
    }
    	
    public CustomerProductInfo getCustomerProductInfoById(int customer_product_id) {
    	return (CustomerProductInfo) this.queryForObject(GET_BY_ID, customer_product_id);
    }

    @Override
    public List<CustomerProductPackagingArchives> getCustomerProductPackagingArchives() {
            return this.queryForList(GET_CUSTOMER_PRODUCT_PACKAGING);
    }

    public List<CustomerProductPackagingArchives> getCustomerProductPackingArchivesById(String customerId){
        return this.queryForList(GET_CUSTOMER_PRODUCT_REQUIRE_BY_ID,customerId);
    }

    public List<CustomerProductInfo> getCustomerProductInfosByPage(QueryCustomerProductInfo queryCustomerProductInfo) {
    	return this.queryForList(GET_PAGE, queryCustomerProductInfo);
    }
    	
    public int count(QueryCustomerProductInfo queryCustomerProductInfo) {
    	return ((Integer) this.queryForObject(COUNT, queryCustomerProductInfo)).intValue();
    }
}
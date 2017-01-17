package com.fuhuadata.dao.impl;
import java.util.List;
import com.fuhuadata.dao.CustomerPurchaseProductDao;
import com.fuhuadata.domain.CustomerPurchaseProduct;
import com.fuhuadata.domain.query.QueryCustomerPurchaseProduct;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import java.util.Map;
import java.io.Serializable;
/**
 * @author wangbo
 * @date 2017-01-12 13:51:34
 */
@SuppressWarnings("unchecked")
@Component
public class CustomerPurchaseProductDaoImpl extends SqlMapClientTemplate implements CustomerPurchaseProductDao {

    public static final String ADD = "CUSTOMERPURCHASEPRODUCT.ADD";
    public static final String UPDATE = "CUSTOMERPURCHASEPRODUCT.UPDATE";
    public static final String DELETE_BY_ID = "CUSTOMERPURCHASEPRODUCT.DELETE-BY-ID";
    public static final String GET_ALL = "CUSTOMERPURCHASEPRODUCT.GET-ALL";
    public static final String GET_BY_QUERY = "CUSTOMERPURCHASEPRODUCT.GET-BY-QUERY";
    public static final String GET_BY_ID = "CUSTOMERPURCHASEPRODUCT.GET-BY-ID";
    public static final String GET_PAGE = "CUSTOMERPURCHASEPRODUCT.GET-PAGE";
    public static final String COUNT = "CUSTOMERPURCHASEPRODUCT.COUNT";
    
    public CustomerPurchaseProduct addCustomerPurchaseProduct(CustomerPurchaseProduct customerPurchaseProduct) {
		customerPurchaseProduct.setId((Integer) this.insert(ADD, customerPurchaseProduct));
    	return customerPurchaseProduct;
    }
    
    public int updateCustomerPurchaseProductById(int id, CustomerPurchaseProduct customerPurchaseProduct) {
    	customerPurchaseProduct.setId(id);
		return this.update(UPDATE, customerPurchaseProduct);
    }
    
    public int deleteCustomerPurchaseProductById(int id) {
    	return this.update(DELETE_BY_ID, id);
    }
    
    public List<CustomerPurchaseProduct> getAllCustomerPurchaseProducts() {
    	return this.queryForList(GET_ALL);
    }
    	
    public List<CustomerPurchaseProduct> getCustomerPurchaseProductsByQuery(QueryCustomerPurchaseProduct queryCustomerPurchaseProduct) {
    	return this.queryForList(GET_BY_QUERY, queryCustomerPurchaseProduct);
    }
    	
    public CustomerPurchaseProduct getCustomerPurchaseProductById(int id) {
    	return (CustomerPurchaseProduct) this.queryForObject(GET_BY_ID, id);
    }
    
    public List<CustomerPurchaseProduct> getCustomerPurchaseProductsByPage(QueryCustomerPurchaseProduct queryCustomerPurchaseProduct) {
    	return this.queryForList(GET_PAGE, queryCustomerPurchaseProduct);
    }
    	
    public int count(QueryCustomerPurchaseProduct queryCustomerPurchaseProduct) {
    	return ((Integer) this.queryForObject(COUNT, queryCustomerPurchaseProduct)).intValue();
    }
}
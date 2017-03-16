package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.CustomerMakeProductDao;
import com.fuhuadata.domain.CustomerMakeProduct;
import com.fuhuadata.domain.query.CustomerMakeProductQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by intanswer on 2017/3/16.
 */
public class CustomerMakeProductDaoImpl extends SqlMapClientTemplate implements CustomerMakeProductDao {
    public static final String ADD = "CUSTOMERMAKEPRODUCT.ADD";
    public static final String UPDATE = "CUSTOMERMAKEPRODUCT.UPDATE";
    public static final String DELETE_BY_ID = "CUSTOMERMAKEPRODUCT.DELETE-BY-ID";
    public static final String DELETE_BY_IDS = "CUSTOMERMAKEPRODUCT.DELETE-BY-IDS";
    public static final String GET_BY_QUERY = "CUSTOMERMAKEPRODUCT.GET-BY-QUERY";
    public static final String GET_BY_ID = "CUSTOMERMAKEPRODUCT.GET-BY-ID";
    public static final String COUNT = "CUSTOMERMAKEPRODUCT.COUNT";
    public static final String BATCH_ADD="CUSTOMERMAKEPRODUCT.BATCH-ADD";
    public static final String GET_BY_CUSTOMERID="CUSTOMERMAKEPRODUCT.GET-BY-CUSTOMERID";
    @Override
    public CustomerMakeProduct addCustomerMakeProduct(CustomerMakeProduct customerMakeProduct) {
               customerMakeProduct.setId ((Integer)this.insert(ADD,customerMakeProduct));
               return customerMakeProduct;
    }

    @Override
    public int updateCustomerMakeProductById(int id, CustomerMakeProduct customerMakeProduct) {
        customerMakeProduct.setId(id);
        return this.update(UPDATE,customerMakeProduct);
    }

    @Override
    public int deleteCustomerMakeProductById(int id) {
        return this.delete(DELETE_BY_ID,id);
    }

    @Override
    public int deleteCustomerMakeProductByIds(List<Integer> list) {
        return this.delete(DELETE_BY_IDS,list);
    }

    @Override
    public int addCustomerMakeProducts(List<CustomerMakeProduct> customerMakeProducts) {
        return ((Integer) this.insert(BATCH_ADD,customerMakeProducts)).intValue();
    }

    @Override
    public CustomerMakeProduct getCustomerMakeProductById(int id) {
        return (CustomerMakeProduct) this.queryForObject(GET_BY_ID,id);
    }

    @Override
    public List<CustomerMakeProduct> getCustomerMakeProductById(String customerId) {
        return this.queryForList(GET_BY_CUSTOMERID,customerId);
    }

    @Override
    public List<CustomerMakeProduct> getCustomerMakeProductByQuery(CustomerMakeProductQuery customerMakeProductQuery) {
        return this.queryForList(GET_BY_QUERY,customerMakeProductQuery);
    }

    @Override
    public int count(CustomerMakeProductQuery customerMakeProductQuery) {
        return ((Integer) this.queryForObject(COUNT,customerMakeProductQuery)).intValue();
    }
}

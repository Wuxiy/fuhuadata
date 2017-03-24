package com.fuhuadata.dao;

import com.fuhuadata.domain.CustomerMakeProduct;
import com.fuhuadata.domain.query.CustomerMakeProductQuery;

import java.util.List;

/**
 * 企业性质为工厂时的产品和产能
 * Created by intanswer on 2017/3/16.
 */
public interface CustomerMakeProductDao {
    public CustomerMakeProduct addCustomerMakeProduct(CustomerMakeProduct customerMakeProduct);

    public int updateCustomerMakeProductById(int id,CustomerMakeProduct customerMakeProduct);

    public int deleteCustomerMakeProductById(int id);

    /**
     * 批量删除
     * @param customerId
     * @return
     */
    public int deleteCustomerMakeProductByCustomerId(String customerId);

    /**
     * 批量增加
     * @param customerMakeProducts
     * @return
     */
    public int addCustomerMakeProducts(List<CustomerMakeProduct> customerMakeProducts);

    public CustomerMakeProduct getCustomerMakeProductById(int id);
    /**
     * 获取客户产品产能
     * @param customerId
     * @return
     */
    public List<CustomerMakeProduct> getCustomerMakeProductById(String customerId);

    public List<CustomerMakeProduct> getCustomerMakeProductByQuery(CustomerMakeProductQuery customerMakeProductQuery);

    public int count(CustomerMakeProductQuery customerMakeProductQuery);

}

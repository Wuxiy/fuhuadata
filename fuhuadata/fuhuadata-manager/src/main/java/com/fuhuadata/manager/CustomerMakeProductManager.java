package com.fuhuadata.manager;

import com.fuhuadata.domain.CustomerMakeProduct;
import com.fuhuadata.domain.query.CustomerMakeProductQuery;

import java.util.List;

/**
 * Created by intanswer on 2017/3/16.
 */
public interface CustomerMakeProductManager {

    public CustomerMakeProduct addCustomerMakeProduct(CustomerMakeProduct customerMakeProduct);

    public boolean updateCustomerMakeProductById(int id,CustomerMakeProduct customerMakeProduct);

    public boolean deleteCustomerMakeProductById(int id);

    /**
     * 批量删除
     * @param customerId
     * @return
     */
    public boolean deleteCustomerMakeProductByCustomerId(String customerId);

    /**
     * 批量增加
     * @param customerMakeProducts
     * @return
     */
    public boolean addCustomerMakeProducts(List<CustomerMakeProduct> customerMakeProducts);

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

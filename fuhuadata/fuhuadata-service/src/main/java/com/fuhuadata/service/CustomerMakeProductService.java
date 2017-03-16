package com.fuhuadata.service;

import com.fuhuadata.domain.CustomerMakeProduct;
import com.fuhuadata.domain.query.CustomerMakeProductQuery;
import com.fuhuadata.domain.query.Result;

import java.util.List;

/**
 * Created by intanswer on 2017/3/16.
 */
public interface CustomerMakeProductService {

    public Result<CustomerMakeProduct> addCustomerMakeProduct(CustomerMakeProduct customerMakeProduct);

    public Result updateCustomerMakeProductById(int id,CustomerMakeProduct customerMakeProduct);

    public Result deleteCustomerMakeProductById(int id);

    /**
     * 批量删除
     * @param list
     * @return
     */
    public Result deleteCustomerMakeProductByIds(List<Integer> list);

    /**
     * 批量增加
     * @param customerMakeProducts
     * @return
     */
    public Result addCustomerMakeProducts(List<CustomerMakeProduct> customerMakeProducts);

    public Result<CustomerMakeProduct> getCustomerMakeProductById(int id);
    /**
     * 获取客户产品产能
     * @param customerId
     * @return
     */
    public Result<List<CustomerMakeProduct>> getCustomerMakeProductById(String customerId);

    public Result<List<CustomerMakeProduct>> getCustomerMakeProductByQuery(CustomerMakeProductQuery customerMakeProductQuery);

    public Result<Integer> count(CustomerMakeProductQuery customerMakeProductQuery);

    public Result updateCustomerMakeProducts(CustomerMakeProduct[] customerMakeProducts);
}

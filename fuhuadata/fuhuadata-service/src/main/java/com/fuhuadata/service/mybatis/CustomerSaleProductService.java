package com.fuhuadata.service.mybatis;

import com.fuhuadata.domain.mybatis.CustomerSaleProduct;
import com.fuhuadata.domain.query.QueryCustomerSaleProduct;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 5/4/2017
 */
public interface CustomerSaleProductService extends BaseService<CustomerSaleProduct, Integer> {

    /**
     * 获取销售产品
     * @param query 可查询分页，productName 模糊查询，year 查询
     * @return
     */
    PageInfo<CustomerSaleProduct> listProducts(QueryCustomerSaleProduct query);

    /**
     * 获取销售产品及其目的国信息
     * @param productId
     * @return
     */
    CustomerSaleProduct getProductAndCountriesByProductId(Integer productId);

    /**
     * 新增或更新销售产品和目的国
     * @param saleProduct
     * @param deleteCountryIds 删除的目的国
     */
    void saveOrUpdateProductsAndCountries(CustomerSaleProduct saleProduct, List<Integer> deleteCountryIds);

    /**
     * 删除销售产品
     * @param productIds
     * @return
     */
    int deleteProducts(List<Integer> productIds);
}

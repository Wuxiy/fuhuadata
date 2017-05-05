package com.fuhuadata.service.mybatis;

import com.fuhuadata.domain.mybatis.CustomerPurchaseProduct;
import com.fuhuadata.domain.query.QueryCustomerPurchaseProduct;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 5/4/2017
 */
public interface CustomerPurchaseProductService extends BaseService<CustomerPurchaseProduct, Integer> {

    /**
     * 获取采购产品
     * @param query 可查询分页，productName模糊查询，year查询
     * @return
     */
    PageInfo<CustomerPurchaseProduct> listProducts(QueryCustomerPurchaseProduct query);

    /**
     * 获取采购产品和其供应商信息
     * @param productId
     * @return
     */
    CustomerPurchaseProduct getProductAndSupplierByProductId(Integer productId);

    /**
     * 新增或更新客户采购产品和供应商信息
     * @param product
     * @param deletedSupplierIds
     * @return
     */
    void saveOrUpdatePurchaseProductAndSuppliers(CustomerPurchaseProduct product, List<Integer> deletedSupplierIds);

    /**
     * 删除采购产品
     * @param productIds
     * @return
     */
    int deleteProducts(List<Integer> productIds);

}

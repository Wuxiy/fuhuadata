package com.fuhuadata.service.mybatis;

import com.fuhuadata.domain.mybatis.CustomerPurchaseSupplier;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 5/4/2017
 */
public interface CustomerPurchaseSupplierService extends BaseService<CustomerPurchaseSupplier, Integer> {

    /**
     * 获取采购产品供应商
     * @param purchaseId
     * @return
     */
    List<CustomerPurchaseSupplier> listSupplierByProductId(Integer purchaseId);

    /**
     * 新增或保存供应商
     * @param suppliers
     * @return
     */
    int saveOrUpdateSuppliers(List<CustomerPurchaseSupplier> suppliers);

    /**
     * 批量删除供应商
     * @param supplierIds
     * @return
     */
    int deleteSuppliersByIds(List<Integer> supplierIds);

    /**
     * 删除采购产品的供应商
     * @param productId
     * @return
     */
    int deleteSuppliersByProductId(Integer productId);
}

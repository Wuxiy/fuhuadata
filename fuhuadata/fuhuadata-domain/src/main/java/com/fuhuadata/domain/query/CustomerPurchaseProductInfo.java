package com.fuhuadata.domain.query;

import com.fuhuadata.domain.mybatis.CustomerPurchaseProduct;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 5/8/2017
 */
public class CustomerPurchaseProductInfo {

    // 采购产品
    private CustomerPurchaseProduct purchaseProduct;

    // 删除的供应商ids
    private List<Integer> deletedSupplierIds;

    public CustomerPurchaseProduct getPurchaseProduct() {
        return purchaseProduct;
    }

    public void setPurchaseProduct(CustomerPurchaseProduct purchaseProduct) {
        this.purchaseProduct = purchaseProduct;
    }

    public List<Integer> getDeletedSupplierIds() {
        return deletedSupplierIds;
    }

    public void setDeletedSupplierIds(List<Integer> deletedSupplierIds) {
        this.deletedSupplierIds = deletedSupplierIds;
    }
}

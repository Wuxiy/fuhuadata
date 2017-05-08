package com.fuhuadata.domain.query;

import com.fuhuadata.domain.mybatis.CustomerSaleProduct;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 5/8/2017
 */
public class CustomerSaleProductInfo {

    private CustomerSaleProduct saleProduct;

    private List<Integer> deleteCountryIds;

    public CustomerSaleProduct getSaleProduct() {
        return saleProduct;
    }

    public void setSaleProduct(CustomerSaleProduct saleProduct) {
        this.saleProduct = saleProduct;
    }

    public List<Integer> getDeleteCountryIds() {
        return deleteCountryIds;
    }

    public void setDeleteCountryIds(List<Integer> deleteCountryIds) {
        this.deleteCountryIds = deleteCountryIds;
    }
}

package com.fuhuadata.vo;

import com.fuhuadata.domain.CustomerBaseInfo;
import com.fuhuadata.domain.CustomerEnterpriceNature;
import com.fuhuadata.domain.CustomerMakeProduct;

/**
 * 客户基本信息更新新增返回
 * Created by intanswer on 2017/3/18.
 */
public class CustomerBaseInfoDO {
    private CustomerBaseInfo customerBaseInfo;//客户基本信息

   private CustomerMakeProduct[] customerMakeProducts;//客户产品产能

   private CustomerEnterpriceNature[] customerEnterpriceNatures;//客户企业性质

    public CustomerMakeProduct[] getCustomerMakeProducts() {
        return customerMakeProducts;
    }

    public CustomerBaseInfoDO( ) {
    }

    public void setCustomerMakeProducts(CustomerMakeProduct[] customerMakeProducts) {
        this.customerMakeProducts = customerMakeProducts;
    }

    public CustomerBaseInfo getCustomerBaseInfo() {
        return customerBaseInfo;
    }

    public void setCustomerBaseInfo(CustomerBaseInfo customerBaseInfo) {
        this.customerBaseInfo = customerBaseInfo;
    }

    public CustomerEnterpriceNature[] getCustomerEnterpriceNatures() {
        return customerEnterpriceNatures;
    }

    public void setCustomerEnterpriceNatures(CustomerEnterpriceNature[] customerEnterpriceNatures) {
        this.customerEnterpriceNatures = customerEnterpriceNatures;
    }
}

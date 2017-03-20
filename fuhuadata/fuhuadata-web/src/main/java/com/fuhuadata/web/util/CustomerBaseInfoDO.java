package com.fuhuadata.web.util;

import com.fuhuadata.domain.CustomerBaseInfo;
import com.fuhuadata.domain.CustomerMakeProduct;
import com.fuhuadata.vo.CustomerBaseInfoVO;

/**
 * Created by intanswer on 2017/3/18.
 */
public class CustomerBaseInfoDO {
    private CustomerBaseInfo customerBaseInfo;

    private CustomerMakeProduct[] customerMakeProducts;

    public CustomerMakeProduct[] getCustomerMakeProducts() {
        return customerMakeProducts;
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
}
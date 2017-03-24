package com.fuhuadata.vo;

import com.fuhuadata.domain.CustomerEnterpriceNature;
import com.fuhuadata.domain.CustomerSubcompanyInfo;

/**
 * 客户子公司vo
 * Created by intanswer on 2017/3/24.
 */
public class CustomerSubcompanyInfoVO {
    private CustomerSubcompanyInfo customerSubcompanyInfo;//子公司基本信息

    private CustomerEnterpriceNature[] customerEnterpriceNatures;//子公司企业性质

    public CustomerSubcompanyInfo getCustomerSubcompanyInfo() {
        return customerSubcompanyInfo;
    }

    public void setCustomerSubcompanyInfo(CustomerSubcompanyInfo customerSubcompanyInfo) {
        this.customerSubcompanyInfo = customerSubcompanyInfo;
    }

    public CustomerEnterpriceNature[] getCustomerEnterpriceNatures() {
        return customerEnterpriceNatures;
    }

    public void setCustomerEnterpriceNatures(CustomerEnterpriceNature[] customerEnterpriceNatures) {
        this.customerEnterpriceNatures = customerEnterpriceNatures;
    }
}

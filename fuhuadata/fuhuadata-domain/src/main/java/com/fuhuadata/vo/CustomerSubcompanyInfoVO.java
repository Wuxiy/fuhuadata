package com.fuhuadata.vo;

import com.fuhuadata.domain.CustomerEnterpriceNature;
import com.fuhuadata.domain.CustomerSubcompanyInfo;

import javax.validation.Valid;

/**
 * 客户子公司vo
 * Created by intanswer on 2017/3/24.
 */
public class CustomerSubcompanyInfoVO {
    @Valid
    private CustomerSubcompanyInfo customerSubcompanyInfo;//子公司基本信息

    @Valid
    private CustomerEnterpriceNature[] customerEnterpriceNatures;//子公司企业性质

    public CustomerSubcompanyInfoVO() {
    }

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

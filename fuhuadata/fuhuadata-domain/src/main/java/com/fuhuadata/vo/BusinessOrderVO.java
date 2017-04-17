package com.fuhuadata.vo;

import com.fuhuadata.domain.BusinessOrder;
import com.fuhuadata.domain.BusinessOrderProduct;
import com.fuhuadata.domain.CustomerBaseInfo;

import java.util.List;

/**    订单报价详情
 * Created by intanswer on 2017/4/16.
 */
public class BusinessOrderVO {

    private BusinessOrder businessOrder;//订单报价表头

    private CustomerBaseInfo customerBaseInfo;//客户基本信息

    private List<BusinessOrderProductList> businessOrderProductLists;//订单产品

    public BusinessOrder getBusinessOrder() {
        return businessOrder;
    }

    public void setBusinessOrder(BusinessOrder businessOrder) {
        this.businessOrder = businessOrder;
    }


    public CustomerBaseInfo getCustomerBaseInfo() {
        return customerBaseInfo;
    }

    public void setCustomerBaseInfo(CustomerBaseInfo customerBaseInfo) {
        this.customerBaseInfo = customerBaseInfo;
    }

    public List<BusinessOrderProductList> getBusinessOrderProductLists() {
        return businessOrderProductLists;
    }

    public void setBusinessOrderProductLists(List<BusinessOrderProductList> businessOrderProductLists) {
        this.businessOrderProductLists = businessOrderProductLists;
    }
}



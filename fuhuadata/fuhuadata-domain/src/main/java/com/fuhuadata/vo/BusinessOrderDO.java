package com.fuhuadata.vo;

import com.fuhuadata.domain.BusinessOrder;
import com.fuhuadata.domain.BusinessOrderProduct;


/**
 *   报价转化订单do
 * Created by intanswer on 2017/4/20.
 */
public class BusinessOrderDO {
    private BusinessOrder businessOrder;//订单 表头

    private BusinessOrderProduct[] businessOrderProducts;//订单产品

    public BusinessOrder getBusinessOrder() {
        return businessOrder;
    }

    public void setBusinessOrder(BusinessOrder businessOrder) {
        this.businessOrder = businessOrder;
    }

    public BusinessOrderProduct[] getBusinessOrderProducts() {
        return businessOrderProducts;
    }

    public void setBusinessOrderProducts(BusinessOrderProduct[] businessOrderProducts) {
        this.businessOrderProducts = businessOrderProducts;
    }
}

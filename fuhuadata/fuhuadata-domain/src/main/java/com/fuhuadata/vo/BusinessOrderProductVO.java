package com.fuhuadata.vo;

import com.fuhuadata.domain.BusinessOrder;
import com.fuhuadata.domain.BusinessOrderProduct;

import java.util.List;

/**
 * 订单产品 转化信息
 * Created by intanswer on 2017/4/20.
 */
public class BusinessOrderProductVO {
    private BusinessOrder businessOrder;//订单 表头

    private List<BusinessOrderProduct> businessOrderProducts;//订单产品

    public BusinessOrder getBusinessOrder() {
        return businessOrder;
    }

    public void setBusinessOrder(BusinessOrder businessOrder) {
        this.businessOrder = businessOrder;
    }

    public List<BusinessOrderProduct> getBusinessOrderProducts() {
        return businessOrderProducts;
    }

    public void setBusinessOrderProducts(List<BusinessOrderProduct> businessOrderProducts) {
        this.businessOrderProducts = businessOrderProducts;
    }
}

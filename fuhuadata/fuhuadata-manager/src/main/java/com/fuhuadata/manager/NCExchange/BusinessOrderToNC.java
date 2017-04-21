package com.fuhuadata.manager.NCExchange;

import com.fuhuadata.domain.BusinessOrder;
import com.fuhuadata.domain.BusinessOrderProduct;

import java.util.Map;

/**
 * Created by zhangxiang on 2017/4/10.
 */
public interface BusinessOrderToNC {
    public String sendBusinessOrder(String orderId);
}

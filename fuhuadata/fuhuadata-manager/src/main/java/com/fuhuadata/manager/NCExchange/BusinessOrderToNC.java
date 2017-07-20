package com.fuhuadata.manager.NCExchange;


import java.util.List;


/**
 * Created by zhangxiang on 2017/4/10.
 */
public interface BusinessOrderToNC {
    public String sendBusinessOrder(String orderId,List<Integer> orderProductsId) throws Exception;
}

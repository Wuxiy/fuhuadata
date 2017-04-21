package com.fuhuadata.dao.NCExchange;

import com.fuhuadata.domain.BusinessOrder;

import java.util.Map;

/**
 * Created by zhangxiang on 2017/4/13.
 */
public interface OrderToNc {
    void updateOrderStatusByNcOrderId(Map<String,Object> mapv);
}

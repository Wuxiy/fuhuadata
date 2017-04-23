package com.fuhuadata.dao.NCExchange;

import com.fuhuadata.domain.BusinessOrder;
import com.fuhuadata.domain.BusinessOrderProduct;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangxiang on 2017/4/13.
 */
public interface OrderToNc {
    void updateOrderStatusByNcOrderId(Map<String,Object> mapv);
    List<BusinessOrderProduct> getOrderProductsById(List<Integer> orderProductsId);
    String getCodeByWareId(int wareId);
}

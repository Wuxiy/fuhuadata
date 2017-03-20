package com.fuhuadata.service;

import com.fuhuadata.domain.BusinessOrder;
import com.fuhuadata.domain.query.QueryBusinessOrder;

import java.util.List;

/**
 * Created by hexingfu on 2017/3/18.
 */
public interface BusinessOrderService {

    public int count(QueryBusinessOrder queryBusinessOrder);

    /**
     * 分页获取订单列表
     * @param queryBusinessOrder
     * @return
     */
    public List<BusinessOrder> getOrderLisPageByQuery(QueryBusinessOrder queryBusinessOrder);
}

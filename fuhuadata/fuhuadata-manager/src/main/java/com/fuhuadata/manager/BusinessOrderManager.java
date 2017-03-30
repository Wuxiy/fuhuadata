package com.fuhuadata.manager;

import com.fuhuadata.domain.BusinessOrder;
import com.fuhuadata.domain.query.QueryBusinessOrder;

import java.util.List;

/**
 * 报价订单
 * Created by intanswer on 2017/3/29.
 */
public interface BusinessOrderManager {

    /**
     * add
     * @param businessOrder
     * @return
     */
    public BusinessOrder addBusinessOrder(BusinessOrder businessOrder);

    /**
     * 根据orderId更新
     * @param businessOrder
     * @return
     */
    public boolean updateBusinessOrderByOrderId(BusinessOrder businessOrder);


    /**
     * 更新报价状态
     * @param businessOrder
     * @return
     */
    public boolean updateOfferStatus(BusinessOrder businessOrder);


    /**
     * 根据订单编号获取订单详情
     * @param orderId
     * @return
     */
    public BusinessOrder getBusinessOrderByOrderId(String orderId);
    /**
     * 分页获取报价列表
     * @param queryBusinessOrder
     * @return
     */
    public List<QueryBusinessOrder> getOfferListPageByQuery(QueryBusinessOrder queryBusinessOrder);

    /**
     * 报价列表数
     * @param queryBusinessOrder
     * @return
     */
    public int countOffer(QueryBusinessOrder queryBusinessOrder);

    /**
     * 订单列表数
     * @param queryBusinessOrder
     * @return
     */
    public int countOrder(QueryBusinessOrder queryBusinessOrder);

    /**
     * 分页获取订单列表
     * @param queryBusinessOrder
     * @return
     */
    public List<QueryBusinessOrder> getOrderListPageByQuery(QueryBusinessOrder queryBusinessOrder);

}

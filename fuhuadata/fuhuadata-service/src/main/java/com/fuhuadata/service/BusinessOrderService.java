package com.fuhuadata.service;

import com.fuhuadata.domain.BusinessOrder;
import com.fuhuadata.domain.query.QueryBusinessOrder;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.vo.BusinessOrderVO;
import com.fuhuadata.vo.CostAndProfitStatistics;

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


    /**
     * add
     * @param businessOrder
     * @return
     */
    public Result<BusinessOrder> addBusinessOrder(BusinessOrder businessOrder);

    /**
     * 根据orderId更新
     * @param businessOrder
     * @return
     */
    public Result updateBusinessOrderByOrderId(BusinessOrder businessOrder);


    /**
     * 更新报价状态
     * @param businessOrder
     * @return
     */
    public Result updateOfferStatus(BusinessOrder businessOrder);


    /**
     * 根据订单编号获取订单详情
     * @param orderId
     * @return
     */
    public Result<BusinessOrderVO> getBusinessOrderByOrderId(String orderId);
    /**
     * 分页获取报价列表
     * @param queryBusinessOrder
     * @return
     */
    public Result<List<QueryBusinessOrder>> getOfferListPageByQuery(QueryBusinessOrder queryBusinessOrder);

    /**
     * 报价列表数
     * @param queryBusinessOrder
     * @return
     */
    public Result<Integer> countOffer(QueryBusinessOrder queryBusinessOrder);

    /**
     * 订单列表数
     * @param queryBusinessOrder
     * @return
     */
    public Result<Integer> countOrder(QueryBusinessOrder queryBusinessOrder);

    /**
     * 分页获取订单列表
     * @param queryBusinessOrder
     * @return
     */
    public Result<List<QueryBusinessOrder>> getOrderListPageByQuery(QueryBusinessOrder queryBusinessOrder);

    /**
     * 费用与利润统计
     * @param costAndProfitStatistics
     * @return
     */
    public Result<List<CostAndProfitStatistics>> getCostAndProfitStatisticsByPage(CostAndProfitStatistics costAndProfitStatistics);

    /**
     * 利润统计
     * @param costAndProfitStatistics
     * @return
     */
    public Result<List<CostAndProfitStatistics>> getProfitStatisticsByPage(CostAndProfitStatistics costAndProfitStatistics);

    public Result<Integer> countCostAndProfit(CostAndProfitStatistics costAndProfitStatistics);

    public Result<Integer> countProfitStatistics(CostAndProfitStatistics costAndProfitStatistics);

}

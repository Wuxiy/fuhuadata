package com.fuhuadata.dao;

import com.fuhuadata.domain.BusinessOrder;
import com.fuhuadata.domain.query.QueryBusinessOrder;
import com.fuhuadata.vo.BusinessOrderVO;
import com.fuhuadata.vo.CostAndProfitStatistics;
import java.util.List;

/**
 * Created by hexingfu on 2017/3/17.
 */
public interface BusinessOrderDao {


    String getOrderIdByBusinessId(String businessId);
    //获取业务员部门code
    String getSalesManDeptCode(String orderId);
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
    public int updateBusinessOrderByOrderId(BusinessOrder businessOrder);


    /**
     * delete by orderId
     * @param orderId
     * @return
     */
    public int deleteBusinessOrderByOrderId(String orderId);


    /**
     * 更新报价状态
     * @param businessOrder
     * @return
     */
    public int updateOfferStatus(BusinessOrder businessOrder);


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


    /**
     * 客户订单信息
     * @param queryBusinessOrder
     * @return
     */
    public int count(QueryBusinessOrder queryBusinessOrder);

    /**
     * 分页获取订单列表
     * @param queryBusinessOrder
     * @return
     */
    public List<BusinessOrder> getOrderLisPageByQuery(QueryBusinessOrder queryBusinessOrder);

    /**
     * 费用与利润统计
     * @param costAndProfitStatistics
     * @return
     */
    public List<CostAndProfitStatistics> getCostAndProfitStatisticsByPage(CostAndProfitStatistics costAndProfitStatistics);

    /**
     * count 费用和利润列表
     * @param costAndProfitStatistics
     * @return
     */
    public int countCostAndProfit(CostAndProfitStatistics costAndProfitStatistics);

    /**
     * 利润统计
     * @param costAndProfitStatistics
     * @return
     */
    public List<CostAndProfitStatistics> getProfitStatisticsByPage(CostAndProfitStatistics costAndProfitStatistics);

    /**
     * count 利润统计
     * @param costAndProfitStatistics
     * @return
     */
    public int countProfitStatistics(CostAndProfitStatistics costAndProfitStatistics);

    public BusinessOrder getById(String orderId);

}

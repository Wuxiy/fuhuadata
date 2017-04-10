package com.fuhuadata.manager.impl;

import com.fuhuadata.dao.BusinessOrderDao;
import com.fuhuadata.domain.BusinessOrder;
import com.fuhuadata.domain.query.QueryBusinessOrder;
import com.fuhuadata.manager.BusinessOrderManager;
import com.fuhuadata.vo.CostAndProfitStatistics;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by intanswer on 2017/3/29.
 */
public class BusinessOrderManagerImpl implements BusinessOrderManager {
    @Autowired
    private BusinessOrderDao businessOrderDao;
    @Override
    public BusinessOrder addBusinessOrder(BusinessOrder businessOrder) {
        return businessOrderDao.addBusinessOrder(businessOrder);
    }

    @Override
    public boolean updateBusinessOrderByOrderId(BusinessOrder businessOrder) {
        return businessOrderDao.updateBusinessOrderByOrderId(businessOrder)==1 ? true : false;
    }

    @Override
    public boolean updateOfferStatus(BusinessOrder businessOrder) {
        return businessOrderDao.updateOfferStatus(businessOrder)==1?true:false;
    }

    @Override
    public BusinessOrder getBusinessOrderByOrderId(String orderId) {
        return businessOrderDao.getBusinessOrderByOrderId(orderId);
    }

    @Override
    public List<QueryBusinessOrder> getOfferListPageByQuery(QueryBusinessOrder queryBusinessOrder) {
        return businessOrderDao.getOfferListPageByQuery(queryBusinessOrder);
    }

    @Override
    public int countOffer(QueryBusinessOrder queryBusinessOrder) {
        return businessOrderDao.countOffer(queryBusinessOrder);
    }

    @Override
    public int countOrder(QueryBusinessOrder queryBusinessOrder) {
        return businessOrderDao.countOrder(queryBusinessOrder);
    }

    @Override
    public List<QueryBusinessOrder> getOrderListPageByQuery(QueryBusinessOrder queryBusinessOrder) {
        return businessOrderDao.getOrderListPageByQuery(queryBusinessOrder);
    }

    @Override
    public List<CostAndProfitStatistics> getCostAndProfitStatisticsByPage(CostAndProfitStatistics costAndProfitStatistics) {
        return businessOrderDao.getCostAndProfitStatisticsByPage(costAndProfitStatistics);
    }

    @Override
    public List<CostAndProfitStatistics> getProfitStatisticsByPage(CostAndProfitStatistics costAndProfitStatistics) {
        return businessOrderDao.getProfitStatisticsByPage(costAndProfitStatistics);
    }

    @Override
    public int countCostAndProfit(CostAndProfitStatistics costAndProfitStatistics) {
        return businessOrderDao.countCostAndProfit(costAndProfitStatistics);
    }

    @Override
    public int countProfitStatistics(CostAndProfitStatistics costAndProfitStatistics) {
        return businessOrderDao.countProfitStatistics(costAndProfitStatistics);
    }
}

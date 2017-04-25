package com.fuhuadata.manager.impl;

import com.fuhuadata.dao.BusinessInfoDao;
import com.fuhuadata.dao.BusinessOrderDao;
import com.fuhuadata.dao.BusinessOrderProductDao;
import com.fuhuadata.dao.CustomerBaseInfoDao;
import com.fuhuadata.domain.BusinessInfo;
import com.fuhuadata.domain.BusinessOrder;
import com.fuhuadata.domain.CustomerBaseInfo;
import com.fuhuadata.domain.query.QueryBusinessOrder;
import com.fuhuadata.manager.BusinessOrderManager;
import com.fuhuadata.util.StringUtil;
import com.fuhuadata.vo.BusinessOrderProductList;
import com.fuhuadata.vo.BusinessOrderVO;
import com.fuhuadata.vo.CostAndProfitStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by intanswer on 2017/3/29.
 */
public class BusinessOrderManagerImpl implements BusinessOrderManager {
    @Autowired
    private BusinessOrderDao businessOrderDao;
    @Autowired
    private CustomerBaseInfoDao customerBaseInfoDao;
    @Autowired
    private BusinessOrderProductDao businessOrderProductDao;
    @Autowired
    private BusinessInfoDao businessInfoDao;

    @Override
    @Transactional
    public BusinessOrder addBusinessOrder(BusinessOrder businessOrder) {
        //将商机状态置为2  已转化
        BusinessInfo businessInfo = new BusinessInfo();
        businessInfo.setBusinessState(2);
        businessInfo.setBusinessId(businessOrder.getBusinessId());
        businessInfoDao.updateBusinessInfoByBusinessId(businessInfo);

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

    @Override
    public BusinessOrderVO getBusinessOrderAllInfo(String orderId) {
        BusinessOrderVO businessOrderVO = new BusinessOrderVO();
        BusinessOrder businessOrder= businessOrderDao.getBusinessOrderByOrderId(orderId);
        businessOrderVO.setBusinessOrder(businessOrder);
        CustomerBaseInfo customerBaseInfo = customerBaseInfoDao.getOrderCustomerInfoByCustomerId(businessOrder.getCustomerId());
        if(customerBaseInfo!=null) {
            businessOrderVO.setCustomerBaseInfo(customerBaseInfo);
        }
        List<BusinessOrderProductList> productList=businessOrderProductDao.getOrderProductList(orderId);
        businessOrderVO.setBusinessOrderProductLists(productList);
        if(productList!=null&&productList.size()>0) {
            for (BusinessOrderProductList c : productList) {
                c.setPackingSpecification(StringUtil.merge2string(c.getSpecification(), c.getModel(), "*"));
            }
        }
        return businessOrderVO;
    }
}

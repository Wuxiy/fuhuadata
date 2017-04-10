package com.fuhuadata.service.impl;

import com.fuhuadata.dao.BusinessOrderDao;
import com.fuhuadata.domain.BusinessOrder;
import com.fuhuadata.domain.query.QueryBusinessOrder;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.BusinessOrderManager;
import com.fuhuadata.service.BusinessOrderService;
import com.fuhuadata.vo.CostAndProfitStatistics;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hexingfu on 2017/3/18.
 */
@Service
public class BusinessOrderServiceImpl implements BusinessOrderService {

    private static final Log log = LogFactory.getLog(BusinessOrderServiceImpl.class);
    @Autowired
    private BusinessOrderManager businessOrderManager;

    @Autowired
    private BusinessOrderDao businessOrderDao;

    @Override
    public int count(QueryBusinessOrder queryBusinessOrder) {
        return businessOrderDao.count(queryBusinessOrder);
    }

    @Override
    public List<BusinessOrder> getOrderLisPageByQuery(QueryBusinessOrder queryBusinessOrder) {
        return businessOrderDao.getOrderLisPageByQuery(queryBusinessOrder);
    }

    @Override
    public Result<BusinessOrder> addBusinessOrder(BusinessOrder businessOrder) {
        Result<BusinessOrder> result = new Result<BusinessOrder>();
        try{
            result.addDefaultModel("BusinessOrder",businessOrderManager.addBusinessOrder(businessOrder));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("新增报价信息错误",e);
        }
        return result;
    }

    @Override
    public Result updateBusinessOrderByOrderId(BusinessOrder businessOrder) {
        Result result = new Result();
        try{
            result.setSuccess(businessOrderManager.updateBusinessOrderByOrderId(businessOrder));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("根据id更新报价信息错误",e);
        }
        return result;
    }

    @Override
    public Result updateOfferStatus(BusinessOrder businessOrder) {
        Result result = new Result();
        try{
            result.setSuccess(businessOrderManager.updateOfferStatus(businessOrder));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("根据id更新报价状态错误",e);
        }
        return result;
    }

    @Override
    public Result<BusinessOrder> getBusinessOrderByOrderId(String orderId) {
        Result<BusinessOrder> result = new Result<BusinessOrder>();
        try{
            result.addDefaultModel("BusinessOrder",businessOrderManager.getBusinessOrderByOrderId(orderId));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("根据id获取报价信息错误",e);
        }
        return result;
    }

    @Override
    public Result<List<QueryBusinessOrder>> getOfferListPageByQuery(QueryBusinessOrder queryBusinessOrder) {
        Result<List<QueryBusinessOrder>> result = new Result<List<QueryBusinessOrder>>();
        try{
            result.addDefaultModel("BusinessOrders",businessOrderManager.getOfferListPageByQuery(queryBusinessOrder));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("分页查询报价列表错误",e);
        }
        return result;
    }

    @Override
    public Result<Integer> countOffer(QueryBusinessOrder queryBusinessOrder) {
        Result<Integer> result = new Result<Integer>();
        try{
            result.addDefaultModel(businessOrderManager.countOffer(queryBusinessOrder));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("条件获取报价列表数错误",e);
        }
        return result;
    }

    @Override
    public Result<Integer> countOrder(QueryBusinessOrder queryBusinessOrder) {
        Result<Integer> result = new Result<Integer>();
        try{
            result.addDefaultModel(businessOrderManager.countOrder(queryBusinessOrder));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("条件获取订单列表数错误",e);
        }
        return result;
    }

    @Override
    public Result<List<QueryBusinessOrder>> getOrderListPageByQuery(QueryBusinessOrder queryBusinessOrder) {
        Result<List<QueryBusinessOrder>> result = new Result<List<QueryBusinessOrder>>();
        try{
            result.addDefaultModel("BusinessOrders",businessOrderManager.getOrderListPageByQuery(queryBusinessOrder));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("分页查询订单列表错误",e);
        }
        return result;
    }

    @Override
    public Result<List<CostAndProfitStatistics>> getCostAndProfitStatisticsByPage(CostAndProfitStatistics costAndProfitStatistics) {
        Result<List<CostAndProfitStatistics>> result = new Result<List<CostAndProfitStatistics>>();
        try{
            result.addDefaultModel("CostAndProfitStatistics",businessOrderManager.getCostAndProfitStatisticsByPage(costAndProfitStatistics));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("分页获取费用与统计列表出错",e);
        }
        return result;
    }

    @Override
    public Result<List<CostAndProfitStatistics>> getProfitStatisticsByPage(CostAndProfitStatistics costAndProfitStatistics) {
        Result<List<CostAndProfitStatistics>> result = new Result<List<CostAndProfitStatistics>>();
        try{
            result.addDefaultModel("ProfitStatistics",businessOrderManager.getProfitStatisticsByPage(costAndProfitStatistics));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("分页获取利润统计列表出错",e);
        }
        return result;
    }

    @Override
    public Result<Integer> countCostAndProfit(CostAndProfitStatistics costAndProfitStatistics) {
        Result<Integer> result = new Result<Integer>();
        try{
            result.addDefaultModel(businessOrderManager.countCostAndProfit(costAndProfitStatistics));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("条件获取利润与统计列表数错误",e);
        }
        return result;
    }


    @Override
    public Result<Integer> countProfitStatistics(CostAndProfitStatistics costAndProfitStatistics) {
        Result<Integer> result = new Result<Integer>();
        try{
            result.addDefaultModel(businessOrderManager.countProfitStatistics(costAndProfitStatistics));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("条件获取利润统计列表数错误",e);
        }
        return result;
    }

}

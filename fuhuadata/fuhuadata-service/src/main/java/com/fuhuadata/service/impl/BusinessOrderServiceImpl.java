package com.fuhuadata.service.impl;

import com.fuhuadata.dao.BusinessOrderDao;
import com.fuhuadata.dao.BusinessOrderProductDao;
import com.fuhuadata.domain.BusinessOrder;
import com.fuhuadata.domain.BusinessOrderProduct;
import com.fuhuadata.domain.query.QueryBusinessOrder;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.BusinessOrderManager;
import com.fuhuadata.manager.NCExchange.BusinessOrderToNC;
import com.fuhuadata.service.BusinessOrderService;
import com.fuhuadata.vo.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Autowired
    private BusinessOrderToNC businessOrderToNC;
    @Autowired
    private BusinessOrderProductDao businessOrderProductDao;

    @Override
    public String getOrderIdByBusinessId(String businessId) {
        return businessOrderDao.getOrderIdByBusinessId(businessId);
    }

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
        result.setMessage("根据id更新报价表头信息成功");
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
        result.setMessage("根据id更新报价状态成功");
        return result;
    }

    @Override
    public Result<BusinessOrderVO> getBusinessOrderByOrderId(String orderId) {
        Result<BusinessOrderVO> result = new Result<BusinessOrderVO>();
        try{
            result.addDefaultModel("BusinessOrderInfo",businessOrderManager.getBusinessOrderAllInfo(orderId));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("根据id获取报价订单信息错误",e);
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

    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    public Result updateBusinessOrderAndProduct(BusinessOrderDO businessOrderDO) {
        Result result = new Result();
        try{
            if(businessOrderDO.getBusinessOrder()!=null) {
                //转化之前先把  订单的状态置为-2 报价失败
                businessOrderDO.getBusinessOrder().setStatus(-2);
                result.setSuccess(businessOrderManager.updateBusinessOrderByOrderId(businessOrderDO.getBusinessOrder()));
            }
            if(businessOrderDO.getBusinessOrderProducts()!=null&&businessOrderDO.getBusinessOrderProducts().length>0){
                List<BusinessOrderProduct> list = Arrays.asList(businessOrderDO.getBusinessOrderProducts());
                result.setSuccess(businessOrderProductDao.updateBusinessOrderProducts(list));
            }
            List<Integer> orderProductsId=new ArrayList<Integer>();
            for(BusinessOrderProduct businessOrderProduct:businessOrderDO.getBusinessOrderProducts()){
                orderProductsId.add(businessOrderProduct.getId());
            }
            String orderId=businessOrderDO.getBusinessOrder().getOrderId();
            String code = businessOrderToNC.sendBusinessOrder(orderId,orderProductsId);
            if("1"==code){
                result.setMessage("订单转化同步NC成功");
            }
        }catch(Exception e){
            result.setSuccess(false);
            log.error("更新订单和订单产品错误,NC同步错误",e);
        }
        return result;
    }

}

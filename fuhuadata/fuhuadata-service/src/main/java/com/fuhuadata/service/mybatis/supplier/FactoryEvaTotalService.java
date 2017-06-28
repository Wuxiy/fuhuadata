package com.fuhuadata.service.mybatis.supplier;

import com.fuhuadata.domain.supplier.FactoryEvaTotal;
import com.fuhuadata.service.mybatis.BaseService;

import java.util.Optional;

/**
 * <p>User: wangjie
 * <p>Date: 6/5/2017
 */
public interface FactoryEvaTotalService extends BaseService<FactoryEvaTotal, Integer> {

    /**
     * 获取订单评价详情
     * @param orderId
     * @return
     */
    FactoryEvaTotal getTotalAndItemsByOrderId(Integer orderId);

    /**
     * 获取订单评价概览信息
     * @param orderId
     * @return
     */
    FactoryEvaTotal getByOrderId(Integer orderId);

    Optional<FactoryEvaTotal> getOptByOrderId(Integer orderId);

    /**
     * 保存或更新评价详情
     * @param evaTotal
     * @return
     */
    FactoryEvaTotal saveOrUpdate(FactoryEvaTotal evaTotal);

    /**
     * 获取某个供应商订单的综合评价
     * @param pkSupplier
     * @return
     */
    Double getTotalScoreByPkSupplier(String pkSupplier);
}

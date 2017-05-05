package com.fuhuadata.dao.NCExchange;

import com.fuhuadata.domain.BusinessOrder;
import com.fuhuadata.domain.BusinessOrderProduct;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangxiang on 2017/4/13.
 */
public interface OrderToNc {
    /**
     * 跟新合同状态
     * @param mapv
     */
    void updateOrderStatusByNcOrderId(Map<String,Object> mapv);
    List<BusinessOrderProduct> getOrderProductsById(List<Integer> orderProductsId);
    String getCodeByWareId(int wareId);
    BusinessOrder getBusinessOrderByOrderId(String orderId);
    String getOrgNcIdByOrgId(int orgId);

    /**
     * 根据客户的nc_id更新新合作客户的合作开始时间
     * @param mapc
     */
    void updateCustCooperationTime(Map<String,Object> mapc);
}

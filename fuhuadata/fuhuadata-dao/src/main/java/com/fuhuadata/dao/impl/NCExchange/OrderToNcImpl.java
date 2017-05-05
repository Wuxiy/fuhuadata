package com.fuhuadata.dao.impl.NCExchange;

import com.fuhuadata.dao.NCExchange.OrderToNc;
import com.fuhuadata.domain.BusinessOrder;
import com.fuhuadata.domain.BusinessOrderProduct;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangxiang on 2017/4/13.
 */

public class OrderToNcImpl extends SqlMapClientTemplate implements OrderToNc {
    private static final String UPDATE_STATUS_BY_NCORDERID="BUSINESSORDERTONC.UPDATE-STATUS-BY-NCORDERID";
    private static final String GET_ORDER_PRODUCTS_BY_ID="BUSINESSORDERTONC.getOrderProductsById";
    private static final String GET_CODE_BY_WARE_ID="BUSINESSORDERTONC.getCodeByWareId";
    private static final String GET_BUSINESSORDER_BY_ORDER_ID="BUSINESSORDERTONC.getBusinessOrderByOrderId";
    private static final String GET_ORG_NCID_BY_ORGID="BUSINESSORDERTONC.getOrgNcIdByOrgId";
    private static final String UPDATE_COOPERATION_TIME="BUSINESSORDERTONC.updateCustCooperationTime";
    @Override
    public void updateOrderStatusByNcOrderId(Map<String,Object> mapv) {
        this.update(UPDATE_STATUS_BY_NCORDERID,mapv);
    }

    @Override
    public List<BusinessOrderProduct> getOrderProductsById(List<Integer> orderProductsId) {
        return this.queryForList(GET_ORDER_PRODUCTS_BY_ID,orderProductsId);
    }

    @Override
    public String getCodeByWareId(int wareId) {
        return (String) this.queryForObject(GET_CODE_BY_WARE_ID,wareId);
    }

    @Override
    public BusinessOrder getBusinessOrderByOrderId(String orderId) {

        return (BusinessOrder) this.queryForObject(GET_BUSINESSORDER_BY_ORDER_ID,orderId);
    }

    @Override
    public String getOrgNcIdByOrgId(int orgId) {
        return (String) this.queryForObject(GET_ORG_NCID_BY_ORGID,orgId);
    }

    @Override
    public void updateCustCooperationTime(Map<String,Object> mapc) {
        this.update(UPDATE_COOPERATION_TIME,mapc);
    }


}

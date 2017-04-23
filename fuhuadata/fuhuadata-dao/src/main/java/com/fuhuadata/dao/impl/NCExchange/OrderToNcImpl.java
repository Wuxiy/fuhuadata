package com.fuhuadata.dao.impl.NCExchange;

import com.fuhuadata.dao.NCExchange.OrderToNc;
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


}

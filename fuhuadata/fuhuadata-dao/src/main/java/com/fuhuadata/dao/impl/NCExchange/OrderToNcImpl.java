package com.fuhuadata.dao.impl.NCExchange;

import com.fuhuadata.dao.NCExchange.OrderToNc;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by zhangxiang on 2017/4/13.
 */

public class OrderToNcImpl extends SqlMapClientTemplate implements OrderToNc {
    private static final String UPDATE_STATUS_BY_NCORDERID="BUSINESSORDERTONC.UPDATE-STATUS-BY-NCORDERID";
    @Override
    public void updateOrderStatusByNcOrderId(Map<String,Object> mapv) {
        this.update(UPDATE_STATUS_BY_NCORDERID,mapv);
    }
}

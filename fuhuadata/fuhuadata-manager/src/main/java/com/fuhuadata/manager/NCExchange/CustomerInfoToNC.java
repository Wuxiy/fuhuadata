package com.fuhuadata.manager.NCExchange;

import com.fuhuadata.domain.CustomerBaseInfo;

import java.util.Map;

/**
 * Created by zhangxiang on 2017/4/11.
 */
public interface CustomerInfoToNC {
    public String sendCustomerInfo(CustomerBaseInfo customerBaseInfo);
}

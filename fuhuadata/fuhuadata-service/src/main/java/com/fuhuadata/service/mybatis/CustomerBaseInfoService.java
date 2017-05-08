package com.fuhuadata.service.mybatis;

import com.fuhuadata.domain.mybatis.CustomerBaseInfo;

/**
 * <p>User: wangjie
 * <p>Date: 5/5/2017
 */
public interface CustomerBaseInfoService extends BaseService<CustomerBaseInfo, Integer> {

    /**
     * 获取合作客户信息
     * @param customerId
     * @return
     */
    CustomerBaseInfo getCoopCustomer(Integer customerId);
}
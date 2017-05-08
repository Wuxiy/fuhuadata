package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.domain.mybatis.CustomerBaseInfo;
import com.fuhuadata.service.mybatis.CustomerBaseInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>User: wangjie
 * <p>Date: 5/5/2017
 */
@Service
public class CustomerBaseInfoServiceImpl extends BaseServiceImpl<CustomerBaseInfo, Integer>
        implements CustomerBaseInfoService {

    @Override
    public CustomerBaseInfo getCoopCustomer(Integer customerId) {
        CustomerBaseInfo customer = get(customerId);

        return customer;
    }
}

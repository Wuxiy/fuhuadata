package com.fuhuadata.service.impl;

import com.fuhuadata.dao.BusinessOrderDao;
import com.fuhuadata.domain.BusinessOrder;
import com.fuhuadata.domain.query.QueryBusinessOrder;
import com.fuhuadata.service.BusinessOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hexingfu on 2017/3/18.
 */
@Service
public class BusinessOrderServiceImpl implements BusinessOrderService {

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
}

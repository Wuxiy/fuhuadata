package com.fuhuadata.manager.impl;

import com.fuhuadata.dao.CustomerAreaDao;
import com.fuhuadata.domain.CustomerArea;
import com.fuhuadata.manager.CustomerAreaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by hexingfu on 2017/3/9.
 */
@Component
public class CustomerAreaManagerImpl implements CustomerAreaManager {
    @Autowired
    private CustomerAreaDao customerAreaDao;
    @Override
    public List<CustomerArea> getAllCustomerAreaList() {
        return customerAreaDao.getAllCustomerAreaList();
    }
}



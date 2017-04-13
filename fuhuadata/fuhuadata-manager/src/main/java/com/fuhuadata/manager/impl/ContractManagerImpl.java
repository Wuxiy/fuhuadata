package com.fuhuadata.manager.impl;

import com.fuhuadata.dao.ContractDao;
import com.fuhuadata.domain.Contract;
import com.fuhuadata.manager.ContractManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by intanswer on 2017/4/13.
 */
public class ContractManagerImpl implements ContractManager {
    @Autowired
    private ContractDao contractDao;
    @Override
    @Transactional
    public boolean synchronousContractStatistics() {
        boolean  flag =false;
        List<Contract> list  =  contractDao.getContractStatistical();
        List<Contract> list1 = contractDao.getContractProductStatistical();

        flag = contractDao.updateBusinessOrderStatistical(list);
        if(!flag){
            return flag;
        }
        flag = contractDao.updateBusinessOrderProductStatistical(list1);
        return flag;
    }
}

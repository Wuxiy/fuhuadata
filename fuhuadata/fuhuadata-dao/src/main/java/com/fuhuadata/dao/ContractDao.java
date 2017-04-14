package com.fuhuadata.dao;

import com.fuhuadata.domain.Contract;

import java.util.List;

/**
 * nc contract
 * Created by wuxi on 2017/4/13.
 */
public interface ContractDao {
    public List<Contract> getContractStatistical();

    public List<Contract> getContractProductStatistical();


    public boolean updateBusinessOrderStatistical(List<Contract> contracts);

    public boolean updateBusinessOrderProductStatistical(List<Contract> contracts);


}

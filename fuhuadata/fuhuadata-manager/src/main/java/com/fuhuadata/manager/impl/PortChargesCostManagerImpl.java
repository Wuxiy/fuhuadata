package com.fuhuadata.manager.impl;

import com.fuhuadata.dao.PortChargesCostDao;
import com.fuhuadata.domain.PortChargesCost;
import com.fuhuadata.domain.query.PortChargesCostQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.PortChargesCostManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 港杂费Manager
 * Created by intanswer on 2017/1/18.
 */
public class PortChargesCostManagerImpl implements PortChargesCostManager{

    private PortChargesCostDao portChargesCostDao;

    @Override
    public PortChargesCost addPortChargesCost(PortChargesCost portChargesCost) {
        return portChargesCostDao.addPortChargesCost(portChargesCost);
    }

    @Override
    public PortChargesCost getPortChargesCostById(int id) {
        return portChargesCostDao.getPortChargesCostById(id);
    }

    @Override
    public boolean updatePortChargesCostById(List<PortChargesCost> portChargesCost) {
        return portChargesCostDao.updatePortChargesCostById(portChargesCost);
    }

    @Override
    public boolean deletePortChargesCostById(int id) {
        return portChargesCostDao.deletePortChargesCostById(id) ==1 ? true : false;
    }

    @Override
    public List<PortChargesCost> getAllPortChargesCosts() {
        return portChargesCostDao.getAllortChargesCosts();
    }

    @Override
    public List<PortChargesCost> getPortChargesCostByQuery(PortChargesCostQuery portChargesCostQuery) {
        return portChargesCostDao.getPortChargesCostByQuery(portChargesCostQuery);
    }

    @Override
    public Result<List<PortChargesCost>> getPortChargesCostsByPage(PortChargesCostQuery portChargesCostQuery) {
        Result<List<PortChargesCost>> result = new Result<List<PortChargesCost>>();
        int totalItem = portChargesCostDao.count(portChargesCostQuery);
        portChargesCostQuery.setTotalItem(totalItem);
        if(totalItem>0){
            result.addDefaultModel("PortChargesCosts",portChargesCostDao.getPortChargesCostsByPage(portChargesCostQuery));
        }else{
            result.addDefaultModel("PortChargesCosts",new ArrayList<PortChargesCost>());
        }
        result.setPageSize(portChargesCostQuery.getPageSize());
        result.setIndex(portChargesCostQuery.getIndex());
        result.setTotalItem(totalItem);
        return result;
    }

    @Override
    public int count(PortChargesCostQuery portChargesCostQuery) {
        return portChargesCostDao.count(portChargesCostQuery);
    }

    public void setPortChargesCostDao(PortChargesCostDao portChargesCostDao) {
        this.portChargesCostDao = portChargesCostDao;
    }
    public PortChargesCostDao getPortChargesCostDao(){
        return this.portChargesCostDao;
    }
}

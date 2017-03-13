package com.fuhuadata.manager.impl;

import com.fuhuadata.dao.CustomerEncyclopediaDao;
import com.fuhuadata.domain.CustomerEncyclopedia;
import com.fuhuadata.domain.query.CustomerEncyclopediaQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.CustomerEncyclopediaManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 客户百科managerImpl
 * Created by intanswer on 2017/1/16.
 */
public class CustomerEncyclopediaManagerImpl implements CustomerEncyclopediaManager{
    private CustomerEncyclopediaDao customerEncyclopediaDao;
    @Override
    public CustomerEncyclopedia addCustomerEncyclopedia(CustomerEncyclopedia customerEncyclopedia) {
        return customerEncyclopediaDao.addCustomerEncyclopedia(customerEncyclopedia);
    }

    /**
     * Dao层更新成功返回1
     * @param id
     * @param customerEncyclopedia
     * @return
     */
    @Override
    public boolean updateCustomerEncyclopediaById(String id, CustomerEncyclopedia customerEncyclopedia) {
        return customerEncyclopediaDao.updateCustomerEncyclopediaById(id,customerEncyclopedia)==1? true:false;
    }

    @Override
    public boolean deleteCustomerEncyclopediaById(String id) {
        return customerEncyclopediaDao.deleteCustomerEncyclopediaById(id) == 1 ? true:false;
    }

    @Override
    public CustomerEncyclopedia getCustomerEncyclopediaById(String id) {
        return customerEncyclopediaDao.getCustomerEncyclopediaById(id);
    }

    @Override
    public List<CustomerEncyclopedia> getCustomerEncyclopediaByQuery(CustomerEncyclopediaQuery customerEncyclopediaQuery) {
        return customerEncyclopediaDao.getCustomerEncyclopediaByQuery(customerEncyclopediaQuery);
    }

    @Override
    public Result<List<CustomerEncyclopedia>> getCustomerEncyclopediasByPage(CustomerEncyclopediaQuery customerEncyclopediaQuery) {
        Result<List<CustomerEncyclopedia>> result = new Result<List<CustomerEncyclopedia>>();
        int totalItem = customerEncyclopediaDao.count(customerEncyclopediaQuery);
        customerEncyclopediaQuery.setTotalItem(totalItem);
        if(totalItem>0){
            result.addDefaultModel("CustomerEncyclopedias",customerEncyclopediaDao.getCustomerEncyclopediasByPage(customerEncyclopediaQuery));
        }else{
            result.addDefaultModel("CustomerEncyclopedias",new ArrayList<CustomerEncyclopedia>());
        }
        result.setPageSize(customerEncyclopediaQuery.getPageSize());
        result.setIndex(customerEncyclopediaQuery.getIndex());
        result.setTotalItem(customerEncyclopediaQuery.getTotalItem());
        return result;
    }

    @Override
    public int count(CustomerEncyclopediaQuery customerEncyclopediaQuery) {
        return customerEncyclopediaDao.count(customerEncyclopediaQuery);
    }

    public CustomerEncyclopediaDao getCustomerEncyclopediaDao() {
        return customerEncyclopediaDao;
    }

    public void setCustomerEncyclopediaDao(CustomerEncyclopediaDao customerEncyclopediaDao){
        this.customerEncyclopediaDao = customerEncyclopediaDao;
    }
}

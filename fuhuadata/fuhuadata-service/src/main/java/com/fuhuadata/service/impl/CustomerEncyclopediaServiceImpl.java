package com.fuhuadata.service.impl;

import com.fuhuadata.domain.CustomerEncyclopedia;
import com.fuhuadata.domain.query.CustomerEncyclopediaQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.CustomerEncyclopediaManager;
import com.fuhuadata.service.CustomerEncyclopediaService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * 客户百科服务层Impl
 * Created by intanswer on 2017/1/16.
 */
public class CustomerEncyclopediaServiceImpl implements CustomerEncyclopediaService {
    private static final Log log = LogFactory.getLog(CustomerEncyclopediaServiceImpl.class);
    private CustomerEncyclopediaManager customerEncyclopediaManager;
    @Override
    public Result<CustomerEncyclopedia> addCustomerEncyclopedia(CustomerEncyclopedia customerEncyclopedia) {
        Result<CustomerEncyclopedia> result = new Result<CustomerEncyclopedia>();
        try{
            result.addDefaultModel(customerEncyclopediaManager.addCustomerEncyclopedia(customerEncyclopedia));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("添加客户百科信息失败",e);
        }
        return result;
    }

    @Override
    public Result updateCustomerEncyclopediaById(int id, CustomerEncyclopedia customerEncyclopedia) {
        Result result = new Result();
        try{
            result.setSuccess(customerEncyclopediaManager.updateCustomerEncyclopediaById(id,customerEncyclopedia));
        }catch (Exception e){
            result.setSuccess(false);
            log.error("更新客户百科信息失败",e);
        }
        return result;
    }

    @Override
    public Result deleteCustomerEncyclopediaById(int id) {
        Result result = new Result();
        try{
            result.setSuccess(customerEncyclopediaManager.deleteCustomerEncyclopediaById(id));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("删除客户百科信息失败",e);
        }
        return result;
    }

    @Override
    public Result<List<CustomerEncyclopedia>> getCustomerEncyclopediasByPage(CustomerEncyclopediaQuery customerEncyclopediaQuery) {
        Result<List<CustomerEncyclopedia>> result = new Result<List<CustomerEncyclopedia>>();
        try{
            result=customerEncyclopediaManager.getCustomerEncyclopediasByPage(customerEncyclopediaQuery);
        }catch(Exception e){
            result.setSuccess(false);
            log.error("分页获取客户百科信息失败",e);
        }
        return result;
    }

    @Override
    public Result<Integer> count(CustomerEncyclopediaQuery customerEncyclopediaQuery) {
        Result<Integer> result = new Result<Integer>();
        try{
            result.addDefaultModel(customerEncyclopediaManager.count(customerEncyclopediaQuery));
        }catch (Exception e){
            result.setSuccess(false);
            log.error("获取客户百科数量失败",e);
        }
        return result;
    }
    public CustomerEncyclopediaManager getCustomerEncyclopediaManager(){
        return customerEncyclopediaManager;
    }
    public void setCustomerEncyclopediaManager(CustomerEncyclopediaManager customerEncyclopediaManager){
        this.customerEncyclopediaManager=customerEncyclopediaManager;
    }
}

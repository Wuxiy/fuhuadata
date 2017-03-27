package com.fuhuadata.service.impl;

import com.fuhuadata.domain.CustomerMakeProduct;
import com.fuhuadata.domain.query.CustomerMakeProductQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.CustomerMakeProductManager;
import com.fuhuadata.service.CustomerMakeProductService;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by intanswer on 2017/3/16.
 */
public class CustomerMakeProductServiceImpl implements CustomerMakeProductService {
    private static final org.apache.commons.logging.Log log = LogFactory.getLog(CustomerMakeProductServiceImpl.class);
    @Autowired
    private CustomerMakeProductManager customerMakeProductManager;
    @Override
    public Result<CustomerMakeProduct> addCustomerMakeProduct(CustomerMakeProduct customerMakeProduct) {
        Result<CustomerMakeProduct> result = new Result<CustomerMakeProduct>();
        try{
            result.addDefaultModel(customerMakeProductManager.addCustomerMakeProduct(customerMakeProduct));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("新增客户产能信息出错",e);
        }
        return result;
    }

    @Override
    public Result updateCustomerMakeProductById(int id, CustomerMakeProduct customerMakeProduct) {
        Result result = new Result();
        try{
            result.setSuccess(customerMakeProductManager.updateCustomerMakeProductById(id,customerMakeProduct));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("更新客户产能信息出错",e);
        }
        return result;
    }

    @Override
    public Result deleteCustomerMakeProductById(int id) {
        Result result = new Result();
        try{
            result.setSuccess(customerMakeProductManager.deleteCustomerMakeProductById(id));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("删除客户产能信息出错",e);
        }
        return result;
    }

    @Override
    public Result deleteCustomerMakeProductByCustomerId(String customerId) {
        Result result = new Result();
        try{
            result.setSuccess(customerMakeProductManager.deleteCustomerMakeProductByCustomerId(customerId));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("批量删除客户产能信息出错",e);
        }
        return result;
    }

    @Override
    public Result addCustomerMakeProducts(List<CustomerMakeProduct> customerMakeProducts) {
        Result result = new Result();
        try{
            result.setSuccess(customerMakeProductManager.addCustomerMakeProducts(customerMakeProducts));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("批量新增客户产能信息出错",e);
        }
        return result;
    }

    @Override
    public Result<CustomerMakeProduct> getCustomerMakeProductById(int id) {
        Result<CustomerMakeProduct> result = new Result<CustomerMakeProduct>();
        try{
            result.addDefaultModel(customerMakeProductManager.getCustomerMakeProductById(id));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("根据id获取客户产能信息出错",e);
        }
        return result;
    }

    @Override
    public Result<List<CustomerMakeProduct>> getCustomerMakeProductById(String customerId) {
        Result<List<CustomerMakeProduct>> result = new Result<List<CustomerMakeProduct>>();
        try{
            result.addDefaultModel("CustomerMakeProducts",customerMakeProductManager.getCustomerMakeProductById(customerId));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("根据客户id获取客户产能信息出错",e);
        }
        return result;
    }

    @Override
    public Result<List<CustomerMakeProduct>> getCustomerMakeProductByQuery(CustomerMakeProductQuery customerMakeProductQuery) {
        Result<List<CustomerMakeProduct>> result = new Result<List<CustomerMakeProduct>>();
        try{
            result.addDefaultModel(customerMakeProductManager.getCustomerMakeProductByQuery(customerMakeProductQuery));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("获取客户产能信息出错",e);
        }
        return result;
    }

    @Override
    public Result<Integer> count(CustomerMakeProductQuery customerMakeProductQuery) {
        Result<Integer> result = new Result<Integer>();
        try{
            result.addDefaultModel(customerMakeProductManager.count(customerMakeProductQuery));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("查询客户产品产能数量失败",e);
        }
        return result;
    }

    /**
     * 客户基本信息更新
     * @param customerMakeProducts
     * @return
     */
    @Override
    public Result updateCustomerMakeProducts(String id,CustomerMakeProduct[] customerMakeProducts) {
        Result result = new Result();
        List<CustomerMakeProduct> list = new ArrayList<CustomerMakeProduct>();
        boolean flag = false;
        try{
            list=Arrays.asList(customerMakeProducts);
            if(list!=null&&list.size()>0) {
                flag = customerMakeProductManager.deleteCustomerMakeProductByCustomerId(id);
            }
            result.setSuccess(customerMakeProductManager.addCustomerMakeProducts(list));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("更新客户产品产能信息出错",e);
        }
        return result;
    }
}

package com.fuhuadata.manager.impl;

import com.fuhuadata.dao.CustomerMakeProductDao;
import com.fuhuadata.domain.CustomerMakeProduct;
import com.fuhuadata.domain.query.CustomerMakeProductQuery;
import com.fuhuadata.manager.CustomerMakeProductManager;

import javax.annotation.Resource;
import javax.mail.Flags;
import java.util.List;

/**
 * Created by intanswer on 2017/3/16.
 */
public class CustomerMakeProductManagerImpl implements CustomerMakeProductManager {
    @Resource
    private CustomerMakeProductDao customerMakeProductDao;
    @Override
    public CustomerMakeProduct addCustomerMakeProduct(CustomerMakeProduct customerMakeProduct) {
        return customerMakeProductDao.addCustomerMakeProduct(customerMakeProduct);
    }

    @Override
    public boolean updateCustomerMakeProductById(int id, CustomerMakeProduct customerMakeProduct) {
        return customerMakeProductDao.updateCustomerMakeProductById(id,customerMakeProduct)== 1?true:false;
    }

    @Override
    public boolean deleteCustomerMakeProductById(int id) {
        return customerMakeProductDao.deleteCustomerMakeProductById(id)==1?true:false;
    }

    @Override
    public boolean deleteCustomerMakeProductByCustomerId(String customerId) {
        return  customerMakeProductDao.deleteCustomerMakeProductByCustomerId(customerId)==0?false:true;
    }

    @Override
    public boolean addCustomerMakeProducts(List<CustomerMakeProduct> customerMakeProducts) {

       boolean flag = customerMakeProductDao.addCustomerMakeProducts(customerMakeProducts)==customerMakeProducts.size()?true:false;
        System.out.println(flag);
        return flag;
    }

    @Override
    public CustomerMakeProduct getCustomerMakeProductById(int id) {
        return customerMakeProductDao.getCustomerMakeProductById(id);
    }

    @Override
    public List<CustomerMakeProduct> getCustomerMakeProductById(String customerId) {
        return customerMakeProductDao.getCustomerMakeProductById(customerId);
    }

    @Override
    public List<CustomerMakeProduct> getCustomerMakeProductByQuery(CustomerMakeProductQuery customerMakeProductQuery) {
        return customerMakeProductDao.getCustomerMakeProductByQuery(customerMakeProductQuery);
    }

    @Override
    public int count(CustomerMakeProductQuery customerMakeProductQuery) {
        return customerMakeProductDao.count(customerMakeProductQuery);
    }
}

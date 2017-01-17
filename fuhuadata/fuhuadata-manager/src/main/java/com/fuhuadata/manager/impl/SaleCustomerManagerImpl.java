package com.fuhuadata.manager.impl;
import java.util.List;
import com.fuhuadata.domain.query.QuerySaleCustomer;
import com.fuhuadata.domain.SaleCustomer;
import com.fuhuadata.dao.SaleCustomerDao;
import com.fuhuadata.manager.SaleCustomerManager;
import com.fuhuadata.domain.query.Result;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

/**
 * @author wangbo
 * @date 2017-01-12 13:27:44
 */
public class SaleCustomerManagerImpl implements SaleCustomerManager {

	@Resource
    private SaleCustomerDao saleCustomerDao;
    

    public SaleCustomer addSaleCustomer(SaleCustomer saleCustomer) {
    	return saleCustomerDao.addSaleCustomer(saleCustomer);
    }
    
    public boolean updateSaleCustomerById(String customer_id, SaleCustomer saleCustomer) {
    	return saleCustomerDao.updateSaleCustomerById(customer_id, saleCustomer) == 1 ? true : false;
    }
    
	public List<SaleCustomer> getSaleCustomersByQuery(QuerySaleCustomer querySaleCustomer) {
		return saleCustomerDao.getSaleCustomersByQuery(querySaleCustomer);
	}

    public boolean deleteSaleCustomerById(String customer_id) {
    	return saleCustomerDao.deleteSaleCustomerById(customer_id) == 1 ? true : false;
    }
    
    
    public List<SaleCustomer> getAllSaleCustomers() {
    	return saleCustomerDao.getAllSaleCustomers();
    }
    	
    public Result<List<SaleCustomer>> getSaleCustomersByPage(QuerySaleCustomer querySaleCustomer) {
		Result<List<SaleCustomer>> result = new Result<List<SaleCustomer>>();
		int totalItem = saleCustomerDao.count(querySaleCustomer);
		;
		if (totalItem > 0) {
			result.addDefaultModel("SaleCustomers", saleCustomerDao.getSaleCustomersByPage(querySaleCustomer));		
		} else {
			result.addDefaultModel("SaleCustomers", new ArrayList<SaleCustomer>());
		}
		
		result.setPageSize(querySaleCustomer.getPageSize());
		result.setIndex(querySaleCustomer.getIndex());
		result.setTotalItem(totalItem);
		
		return result;
    }
    	
    	
    public SaleCustomer getSaleCustomerById(String customer_id) {
    	return saleCustomerDao.getSaleCustomerById(customer_id);
    }
    

    public int count(QuerySaleCustomer querySaleCustomer) {
    	return saleCustomerDao.count(querySaleCustomer);
    }
    
}
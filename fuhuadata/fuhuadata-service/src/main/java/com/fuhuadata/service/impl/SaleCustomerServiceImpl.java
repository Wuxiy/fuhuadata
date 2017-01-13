package com.fuhuadata.service.impl;
import java.util.List;
import com.fuhuadata.service.SaleCustomerService;
import com.fuhuadata.domain.query.QuerySaleCustomer;
import com.fuhuadata.domain.SaleCustomer;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.SaleCustomerManager;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.io.Serializable;

/**
 * @author wangbo
 * @date 2017-01-12 13:27:44
 */
@Component
public class SaleCustomerServiceImpl implements SaleCustomerService {
	
	@Resource
    private SaleCustomerManager saleCustomerManager;
    public Result<SaleCustomer> addSaleCustomer(SaleCustomer saleCustomer) {
		Result<SaleCustomer> result = new Result<SaleCustomer>();
		try {
			result.addDefaultModel(saleCustomerManager.addSaleCustomer(saleCustomer));			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result updateSaleCustomerById(String customer_id, SaleCustomer saleCustomer) {
		Result result = new Result();
		try {
			result.setSuccess(saleCustomerManager.updateSaleCustomerById(customer_id, saleCustomer));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }
    
    public Result deleteSaleCustomerById(String customer_id) {
		Result result = new Result();
		try {
			result.setSuccess(saleCustomerManager.deleteSaleCustomerById(customer_id));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }	
    	
    public Result<List<SaleCustomer>> getSaleCustomersByQuery(QuerySaleCustomer querySaleCustomer) {
		Result<List<SaleCustomer>> result = new Result<List<SaleCustomer>>();
		try {
			result.addDefaultModel("${!className}s", saleCustomerManager.getSaleCustomersByQuery(querySaleCustomer));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<SaleCustomer> getSaleCustomerById(String customer_id) {
		Result<SaleCustomer> result = new Result<SaleCustomer>();
		try {		
		    SaleCustomer  saleCustomer = saleCustomerManager.getSaleCustomerById(customer_id);
		    if(saleCustomer == null){
				result.setSimpleErrorMsg(0, "当前数据不存在，请重试");
			}else{
				result.addDefaultModel("SaleCustomer", saleCustomer);
			}
			
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    

    public Result<List<SaleCustomer>> getSaleCustomersByPage(QuerySaleCustomer querySaleCustomer) {
		Result<List<SaleCustomer>> result = new Result<List<SaleCustomer>>();
		try {		
			result = saleCustomerManager.getSaleCustomersByPage(querySaleCustomer);
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
    	
    public Result<Integer> count(QuerySaleCustomer querySaleCustomer) {
		Result<Integer> result = new Result<Integer>();
		try {	
			result.addDefaultModel(saleCustomerManager.count(querySaleCustomer));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;	
    }
	
}
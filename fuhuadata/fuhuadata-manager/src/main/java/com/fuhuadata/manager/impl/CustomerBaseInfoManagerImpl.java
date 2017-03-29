package com.fuhuadata.manager.impl;
import com.fuhuadata.dao.CustomerMakeProductDao;
import com.fuhuadata.domain.CountCustomersOrderProduct;
import com.fuhuadata.domain.CustomerBaseInfo;
import com.fuhuadata.domain.CustomerEnterpriceNature;
import com.fuhuadata.domain.CustomerMakeProduct;
import com.fuhuadata.manager.CustomerBaseInfoManager;

import java.math.BigDecimal;
import java.util.List;

import com.fuhuadata.dao.CustomerBaseInfoDao;
import com.fuhuadata.domain.query.QueryCustomerBaseInfo;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.vo.CustomerBaseInfoVO;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author wangbo
 * @date 2017-01-12 11:49:51
 */
public class CustomerBaseInfoManagerImpl implements CustomerBaseInfoManager {

	@Resource
    private CustomerBaseInfoDao customerBaseInfoDao;

	@Resource
	private CustomerMakeProductDao customerMakeProductDao;


	/**
	 * 一般客户新增
	 * @param customerBaseInfo
	 * @return
	 */
	@Override
	public CustomerBaseInfo addCustomerBaseInfo(CustomerBaseInfo customerBaseInfo) {
		return customerBaseInfoDao.addCustomerBaseInfo(customerBaseInfo);
	}

	/**
	 * 潜在客户新增，包括产品产能和企业性质
	 * @param customerEnterpriceNatures
	 * @param customerMakeProducts
	 * @param customerBaseInfo
	 * @return
	 */
	@Transactional
    public CustomerBaseInfoVO addCustomerBaseInfo(List<CustomerEnterpriceNature> customerEnterpriceNatures, List<CustomerMakeProduct> customerMakeProducts , CustomerBaseInfo customerBaseInfo) {
		CustomerBaseInfo cbi = customerBaseInfoDao.addCustomerBaseInfo(customerBaseInfo);
		System.out.println(cbi.getCustomerId());
		for(CustomerEnterpriceNature cen:customerEnterpriceNatures){
			cen.setCustomerId(cbi.getCustomerId());
		}
		for(CustomerMakeProduct cmp : customerMakeProducts){
			cmp.setCustomerId(cbi.getCustomerId());
		}
		customerBaseInfoDao.batchAddNature(customerEnterpriceNatures);
		customerMakeProductDao.addCustomerMakeProducts(customerMakeProducts);
		return customerBaseInfoDao.getCustomerInfoById(customerBaseInfo.getCustomerId());

    }

	@Override
	public boolean deleteCustomerEnterpriceNatureByCustomerId(String customerId) {
		return customerBaseInfoDao.deleteCustomerEnterpriceNatureByCustomerId(customerId)==0?false:true;
	}

	public boolean batchAddNature(List<CustomerEnterpriceNature> customerEnterpriceNatures){
    	return customerBaseInfoDao.batchAddNature(customerEnterpriceNatures)==customerEnterpriceNatures.size()?true :false;
	}

	public boolean updateCustomerBaseInfoById(String customerId,CustomerBaseInfo customerBaseInfo){
		return customerBaseInfoDao.updateCustomerBaseInfoById(customerId,customerBaseInfo)==1?true : false;
	}
	@Transactional
	public boolean updateCustomerBaseInfo(List<CustomerEnterpriceNature> customerEnterpriceNatures, List<CustomerMakeProduct> customerMakeProducts , CustomerBaseInfo customerBaseInfo) {
		boolean flag= false;
			customerBaseInfoDao.deleteCustomerEnterpriceNatureByCustomerId(customerBaseInfo.getCustomerId());
			customerBaseInfoDao.batchAddNature(customerEnterpriceNatures);
			customerMakeProductDao.deleteCustomerMakeProductByCustomerId(customerBaseInfo.getCustomerId());
			customerMakeProductDao.addCustomerMakeProducts(customerMakeProducts);
			flag =  customerBaseInfoDao.updateCustomerBaseInfoById(customerBaseInfo.getCustomerId(), customerBaseInfo) == 1 ? true : false;

		return flag;
    }
    
	public List<CustomerBaseInfo> getCustomerBaseInfoByQuery(QueryCustomerBaseInfo queryCustomerBaseInfo) {
		return customerBaseInfoDao.getCustomerBaseInfosByQuery(queryCustomerBaseInfo);
	}

    public boolean deleteCustomerBaseInfoById(String customer_id) {
    	return customerBaseInfoDao.deleteCustomerBaseInfoById(customer_id) == 1 ? true : false;
    }
    
    
    public List<CustomerBaseInfo> getAllCustomerBaseInfos() {
    	return customerBaseInfoDao.getAllCustomerBaseInfos();
    }
    	
    public Result<List<CustomerBaseInfo>> getCustomerBaseInfoByPage(QueryCustomerBaseInfo queryCustomerBaseInfo) {
		Result<List<CustomerBaseInfo>> result = new Result<List<CustomerBaseInfo>>();
		List<CustomerBaseInfo> customerList =  customerBaseInfoDao.getCustomerBaseInfoByPage(queryCustomerBaseInfo);
		if(customerList!=null && customerList.size()>0 ){
			//如果当前查询的数据列表为合作客户或流失客户，则查询订单汇总信息
			if(queryCustomerBaseInfo.getCustomerType()!=2){
				for(CustomerBaseInfo c:customerList){
					CustomerBaseInfo order_count = customerBaseInfoDao.countOrderByCustomer(c.getCustomerId());
					if(order_count!=null){
						c.setTotalMoney(order_count.getTotalMoney());
						c.setMaintenanceFee(order_count.getMaintenanceFee());
						c.setMinPrice(order_count.getMinPrice());
						c.setNetProfit(order_count.getNetProfit());
						c.setPayMoney(order_count.getPayMoney());
					}else{
						BigDecimal default_val = new BigDecimal(0);
						c.setTotalMoney(default_val);
						c.setMaintenanceFee(default_val);
						c.setMinPrice(default_val);
						c.setNetProfit(default_val);
						c.setPayMoney(default_val);
					}
				}
			}
		}else{
			customerList =new ArrayList<CustomerBaseInfo>();
		}
		result.addDefaultModel("CustomerBaseInfos", customerList);
		return result;
    }
    	
    	
    public CustomerBaseInfo getCustomerBaseInfoById(String customer_id) {
    	return customerBaseInfoDao.getCustomerBaseInfoById(customer_id);
    }

	/**
	 * 获取客户基本信息
	 * @param id
	 * @return
	 */
	@Override
	public CustomerBaseInfoVO getCustomerInfoById(String id) {
		CustomerBaseInfoVO customerBaseInfoVO = customerBaseInfoDao.getCustomerInfoById(id);

		if(customerBaseInfoVO!=null) {
		List<CustomerMakeProduct> customerMakeProduct =customerBaseInfoDao.getCustomerMakeProductById(id);
		System.out.println(customerMakeProduct.size());
		customerBaseInfoVO.setCustomerMakeProduct(customerMakeProduct);
		}

		return customerBaseInfoVO;
	}

	@Override



	public int count(QueryCustomerBaseInfo queryCustomerBaseInfo) {
    	return customerBaseInfoDao.count(queryCustomerBaseInfo);
    }

	@Override
	public List<CountCustomersOrderProduct> countOrderProduct(String customerId) {
		return customerBaseInfoDao.countOrderProduct(customerId);
	}
}
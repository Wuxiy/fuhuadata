package com.fuhuadata.dao;
import java.util.List;

import com.fuhuadata.domain.CountCustomersOrderProduct;
import com.fuhuadata.domain.CustomerBaseInfo;
import com.fuhuadata.domain.CustomerEnterpriceNature;
import com.fuhuadata.domain.CustomerMakeProduct;
import com.fuhuadata.domain.query.QueryCustomerBaseInfo;
import com.fuhuadata.vo.CustomerBaseInfoVO;

/**
 * @author wangbo
 * @date 2017-01-12 11:49:51
 */
public interface CustomerBaseInfoDao {
	/**
	 * 新增 customerBaseInfo,返回customerBaseInfo对象(设置了新生成id)
	 * @param customerBaseInfo
	 * @return
	 */
    public CustomerBaseInfo addCustomerBaseInfo(CustomerBaseInfo customerBaseInfo);

    public int batchAddNature(List<CustomerEnterpriceNature> customerEnterpriceNatures);
    
	 /**
     * 按照主键id更新customerBaseInfo，成功返回1，使用接口时，请重新new CustomerBaseInfo 的更新对象，设置要更新的字段
     * @param customerId
     * @param customerBaseInfo
     * @return
     */
    public int updateCustomerBaseInfoById(String customerId, CustomerBaseInfo customerBaseInfo);
    
	 /**
     * 按照主键id 删除 记录，返回1为成功
     * @param customer_id
     * @return
     */
    public int deleteCustomerBaseInfoById(String customer_id);
    
	 /**
     * 返回数据库所有记录，谨慎使用，最好不用
     * @return
     */
    public List<CustomerBaseInfo> getAllCustomerBaseInfos();
    
    /**
     * 查询列表，此接口不包含分页查询，查询结果为空返回空的List对象
     * @param queryCustomerBaseInfo
     * @return
     */
    public List<CustomerBaseInfo> getCustomerBaseInfosByQuery(QueryCustomerBaseInfo queryCustomerBaseInfo);
    
    /**
     * 通过主键id查询CustomerBaseInfo，查询不到返回NULL值
     * @param customer_id
     * @return
     */
    public CustomerBaseInfo getCustomerBaseInfoById(String customer_id);

	/**
	 * 客户基本信息
	 * @param customerId
	 * @return
	 */
	public CustomerBaseInfoVO getCustomerInfoById(String customerId);

	/**
	 * 获取客户产品产能
	 * @param customerId
	 * @return
	 */
	public List<CustomerMakeProduct> getCustomerMakeProductById(String customerId);
        
	 /**
     * 查询列表，包含分页查询，查询结果为空返回空的List对象
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
     * @param queryCustomerBaseInfo
     * @return
     */
    public List<CustomerBaseInfo> getCustomerBaseInfoByPage(QueryCustomerBaseInfo queryCustomerBaseInfo);
    	
	 /**
     * 查询总数
     * @param queryCustomerBaseInfo
     * @return
     */
    public int count(QueryCustomerBaseInfo queryCustomerBaseInfo);

	/**
	 * 根据客户id汇总订单相关金额信息
	 * @param customerId
	 * @return
	 */

	public CustomerBaseInfo countOrderByCustomer(String customerId);

	/**
	 * 根据客户id汇总产品购买信息
	 * @param customerId
	 * @return
	 */
	public List<CountCustomersOrderProduct> countOrderProduct(String customerId);

	/**
	 * 根据客户id获取合作情况
	 * @param customerId
	 * @return
	 */
	public CustomerBaseInfo queryCooperationByCid(String customerId);
}
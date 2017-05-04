package com.fuhuadata.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fuhuadata.domain.CustomerProductArchives;
import com.fuhuadata.domain.query.QueryCustomerProductArchives;
import com.fuhuadata.vo.CustomerProductPackagingArchives;

/**
 * @author wangbo
 * @date 2017-02-03 15:51:13
 */
public interface CustomerProductArchivesDao {
	/**
	 * 新增 customerProductArchives,返回customerProductInfo对象(设置了新生成id)
	 * @param customerProductArchives
	 * @return
	 */
    public CustomerProductArchives addCustomerProductInfo(CustomerProductArchives customerProductArchives);
    
	 /**
     * 按照主键id更新customerProductInfo，成功返回1，使用接口时，请重新new QueryCustomerProductArchives 的更新对象，设置要更新的字段
     * @param customer_product_id
     * @param customerProductArchives
     * @return
     */
    public int updateCustomerProductInfoById(int customer_product_id, CustomerProductArchives customerProductArchives);
    
	 /**
     * 按照主键id 删除 记录，返回1为成功
     * @param customer_product_id
     * @return
     */
    public int deleteCustomerProductInfoById(int customer_product_id);
    
	 /**
     * 返回数据库所有记录，谨慎使用，最好不用
     * @return
     */
    public List<CustomerProductArchives> getAllCustomerProductInfos();
    
    /**
     * 查询列表，此接口不包含分页查询，查询结果为空返回空的List对象
     * @param queryCustomerProductArchives
     * @return
     */
    public List<CustomerProductArchives> getCustomerProductInfosByQuery(QueryCustomerProductArchives queryCustomerProductArchives);
    
    /**
     * 通过主键id查询CustomerProductInfo，查询不到返回NULL值
     * @param customer_product_id
     * @return
     */
    public CustomerProductArchives getCustomerProductInfoById(int customer_product_id);

	/**
	 * 知识库-结合客户标准产品档案表和规格型号表查询客户包装要求信息
	 * @return
	 */
	public List<CustomerProductPackagingArchives> getCustomerProductPackagingArchives(CustomerProductPackagingArchives cppa);
	/**
	 *
	 * @param cppa
	 * @return
	 */
	public int countCustomerProductPackagingArchives(CustomerProductPackagingArchives cppa);

	/**
	 * 根据id获取客户产品要求
	 * @param customerId
	 * @return
	 */
	public List<CustomerProductPackagingArchives> getCustomerProductPackingArchivesById(String customerId);

	/**
	 * 根据客户产品档案id获取 客户产品要求页面所需ids
	 * @param id
	 * @return
	 */
	public CustomerProductPackagingArchives getCustomerProductIds(int id);
        
	 /**
     * 查询列表，包含分页查询，查询结果为空返回空的List对象
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
     * @param queryCustomerProductArchives
     * @return
     */
    public List<CustomerProductArchives> getCustomerProductInfosByPage(QueryCustomerProductArchives queryCustomerProductArchives);
    	
	 /**
     * 查询总数
     * @param queryCustomerProductArchives
     * @return
     */
    public int count(QueryCustomerProductArchives queryCustomerProductArchives);

	/**
	 * 查询用户产品档案单据要求
	 * @param customerId
	 * @return
	 */
	public List<CustomerProductArchives> getCustomerBillRequirement(String customerId);


	/**
	 * 查询用户产品档案订舱出运要求
	 * @param customerId
	 * @return
	 */
	public List<CustomerProductArchives> getCustomerTransportRequirement(String customerId);

	/**
	 * 查询订单产品插入到客户产品档案库
	 * @param businessProductId
	 * @return
	 */
	int addArchives(Integer businessProductId);

	/**
	 * 根据订单产品表主键更新客户产品表档案
	 * @param businessProductId
	 * @return
	 */
	int updateArchives(Integer businessProductId);




}
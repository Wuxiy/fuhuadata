package com.fuhuadata.service;
import java.util.List;

import com.fuhuadata.domain.CustomerProductArchives;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.QueryCustomerProductArchives;
import com.fuhuadata.vo.CustomerProductPackagingArchives;

/**
 * @author wangbo
 * @date 2017-02-03 15:51:13
 */
public interface CustomerProductArchivesService {

	/**
	 * 新增 customerProductArchives
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到新增 customerProductArchives
	 * @param customerProductArchives
	 * @return
	 */
    public Result<CustomerProductArchives> addCustomerProductInfo(CustomerProductArchives customerProductArchives) ;
 
    /**
     * 按照主键id更新customerProductInfo，请重新new QueryCustomerProductArchives 的更新对象，设置要更新的字段
	 * 返回result，通过result.isSuccess()判断更新是否成功
     * @param customer_product_id
     * @param customerProductArchives
     * @return
     */
    public Result updateCustomerProductInfoById(int customer_product_id, CustomerProductArchives customerProductArchives);

    /**
     * 按照主键id 删除 记录
	 * 返回result，通过result.isSuccess()判断删除是否成功
     * @param customer_product_id
     * @return
     */
    public Result deleteCustomerProductInfoById(int customer_product_id);

	/**
	 * 知识库-客户产品包装要求
	 * @return
	 */
	public Result<List<CustomerProductPackagingArchives>> getCustomerProductPackagingArchives(CustomerProductPackagingArchives customerProductPackagingArchives);

	/**
	 *  知识库-客户产品包装要求 count
	 * @param cppa
	 * @return
	 */
	public Result<Integer> countCustomerProductPackagingArchives(CustomerProductPackagingArchives cppa);

	public Result<List<CustomerProductPackagingArchives>> getCustomerProductPackagingArchivesById(String customerId);

	/**
     * 查询列表，此接口不包含分页查询
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到列表信息
     * @param queryCustomerProductArchives
     * @return
     */
    public Result<List<CustomerProductArchives>> getCustomerProductInfosByQuery(QueryCustomerProductArchives queryCustomerProductArchives);

    /**
     * 通过主键id查询CustomerProductInfo
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到查询的单条customerProductInfo信息
     * @param customer_product_id
     * @return
     */
    public Result<CustomerProductArchives> getCustomerProductInfoById(int customer_product_id);

    /**
     * 查询列表，包含分页查询
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getTotal()返回结果总数
	 * 通过result.getModel()得到查询的单页列表信息
     * @param queryCustomerProductArchives
     * @return
     */
    public Result<List<CustomerProductArchives>> getCustomerProductInfosByPage(QueryCustomerProductArchives queryCustomerProductArchives);

    /**
     * 查询总数
     * @param queryCustomerProductArchives
     * @return
     */
    public Result<Integer> count(QueryCustomerProductArchives queryCustomerProductArchives);

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
	 * 根据客户产品档案id 查询详情页所需id
	 * @param id
	 * @return
	 */
	public Result<CustomerProductPackagingArchives> getCustomerProductIds(int id);

	
}
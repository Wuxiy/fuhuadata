package com.fuhuadata.service;
import java.util.List;

import com.fuhuadata.domain.CustomerBaseInfo;
import com.fuhuadata.domain.query.QueryCustomerBaseInfo;
import com.fuhuadata.domain.query.Result;

/**
 * @author wangbo
 * @date 2017-01-12 11:49:51
 */
public interface CustomerBaseInfoService {

	/**
	 * 新增 customerParent
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到新增 customerParent
	 * @param customerParent
	 * @return
	 */
    public Result<CustomerBaseInfo> addCustomerParent(CustomerBaseInfo customerParent) ;
 
    /**
     * 按照主键id更新customerParent，请重新new CustomerBaseInfo 的更新对象，设置要更新的字段
	 * 返回result，通过result.isSuccess()判断更新是否成功
     * @param customer_id
     * @param customerParent
     * @return
     */
    public Result updateCustomerParentById(String customer_id, CustomerBaseInfo customerParent);

    /**
     * 按照主键id 删除 记录
	 * 返回result，通过result.isSuccess()判断删除是否成功
     * @param customer_id
     * @return
     */
    public Result deleteCustomerParentById(String customer_id);
    
    /**
     * 查询列表，此接口不包含分页查询
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到列表信息
     * @param queryCustomerParent
     * @return
     */
    public Result<List<CustomerBaseInfo>> getCustomerParentsByQuery(QueryCustomerBaseInfo queryCustomerParent);

    /**
     * 通过主键id查询CustomerParent
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到查询的单条customerParent信息
     * @param customer_id
     * @return
     */
    public Result<CustomerBaseInfo> getCustomerParentById(String customer_id);

    /**
     * 查询列表，包含分页查询
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getTotal()返回结果总数
	 * 通过result.getModel()得到查询的单页列表信息
     * @param queryCustomerParent
     * @return
     */
    public Result<List<CustomerBaseInfo>> getCustomerParentsByPage(QueryCustomerBaseInfo queryCustomerParent);

    /**
     * 查询总数
     * @param queryCustomerParent
     * @return
     */
    public Result<Integer> count(QueryCustomerBaseInfo queryCustomerParent);
	
}
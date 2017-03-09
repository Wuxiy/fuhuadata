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
	 * 新增 customerBaseInfo
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到新增 customerBaseInfo
	 * @param customerBaseInfo
	 * @return
	 */
    public Result<CustomerBaseInfo> addCustomerBaseInfo(CustomerBaseInfo customerBaseInfo) ;
 
    /**
     * 按照主键id更新customerBaseInfo，请重新new CustomerBaseInfo 的更新对象，设置要更新的字段
	 * 返回result，通过result.isSuccess()判断更新是否成功
     * @param customer_id
     * @param customerBaseInfo
     * @return
     */
    public Result updateCustomerBaseInfoById(String customer_id, CustomerBaseInfo customerBaseInfo);

    /**
     * 按照主键id 删除 记录
	 * 返回result，通过result.isSuccess()判断删除是否成功
     * @param customer_id
     * @return
     */
    public Result deleteCustomerBaseInfoById(String customer_id);
    
    /**
     * 查询列表，此接口不包含分页查询
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到列表信息
     * @param queryCustomerBaseInfo
     * @return
     */
    public Result<List<CustomerBaseInfo>> getCustomerBaseInfoByQuery(QueryCustomerBaseInfo queryCustomerBaseInfo);

    /**
     * 通过主键id查询CustomerBaseInfo
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到查询的单条customerBaseInfo信息
     * @param customer_id
     * @return
     */
    public Result<CustomerBaseInfo> getCustomerBaseInfoById(String customer_id);

    /**
     * 查询列表，包含分页查询
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getTotal()返回结果总数
	 * 通过result.getModel()得到查询的单页列表信息
     * @param queryCustomerBaseInfo
     * @return
     */
    public Result<List<CustomerBaseInfo>> getCustomerBaseInfoByPage(QueryCustomerBaseInfo queryCustomerBaseInfo);

    /**
     * 查询总数
     * @param queryCustomerBaseInfo
     * @return
     */
    public Result<Integer> count(QueryCustomerBaseInfo queryCustomerBaseInfo);
	
}
package com.fuhuadata.service;
import java.util.List;

import com.fuhuadata.domain.CustomerEnterpriceNature;
import com.fuhuadata.domain.query.QueryCustomerSubcompanyInfo;
import com.fuhuadata.domain.CustomerSubcompanyInfo;
import com.fuhuadata.domain.query.Result;

/**
 * @author wangbo
 * @date 2017-01-12 13:37:25
 */
public interface CustomerSubcompanyInfoService {

	/**
	 * 新增 customerSubcompanyInfo
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到新增 customerSubcompanyInfo
	 * @param customerSubcompanyInfo
	 * @return
	 */
    public Result<CustomerSubcompanyInfo> addCustomerSubcompanyInfo(CustomerSubcompanyInfo customerSubcompanyInfo,List<CustomerEnterpriceNature> customerEnterpriceNatures) ;
 
    /**
     * 按照主键id更新customerSubcompanyInfo，请重新new CustomerSubcompanyInfo 的更新对象，设置要更新的字段
	 * 返回result，通过result.isSuccess()判断更新是否成功
     * @param
     * @param customerSubcompanyInfo
     * @return
     */
    public Result updateCustomerSubcompanyInfoById(List<CustomerEnterpriceNature> list, CustomerSubcompanyInfo customerSubcompanyInfo);

	/**
	 * 根据客户id获取子公司列表
	 * @param customerId
	 * @return
	 */
	public Result<List<CustomerSubcompanyInfo>> getCustomerSubcompanyInfoByCustomerId(String customerId);

    /**
     * 按照主键id 删除 记录
	 * 返回result，通过result.isSuccess()判断删除是否成功
     * @param customer_sub_id
     * @return
     */
    public Result deleteCustomerSubcompanyInfoById(int customer_sub_id);
    
    /**
     * 查询列表，此接口不包含分页查询
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到列表信息
     * @param queryCustomerSubcompanyInfo
     * @return
     */
    public Result<List<CustomerSubcompanyInfo>> getCustomerSubcompanyInfosByQuery(QueryCustomerSubcompanyInfo queryCustomerSubcompanyInfo);

    /**
     * 通过主键id查询CustomerSubcompanyInfo
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到查询的单条customerSubcompanyInfo信息
     * @param customer_sub_id
     * @return
     */
    public Result<CustomerSubcompanyInfo> getCustomerSubcompanyInfoById(int customer_sub_id);

    /**
     * 查询列表，包含分页查询
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getTotal()返回结果总数
	 * 通过result.getModel()得到查询的单页列表信息
     * @param queryCustomerSubcompanyInfo
     * @return
     */
    public Result<List<CustomerSubcompanyInfo>> getCustomerSubcompanyInfosByPage(QueryCustomerSubcompanyInfo queryCustomerSubcompanyInfo);

    /**
     * 查询总数
     * @param queryCustomerSubcompanyInfo
     * @return
     */
    public Result<Integer> count(QueryCustomerSubcompanyInfo queryCustomerSubcompanyInfo);
	
}
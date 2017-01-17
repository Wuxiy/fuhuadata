package com.fuhuadata.service;
import java.util.List;
import com.fuhuadata.domain.CustomerParent;
import com.fuhuadata.domain.query.QueryCustomerParent;
import com.fuhuadata.domain.query.Result;

/**
 * @author wangbo
 * @date 2017-01-12 11:49:51
 */
public interface CustomerParentService {

	/**
	 * 新增 customerParent
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到新增 customerParent
	 * @param customerParent
	 * @return
	 */
    public Result<CustomerParent> addCustomerParent(CustomerParent customerParent) ;
 
    /**
     * 按照主键id更新customerParent，请重新new CustomerParent 的更新对象，设置要更新的字段
	 * 返回result，通过result.isSuccess()判断更新是否成功
     * @param customer_id
     * @param customerParent
     * @return
     */
    public Result updateCustomerParentById(String customer_id, CustomerParent customerParent);

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
    public Result<List<CustomerParent>> getCustomerParentsByQuery(QueryCustomerParent queryCustomerParent);

    /**
     * 通过主键id查询CustomerParent
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到查询的单条customerParent信息
     * @param customer_id
     * @return
     */
    public Result<CustomerParent> getCustomerParentById(String customer_id);

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
    public Result<List<CustomerParent>> getCustomerParentsByPage(QueryCustomerParent queryCustomerParent);

    /**
     * 查询总数
     * @param queryCustomerParent
     * @return
     */
    public Result<Integer> count(QueryCustomerParent queryCustomerParent);
	
}
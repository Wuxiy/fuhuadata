package com.fuhuadata.service;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.CustomerProductInfo;
import com.fuhuadata.domain.query.QueryCustomerProductInfo;

/**
 * @author wangbo
 * @date 2017-02-03 15:51:13
 */
public interface CustomerProductInfoService {

	/**
	 * 新增 customerProductInfo
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到新增 customerProductInfo
	 * @param customerProductInfo
	 * @return
	 */
    public Result<CustomerProductInfo> addCustomerProductInfo(CustomerProductInfo customerProductInfo) ;
 
    /**
     * 按照主键id更新customerProductInfo，请重新new CustomerProductInfo 的更新对象，设置要更新的字段
	 * 返回result，通过result.isSuccess()判断更新是否成功
     * @param customer_product_id
     * @param customerProductInfo
     * @return
     */
    public Result updateCustomerProductInfoById(int customer_product_id, CustomerProductInfo customerProductInfo);

    /**
     * 按照主键id 删除 记录
	 * 返回result，通过result.isSuccess()判断删除是否成功
     * @param customer_product_id
     * @return
     */
    public Result deleteCustomerProductInfoById(int customer_product_id);
    
    /**
     * 查询列表，此接口不包含分页查询
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到列表信息
     * @param queryCustomerProductInfo
     * @return
     */
    public Result<List<CustomerProductInfo>> getCustomerProductInfosByQuery(QueryCustomerProductInfo queryCustomerProductInfo);

    /**
     * 通过主键id查询CustomerProductInfo
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到查询的单条customerProductInfo信息
     * @param customer_product_id
     * @return
     */
    public Result<CustomerProductInfo> getCustomerProductInfoById(int customer_product_id);

    /**
     * 查询列表，包含分页查询
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getTotal()返回结果总数
	 * 通过result.getModel()得到查询的单页列表信息
     * @param queryCustomerProductInfo
     * @return
     */
    public Result<List<CustomerProductInfo>> getCustomerProductInfosByPage(QueryCustomerProductInfo queryCustomerProductInfo);

    /**
     * 查询总数
     * @param queryCustomerProductInfo
     * @return
     */
    public Result<Integer> count(QueryCustomerProductInfo queryCustomerProductInfo);
	
}
package com.fuhuadata.service;
import java.util.List;
import com.fuhuadata.domain.query.QuerySaleCustomer;
import com.fuhuadata.domain.SaleCustomer;
import com.fuhuadata.domain.query.Result;

/**
 * @author wangbo
 * @date 2017-01-12 13:27:44
 */
public interface SaleCustomerService {

	/**
	 * 新增 saleCustomer
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到新增 saleCustomer
	 * @param saleCustomer
	 * @return
	 */
    public Result<SaleCustomer> addSaleCustomer(SaleCustomer saleCustomer) ;
 
    /**
     * 按照主键id更新saleCustomer，请重新new SaleCustomer 的更新对象，设置要更新的字段
	 * 返回result，通过result.isSuccess()判断更新是否成功
     * @param customer_id
     * @param saleCustomer
     * @return
     */
    public Result updateSaleCustomerById(String customer_id, SaleCustomer saleCustomer);

    /**
     * 按照主键id 删除 记录
	 * 返回result，通过result.isSuccess()判断删除是否成功
     * @param customer_id
     * @return
     */
    public Result deleteSaleCustomerById(String customer_id);
    
    /**
     * 查询列表，此接口不包含分页查询
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到列表信息
     * @param querySaleCustomer
     * @return
     */
    public Result<List<SaleCustomer>> getSaleCustomersByQuery(QuerySaleCustomer querySaleCustomer);

    /**
     * 通过主键id查询SaleCustomer
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到查询的单条saleCustomer信息
     * @param customer_id
     * @return
     */
    public Result<SaleCustomer> getSaleCustomerById(String customer_id);

    /**
     * 查询列表，包含分页查询
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getTotal()返回结果总数
	 * 通过result.getModel()得到查询的单页列表信息
     * @param querySaleCustomer
     * @return
     */
    public Result<List<SaleCustomer>> getSaleCustomersByPage(QuerySaleCustomer querySaleCustomer);

    /**
     * 查询总数
     * @param querySaleCustomer
     * @return
     */
    public Result<Integer> count(QuerySaleCustomer querySaleCustomer);
	
}
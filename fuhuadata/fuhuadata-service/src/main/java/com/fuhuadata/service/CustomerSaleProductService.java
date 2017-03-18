package com.fuhuadata.service;
import java.util.List;
import com.fuhuadata.domain.query.QueryCustomerSaleProduct;
import com.fuhuadata.domain.CustomerSaleProduct;
import com.fuhuadata.domain.query.Result;

/**
 * @author wangbo
 * @date 2017-01-12 13:41:04
 */
public interface CustomerSaleProductService {

	/**
	 * 新增 customerSaleProduct
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到新增 customerSaleProduct
	 * @param customerSaleProduct
	 * @return
	 */
    public Result<CustomerSaleProduct> addCustomerSaleProduct(CustomerSaleProduct customerSaleProduct) ;

	public boolean batchInsert(List<CustomerSaleProduct> customerSaleProducts);
    /**
     * 按照主键id更新customerSaleProduct，请重新new CustomerSaleProduct 的更新对象，设置要更新的字段
	 * 返回result，通过result.isSuccess()判断更新是否成功
     * @param id
     * @param customerSaleProduct
     * @return
     */
    public Result updateCustomerSaleProductById(int id, CustomerSaleProduct customerSaleProduct);

    /**
     * 按照主键id 删除 记录
	 * 返回result，通过result.isSuccess()判断删除是否成功
     * @param id
     * @return
     */
    public Result deleteCustomerSaleProductById(int id);
    
    /**
     * 查询列表，此接口不包含分页查询
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到列表信息
     * @param queryCustomerSaleProduct
     * @return
     */
    public Result<List<CustomerSaleProduct>> getCustomerSaleProductsByQuery(QueryCustomerSaleProduct queryCustomerSaleProduct);

    /**
     * 通过主键id查询CustomerSaleProduct
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到查询的单条customerSaleProduct信息
     * @param id
     * @return
     */
    public Result<CustomerSaleProduct> getCustomerSaleProductById(int id);

    /**
     * 查询列表，包含分页查询
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getTotal()返回结果总数
	 * 通过result.getModel()得到查询的单页列表信息
     * @param queryCustomerSaleProduct
     * @return
     */
    public Result<List<CustomerSaleProduct>> getCustomerSaleProductsByPage(QueryCustomerSaleProduct queryCustomerSaleProduct);

    /**
     * 查询总数
     * @param queryCustomerSaleProduct
     * @return
     */
    public Result<Integer> count(QueryCustomerSaleProduct queryCustomerSaleProduct);
	
}
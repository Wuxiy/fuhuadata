package com.fuhuadata.service;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.CustomerPurchaseProduct;
import com.fuhuadata.domain.query.QueryCustomerPurchaseProduct;
import java.util.Map;
import java.io.Serializable;

/**
 * @author wangbo
 * @date 2017-01-12 13:51:34
 */
public interface CustomerPurchaseProductService {

	/**
	 * 新增 customerPurchaseProduct
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到新增 customerPurchaseProduct
	 * @param customerPurchaseProduct
	 * @return
	 */
    public Result<CustomerPurchaseProduct> addCustomerPurchaseProduct(CustomerPurchaseProduct customerPurchaseProduct) ;
 
    /**
     * 按照主键id更新customerPurchaseProduct，请重新new CustomerPurchaseProduct 的更新对象，设置要更新的字段
	 * 返回result，通过result.isSuccess()判断更新是否成功
     * @param id
     * @param customerPurchaseProduct
     * @return
     */
    public Result updateCustomerPurchaseProductById(int id, CustomerPurchaseProduct customerPurchaseProduct);

    /**
     * 按照主键id 删除 记录
	 * 返回result，通过result.isSuccess()判断删除是否成功
     * @param id
     * @return
     */
    public Result deleteCustomerPurchaseProductById(int id);
    
    /**
     * 查询列表，此接口不包含分页查询
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到列表信息
     * @param queryCustomerPurchaseProduct
     * @return
     */
    public Result<List<CustomerPurchaseProduct>> getCustomerPurchaseProductsByQuery(QueryCustomerPurchaseProduct queryCustomerPurchaseProduct);

    /**
     * 通过主键id查询CustomerPurchaseProduct
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到查询的单条customerPurchaseProduct信息
     * @param id
     * @return
     */
    public Result<CustomerPurchaseProduct> getCustomerPurchaseProductById(int id);

    /**
     * 查询列表，包含分页查询
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getTotal()返回结果总数
	 * 通过result.getModel()得到查询的单页列表信息
     * @param queryCustomerPurchaseProduct
     * @return
     */
    public Result<List<CustomerPurchaseProduct>> getCustomerPurchaseProductsByPage(QueryCustomerPurchaseProduct queryCustomerPurchaseProduct);

    /**
     * 查询总数
     * @param queryCustomerPurchaseProduct
     * @return
     */
    public Result<Integer> count(QueryCustomerPurchaseProduct queryCustomerPurchaseProduct);
	
}
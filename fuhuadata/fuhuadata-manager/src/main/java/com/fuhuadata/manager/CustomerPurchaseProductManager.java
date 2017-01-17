package com.fuhuadata.manager;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.CustomerPurchaseProduct;
import com.fuhuadata.domain.query.QueryCustomerPurchaseProduct;

/**
 * @author wangbo
 * @date 2017-01-12 13:51:34
 */
public interface CustomerPurchaseProductManager {
	/**
	 * 新增 customerPurchaseProduct,返回customerPurchaseProduct对象(设置了新生成id)
	 * @param customerPurchaseProduct
	 * @return
	 */
    public CustomerPurchaseProduct addCustomerPurchaseProduct(CustomerPurchaseProduct customerPurchaseProduct) ;
    
	 /**
     * 按照主键id更新customerPurchaseProduct，请重新new CustomerPurchaseProduct 的更新对象，设置要更新的字段
	 * 成功返回true，失败返回false
     * @param id
     * @param customerPurchaseProduct
     * @return
     */
    public boolean updateCustomerPurchaseProductById(int id, CustomerPurchaseProduct customerPurchaseProduct);

    /**
     * 按照主键id 删除 记录
	 * 成功返回true，失败返回false
     * @param id
     * @return
     */
    public boolean deleteCustomerPurchaseProductById(int id);

    /**
     * 返回数据库所有记录，谨慎使用，最好不用
     * @return
     */
    public List<CustomerPurchaseProduct> getAllCustomerPurchaseProducts();
    
	/**
     * 查询列表，此接口不包含分页查询，查询结果为空返回空的List对象
     * @param queryCustomerPurchaseProduct
     * @return
     */    	
    public List<CustomerPurchaseProduct> getCustomerPurchaseProductsByQuery(QueryCustomerPurchaseProduct queryCustomerPurchaseProduct);

    /**
     * 通过主键id查询CustomerPurchaseProduct
	 * 查询不到返回NULL值
     * @param id
     * @return
     */
    public CustomerPurchaseProduct getCustomerPurchaseProductById(int id);

    /**
     * 查询列表，包含分页查询，
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回Result中，可以通过result.getTotal()返回结果总数，
	 * result中包装了分页需要的信息，和当前列表
     * @param queryCustomerPurchaseProduct
     * @return
     */
    public Result<List<CustomerPurchaseProduct>> getCustomerPurchaseProductsByPage(QueryCustomerPurchaseProduct queryCustomerPurchaseProduct);

    /**
     * 查询总数
     * @param queryCustomerPurchaseProduct
     * @return
     */
    public int count(QueryCustomerPurchaseProduct queryCustomerPurchaseProduct);
	
}
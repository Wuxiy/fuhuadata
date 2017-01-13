package com.fuhuadata.manager;
import java.util.List;
import com.fuhuadata.domain.query.QueryCustomerSaleProduct;
import com.fuhuadata.domain.CustomerSaleProduct;
import com.fuhuadata.domain.query.Result;
import java.util.Map;
import java.io.Serializable;

/**
 * @author wangbo
 * @date 2017-01-12 13:41:04
 */
public interface CustomerSaleProductManager {
	/**
	 * 新增 customerSaleProduct,返回customerSaleProduct对象(设置了新生成id)
	 * @param customerSaleProduct
	 * @return
	 */
    public CustomerSaleProduct addCustomerSaleProduct(CustomerSaleProduct customerSaleProduct) ;
    
	 /**
     * 按照主键id更新customerSaleProduct，请重新new CustomerSaleProduct 的更新对象，设置要更新的字段
	 * 成功返回true，失败返回false
     * @param id
     * @param customerSaleProduct
     * @return
     */
    public boolean updateCustomerSaleProductById(int id, CustomerSaleProduct customerSaleProduct);

    /**
     * 按照主键id 删除 记录
	 * 成功返回true，失败返回false
     * @param id
     * @return
     */
    public boolean deleteCustomerSaleProductById(int id);

    /**
     * 返回数据库所有记录，谨慎使用，最好不用
     * @return
     */
    public List<CustomerSaleProduct> getAllCustomerSaleProducts();
    
	/**
     * 查询列表，此接口不包含分页查询，查询结果为空返回空的List对象
     * @param queryCustomerSaleProduct
     * @return
     */    	
    public List<CustomerSaleProduct> getCustomerSaleProductsByQuery(QueryCustomerSaleProduct queryCustomerSaleProduct);

    /**
     * 通过主键id查询CustomerSaleProduct
	 * 查询不到返回NULL值
     * @param id
     * @return
     */
    public CustomerSaleProduct getCustomerSaleProductById(int id);

    /**
     * 查询列表，包含分页查询，
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回Result中，可以通过result.getTotal()返回结果总数，
	 * result中包装了分页需要的信息，和当前列表
     * @param queryCustomerSaleProduct
     * @return
     */
    public Result<List<CustomerSaleProduct>> getCustomerSaleProductsByPage(QueryCustomerSaleProduct queryCustomerSaleProduct);

    /**
     * 查询总数
     * @param queryCustomerSaleProduct
     * @return
     */
    public int count(QueryCustomerSaleProduct queryCustomerSaleProduct);
	
}
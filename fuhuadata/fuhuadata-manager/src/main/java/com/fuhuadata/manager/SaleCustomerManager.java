package com.fuhuadata.manager;
import java.util.List;
import com.fuhuadata.domain.query.QuerySaleCustomer;
import com.fuhuadata.domain.SaleCustomer;
import com.fuhuadata.domain.query.Result;

/**
 * @author wangbo
 * @date 2017-01-12 13:27:44
 */
public interface SaleCustomerManager {
	/**
	 * 新增 saleCustomer,返回saleCustomer对象(设置了新生成id)
	 * @param saleCustomer
	 * @return
	 */
    public SaleCustomer addSaleCustomer(SaleCustomer saleCustomer) ;
    
	 /**
     * 按照主键id更新saleCustomer，请重新new SaleCustomer 的更新对象，设置要更新的字段
	 * 成功返回true，失败返回false
     * @paramid
     * @param saleCustomer
     * @return
     */
    public boolean updateSaleCustomerById(String customer_id, SaleCustomer saleCustomer);

    /**
     * 按照主键id 删除 记录
	 * 成功返回true，失败返回false
     * @param customer_id
     * @return
     */
    public boolean deleteSaleCustomerById(String customer_id);

    /**
     * 返回数据库所有记录，谨慎使用，最好不用
     * @return
     */
    public List<SaleCustomer> getAllSaleCustomers();
    
	/**
     * 查询列表，此接口不包含分页查询，查询结果为空返回空的List对象
     * @param querySaleCustomer
     * @return
     */    	
    public List<SaleCustomer> getSaleCustomersByQuery(QuerySaleCustomer querySaleCustomer);

    /**
     * 通过主键id查询SaleCustomer
	 * 查询不到返回NULL值
     * @param customer_id
     * @return
     */
    public SaleCustomer getSaleCustomerById(String customer_id);

    /**
     * 查询列表，包含分页查询，
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回Result中，可以通过result.getTotal()返回结果总数，
	 * result中包装了分页需要的信息，和当前列表
     * @param querySaleCustomer
     * @return
     */
    public Result<List<SaleCustomer>> getSaleCustomersByPage(QuerySaleCustomer querySaleCustomer);

    /**
     * 查询总数
     * @param querySaleCustomer
     * @return
     */
    public int count(QuerySaleCustomer querySaleCustomer);
	
}
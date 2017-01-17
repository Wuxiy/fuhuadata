package com.fuhuadata.manager;
import java.util.List;
import com.fuhuadata.domain.CustomerParent;
import com.fuhuadata.domain.query.QueryCustomerParent;
import com.fuhuadata.domain.query.Result;

/**
 * @author wangbo
 * @date 2017-01-12 11:49:51
 */
public interface CustomerParentManager {
	/**
	 * 新增 customerParent,返回customerParent对象(设置了新生成id)
	 * @param customerParent
	 * @return
	 */
    public CustomerParent addCustomerParent(CustomerParent customerParent) ;
    
	 /**
     * 按照主键id更新customerParent，请重新new CustomerParent 的更新对象，设置要更新的字段
	 * 成功返回true，失败返回false
     * @paramid
     * @param customerParent
     * @return
     */
    public boolean updateCustomerParentById(String customer_id, CustomerParent customerParent);

    /**
     * 按照主键id 删除 记录
	 * 成功返回true，失败返回false
     * @paramid
     * @return
     */
    public boolean deleteCustomerParentById(String customer_id);

    /**
     * 返回数据库所有记录，谨慎使用，最好不用
     * @return
     */
    public List<CustomerParent> getAllCustomerParents();
    
	/**
     * 查询列表，此接口不包含分页查询，查询结果为空返回空的List对象
     * @param queryCustomerParent
     * @return
     */    	
    public List<CustomerParent> getCustomerParentsByQuery(QueryCustomerParent queryCustomerParent);

    /**
     * 通过主键id查询CustomerParent
	 * 查询不到返回NULL值
     * @paramid
     * @return
     */
    public CustomerParent getCustomerParentById(String customer_id);

    /**
     * 查询列表，包含分页查询，
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回Result中，可以通过result.getTotal()返回结果总数，
	 * result中包装了分页需要的信息，和当前列表
     * @param queryCustomerParent
     * @return
     */
    public Result<List<CustomerParent>> getCustomerParentsByPage(QueryCustomerParent queryCustomerParent);

    /**
     * 查询总数
     * @param queryCustomerParent
     * @return
     */
    public int count(QueryCustomerParent queryCustomerParent);
	
}
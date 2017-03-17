package com.fuhuadata.manager;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.QueryCustomerLinkman;
import com.fuhuadata.domain.CustomerLinkman;

/**
 * @author wangbo
 * @date 2017-01-13 16:10:56
 */
public interface CustomerLinkmanManager {
	/**
	 * 新增 customerLinkman,返回customerLinkman对象(设置了新生成id)
	 * @param customerLinkman
	 * @return
	 */
    public CustomerLinkman addCustomerLinkman(CustomerLinkman customerLinkman) ;
    
	 /**
     * 按照主键id更新customerLinkman，请重新new CustomerLinkman 的更新对象，设置要更新的字段
	 * 成功返回true，失败返回false
     * @param linkman_id
     * @param customerLinkman
     * @return
     */
    public boolean updateCustomerLinkmanById(String linkman_id, CustomerLinkman customerLinkman);

    /**
     * 按照主键id 删除 记录
	 * 成功返回true，失败返回false
     * @param linkman_id
     * @return
     */
    public boolean deleteCustomerLinkmanById(String linkman_id);

    /**
     * 返回数据库所有记录，谨慎使用，最好不用
     * @return
     */
    public List<CustomerLinkman> getAllCustomerLinkmans();
    
	/**
     * 查询列表，此接口不包含分页查询，查询结果为空返回空的List对象
     * @param queryCustomerLinkman
     * @return
     */    	
    public List<CustomerLinkman> getCustomerLinkmansByQuery(QueryCustomerLinkman queryCustomerLinkman);

    /**
     * 通过主键id查询CustomerLinkman
	 * 查询不到返回NULL值
     * @param linkman_id
     * @return
     */
    public CustomerLinkman getCustomerLinkmanById(String linkman_id);

	public List<CustomerLinkman> getCustomerLinkmanByCustomerId(String customerId);

    /**
     * 查询列表，包含分页查询，
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回Result中，可以通过result.getTotal()返回结果总数，
	 * result中包装了分页需要的信息，和当前列表
     * @param queryCustomerLinkman
     * @return
     */
    public Result<List<CustomerLinkman>> getCustomerLinkmansByPage(QueryCustomerLinkman queryCustomerLinkman);

    /**
     * 查询总数
     * @param queryCustomerLinkman
     * @return
     */
    public int count(QueryCustomerLinkman queryCustomerLinkman);
	
}
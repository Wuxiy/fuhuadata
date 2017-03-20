package com.fuhuadata.dao;
import java.util.List;
import com.fuhuadata.domain.query.QueryCustomerLinkman;
import com.fuhuadata.domain.CustomerLinkman;
import java.util.Map;
import java.io.Serializable;

/**
 * @author wangbo
 * @date 2017-01-13 16:10:56
 */
public interface CustomerLinkmanDao {
	/**
	 * 新增 customerLinkman,返回customerLinkman对象(设置了新生成id)
	 * @param customerLinkman
	 * @return
	 */
    public CustomerLinkman addCustomerLinkman(CustomerLinkman customerLinkman);
    
	 /**
     * 按照主键id更新customerLinkman，成功返回1，使用接口时，请重新new CustomerLinkman 的更新对象，设置要更新的字段
     * @param linkman_id
     * @param customerLinkman
     * @return
     */
    public int updateCustomerLinkmanById(String linkman_id, CustomerLinkman customerLinkman);
    
	 /**
     * 按照主键id 删除 记录，返回1为成功
     * @param linkman_id
     * @return
     */
    public int deleteCustomerLinkmanById(String linkman_id);

	/**
	 * 根据客户id查找客户默认联系人
	 * @param customerId
	 * @return
	 */
	public CustomerLinkman getCustomerLinkmanDefaultByCustomerId(String customerId);
    
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
     * 通过主键id查询CustomerLinkman，查询不到返回NULL值
     * @param linkman_id
     * @return
     */
    public CustomerLinkman getCustomerLinkmanById(String linkman_id);

    public List<CustomerLinkman> getCustomerLinkmanByCustomerId(String customerId);
        
	 /**
     * 查询列表，包含分页查询，查询结果为空返回空的List对象
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
     * @param queryCustomerLinkman
     * @return
     */
    public List<CustomerLinkman> getCustomerLinkmansByPage(QueryCustomerLinkman queryCustomerLinkman);
    	
	 /**
     * 查询总数
     * @param queryCustomerLinkman
     * @return
     */
    public int count(QueryCustomerLinkman queryCustomerLinkman);
    		
}
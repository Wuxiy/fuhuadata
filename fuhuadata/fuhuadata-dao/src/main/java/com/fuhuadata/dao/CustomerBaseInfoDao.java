package com.fuhuadata.dao;
import java.util.List;

import com.fuhuadata.domain.CustomerBaseInfo;
import com.fuhuadata.domain.query.QueryCustomerBaseInfo;

/**
 * @author wangbo
 * @date 2017-01-12 11:49:51
 */
public interface CustomerBaseInfoDao {
	/**
	 * 新增 customerParent,返回customerParent对象(设置了新生成id)
	 * @param customerParent
	 * @return
	 */
    public CustomerBaseInfo addCustomerParent(CustomerBaseInfo customerParent);
    
	 /**
     * 按照主键id更新customerParent，成功返回1，使用接口时，请重新new CustomerBaseInfo 的更新对象，设置要更新的字段
     * @param customer_id
     * @param customerParent
     * @return
     */
    public int updateCustomerParentById(String customer_id, CustomerBaseInfo customerParent);
    
	 /**
     * 按照主键id 删除 记录，返回1为成功
     * @param customer_id
     * @return
     */
    public int deleteCustomerParentById(String customer_id);
    
	 /**
     * 返回数据库所有记录，谨慎使用，最好不用
     * @return
     */
    public List<CustomerBaseInfo> getAllCustomerParents();
    
    /**
     * 查询列表，此接口不包含分页查询，查询结果为空返回空的List对象
     * @param queryCustomerParent
     * @return
     */
    public List<CustomerBaseInfo> getCustomerParentsByQuery(QueryCustomerBaseInfo queryCustomerParent);
    
    /**
     * 通过主键id查询CustomerParent，查询不到返回NULL值
     * @param customer_id
     * @return
     */
    public CustomerBaseInfo getCustomerParentById(String customer_id);
        
	 /**
     * 查询列表，包含分页查询，查询结果为空返回空的List对象
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
     * @param queryCustomerParent
     * @return
     */
    public List<CustomerBaseInfo> getCustomerParentsByPage(QueryCustomerBaseInfo queryCustomerParent);
    	
	 /**
     * 查询总数
     * @param queryCustomerParent
     * @return
     */
    public int count(QueryCustomerBaseInfo queryCustomerParent);
    		
}
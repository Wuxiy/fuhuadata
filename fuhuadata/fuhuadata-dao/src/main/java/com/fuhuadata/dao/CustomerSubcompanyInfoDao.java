package com.fuhuadata.dao;
import java.util.List;
import com.fuhuadata.domain.query.QueryCustomerSubcompanyInfo;
import com.fuhuadata.domain.CustomerSubcompanyInfo;
import java.util.Map;
import java.io.Serializable;

/**
 * @author wangbo
 * @date 2017-01-12 13:37:25
 */
public interface CustomerSubcompanyInfoDao {
	/**
	 * 新增 customerSubcompanyInfo,返回customerSubcompanyInfo对象(设置了新生成id)
	 * @param customerSubcompanyInfo
	 * @return
	 */
    public CustomerSubcompanyInfo addCustomerSubcompanyInfo(CustomerSubcompanyInfo customerSubcompanyInfo);
    
	 /**
     * 按照主键id更新customerSubcompanyInfo，成功返回1，使用接口时，请重新new CustomerSubcompanyInfo 的更新对象，设置要更新的字段
     * @param customer_sub_id
     * @param customerSubcompanyInfo
     * @return
     */
    public int updateCustomerSubcompanyInfoById(String customer_sub_id, CustomerSubcompanyInfo customerSubcompanyInfo);
    
	 /**
     * 按照主键id 删除 记录，返回1为成功
     * @param customer_sub_id
     * @return
     */
    public int deleteCustomerSubcompanyInfoById(String customer_sub_id);
    
	 /**
     * 返回数据库所有记录，谨慎使用，最好不用
     * @return
     */
    public List<CustomerSubcompanyInfo> getAllCustomerSubcompanyInfos();
    
    /**
     * 查询列表，此接口不包含分页查询，查询结果为空返回空的List对象
     * @param queryCustomerSubcompanyInfo
     * @return
     */
    public List<CustomerSubcompanyInfo> getCustomerSubcompanyInfosByQuery(QueryCustomerSubcompanyInfo queryCustomerSubcompanyInfo);
    
    /**
     * 通过主键id查询CustomerSubcompanyInfo，查询不到返回NULL值
     * @param customer_sub_id
     * @return
     */
    public CustomerSubcompanyInfo getCustomerSubcompanyInfoById(String customer_sub_id);
        
	 /**
     * 查询列表，包含分页查询，查询结果为空返回空的List对象
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
     * @param queryCustomerSubcompanyInfo
     * @return
     */
    public List<CustomerSubcompanyInfo> getCustomerSubcompanyInfosByPage(QueryCustomerSubcompanyInfo queryCustomerSubcompanyInfo);
    	
	 /**
     * 查询总数
     * @param queryCustomerSubcompanyInfo
     * @return
     */
    public int count(QueryCustomerSubcompanyInfo queryCustomerSubcompanyInfo);
    		
}
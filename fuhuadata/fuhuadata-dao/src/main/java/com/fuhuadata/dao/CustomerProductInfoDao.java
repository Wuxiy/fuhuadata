package com.fuhuadata.dao;
import java.util.List;
import com.fuhuadata.domain.CustomerProductInfo;
import com.fuhuadata.domain.query.QueryCustomerProductInfo;
import com.fuhuadata.vo.CustomerProductPackagingArchives;

/**
 * @author wangbo
 * @date 2017-02-03 15:51:13
 */
public interface CustomerProductInfoDao {
	/**
	 * 新增 customerProductInfo,返回customerProductInfo对象(设置了新生成id)
	 * @param customerProductInfo
	 * @return
	 */
    public CustomerProductInfo addCustomerProductInfo(CustomerProductInfo customerProductInfo);
    
	 /**
     * 按照主键id更新customerProductInfo，成功返回1，使用接口时，请重新new CustomerProductInfo 的更新对象，设置要更新的字段
     * @param customer_product_id
     * @param customerProductInfo
     * @return
     */
    public int updateCustomerProductInfoById(int customer_product_id, CustomerProductInfo customerProductInfo);
    
	 /**
     * 按照主键id 删除 记录，返回1为成功
     * @param customer_product_id
     * @return
     */
    public int deleteCustomerProductInfoById(int customer_product_id);
    
	 /**
     * 返回数据库所有记录，谨慎使用，最好不用
     * @return
     */
    public List<CustomerProductInfo> getAllCustomerProductInfos();
    
    /**
     * 查询列表，此接口不包含分页查询，查询结果为空返回空的List对象
     * @param queryCustomerProductInfo
     * @return
     */
    public List<CustomerProductInfo> getCustomerProductInfosByQuery(QueryCustomerProductInfo queryCustomerProductInfo);
    
    /**
     * 通过主键id查询CustomerProductInfo，查询不到返回NULL值
     * @param customer_product_id
     * @return
     */
    public CustomerProductInfo getCustomerProductInfoById(int customer_product_id);

	/**
	 * 结合客户标准产品档案表和规格型号表查询客户包装要求信息
	 * @return
	 */
	public List<CustomerProductPackagingArchives> getCustomerProductPackagingArchives();

	/**
	 * 根据id获取客户产品要求
	 * @param customerId
	 * @return
	 */
	public List<CustomerProductPackagingArchives> getCustomerProductPackingArchivesById(String customerId);
        
	 /**
     * 查询列表，包含分页查询，查询结果为空返回空的List对象
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
     * @param queryCustomerProductInfo
     * @return
     */
    public List<CustomerProductInfo> getCustomerProductInfosByPage(QueryCustomerProductInfo queryCustomerProductInfo);
    	
	 /**
     * 查询总数
     * @param queryCustomerProductInfo
     * @return
     */
    public int count(QueryCustomerProductInfo queryCustomerProductInfo);
    		
}
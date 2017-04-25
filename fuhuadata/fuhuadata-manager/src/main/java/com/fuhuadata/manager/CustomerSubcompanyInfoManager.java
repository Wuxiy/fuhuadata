package com.fuhuadata.manager;
import java.util.List;

import com.fuhuadata.domain.CustomerEnterpriceNature;
import com.fuhuadata.domain.query.QueryCustomerSubcompanyInfo;
import com.fuhuadata.domain.CustomerSubcompanyInfo;
import com.fuhuadata.domain.query.Result;

/**
 * @author wangbo
 * @date 2017-01-12 13:37:25
 */
public interface CustomerSubcompanyInfoManager {
	/**
	 * 新增 customerSubcompanyInfo,返回customerSubcompanyInfo对象(设置了新生成id)
	 * @param customerSubcompanyInfo
	 * @return
	 */
    public CustomerSubcompanyInfo addCustomerSubcompanyInfo(CustomerSubcompanyInfo customerSubcompanyInfo,List<CustomerEnterpriceNature> list) ;
    
	 /**
     * 按照主键id更新customerSubcompanyInfo，请重新new CustomerSubcompanyInfo 的更新对象，设置要更新的字段
	 * 成功返回true，失败返回false
     * @paramid
     * @param customerSubcompanyInfo
     * @return
     */
    public boolean updateCustomerSubcompanyInfoById(List<CustomerEnterpriceNature> list, CustomerSubcompanyInfo customerSubcompanyInfo);

    /**
     * 按照主键id 删除 记录
	 * 成功返回true，失败返回false
     * @param customer_sub_id
     * @return
     */
    public boolean deleteCustomerSubcompanyInfoById(int customer_sub_id);

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
     * 通过主键id查询CustomerSubcompanyInfo
	 * 查询不到返回NULL值
     * @param customer_sub_id
     * @return
     */
    public CustomerSubcompanyInfo getCustomerSubcompanyInfoById(int customer_sub_id);


	/**
	 * 根据客户id获取子公司列表
	 * @param customerId
	 * @return
	 */
	public List<CustomerSubcompanyInfo> getCustomerSubcompanyInfoByCustomerId(String customerId);

    /**
     * 查询列表，包含分页查询，
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回Result中，可以通过result.getTotal()返回结果总数，
	 * result中包装了分页需要的信息，和当前列表
     * @param queryCustomerSubcompanyInfo
     * @return
     */
    public Result<List<CustomerSubcompanyInfo>> getCustomerSubcompanyInfosByPage(QueryCustomerSubcompanyInfo queryCustomerSubcompanyInfo);

    /**
     * 查询总数
     * @param queryCustomerSubcompanyInfo
     * @return
     */
    public int count(QueryCustomerSubcompanyInfo queryCustomerSubcompanyInfo);
	
}
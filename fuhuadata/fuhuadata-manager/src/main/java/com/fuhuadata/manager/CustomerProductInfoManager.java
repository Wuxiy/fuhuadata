package com.fuhuadata.manager;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.CustomerProductInfo;
import com.fuhuadata.domain.query.QueryCustomerProductInfo;
import com.fuhuadata.vo.CustomerProductPackagingArchives;

import java.util.Map;
import java.io.Serializable;

/**
 * @author wangbo
 * @date 2017-02-03 15:51:13
 */
public interface CustomerProductInfoManager {
	/**
	 * 新增 customerProductInfo,返回customerProductInfo对象(设置了新生成id)
	 * @param customerProductInfo
	 * @return
	 */
    public CustomerProductInfo addCustomerProductInfo(CustomerProductInfo customerProductInfo) ;
    
	 /**
     * 按照主键id更新customerProductInfo，请重新new CustomerProductInfo 的更新对象，设置要更新的字段
	 * 成功返回true，失败返回false
     * @param customer_product_id
     * @param customerProductInfo
     * @return
     */
    public boolean updateCustomerProductInfoById(int customer_product_id, CustomerProductInfo customerProductInfo);

    /**
     * 按照主键id 删除 记录
	 * 成功返回true，失败返回false
     * @param customer_product_id
     * @return
     */
    public boolean deleteCustomerProductInfoById(int customer_product_id);

	/**
	 * 客户产品包装要求信息
	 * @return
	 */
	public List<CustomerProductPackagingArchives> getCustomerProductPackagingArchives();

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
     * 通过主键id查询CustomerProductInfo
	 * 查询不到返回NULL值
     * @param customer_product_id
     * @return
     */
    public CustomerProductInfo getCustomerProductInfoById(int customer_product_id);

    /**
     * 查询列表，包含分页查询，
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回Result中，可以通过result.getTotal()返回结果总数，
	 * result中包装了分页需要的信息，和当前列表
     * @param queryCustomerProductInfo
     * @return
     */
    public Result<List<CustomerProductInfo>> getCustomerProductInfosByPage(QueryCustomerProductInfo queryCustomerProductInfo);

    /**
     * 查询总数
     * @param queryCustomerProductInfo
     * @return
     */
    public int count(QueryCustomerProductInfo queryCustomerProductInfo);
	
}
package com.fuhuadata.manager;
import java.util.List;

import com.fuhuadata.domain.CountCustomersOrderProduct;
import com.fuhuadata.domain.CustomerBaseInfo;
import com.fuhuadata.domain.CustomerEnterpriceNature;
import com.fuhuadata.domain.CustomerMakeProduct;
import com.fuhuadata.domain.query.QueryCustomerBaseInfo;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.vo.CustomerBaseInfoVO;

/**
 * @author wangbo
 * @date 2017-01-12 11:49:51
 */
public interface CustomerBaseInfoManager {
	/**
	 * 新增 customerBaseInfo,返回customerBaseInfo对象(设置了新生成id)
	 * @param customerBaseInfo
	 * @return
	 */
    public CustomerBaseInfo addCustomerBaseInfo(CustomerBaseInfo customerBaseInfo) ;

	public boolean deleteCustomerEnterpriceNatureByCustomerId(String customerId);

	public boolean batchAddNature(List<CustomerEnterpriceNature> customerEnterpriceNatures);

	/**
     * 按照主键id更新customerBaseInfo，请重新new CustomerBaseInfo 的更新对象，设置要更新的字段
	 * 成功返回true，失败返回false
     * @paramid
     * @param customerBaseInfo
     * @return
     */
    public boolean updateCustomerBaseInfoById(String customer_id, CustomerBaseInfo customerBaseInfo);

    /**
     * 按照主键id 删除 记录
	 * 成功返回true，失败返回false
     * @paramid
     * @return
     */
    public boolean deleteCustomerBaseInfoById(String customer_id);

    /**
     * 返回数据库所有记录，谨慎使用，最好不用
     * @return
     */
    public List<CustomerBaseInfo> getAllCustomerBaseInfos();
    
	/**
     * 查询列表，此接口不包含分页查询，查询结果为空返回空的List对象
     * @param queryCustomerBaseInfo
     * @return
     */    	
    public List<CustomerBaseInfo> getCustomerBaseInfoByQuery(QueryCustomerBaseInfo queryCustomerBaseInfo);

    /**
     * 通过主键id查询CustomerBaseInfo
	 * 查询不到返回NULL值
     * @paramid
     * @return
     */
    public CustomerBaseInfo getCustomerBaseInfoById(String customer_id);

	public CustomerBaseInfoVO getCustomerInfoById(String id);


    /**
     * 查询列表，包含分页查询，
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回Result中，可以通过result.getTotal()返回结果总数，
	 * result中包装了分页需要的信息，和当前列表
     * @param queryCustomerBaseInfo
     * @return
     */
    public Result<List<CustomerBaseInfo>> getCustomerBaseInfoByPage(QueryCustomerBaseInfo queryCustomerBaseInfo);

    /**
     * 查询总数
     * @param queryCustomerBaseInfo
     * @return
     */
    public int count(QueryCustomerBaseInfo queryCustomerBaseInfo);

	/**
	 * 根据客户id统计其购买产品明细清单
	 * @param customerId
	 * @return
	 */
	public List<CountCustomersOrderProduct> countOrderProduct(String customerId);
	
}
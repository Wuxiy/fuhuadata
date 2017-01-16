package com.fuhuadata.manager;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.QueryFreightforwardingInfo;
import com.fuhuadata.domain.FreightforwardingInfo;

/**
 * @author wangbo
 * @date 2017-01-16 15:25:40
 */
public interface FreightforwardingInfoManager {
	/**
	 * 新增 freightforwardingInfo,返回freightforwardingInfo对象(设置了新生成id)
	 * @param freightforwardingInfo
	 * @return
	 */
    public FreightforwardingInfo addFreightforwardingInfo(FreightforwardingInfo freightforwardingInfo) ;
    
	 /**
     * 按照主键id更新freightforwardingInfo，请重新new FreightforwardingInfo 的更新对象，设置要更新的字段
	 * 成功返回true，失败返回false
     * @param customer_id
     * @param freightforwardingInfo
     * @return
     */
    public boolean updateFreightforwardingInfoById(String customer_id, FreightforwardingInfo freightforwardingInfo);

    /**
     * 按照主键id 删除 记录
	 * 成功返回true，失败返回false
     * @param customer_id
     * @return
     */
    public boolean deleteFreightforwardingInfoById(String customer_id);

    /**
     * 返回数据库所有记录，谨慎使用，最好不用
     * @return
     */
    public List<FreightforwardingInfo> getAllFreightforwardingInfos();
    
	/**
     * 查询列表，此接口不包含分页查询，查询结果为空返回空的List对象
     * @param queryFreightforwardingInfo
     * @return
     */    	
    public List<FreightforwardingInfo> getFreightforwardingInfosByQuery(QueryFreightforwardingInfo queryFreightforwardingInfo);

    /**
     * 通过主键id查询FreightforwardingInfo
	 * 查询不到返回NULL值
     * @param customer_id
     * @return
     */
    public FreightforwardingInfo getFreightforwardingInfoById(String customer_id);

    /**
     * 查询列表，包含分页查询，
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回Result中，可以通过result.getTotal()返回结果总数，
	 * result中包装了分页需要的信息，和当前列表
     * @param queryFreightforwardingInfo
     * @return
     */
    public Result<List<FreightforwardingInfo>> getFreightforwardingInfosByPage(QueryFreightforwardingInfo queryFreightforwardingInfo);

    /**
     * 查询总数
     * @param queryFreightforwardingInfo
     * @return
     */
    public int count(QueryFreightforwardingInfo queryFreightforwardingInfo);
	
}
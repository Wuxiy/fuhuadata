package com.fuhuadata.service;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.QueryFreightforwardingInfo;
import com.fuhuadata.domain.FreightforwardingInfo;

/**
 * @author wangbo
 * @date 2017-01-16 15:25:40
 */
public interface FreightforwardingInfoService {

	/**
	 * 新增 freightforwardingInfo
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到新增 freightforwardingInfo
	 * @param freightforwardingInfo
	 * @return
	 */
    public Result<FreightforwardingInfo> addFreightforwardingInfo(FreightforwardingInfo freightforwardingInfo) ;
 
    /**
     * 按照主键id更新freightforwardingInfo，请重新new FreightforwardingInfo 的更新对象，设置要更新的字段
	 * 返回result，通过result.isSuccess()判断更新是否成功
     * @param customer_id
     * @param freightforwardingInfo
     * @return
     */
    public Result updateFreightforwardingInfoById(String customer_id, FreightforwardingInfo freightforwardingInfo);

    /**
     * 按照主键id 删除 记录
	 * 返回result，通过result.isSuccess()判断删除是否成功
     * @param customer_id
     * @return
     */
    public Result deleteFreightforwardingInfoById(String customer_id);
    
    /**
     * 查询列表，此接口不包含分页查询
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到列表信息
     * @param queryFreightforwardingInfo
     * @return
     */
    public Result<List<FreightforwardingInfo>> getFreightforwardingInfosByQuery(QueryFreightforwardingInfo queryFreightforwardingInfo);

    /**
     * 通过主键id查询FreightforwardingInfo
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到查询的单条freightforwardingInfo信息
     * @param customer_id
     * @return
     */
    public Result<FreightforwardingInfo> getFreightforwardingInfoById(String customer_id);

    /**
     * 查询列表，包含分页查询
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getTotal()返回结果总数
	 * 通过result.getModel()得到查询的单页列表信息
     * @param queryFreightforwardingInfo
     * @return
     */
    public Result<List<FreightforwardingInfo>> getFreightforwardingInfosByPage(QueryFreightforwardingInfo queryFreightforwardingInfo);

    /**
     * 查询总数
     * @param queryFreightforwardingInfo
     * @return
     */
    public Result<Integer> count(QueryFreightforwardingInfo queryFreightforwardingInfo);
	
}
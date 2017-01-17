package com.fuhuadata.service;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.QueryFreightforwardingWarehouseRelation;
import com.fuhuadata.domain.FreightforwardingWarehouseRelation;


/**
 * @author wangbo
 * @date 2017-01-17 14:24:28
 */
public interface FreightforwardingWarehouseRelationService {

	/**
	 * 新增 freightforwardingWarehouseRelation
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到新增 freightforwardingWarehouseRelation
	 * @param freightforwardingWarehouseRelation
	 * @return
	 */
    public Result<FreightforwardingWarehouseRelation> addFreightforwardingWarehouseRelation(FreightforwardingWarehouseRelation freightforwardingWarehouseRelation) ;
 
    /**
     * 按照主键id更新freightforwardingWarehouseRelation，请重新new FreightforwardingWarehouseRelation 的更新对象，设置要更新的字段
	 * 返回result，通过result.isSuccess()判断更新是否成功
     * @param id
     * @param freightforwardingWarehouseRelation
     * @return
     */
    public Result updateFreightforwardingWarehouseRelationById(int id, FreightforwardingWarehouseRelation freightforwardingWarehouseRelation);

    /**
     * 按照主键id 删除 记录
	 * 返回result，通过result.isSuccess()判断删除是否成功
     * @param id
     * @return
     */
    public Result deleteFreightforwardingWarehouseRelationById(int id);
    
    /**
     * 查询列表，此接口不包含分页查询
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到列表信息
     * @param queryFreightforwardingWarehouseRelation
     * @return
     */
    public Result<List<FreightforwardingWarehouseRelation>> getFreightforwardingWarehouseRelationsByQuery(QueryFreightforwardingWarehouseRelation queryFreightforwardingWarehouseRelation);

    /**
     * 通过主键id查询FreightforwardingWarehouseRelation
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到查询的单条freightforwardingWarehouseRelation信息
     * @param id
     * @return
     */
    public Result<FreightforwardingWarehouseRelation> getFreightforwardingWarehouseRelationById(int id);

    /**
     * 查询列表，包含分页查询
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getTotal()返回结果总数
	 * 通过result.getModel()得到查询的单页列表信息
     * @param queryFreightforwardingWarehouseRelation
     * @return
     */
    public Result<List<FreightforwardingWarehouseRelation>> getFreightforwardingWarehouseRelationsByPage(QueryFreightforwardingWarehouseRelation queryFreightforwardingWarehouseRelation);

    /**
     * 查询总数
     * @param queryFreightforwardingWarehouseRelation
     * @return
     */
    public Result<Integer> count(QueryFreightforwardingWarehouseRelation queryFreightforwardingWarehouseRelation);
	
}
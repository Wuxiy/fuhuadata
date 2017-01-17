package com.fuhuadata.dao;
import java.util.List;
import com.fuhuadata.domain.query.QueryFreightforwardingWarehouseRelation;
import com.fuhuadata.domain.FreightforwardingWarehouseRelation;

/**
 * @author wangbo
 * @date 2017-01-17 14:24:28
 */
public interface FreightforwardingWarehouseRelationDao {
	/**
	 * 新增 freightforwardingWarehouseRelation,返回freightforwardingWarehouseRelation对象(设置了新生成id)
	 * @param freightforwardingWarehouseRelation
	 * @return
	 */
    public FreightforwardingWarehouseRelation addFreightforwardingWarehouseRelation(FreightforwardingWarehouseRelation freightforwardingWarehouseRelation);
    
	 /**
     * 按照主键id更新freightforwardingWarehouseRelation，成功返回1，使用接口时，请重新new FreightforwardingWarehouseRelation 的更新对象，设置要更新的字段
     * @param id
     * @param freightforwardingWarehouseRelation
     * @return
     */
    public int updateFreightforwardingWarehouseRelationById(int id, FreightforwardingWarehouseRelation freightforwardingWarehouseRelation);
    
	 /**
     * 按照主键id 删除 记录，返回1为成功
     * @param id
     * @return
     */
    public int deleteFreightforwardingWarehouseRelationById(int id);
    
	 /**
     * 返回数据库所有记录，谨慎使用，最好不用
     * @return
     */
    public List<FreightforwardingWarehouseRelation> getAllFreightforwardingWarehouseRelations();
    
    /**
     * 查询列表，此接口不包含分页查询，查询结果为空返回空的List对象
     * @param queryFreightforwardingWarehouseRelation
     * @return
     */
    public List<FreightforwardingWarehouseRelation> getFreightforwardingWarehouseRelationsByQuery(QueryFreightforwardingWarehouseRelation queryFreightforwardingWarehouseRelation);
    
    /**
     * 通过主键id查询FreightforwardingWarehouseRelation，查询不到返回NULL值
     * @param id
     * @return
     */
    public FreightforwardingWarehouseRelation getFreightforwardingWarehouseRelationById(int id);
        
	 /**
     * 查询列表，包含分页查询，查询结果为空返回空的List对象
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
     * @param queryFreightforwardingWarehouseRelation
     * @return
     */
    public List<FreightforwardingWarehouseRelation> getFreightforwardingWarehouseRelationsByPage(QueryFreightforwardingWarehouseRelation queryFreightforwardingWarehouseRelation);
    	
	 /**
     * 查询总数
     * @param queryFreightforwardingWarehouseRelation
     * @return
     */
    public int count(QueryFreightforwardingWarehouseRelation queryFreightforwardingWarehouseRelation);
    		
}
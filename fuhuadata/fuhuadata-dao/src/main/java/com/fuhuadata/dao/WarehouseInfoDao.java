package com.fuhuadata.dao;
import java.util.List;
import com.fuhuadata.domain.WarehouseInfo;
import com.fuhuadata.domain.query.QueryWarehouseInfo;

/**
 * @author wangbo
 * @date 2017-01-16 17:17:06
 */
public interface WarehouseInfoDao {
	/**
	 * 新增 warehouseInfo,返回warehouseInfo对象(设置了新生成id)
	 * @param warehouseInfo
	 * @return
	 */
    public WarehouseInfo addWarehouseInfo(WarehouseInfo warehouseInfo);
    
	 /**
     * 按照主键id更新warehouseInfo，成功返回1，使用接口时，请重新new WarehouseInfo 的更新对象，设置要更新的字段
     * @param customer_id
     * @param warehouseInfo
     * @return
     */
    public int updateWarehouseInfoById(String customer_id, WarehouseInfo warehouseInfo);
    
	 /**
     * 按照主键id 删除 记录，返回1为成功
     * @param customer_id
     * @return
     */
    public int deleteWarehouseInfoById(String customer_id);
    
	 /**
     * 返回数据库所有记录，谨慎使用，最好不用
     * @return
     */
    public List<WarehouseInfo> getAllWarehouseInfos();
    
    /**
     * 查询列表，此接口不包含分页查询，查询结果为空返回空的List对象
     * @param queryWarehouseInfo
     * @return
     */
    public List<WarehouseInfo> getWarehouseInfosByQuery(QueryWarehouseInfo queryWarehouseInfo);
    
    /**
     * 通过主键id查询WarehouseInfo，查询不到返回NULL值
     * @param customer_id
     * @return
     */
    public WarehouseInfo getWarehouseInfoById(String customer_id);
        
	 /**
     * 查询列表，包含分页查询，查询结果为空返回空的List对象
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
     * @param queryWarehouseInfo
     * @return
     */
    public List<WarehouseInfo> getWarehouseInfosByPage(QueryWarehouseInfo queryWarehouseInfo);
    	
	 /**
     * 查询总数
     * @param queryWarehouseInfo
     * @return
     */
    public int count(QueryWarehouseInfo queryWarehouseInfo);
    		
}
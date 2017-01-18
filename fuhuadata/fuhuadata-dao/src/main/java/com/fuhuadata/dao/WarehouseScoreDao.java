package com.fuhuadata.dao;
import java.util.List;
import com.fuhuadata.domain.WarehouseScore;
import com.fuhuadata.domain.query.QueryWarehouseScore;

/**
 * @author wangbo
 * @date 2017-01-17 15:17:14
 */
public interface WarehouseScoreDao {
	/**
	 * 新增 warehouseScore,返回warehouseScore对象(设置了新生成id)
	 * @param warehouseScore
	 * @return
	 */
    public WarehouseScore addWarehouseScore(WarehouseScore warehouseScore);
    
	 /**
     * 按照主键id更新warehouseScore，成功返回1，使用接口时，请重新new WarehouseScore 的更新对象，设置要更新的字段
     * @param id
     * @param warehouseScore
     * @return
     */
    public int updateWarehouseScoreById(int id, WarehouseScore warehouseScore);
    
	 /**
     * 按照主键id 删除 记录，返回1为成功
     * @param id
     * @return
     */
    public int deleteWarehouseScoreById(int id);
    
	 /**
     * 返回数据库所有记录，谨慎使用，最好不用
     * @return
     */
    public List<WarehouseScore> getAllWarehouseScores();
    
    /**
     * 查询列表，此接口不包含分页查询，查询结果为空返回空的List对象
     * @param queryWarehouseScore
     * @return
     */
    public List<WarehouseScore> getWarehouseScoresByQuery(QueryWarehouseScore queryWarehouseScore);
    
    /**
     * 通过主键id查询WarehouseScore，查询不到返回NULL值
     * @param id
     * @return
     */
    public WarehouseScore getWarehouseScoreById(int id);
        
	 /**
     * 查询列表，包含分页查询，查询结果为空返回空的List对象
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
     * @param queryWarehouseScore
     * @return
     */
    public List<WarehouseScore> getWarehouseScoresByPage(QueryWarehouseScore queryWarehouseScore);
    	
	 /**
     * 查询总数
     * @param queryWarehouseScore
     * @return
     */
    public int count(QueryWarehouseScore queryWarehouseScore);
    		
}
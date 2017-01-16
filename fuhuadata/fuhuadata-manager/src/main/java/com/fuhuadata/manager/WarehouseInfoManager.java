package com.fuhuadata.manager;
import java.util.List;
import com.fuhuadata.domain.WarehouseInfo;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.QueryWarehouseInfo;

/**
 * @author wangbo
 * @date 2017-01-16 17:17:06
 */
public interface WarehouseInfoManager {
	/**
	 * 新增 warehouseInfo,返回warehouseInfo对象(设置了新生成id)
	 * @param warehouseInfo
	 * @return
	 */
    public WarehouseInfo addWarehouseInfo(WarehouseInfo warehouseInfo) ;
    
	 /**
     * 按照主键id更新warehouseInfo，请重新new WarehouseInfo 的更新对象，设置要更新的字段
	 * 成功返回true，失败返回false
     * @param customer_id
     * @param warehouseInfo
     * @return
     */
    public boolean updateWarehouseInfoById(String customer_id, WarehouseInfo warehouseInfo);

    /**
     * 按照主键id 删除 记录
	 * 成功返回true，失败返回false
     * @param customer_id
     * @return
     */
    public boolean deleteWarehouseInfoById(String customer_id);

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
     * 通过主键id查询WarehouseInfo
	 * 查询不到返回NULL值
     * @param customer_id
     * @return
     */
    public WarehouseInfo getWarehouseInfoById(String customer_id);

    /**
     * 查询列表，包含分页查询，
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回Result中，可以通过result.getTotal()返回结果总数，
	 * result中包装了分页需要的信息，和当前列表
     * @param queryWarehouseInfo
     * @return
     */
    public Result<List<WarehouseInfo>> getWarehouseInfosByPage(QueryWarehouseInfo queryWarehouseInfo);

    /**
     * 查询总数
     * @param queryWarehouseInfo
     * @return
     */
    public int count(QueryWarehouseInfo queryWarehouseInfo);
	
}
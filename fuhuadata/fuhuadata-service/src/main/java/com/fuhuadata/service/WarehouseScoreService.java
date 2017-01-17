package com.fuhuadata.service;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.WarehouseScore;
import com.fuhuadata.domain.query.QueryWarehouseScore;

/**
 * @author wangbo
 * @date 2017-01-17 15:17:14
 */
public interface WarehouseScoreService {

	/**
	 * 新增 warehouseScore
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到新增 warehouseScore
	 * @param warehouseScore
	 * @return
	 */
    public Result<WarehouseScore> addWarehouseScore(WarehouseScore warehouseScore) ;
 
    /**
     * 按照主键id更新warehouseScore，请重新new WarehouseScore 的更新对象，设置要更新的字段
	 * 返回result，通过result.isSuccess()判断更新是否成功
     * @param id
     * @param warehouseScore
     * @return
     */
    public Result updateWarehouseScoreById(int id, WarehouseScore warehouseScore);

    /**
     * 按照主键id 删除 记录
	 * 返回result，通过result.isSuccess()判断删除是否成功
     * @param id
     * @return
     */
    public Result deleteWarehouseScoreById(int id);
    
    /**
     * 查询列表，此接口不包含分页查询
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到列表信息
     * @param queryWarehouseScore
     * @return
     */
    public Result<List<WarehouseScore>> getWarehouseScoresByQuery(QueryWarehouseScore queryWarehouseScore);

    /**
     * 通过主键id查询WarehouseScore
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到查询的单条warehouseScore信息
     * @param id
     * @return
     */
    public Result<WarehouseScore> getWarehouseScoreById(int id);

    /**
     * 查询列表，包含分页查询
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getTotal()返回结果总数
	 * 通过result.getModel()得到查询的单页列表信息
     * @param queryWarehouseScore
     * @return
     */
    public Result<List<WarehouseScore>> getWarehouseScoresByPage(QueryWarehouseScore queryWarehouseScore);

    /**
     * 查询总数
     * @param queryWarehouseScore
     * @return
     */
    public Result<Integer> count(QueryWarehouseScore queryWarehouseScore);
	
}
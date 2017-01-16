package com.fuhuadata.service;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.WarehouseInfo;
import com.fuhuadata.domain.query.QueryWarehouseInfo;

/**
 * @author wangbo
 * @date 2017-01-16 17:17:06
 */
public interface WarehouseInfoService {

	/**
	 * 新增 warehouseInfo
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到新增 warehouseInfo
	 * @param warehouseInfo
	 * @return
	 */
    public Result<WarehouseInfo> addWarehouseInfo(WarehouseInfo warehouseInfo) ;
 
    /**
     * 按照主键id更新warehouseInfo，请重新new WarehouseInfo 的更新对象，设置要更新的字段
	 * 返回result，通过result.isSuccess()判断更新是否成功
     * @param customer_id
     * @param warehouseInfo
     * @return
     */
    public Result updateWarehouseInfoById(String customer_id, WarehouseInfo warehouseInfo);

    /**
     * 按照主键id 删除 记录
	 * 返回result，通过result.isSuccess()判断删除是否成功
     * @param customer_id
     * @return
     */
    public Result deleteWarehouseInfoById(String customer_id);
    
    /**
     * 查询列表，此接口不包含分页查询
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到列表信息
     * @param queryWarehouseInfo
     * @return
     */
    public Result<List<WarehouseInfo>> getWarehouseInfosByQuery(QueryWarehouseInfo queryWarehouseInfo);

    /**
     * 通过主键id查询WarehouseInfo
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到查询的单条warehouseInfo信息
     * @param customer_id
     * @return
     */
    public Result<WarehouseInfo> getWarehouseInfoById(String customer_id);

    /**
     * 查询列表，包含分页查询
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getTotal()返回结果总数
	 * 通过result.getModel()得到查询的单页列表信息
     * @param queryWarehouseInfo
     * @return
     */
    public Result<List<WarehouseInfo>> getWarehouseInfosByPage(QueryWarehouseInfo queryWarehouseInfo);

    /**
     * 查询总数
     * @param queryWarehouseInfo
     * @return
     */
    public Result<Integer> count(QueryWarehouseInfo queryWarehouseInfo);
	
}
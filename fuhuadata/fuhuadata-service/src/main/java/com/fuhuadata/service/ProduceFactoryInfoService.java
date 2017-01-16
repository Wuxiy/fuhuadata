package com.fuhuadata.service;
import com.fuhuadata.domain.query.QueryProduceFactoryInfo;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.ProduceFactoryInfo;

/**
 * @author wangbo
 * @date 2017-01-16 11:10:51
 */
public interface ProduceFactoryInfoService {

	/**
	 * 新增 produceFactoryInfo
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到新增 produceFactoryInfo
	 * @param produceFactoryInfo
	 * @return
	 */
    public Result<ProduceFactoryInfo> addProduceFactoryInfo(ProduceFactoryInfo produceFactoryInfo) ;
 
    /**
     * 按照主键id更新produceFactoryInfo，请重新new ProduceFactoryInfo 的更新对象，设置要更新的字段
	 * 返回result，通过result.isSuccess()判断更新是否成功
     * @param customer_id
     * @param produceFactoryInfo
     * @return
     */
    public Result updateProduceFactoryInfoById(String customer_id, ProduceFactoryInfo produceFactoryInfo);

    /**
     * 按照主键id 删除 记录
	 * 返回result，通过result.isSuccess()判断删除是否成功
     * @param customer_id
     * @return
     */
    public Result deleteProduceFactoryInfoById(String customer_id);
    
    /**
     * 查询列表，此接口不包含分页查询
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到列表信息
     * @param queryProduceFactoryInfo
     * @return
     */
    public Result<List<ProduceFactoryInfo>> getProduceFactoryInfosByQuery(QueryProduceFactoryInfo queryProduceFactoryInfo);

    /**
     * 通过主键id查询ProduceFactoryInfo
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到查询的单条produceFactoryInfo信息
     * @param customer_id
     * @return
     */
    public Result<ProduceFactoryInfo> getProduceFactoryInfoById(String customer_id);

    /**
     * 查询列表，包含分页查询
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getTotal()返回结果总数
	 * 通过result.getModel()得到查询的单页列表信息
     * @param queryProduceFactoryInfo
     * @return
     */
    public Result<List<ProduceFactoryInfo>> getProduceFactoryInfosByPage(QueryProduceFactoryInfo queryProduceFactoryInfo);

    /**
     * 查询总数
     * @param queryProduceFactoryInfo
     * @return
     */
    public Result<Integer> count(QueryProduceFactoryInfo queryProduceFactoryInfo);
	
}
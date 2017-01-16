package com.fuhuadata.manager;
import com.fuhuadata.domain.query.QueryProduceFactoryInfo;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.ProduceFactoryInfo;

/**
 * @author wangbo
 * @date 2017-01-16 11:10:51
 */
public interface ProduceFactoryInfoManager {
	/**
	 * 新增 produceFactoryInfo,返回produceFactoryInfo对象(设置了新生成id)
	 * @param produceFactoryInfo
	 * @return
	 */
    public ProduceFactoryInfo addProduceFactoryInfo(ProduceFactoryInfo produceFactoryInfo) ;
    
	 /**
     * 按照主键id更新produceFactoryInfo，请重新new ProduceFactoryInfo 的更新对象，设置要更新的字段
	 * 成功返回true，失败返回false
     * @param customer_id
     * @param produceFactoryInfo
     * @return
     */
    public boolean updateProduceFactoryInfoById(String customer_id, ProduceFactoryInfo produceFactoryInfo);

    /**
     * 按照主键id 删除 记录
	 * 成功返回true，失败返回false
     * @param customer_id
     * @return
     */
    public boolean deleteProduceFactoryInfoById(String customer_id);

    /**
     * 返回数据库所有记录，谨慎使用，最好不用
     * @return
     */
    public List<ProduceFactoryInfo> getAllProduceFactoryInfos();
    
	/**
     * 查询列表，此接口不包含分页查询，查询结果为空返回空的List对象
     * @param queryProduceFactoryInfo
     * @return
     */    	
    public List<ProduceFactoryInfo> getProduceFactoryInfosByQuery(QueryProduceFactoryInfo queryProduceFactoryInfo);

    /**
     * 通过主键id查询ProduceFactoryInfo
	 * 查询不到返回NULL值
     * @param customer_id
     * @return
     */
    public ProduceFactoryInfo getProduceFactoryInfoById(String customer_id);

    /**
     * 查询列表，包含分页查询，
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回Result中，可以通过result.getTotal()返回结果总数，
	 * result中包装了分页需要的信息，和当前列表
     * @param queryProduceFactoryInfo
     * @return
     */
    public Result<List<ProduceFactoryInfo>> getProduceFactoryInfosByPage(QueryProduceFactoryInfo queryProduceFactoryInfo);

    /**
     * 查询总数
     * @param queryProduceFactoryInfo
     * @return
     */
    public int count(QueryProduceFactoryInfo queryProduceFactoryInfo);
	
}
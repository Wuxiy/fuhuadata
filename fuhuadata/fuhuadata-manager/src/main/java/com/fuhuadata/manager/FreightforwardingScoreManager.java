package com.fuhuadata.manager;
import com.fuhuadata.domain.FreightforwardingScore;
import com.fuhuadata.domain.query.QueryFreightforwardingScore;
import java.util.List;
import com.fuhuadata.domain.query.Result;

/**
 * @author wangbo
 * @date 2017-01-16 16:22:49
 */
public interface FreightforwardingScoreManager {
	/**
	 * 新增 freightforwardingScore,返回freightforwardingScore对象(设置了新生成id)
	 * @param freightforwardingScore
	 * @return
	 */
    public FreightforwardingScore addFreightforwardingScore(FreightforwardingScore freightforwardingScore) ;
    
	 /**
     * 按照主键id更新freightforwardingScore，请重新new FreightforwardingScore 的更新对象，设置要更新的字段
	 * 成功返回true，失败返回false
     * @param id
     * @param freightforwardingScore
     * @return
     */
    public boolean updateFreightforwardingScoreById(int id, FreightforwardingScore freightforwardingScore);

    /**
     * 按照主键id 删除 记录
	 * 成功返回true，失败返回false
     * @param id
     * @return
     */
    public boolean deleteFreightforwardingScoreById(int id);

    /**
     * 返回数据库所有记录，谨慎使用，最好不用
     * @return
     */
    public List<FreightforwardingScore> getAllFreightforwardingScores();
    
	/**
     * 查询列表，此接口不包含分页查询，查询结果为空返回空的List对象
     * @param queryFreightforwardingScore
     * @return
     */    	
    public List<FreightforwardingScore> getFreightforwardingScoresByQuery(QueryFreightforwardingScore queryFreightforwardingScore);

    /**
     * 通过主键id查询FreightforwardingScore
	 * 查询不到返回NULL值
     * @param id
     * @return
     */
    public FreightforwardingScore getFreightforwardingScoreById(int id);

    /**
     * 查询列表，包含分页查询，
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回Result中，可以通过result.getTotal()返回结果总数，
	 * result中包装了分页需要的信息，和当前列表
     * @param queryFreightforwardingScore
     * @return
     */
    public Result<List<FreightforwardingScore>> getFreightforwardingScoresByPage(QueryFreightforwardingScore queryFreightforwardingScore);

    /**
     * 查询总数
     * @param queryFreightforwardingScore
     * @return
     */
    public int count(QueryFreightforwardingScore queryFreightforwardingScore);
	
}
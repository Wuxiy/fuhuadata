package com.fuhuadata.dao;
import com.fuhuadata.domain.FreightforwardingScore;
import com.fuhuadata.domain.query.QueryFreightforwardingScore;
import java.util.List;

/**
 * @author wangbo
 * @date 2017-01-16 16:22:49
 */
public interface FreightforwardingScoreDao {
	/**
	 * 新增 freightforwardingScore,返回freightforwardingScore对象(设置了新生成id)
	 * @param freightforwardingScore
	 * @return
	 */
    public FreightforwardingScore addFreightforwardingScore(FreightforwardingScore freightforwardingScore);
    
	 /**
     * 按照主键id更新freightforwardingScore，成功返回1，使用接口时，请重新new FreightforwardingScore 的更新对象，设置要更新的字段
     * @param id
     * @param freightforwardingScore
     * @return
     */
    public int updateFreightforwardingScoreById(int id, FreightforwardingScore freightforwardingScore);
    
	 /**
     * 按照主键id 删除 记录，返回1为成功
     * @param id
     * @return
     */
    public int deleteFreightforwardingScoreById(int id);
    
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
     * 通过主键id查询FreightforwardingScore，查询不到返回NULL值
     * @param id
     * @return
     */
    public FreightforwardingScore getFreightforwardingScoreById(int id);
        
	 /**
     * 查询列表，包含分页查询，查询结果为空返回空的List对象
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
     * @param queryFreightforwardingScore
     * @return
     */
    public List<FreightforwardingScore> getFreightforwardingScoresByPage(QueryFreightforwardingScore queryFreightforwardingScore);
    	
	 /**
     * 查询总数
     * @param queryFreightforwardingScore
     * @return
     */
    public int count(QueryFreightforwardingScore queryFreightforwardingScore);
    		
}
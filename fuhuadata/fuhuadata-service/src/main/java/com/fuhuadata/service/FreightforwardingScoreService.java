package com.fuhuadata.service;
import com.fuhuadata.domain.FreightforwardingScore;
import com.fuhuadata.domain.query.QueryFreightforwardingScore;
import java.util.List;
import com.fuhuadata.domain.query.Result;

/**
 * @author wangbo
 * @date 2017-01-16 16:22:49
 */
public interface FreightforwardingScoreService {

	/**
	 * 新增 freightforwardingScore
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到新增 freightforwardingScore
	 * @param freightforwardingScore
	 * @return
	 */
    public Result<FreightforwardingScore> addFreightforwardingScore(FreightforwardingScore freightforwardingScore) ;
 
    /**
     * 按照主键id更新freightforwardingScore，请重新new FreightforwardingScore 的更新对象，设置要更新的字段
	 * 返回result，通过result.isSuccess()判断更新是否成功
     * @param id
     * @param freightforwardingScore
     * @return
     */
    public Result updateFreightforwardingScoreById(int id, FreightforwardingScore freightforwardingScore);

    /**
     * 按照主键id 删除 记录
	 * 返回result，通过result.isSuccess()判断删除是否成功
     * @param id
     * @return
     */
    public Result deleteFreightforwardingScoreById(int id);
    
    /**
     * 查询列表，此接口不包含分页查询
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到列表信息
     * @param queryFreightforwardingScore
     * @return
     */
    public Result<List<FreightforwardingScore>> getFreightforwardingScoresByQuery(QueryFreightforwardingScore queryFreightforwardingScore);

    /**
     * 通过主键id查询FreightforwardingScore
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到查询的单条freightforwardingScore信息
     * @param id
     * @return
     */
    public Result<FreightforwardingScore> getFreightforwardingScoreById(int id);

    /**
     * 查询列表，包含分页查询
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getTotal()返回结果总数
	 * 通过result.getModel()得到查询的单页列表信息
     * @param queryFreightforwardingScore
     * @return
     */
    public Result<List<FreightforwardingScore>> getFreightforwardingScoresByPage(QueryFreightforwardingScore queryFreightforwardingScore);

    /**
     * 查询总数
     * @param queryFreightforwardingScore
     * @return
     */
    public Result<Integer> count(QueryFreightforwardingScore queryFreightforwardingScore);
	
}
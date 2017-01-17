package com.fuhuadata.service;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.QueryRecordLinkman;
import com.fuhuadata.domain.RecordLinkman;

/**
 * @author wangbo
 * @date 2017-01-13 16:26:04
 */
public interface RecordLinkmanService {

	/**
	 * 新增 recordLinkman
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到新增 recordLinkman
	 * @param recordLinkman
	 * @return
	 */
    public Result<RecordLinkman> addRecordLinkman(RecordLinkman recordLinkman) ;
 
    /**
     * 按照主键id更新recordLinkman，请重新new RecordLinkman 的更新对象，设置要更新的字段
	 * 返回result，通过result.isSuccess()判断更新是否成功
     * @param id
     * @param recordLinkman
     * @return
     */
    public Result updateRecordLinkmanById(int id, RecordLinkman recordLinkman);

    /**
     * 按照主键id 删除 记录
	 * 返回result，通过result.isSuccess()判断删除是否成功
     * @param id
     * @return
     */
    public Result deleteRecordLinkmanById(int id);
    
    /**
     * 查询列表，此接口不包含分页查询
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到列表信息
     * @param queryRecordLinkman
     * @return
     */
    public Result<List<RecordLinkman>> getRecordLinkmansByQuery(QueryRecordLinkman queryRecordLinkman);

    /**
     * 通过主键id查询RecordLinkman
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到查询的单条recordLinkman信息
     * @param id
     * @return
     */
    public Result<RecordLinkman> getRecordLinkmanById(int id);

    /**
     * 查询列表，包含分页查询
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getTotal()返回结果总数
	 * 通过result.getModel()得到查询的单页列表信息
     * @param queryRecordLinkman
     * @return
     */
    public Result<List<RecordLinkman>> getRecordLinkmansByPage(QueryRecordLinkman queryRecordLinkman);

    /**
     * 查询总数
     * @param queryRecordLinkman
     * @return
     */
    public Result<Integer> count(QueryRecordLinkman queryRecordLinkman);
	
}
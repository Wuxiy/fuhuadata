package com.fuhuadata.manager;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.QueryRecordLinkman;
import com.fuhuadata.domain.RecordLinkman;

/**
 * @author wangbo
 * @date 2017-01-13 16:26:04
 */
public interface RecordLinkmanManager {
	/**
	 * 新增 recordLinkman,返回recordLinkman对象(设置了新生成id)
	 * @param recordLinkman
	 * @return
	 */
    public RecordLinkman addRecordLinkman(RecordLinkman recordLinkman) ;
    
	 /**
     * 按照主键id更新recordLinkman，请重新new RecordLinkman 的更新对象，设置要更新的字段
	 * 成功返回true，失败返回false
     * @param id
     * @param recordLinkman
     * @return
     */
    public boolean updateRecordLinkmanById(int id, RecordLinkman recordLinkman);

    /**
     * 按照主键id 删除 记录
	 * 成功返回true，失败返回false
     * @param id
     * @return
     */
    public boolean deleteRecordLinkmanById(int id);

    /**
     * 返回数据库所有记录，谨慎使用，最好不用
     * @return
     */


    public List<RecordLinkman> getAllRecordLinkmans();
    
	/**
     * 查询列表，此接口不包含分页查询，查询结果为空返回空的List对象
     * @param queryRecordLinkman
     * @return
     */    	
    public List<RecordLinkman> getRecordLinkmansByQuery(QueryRecordLinkman queryRecordLinkman);

    public List<RecordLinkman> getRecordLinkmanByLinkmanId(String linkmanId);

    /**
     * 通过主键id查询RecordLinkman
	 * 查询不到返回NULL值
     * @param id
     * @return
     */
    public RecordLinkman getRecordLinkmanById(int id);

    /**
     * 查询列表，包含分页查询，
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回Result中，可以通过result.getTotal()返回结果总数，
	 * result中包装了分页需要的信息，和当前列表
     * @param queryRecordLinkman
     * @return
     */
    public Result<List<RecordLinkman>> getRecordLinkmansByPage(QueryRecordLinkman queryRecordLinkman);


    /**
     * 查询总数
     * @param queryRecordLinkman
     * @return
     */
    public int count(QueryRecordLinkman queryRecordLinkman);
	
}
package com.fuhuadata.dao;

import com.fuhuadata.domain.PackingArchives;
import com.fuhuadata.domain.query.PackingArchivesQuery;

import java.util.List;

/**
 * 包材档案Dao
 * Created by intanswer on 2017/1/23.
 */
public interface PackingArchivesDao {

    public PackingArchives addPackingArchives(PackingArchives packingArchives);

    /**
     * 通过主键id更新，成功返回1
     * @param id
     * @param packingArchives
     * @return
     */
    public int updatePackingArchivesById(int id,PackingArchives packingArchives);

    public int deletePackingArchivesById(int id);

    /**
     * 返回数据库所有记录，谨慎使用，最好不用
     * @param
     * @return
     */
    public List<PackingArchives> getAllPackingArchives();

    public List<PackingArchives> getPackingArchivesByQuery(PackingArchivesQuery packingArchivesQuery);

    /**
     * 通过主键id查询PackingArchives，查询不到返回NULL值
     * @param id
     * @return
     */
    public PackingArchives getPackingArchivesById(int id);

    /**
     * 通过ids字符串获取关联包材列表
     * @param ids
     * @return
     */
    public List<PackingArchives> getPackingArchivesByIds(String ids);

    /**
     * 通过包材分类id查询包材成本档案列表
     * @param id
     * @return
     */
    public List<PackingArchives> getPackingArchivesByPId(int id);

    /**
     * 查询列表，包含分页查询，查询结果为空返回空的List对象
     * 查询分页信息，请设置
     * Query(设置当前页数)
     * Query(设置当前页面数据行数)
     * @param packingArchivesQuery
     * @return
     */
    public List<PackingArchives> getPackingArchivesByPage(PackingArchivesQuery packingArchivesQuery);

    /**
     * 查询总数
     * @param packingArchivesQuery
     * @return
     */
    public int count(PackingArchivesQuery packingArchivesQuery);

}

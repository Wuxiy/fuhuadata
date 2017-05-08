package com.fuhuadata.manager;


import com.fuhuadata.domain.PackingArchives;
import com.fuhuadata.domain.PackingRelation;
import com.fuhuadata.domain.query.PackingArchivesQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.vo.RelationPackingArchives;

import java.util.List;

/**
 * 包材档案Manager
 * Created by intanswer on 2017/1/23.
 */
public interface PackingArchivesManager {

    public PackingArchives addPackingArchives(PackingArchives packingArchives);

    public PackingArchives getPackingArchivesById(int id);

    public List<PackingArchives> getPackingArchivesByIds(String ids);

    public boolean updatePackingArchivesById(int id,PackingArchives packingArchives);

    public boolean deletePackingArchivesById(int id);

    public List<PackingArchives> getPackingArchivesByPId(int id);

    public List<PackingArchives> getPackingArchivesByQuery(PackingArchivesQuery packingArchivesQuery);

    public Result<List<PackingArchives>> getPackingArchivesByPage(PackingArchivesQuery packingArchivesQuery);

    public int count(PackingArchivesQuery packingArchivesQuery);

    /**
     * 批量新增关联包材档案
     * @param list
     * @return
     */
    public boolean batchAddRelationPacking(List<PackingRelation> list);

    /**
     * 根据主材id删除全部关联
     * @param mainPackingId
     * @return
     */
    public boolean deleteRelationPacking(int mainPackingId);

    /**
     *  根据ids删除关联包材
     * @param ids
     * @return
     */
    public boolean deleteRelationPackingByIds(String ids);

    /**
     * 获取关联包材列表档案
     * @param packingId
     * @return
     */
    public List<RelationPackingArchives> getRelationPackingById(int packingId);


}

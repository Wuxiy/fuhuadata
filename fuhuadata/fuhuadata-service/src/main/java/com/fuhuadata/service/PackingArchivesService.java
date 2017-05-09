package com.fuhuadata.service;

import com.fuhuadata.domain.PackingArchives;
import com.fuhuadata.domain.PackingRelation;
import com.fuhuadata.domain.query.PackingArchivesQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.vo.PackingArchivesVO;
import com.fuhuadata.vo.RelationPackingArchives;

import java.util.List;

/**
 *
 * Created by intanswer on 2017/1/23.
 */
public interface PackingArchivesService {

    public Result<PackingArchives> addPackingArchives(PackingArchives packingArchives);

    public Result updatePackingArchivesById(int id, PackingArchives packingArchives);

    public Result deletePackingArchivesById(int id);

    public Result<PackingArchives> getAllPackingArchives();

    public Result<List<PackingArchives>> getPackingArchivesByQuery(PackingArchivesQuery packingArchivesQuery);

    public Result<PackingArchivesVO> getPackingArchivesById(int id);

    public Result<List<PackingArchives>> getPakcingArchivesByIds(String[] ids);

    public Result<List<PackingArchives>> getPackingArchivesByPId(int id);

    public Result<List<PackingArchives>> getPackingArchivesByPage(PackingArchivesQuery packingArchivesQuery);

    public Result<Integer> count(PackingArchivesQuery packingArchivesQuery);

    /**
     * 批量新增关联包材档案
     * @param list
     * @return
     */
    public Result batchAddRelationPacking(List<PackingRelation> list);

    /**
     * 根据主材id删除全部关联
     * @param mainPackingId
     * @return
     */
    public Result deleteRelationPacking(int mainPackingId);

    /**
     *  根据ids删除关联
     * @param ids
     * @return
     */
    public Result deleteRelationPackingByIds(String ids);


}
package com.fuhuadata.manager.impl;

import com.fuhuadata.dao.PackingArchivesDao;
import com.fuhuadata.dao.PreparationProcessCostDao;
import com.fuhuadata.domain.PackingArchives;
import com.fuhuadata.domain.PackingRelation;
import com.fuhuadata.domain.PreparationProcessCost;
import com.fuhuadata.domain.query.PackingArchivesQuery;
import com.fuhuadata.domain.query.PreparationProcessCostQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.PackingArchivesManager;
import com.fuhuadata.vo.RelationPackingArchives;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 包材档案ManagerImpl
 * Created by intanswer on 2017/1/23.
 */
public class PackingArchivesManagerImpl implements PackingArchivesManager {
    private PackingArchivesDao packingArchivesDao;
    @Autowired
    private PreparationProcessCostDao preparationProcessCostDao;
    @Override
    @Transactional
    public PackingArchives addPackingArchives(PackingArchives packingArchives) {
        //若添加主材，则要将新增的规格添加进人工费规格表
        if(packingArchives.getBigCategoryId()==1) {
            PreparationProcessCostQuery preparationProcessCostQuery = new PreparationProcessCostQuery();
            preparationProcessCostQuery.setType(0);
            preparationProcessCostQuery.setCostTerm(packingArchives.getSpec());
            List<PreparationProcessCost> list=preparationProcessCostDao.getPreparationProcessCostByQuery(preparationProcessCostQuery);
            if(list!=null||list.size()==1) {
                PreparationProcessCost preparationProcessCost = new PreparationProcessCost();
                preparationProcessCost.setType(0);
                preparationProcessCost.setCostTerm(packingArchives.getSpec());
                preparationProcessCostDao.addPreparationProcessCost(preparationProcessCost);
            }
        }
        return packingArchivesDao.addPackingArchives(packingArchives);
    }

    @Override
    public PackingArchives getPackingArchivesById(int id) {
        return packingArchivesDao.getPackingArchivesById(id);
    }

    @Override
    public List<PackingArchives> getPackingArchivesByIds(String ids) {
        return packingArchivesDao.getPackingArchivesByIds(ids);
    }

    @Override
    public boolean updatePackingArchivesById(int id, PackingArchives packingArchives) {
        return packingArchivesDao.updatePackingArchivesById(id,packingArchives)==1?true:false;
    }

    @Override
    public boolean deletePackingArchivesById(int id) {
        return packingArchivesDao.deletePackingArchivesById(id)==1?true:false;
    }

    @Override
    public List<PackingArchives> getPackingArchivesByPId(int id) {
        return packingArchivesDao.getPackingArchivesByPId(id);
    }

    @Override
    public List<PackingArchives> getPackingArchivesByQuery(PackingArchivesQuery packingArchivesQuery) {
        return packingArchivesDao.getPackingArchivesByQuery(packingArchivesQuery);
    }

    @Override
    public Result<List<PackingArchives>> getPackingArchivesByPage(PackingArchivesQuery packingArchivesQuery) {
        Result<List<PackingArchives>> result = new Result<List<PackingArchives>>();
        int totalItem = packingArchivesDao.count(packingArchivesQuery);
        packingArchivesQuery.setTotalItem(totalItem);
        if(totalItem>0){
            result.addDefaultModel("PackingArchives",packingArchivesDao.getPackingArchivesByPage(packingArchivesQuery));
        }else{
            result.addDefaultModel("PackingArchives",new ArrayList<PackingArchives>());
        }
        result.setTotalItem(totalItem);
        result.setPageSize(packingArchivesQuery.getPageSize());
        result.setIndex(packingArchivesQuery.getIndex());
        return result;
    }

    @Override
    public int count(PackingArchivesQuery packingArchivesQuery) {
        return packingArchivesDao.count(packingArchivesQuery);
    }

    @Override
    @Transactional
    public boolean batchAddRelationPacking(int mainPackingId,List<PackingRelation> list) {
        packingArchivesDao.deleteRelationPacking(mainPackingId);
        return packingArchivesDao.batchAddRelationPacking(list)==list.size()?true:false;
    }

    @Override
    public boolean deleteRelationPacking(int mainPackingId) {
        return packingArchivesDao.deleteRelationPacking(mainPackingId)>=1?true:false;
    }
    public boolean deleteRelationPackingByIds(String ids) {
        String[] str = ids.split(",");
        int re =  packingArchivesDao.deleteRelationPackingByIds(ids);
        return re==str.length?true:false;
    }


    @Override
    public List<RelationPackingArchives> getRelationPackingById(int packingId) {
        return packingArchivesDao.getRelationPackingById(packingId);
    }

    /**
     * 包材树获取全部关联包材
     * @param packingId
     * @return
     */
    @Override
    public List<RelationPackingArchives> getRelationPackingByPackId(int packingId) {
        return packingArchivesDao.getRelationPackingByPackId(packingId);
    }

    public PackingArchivesDao getPackingArchivesDao() {
        return packingArchivesDao;
    }

    public void setPackingArchivesDao(PackingArchivesDao packingArchivesDao) {
        this.packingArchivesDao = packingArchivesDao;
    }

}

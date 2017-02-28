package com.fuhuadata.manager.impl;

import com.fuhuadata.dao.PackingArchivesDao;
import com.fuhuadata.domain.PackingArchives;
import com.fuhuadata.domain.query.PackingArchivesQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.PackingArchivesManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 包材档案ManagerImpl
 * Created by intanswer on 2017/1/23.
 */
public class PackingArchivesManagerImpl implements PackingArchivesManager {
    private PackingArchivesDao packingArchivesDao;
    @Override
    public PackingArchives addPackingArchives(PackingArchives packingArchives) {
        return packingArchivesDao.addPackingArchives(packingArchives);
    }

    @Override
    public PackingArchives getPackingArchivesById(int id) {
        return packingArchivesDao.getPackingArchivesById(id);
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

    public PackingArchivesDao getPackingArchivesDao() {
        return packingArchivesDao;
    }

    public void setPackingArchivesDao(PackingArchivesDao packingArchivesDao) {
        this.packingArchivesDao = packingArchivesDao;
    }
}

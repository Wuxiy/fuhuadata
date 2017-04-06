package com.fuhuadata.manager.impl;

import com.fuhuadata.dao.PackingCategoryDao;
import com.fuhuadata.domain.PackingCategory;
import com.fuhuadata.manager.PackingCategoryManager;
import com.fuhuadata.vo.PackingCategoryVO;

import java.util.List;

/**
 * Created by intanswer on 2017/2/23.
 */
public class PackingCategoryManagerImpl implements PackingCategoryManager {

    private PackingCategoryDao packingCategoryDao;
    @Override
    public PackingCategory addPackingCategory(PackingCategory packingCategory) {
        return packingCategoryDao.addPackingCategory(packingCategory);
    }

    @Override
    public boolean updatePackingCategoryById(int id, PackingCategory packingCategory) {
        return packingCategoryDao.updatePackingCategoryById(id,packingCategory)==1?true:false;
    }

    @Override
    public boolean deletePackingCategoryById(int id) {
        return packingCategoryDao.deletePackingCategoryById(id)==1?true:false;
    }

    @Override
    public List<PackingCategory> getAll() {
        return packingCategoryDao.getAll();
    }

    @Override
    public List<PackingCategory> getPackingCategoryByPId(int id) {
        return packingCategoryDao.getPackingCategoryByParentId(id);
    }

    @Override
    public List<PackingCategoryVO> getAllByLevel(String parentIds) {
        return packingCategoryDao.getAllByLevel(parentIds);
    }

    @Override
    public PackingCategory getPackingCategoryById(int id) {
        return packingCategoryDao.getPackingCategoryById(id);
    }

    public void setPackingCategoryDao(PackingCategoryDao packingCategoryDao) {
        this.packingCategoryDao = packingCategoryDao;
    }
    public PackingCategoryDao getPackingCategoryDao(){
        return this.packingCategoryDao;
    }
}

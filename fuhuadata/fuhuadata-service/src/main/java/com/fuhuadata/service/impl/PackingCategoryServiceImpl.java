package com.fuhuadata.service.impl;

import com.fuhuadata.domain.PackingCategory;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.PackingCategoryManager;
import com.fuhuadata.service.PackingCategoryService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * Created by intanswer on 2017/2/23.
 */
public class PackingCategoryServiceImpl implements PackingCategoryService {
    private static final Log log= LogFactory.getLog(PackingCategoryServiceImpl.class);
    private PackingCategoryManager packingCategoryManager;
    @Override
    public Result<PackingCategory> addPackingCategory(PackingCategory packingCategory) {
        Result<PackingCategory> result = new Result<PackingCategory>();
        try{
            result.addDefaultModel(packingCategoryManager.addPackingCategory(packingCategory));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("添加包材目录树节点错误",e);
        }
        return result;
    }

    @Override
    public Result updatePackingCategoryById(int id, PackingCategory packingCategory) {
        Result result = new Result();
        try{
            result.setSuccess(packingCategoryManager.updatePackingCategoryById(id,packingCategory));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("根据id更新包材目录节点错误",e);
        }
        return result;
    }

    @Override
    public Result deltePackingCategoryById(int id) {
        Result result = new Result();
        try {
           result.setSuccess(packingCategoryManager.deletePackingCategoryById(id));
        } catch (Exception e) {
            result.setSuccess(false);
            log.error("根据id删除包材树节点错误",e);
        }
        return result;
    }

    @Override
    public Result<List<PackingCategory>> getAll() {
        Result<List<PackingCategory>> result = new Result<List<PackingCategory>>();
        try {
            result.addDefaultModel("PackingCategory",packingCategoryManager.getAll());
        } catch (Exception e) {
            result.setSuccess(false);
            log.error("获取包材目录树原数据错误",e);
        }
        return result;
    }

    public PackingCategoryManager getPackingCategoryManager() {
        return packingCategoryManager;
    }

    public void setPackingCategoryManager(PackingCategoryManager packingCategoryManager) {
        this.packingCategoryManager = packingCategoryManager;
    }
}

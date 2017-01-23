package com.fuhuadata.service.impl;

import com.fuhuadata.domain.PackingArchives;
import com.fuhuadata.domain.query.PackingArchivesQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.PackingArchivesManager;
import com.fuhuadata.service.PackingArchivesService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * Created by intanswer on 2017/1/23.
 */
public class PackingArchivesServiceImpl implements PackingArchivesService {
    private final static Log log = LogFactory.getLog(UserAccountServiceImpl.class);
    private PackingArchivesManager packingArchivesManager;
    @Override
    public Result<PackingArchives> addPackingArchives(PackingArchives packingArchives) {
        Result<PackingArchives> result = new Result<PackingArchives>();
        try {
            result.addDefaultModel(packingArchivesManager.addPackingArchives(packingArchives));
        } catch (Exception e) {
            result.setSuccess(false);
            // 打印日志
            log.error("添加包材档案失败",e);
        }
        return result;

    }

    @Override
    public Result updatePackingArchivesById(int id, PackingArchives packingArchives) {
        Result result = new Result();
        try {
            result.setSuccess(packingArchivesManager.updatePackingArchivesById(id, packingArchives));
        } catch (Exception e) {
            result.setSuccess(false);
            // 打印日志
            log.error("修改包材档案信息失败",e);
        }
        return result;
    }

    @Override
    public Result deletePackingArchivesById(int id) {
        Result result = new Result();
        try {
            result.setSuccess(packingArchivesManager.deletePackingArchivesById(id));
        } catch (Exception e) {
            result.setSuccess(false);
            // 打印日志
            log.error("根据id删除包材档案错误",e);
        }
        return result;
    }

    @Override
    public Result<PackingArchives> getAllPackingArchives() {
            return null;
    }

    @Override
    public Result<List<PackingArchives>> getPackingArchivesByQuery(PackingArchivesQuery packingArchivesQuery) {
        Result<List<PackingArchives>> result = new Result<List<PackingArchives>>();
        try {
            result.addDefaultModel("PackingArchives", packingArchivesManager.getPackingArchivesByQuery(packingArchivesQuery));
        } catch (Exception e) {
            result.setSuccess(false);
            // 打印日志
            log.error("查询包材档案错误",e);
        }
        return result;
    }

    @Override
    public Result<PackingArchives> getPackingArchivesById(int id) {
        Result<PackingArchives> result = new Result<PackingArchives>();
        try {
            PackingArchives packingArchives = packingArchivesManager.getPackingArchivesById(id);
            if(packingArchives == null){
                result.setSimpleErrorMsg(0, "当前包材档案数据不存在，请重试");
            }else{
                result.addDefaultModel("PackingArchives", packingArchives);
            }
        } catch (Exception e) {
            result.setSuccess(false);
            // 打印日志
            log.error("根据id获取包材档案错误",e);
        }
        return result;
    }

    @Override
    public Result<List<PackingArchives>> getPackingArchivesByPage(PackingArchivesQuery packingArchivesQuery) {
        Result<List<PackingArchives>> result = new Result<List<PackingArchives>>();
        try {
            result = packingArchivesManager.getPackingArchivesByPage(packingArchivesQuery);
        } catch (Exception e) {
            result.setSuccess(false);
            // 打印日志
            log.error("分页获取包材档案错误",e);
        }
        return result;
    }

    @Override
    public Result<Integer> count(PackingArchivesQuery packingArchivesQuery) {
        Result<Integer> result = new Result<Integer>();
        try {
            result.addDefaultModel(packingArchivesManager.count(packingArchivesQuery));
        } catch (Exception e) {
            result.setSuccess(false);
            // 打印日志
            log.error("查询包材档案数量错误",e);
        }
        return result;
    }

    public PackingArchivesManager getPackingArchivesManager(){
        return this.packingArchivesManager;
    }

    public void setPackingArchivesManager(PackingArchivesManager packingArchivesManager) {
        this.packingArchivesManager = packingArchivesManager;
    }
}

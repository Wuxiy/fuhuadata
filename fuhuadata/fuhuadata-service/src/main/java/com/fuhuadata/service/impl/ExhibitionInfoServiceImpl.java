package com.fuhuadata.service.impl;

import com.fuhuadata.domain.ExhibitionInfo;
import com.fuhuadata.domain.query.ExhibitionInfoQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.ExhibitionInfoManager;
import com.fuhuadata.service.ExhibitionInfoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import java.util.List;

/**
 * Created by intanswer on 2017/1/13.
 */
public class ExhibitionInfoServiceImpl  implements ExhibitionInfoService{

    private static final Log log = LogFactory.getLog(ExhibitionInfoServiceImpl.class);
    private ExhibitionInfoManager exhibitionInfoManager;
    @Override
    public Result<ExhibitionInfo> addExhibitionInfo(ExhibitionInfo exhibitionInfo) {
        Result<ExhibitionInfo> result = new Result<ExhibitionInfo>();
        try {
            result.addDefaultModel(exhibitionInfoManager.addExhibitionInfo(exhibitionInfo));
        } catch (Exception e) {
            result.setSuccess(false);
            log.error("添加展会动态失败",e);
        }
        return result;
    }

    @Override
    public Result<List<ExhibitionInfo>> getExhibitionInfosByPage(ExhibitionInfoQuery exhibitonInfoQuery) {
        Result<List<ExhibitionInfo>> result = new Result<List<ExhibitionInfo>>();

        try {
            result=exhibitionInfoManager.getExhibitionInfosByPage(exhibitonInfoQuery);
        } catch (Exception e) {
            log.error(false);
            log.error("分页获取展会动态失败",e);
        }
        return result;
    }

    @Override
    public Result updateExhibitionInfoById(int id, ExhibitionInfo exhibitionInfo) {
        Result result = new Result();
        try{
            result.setSuccess(exhibitionInfoManager.updateExhibitionInfoById(id,exhibitionInfo));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("更新展会动态信息错误",e);
        }
        return result;
    }

    @Override
    public Result deleteExhibitionInfoById(int id) {
        Result result = new Result();
        try{
            result.setSuccess(exhibitionInfoManager.deleteExhibitionInfoById(id));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("根据id删除展会动态信息出错",e);
        }
        return result;
    }

    @Override
    public Result<Integer> count(ExhibitionInfoQuery exhibitionInfoQuery) {
        Result<Integer> result = new Result<Integer>();
        try {
            result.addDefaultModel(exhibitionInfoManager.count(exhibitionInfoQuery));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("查询展会信息数量失败",e);
        }
        return result;
    }

    public ExhibitionInfoManager getExhibitionInfoManager(){
        return this.exhibitionInfoManager;
    }

    public void setExhibitionInfoManager(ExhibitionInfoManager exhibitionInfoManager){
        this.exhibitionInfoManager=exhibitionInfoManager;
    }
}

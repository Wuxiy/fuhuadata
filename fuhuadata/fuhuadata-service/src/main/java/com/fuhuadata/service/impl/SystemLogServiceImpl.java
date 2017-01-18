package com.fuhuadata.service.impl;

import com.fuhuadata.domain.SystemLog;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.SystemLogQuery;
import com.fuhuadata.manager.SystemLogManager;
import com.fuhuadata.service.SystemLogService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import java.util.List;

/**
 * Created by intanswer on 2017/1/11.
 */
class SystemLogServiceImpl implements SystemLogService{
    private final static Log log = LogFactory.getLog(SystemLogServiceImpl.class);
    private SystemLogManager systemLogManager;

    /**
     * 新增systemLog,返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getModel()得到新增 userAccount
     * @param  systemLog
     * @return
     */
    @Override
    public Result<SystemLog> addSystemLog(SystemLog systemLog) {
        Result<SystemLog> result = new Result<SystemLog>();
        try{
            result.addDefaultModel(systemLogManager.addSystemLog(systemLog));

        }catch (Exception e){
            result.setSuccess(false);
            log.error("添加系统用户监控日志失败",e);
        }
        return result;
    }

    /**
     * 查询列表，包含分页查询 查询分页信息，请设置 Query(设置当前页数) Query(设置当前页面数据行数)
     * 返回result，通过result.isSuccess()判断服务调用是否成功 通过result.getTotal()返回结果总数
     * 通过result.getModel()得到查询的单页列表信息
     * @param systemLogQuery
     * @return
     */
    @Override
    public Result<List<SystemLog>> getSystemLogsByPage(SystemLogQuery systemLogQuery) {
        Result<List<SystemLog>> result = new Result<List<SystemLog>>();
        try{
            result= systemLogManager.getSystemLogsByPage(systemLogQuery);
        }catch (Exception e){
            result.setSuccess(false);
            log.error("分页获取用户监控日志失败",e);
        }
        return result;
    }

    /**
     * 总数
     * @param systemLogQuery
     * @return
     */
    @Override
    public Result<Integer> count(SystemLogQuery systemLogQuery) {
        Result<Integer> result = new Result<Integer>();
        try{
            result.addDefaultModel(systemLogManager.count(systemLogQuery));
        }catch (Exception e){
            result.setSuccess(false);
            log.error("查询后台用户监控数量出错",e);
        }
        return result;
    }
    public SystemLogManager getSystemLogManager(){
        return systemLogManager;
    }
    public void setSystemLogManager(SystemLogManager systemLogManager){
        this.systemLogManager=systemLogManager;
    }
}

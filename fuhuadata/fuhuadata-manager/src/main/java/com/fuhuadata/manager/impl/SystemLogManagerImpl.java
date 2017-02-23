package com.fuhuadata.manager.impl;

import com.fuhuadata.dao.SystemLogDao;
import com.fuhuadata.domain.SystemLog;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.SystemLogQuery;
import com.fuhuadata.manager.SystemLogManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by intanswer on 2017/1/10.
 */
public class SystemLogManagerImpl implements SystemLogManager {
    private SystemLogDao systemLogDao;
    @Override
    public SystemLog addSystemLog(SystemLog systemLog) {
        return systemLogDao.addSystemLog(systemLog);
    }

    @Override
    public List<SystemLog> getSystemLogByQuery(SystemLogQuery systemLogQuery) {
        return systemLogDao.getSystemLogByQuery(systemLogQuery);
    }

    @Override
    public Result<List<SystemLog>> getSystemLogsByPage(SystemLogQuery systemLogQuery) {
        Result<List<SystemLog>> result = new Result<List<SystemLog>>();
        int totalItem=systemLogDao.count(systemLogQuery);
        systemLogQuery.setTotalItem(totalItem);
        if (totalItem > 0){
            result.addDefaultModel("SystemLogs",systemLogDao.getSystemLogsByPage(systemLogQuery));
        }
        else{
            result.addDefaultModel("SystemLogs",new ArrayList<SystemLog>());
        }
        result.setPageSize(systemLogQuery.getPageSize());
        result.setIndex(systemLogQuery.getIndex());
        result.setTotalItem(totalItem);
        return result;
    }

    @Override
    public int count(SystemLogQuery systemLogQuery) {
        return systemLogDao.count(systemLogQuery);
    }
    public SystemLogDao getSystemLogDao(){
        return systemLogDao;
    }
    public void setSystemLogDao(SystemLogDao systemLogDao){
        this.systemLogDao=systemLogDao;
    }

}

package com.fuhuadata.dao;

import com.fuhuadata.domain.SystemLog;
import com.fuhuadata.domain.query.SystemLogQuery;

import java.util.List;

/**
 * 系统监控用户行为dao
 * Created by intanswer on 2017/1/10.
 */
public interface SystemLogDao {
    /**
     * 新增监控记录
     * @param systemLog
     * @return
     */
    public SystemLog addSystemLog(SystemLog systemLog);

    /**
     * 分页查询监控日志列表
     * @param systemLogQuery
     * @return
     */
    public List<SystemLog> getSystemLogsByPage(SystemLogQuery systemLogQuery);

    /**
     * 查询监控记录记录总数
     * @param systemLogQuery
     * @return
     */
    public int count(SystemLogQuery systemLogQuery);
}

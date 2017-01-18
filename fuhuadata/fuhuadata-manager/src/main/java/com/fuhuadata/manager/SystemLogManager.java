package com.fuhuadata.manager;

import com.fuhuadata.domain.SystemLog;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.SystemLogQuery;

import java.util.List;

/**
 * Created by intanswer on 2017/1/10.
 */
public interface SystemLogManager {
    /**
     * 新增监控记录
     * @param systemLog
     * @return
     */
    public SystemLog addSystemLog(SystemLog systemLog);

    /**
     * 分页查询监控日志列表
     * 查询分页信息，请设置
     * Query(设置当前页数)
     * Query(设置当前页面数据行数)
     * 返回Result中，可以通过result.getTotal()返回结果总数，
     * result中包装了分页需要的信息，和当前列表
     * @param systemLogQuery
     * @return
     */
    public Result<List<SystemLog>> getSystemLogsByPage(SystemLogQuery systemLogQuery);

    /**
     * 查询记录总数
     * @param systemLogQuery
     * @return
     */
    public int count(SystemLogQuery systemLogQuery);

}

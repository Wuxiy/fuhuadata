package com.fuhuadata.service;

import com.fuhuadata.domain.SystemLog;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.SystemLogQuery;

import java.util.List;

/**
 * 监控用户行为的系统日志service
 * Created by wuxi on 2017/1/10.
 */
public interface SystemLogService {
    /**
     * 新增 SystemLog
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getModel()得到新增  userAccount
     * @param  systemLog
     * @return
     */
    public Result<SystemLog> addSystemLog(SystemLog systemLog) ;


    /**
     * 查询列表，包含分页查询
     * 查询分页信息，请设置
     * Query(设置当前页数)
     * Query(设置当前页面数据行数)
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getTotal()返回结果总数
     * 通过result.getModel()得到查询的单页列表信息
     * @param systemLogQuery
     * @return
     */
    public Result<List<SystemLog>> getSystemLogsByPage(SystemLogQuery systemLogQuery);

    /**
     * 查询总数
     * @param systemLogQuery
     * @return
     */
    public Result<Integer> count(SystemLogQuery systemLogQuery);
}

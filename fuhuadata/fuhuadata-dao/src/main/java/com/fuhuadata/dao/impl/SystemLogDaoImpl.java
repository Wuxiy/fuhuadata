package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.SystemLogDao;
import com.fuhuadata.domain.SystemLog;
import com.fuhuadata.domain.query.SystemLogQuery;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.ibatis.sqlmap.engine.builder.xml.SqlMapClasspathEntityResolver;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by intanswer on 2017/1/10.
 */
public class SystemLogDaoImpl extends SqlMapClientTemplate implements SystemLogDao {
    public static final String ADD = "SYSTEMLOG.ADD";
    public static final String GET_PAGE="SYSTEMLOG.GET-PAGE";
    public static final String COUNT = "SYSTEMLOG.COUNT";
    public static final String GET_BY_QUERY="SYSTEMLOG.GET-BY-QUERY";

    /**
     * 新增systemLog,返回systemLog对象（设置了新生成id）
     * @param systemLog
     * @return
     */
    @Override
    public SystemLog addSystemLog(SystemLog systemLog) {
        systemLog.setLogId((Integer) this.insert(ADD,systemLog));
        return systemLog;
    }

    @Override
    public List<SystemLog> getSystemLogByQuery(SystemLogQuery systemLogQuery) {
        return this.queryForList(GET_BY_QUERY,systemLogQuery);
    }

    /**
     * 查询列表，包含分页查询，查询结果为空返回空的List对象
     * 查询分页信息，请设置
     * Query(设置当前页数)
     * Query(设置当前页面数据行数)
     * @param systemLogQuery
     * @return
     */
    @Override
    public List<SystemLog> getSystemLogsByPage(SystemLogQuery systemLogQuery) {

        return this.queryForList(GET_PAGE,systemLogQuery);
    }

    /**
     * 查询总数
     * @param systemLogQuery
     * @return
     */

    @Override
    public int count(SystemLogQuery systemLogQuery) {
        return ((Integer)this.queryForObject(COUNT,systemLogQuery)).intValue();
    }
}

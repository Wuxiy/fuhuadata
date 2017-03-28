package com.fuhuadata.dao;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by hexingfu on 2017/3/15.
 */
public class BaseDao<T> {

    public boolean batch(SqlMapClientTemplate sqlMapClientTemplate,String statement, List<T> list){
        final List<T> objs = list;
        final String stmt = statement;
        try {
            sqlMapClientTemplate.execute(new SqlMapClientCallback<Object>() {
                public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
                    executor.startBatch();
                    for(int i=0;i<objs.size();i++){
                        executor.update(stmt,objs.get(i));
                    }
                    executor.executeBatch();
                    return null;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

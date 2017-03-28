package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.BCodeDao;
import com.fuhuadata.domain.BCode;
import com.fuhuadata.domain.query.QueryBCode;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * Created by hexingfu on 2017/3/28.
 */
@Repository
public class BCodeDaoImpl implements BCodeDao{

    @Autowired
    private SqlMapClient sqlMapClient;

    @Override
    public int insertBcode(BCode record) {
        try {
            Object r = sqlMapClient.insert("Bcode.insertBcode",record);
            return (Integer)r;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public BCode getBcodeByQuery(QueryBCode queryBCode) {
        try {
            return (BCode)sqlMapClient.queryForObject("Bcode.getBcodeByQuery",queryBCode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int setCurrentVal(BCode record) {
        try {
            return sqlMapClient.update("Bcode.setCurrentVal",record);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

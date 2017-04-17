package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.IncomeDao;
import com.fuhuadata.domain.Income;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * Created by hexingfu on 2017/4/17.
 */
@Repository
public class IncomeDaoImpl implements IncomeDao {
    private static final String GET_BY_CODE = "Income.getByCode";
    @Autowired
    private SqlMapClient sqlMapClient;
    @Override
    public Income getByCode(String code) {
        try {
            return (Income)sqlMapClient.queryForObject(GET_BY_CODE,code);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

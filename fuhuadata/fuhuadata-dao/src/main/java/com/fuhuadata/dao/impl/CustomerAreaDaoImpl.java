package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.CustomerAreaDao;
import com.fuhuadata.domain.CustomerArea;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by hexingfu on 2017/3/9.
 */
@Repository
public class CustomerAreaDaoImpl  implements CustomerAreaDao {
    private static final String GET_ALL_LIST = "CustomerArea.getAllList";
    @Autowired
    private SqlMapClient sqlMapClient;
    @Override
    public List<CustomerArea> getAllCustomerAreaList(String id) {
        try {
            return sqlMapClient.queryForList(GET_ALL_LIST,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

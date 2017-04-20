package com.fuhuadata.service.task;

import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 同步NC合同部分字段到mysql
 * Created by hexingfu on 2017/4/19.
 */
@Service("syncContract")
public class SyncContract {
    @Autowired
    private SqlMapClient sqlMapClientOracle;
    @Autowired
    private SqlMapClient sqlMapClient;

    public void sync(){

    }
}

package com.fuhuadata.dao.task;

import com.fuhuadata.domain.task.SyncContract;
import com.fuhuadata.domain.task.SyncSubContract;

import java.util.List;

/**
 * Created by hexingfu on 2017/4/19.
 */
public interface SyncContractDao {
    /**
     * 从oracle数据库获取转口合同和出口合同数据
     * @return
     */
    List<SyncContract> getOracleData() throws Exception;

    /**
     * 清空mysql里面的同步表数据
     * @return
     */
    void deleteMysqlData() throws Exception;

    /**
     * 将oracle数据插入到mysql
     * @return
     */
    void insertMysqlData(List<SyncContract> list)throws Exception;

}

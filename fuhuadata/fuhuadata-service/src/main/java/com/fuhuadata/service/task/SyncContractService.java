package com.fuhuadata.service.task;

import com.fuhuadata.dao.task.SyncContractDao;
import com.fuhuadata.domain.task.SyncContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 同步NC合同部分字段到mysql
 * Created by hexingfu on 2017/4/19.
 */
@Service("syncContract")
public class SyncContractService {

    @Autowired
    private SyncContractDao syncContractDao;
    @Transactional
    public void sync(){
            try {
                //从oracle获取数据
                List<SyncContract> list = syncContractDao.getOracleData();
                //清除mysql数据
                syncContractDao.deleteMysqlData();
                //将oracle数据插入mysql
                syncContractDao.insertMysqlData(list);
            } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

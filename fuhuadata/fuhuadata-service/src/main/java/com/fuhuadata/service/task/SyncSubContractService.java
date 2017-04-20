package com.fuhuadata.service.task;

import com.fuhuadata.dao.task.SyncContractDao;
import com.fuhuadata.dao.task.SyncSubContractDao;
import com.fuhuadata.domain.task.SyncContract;
import com.fuhuadata.domain.task.SyncSubContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 同步NC合同部分字段到mysql
 * Created by hexingfu on 2017/4/19.
 */
@Service("syncSubContract")
public class SyncSubContractService {

    @Autowired
    private SyncSubContractDao syncSubContractDao;
    @Transactional
    public void sync(){
        try {
            //从oracle获取数据
            List<SyncSubContract> list = syncSubContractDao.getOracleData();
            //清除mysql数据
            syncSubContractDao.deleteMysqlData();
            //将oracle数据插入mysql
            syncSubContractDao.insertMysqlData(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

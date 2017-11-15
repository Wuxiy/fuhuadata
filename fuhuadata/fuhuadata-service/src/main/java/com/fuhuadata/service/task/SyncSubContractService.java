package com.fuhuadata.service.task;

import com.fuhuadata.dao.task.SyncContractDao;
import com.fuhuadata.dao.task.SyncSubContractDao;
import com.fuhuadata.domain.task.SyncContract;
import com.fuhuadata.domain.task.SyncSubContract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 同步NC合同部分字段到mysql
 * Created by zhangxiang on 2017/4/19.
 */
@Service("syncSubContract")
public class SyncSubContractService {
    private Logger logger= LoggerFactory.getLogger(SyncSubContractService.class);
    @Autowired
    private SyncSubContractDao syncSubContractDao;
    @Autowired
    private SyncContractDao syncContractDao;
    @Transactional
    public void sync(){
        syncContract();
        syncSubContract();
    }
    private void syncSubContract(){
        try{
            List<SyncSubContract> list = syncSubContractDao.getOracleData();
            syncSubContractDao.insertMysqlData(list);
            logger.debug("同步[{}]条合同表体",list.size());
        }catch (Exception e){
            logger.error("同步合同表体出错",e);
        }
    }
    private void syncContract(){
        try {
            List<SyncContract> list = syncContractDao.getOracleData();
            syncContractDao.insertMysqlData(list);
            logger.debug("同步[{}]条合同",list.size());
        } catch (Exception e) {
            logger.error("同步合同出错",e);
        }

    }
}

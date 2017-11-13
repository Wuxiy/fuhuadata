package com.fuhuadata.service.task;

import com.fuhuadata.dao.task.SyncUserAccountDao;
import com.fuhuadata.domain.mybatis.UserAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by zhangxiang on 2017/11/10.
 */
@Service("syncUserAccount")
public class SyncUserAccount {
    Logger logger= LoggerFactory.getLogger(SyncUserAccount.class);
    @Autowired
    private SyncUserAccountDao syncUserAccountDao;
    @Transactional
    public void sync(){
        try {
            List<UserAccount> list= syncUserAccountDao.getUserFromNC();
            syncUserAccountDao.replaceUser(list);
            logger.debug("成功同步[{}]条用户档案",list.size());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("同步用戶档案出错",e);
        }
    }
}

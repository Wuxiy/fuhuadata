package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.domain.mybatis.UserLoginLog;
import com.fuhuadata.service.mybatis.UserLoginLogService;
import org.springframework.stereotype.Service;

/**
 * <p>User: wangjie
 * <p>Date: 4/8/2017
 */
@Service
public class UserLoginLogServiceImpl extends BaseServiceImpl<UserLoginLog, Integer>
        implements UserLoginLogService {

    @Override
    public void saveLog(UserLoginLog loginLog) {
        save(loginLog);
    }
}

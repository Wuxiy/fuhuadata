package com.fuhuadata.service.mybatis;

import com.fuhuadata.domain.mybatis.UserLoginLog;

/**
 * <p>User: wangjie
 * <p>Date: 4/8/2017
 */
public interface UserLoginLogService extends BaseService<UserLoginLog, Integer> {

    void saveLog(UserLoginLog loginLog);
}

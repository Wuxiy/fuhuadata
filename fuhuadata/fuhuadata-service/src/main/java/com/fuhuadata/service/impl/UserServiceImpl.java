package com.fuhuadata.service.impl;

import com.fuhuadata.domain.UserAccount;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.UserManager;
import com.fuhuadata.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by zhangxiang on 2017/2/8.
 */
public class UserServiceImpl implements UserService {
    private static final Log log = LogFactory.getLog(UserServiceImpl.class);
    private UserManager userManager;
    @Override
    public Result<UserAccount> getUserByAccount(String account) {
        Result result=new Result();
        try {
            UserAccount userAccount= userManager.getUserByAccount(account);
            if (userAccount!=null){
                result.addDefaultModel("userAccount",userAccount);
            }else {
                result.setCode(-1);
                result.setSuccess(false);
            }
        }catch (Exception e){
            result.setCode(0);
            result.setSuccess(false);
            log.error("查询用户失败",e);
        }
        return result;
    }
}

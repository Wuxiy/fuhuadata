package com.fuhuadata.service.mybatis;

import com.fuhuadata.domain.mybatis.UserAccount;

/**
 * <p>User: wangjie
 * <p>Date: 4/15/2017
 */
public interface PasswordService {

    /**
     * 验证用户密码是否正确
     * @param user
     * @param password
     */
    void validate(UserAccount user, String password);
}

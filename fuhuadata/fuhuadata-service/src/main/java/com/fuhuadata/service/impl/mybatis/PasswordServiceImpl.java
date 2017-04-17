package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.domain.mybatis.UserAccount;
import com.fuhuadata.service.exception.UserPasswordNotMatchException;
import com.fuhuadata.service.mybatis.PasswordService;
import org.springframework.stereotype.Service;

/**
 * <p>User: wangjie
 * <p>Date: 4/15/2017
 */
@Service
public class PasswordServiceImpl implements PasswordService {

    @Override
    public void validate(UserAccount user, String password) {
        if (!matchs(user, password)) {
            throw new UserPasswordNotMatchException("密码错误");
        }
    }

    private boolean matchs(UserAccount user, String password) {
        String loginPassword = user.getLoginPassword();

        return loginPassword.equals(password);
    }
}

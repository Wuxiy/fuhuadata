package com.fuhuadata.homesales.user.domain;

import com.fuhuadata.domain.mybatis.UserAccount;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * <p>User: wangjie
 * <p>Date: 7/26/2017
 */
public class User extends UserAccount {

    /**
     * 用户职位：1=领导，2=普通业务员
     */
    private Integer userPosition;

    public Integer getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(Integer userPosition) {
        this.userPosition = userPosition;
    }

    public static User of(UserAccount userAccount) {

        User user = new User();
        try {
            BeanUtils.copyProperties(user, userAccount);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("UserAccount转换为User失败", e);
        }

        return user;
    }
}

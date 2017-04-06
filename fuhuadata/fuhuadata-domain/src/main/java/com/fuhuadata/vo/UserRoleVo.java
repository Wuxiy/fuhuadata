package com.fuhuadata.vo;

import com.fuhuadata.domain.mybatis.UserArea;
import com.fuhuadata.domain.mybatis.UserRole;

import java.util.Collections;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 3/30/2017
 */
public class UserRoleVo extends UserRole {

    /**
     * 用户地区
     */
    private List<UserArea> userAreas;

    public List<UserArea> getUserAreas() {
        if (this.userAreas == null) {
            return Collections.emptyList();
        }
        return this.userAreas;
    }

    public void setUserAreas(List<UserArea> userAreas) {
        this.userAreas = userAreas;
    }
}

package com.fuhuadata.homesales.user.service;

import com.fuhuadata.homesales.user.domain.User;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 7/26/2017
 */
public interface UserService {

    User get(String userId);

    /**
     * 列出所有的下属
     * @param userId
     * @return
     */
    List<User> listSubordinates(String userId);

    /**
     * 获取某地区下的人员
     * @param areaId
     * @return
     */
    List<User> listByAreaId(String areaId);

    /**
     * 获取某地区下的子子孙孙人员
     * @param areaId
     * @return
     */
    List<User> listAllByAreaId(String areaId);

    /**
     * 判断用户是否是领导
     *
     * <p>如果所分配的地区有子地区</p>
     * @param user
     * @return
     */
    boolean isLead(User user);

    /**
     * 设置 user 是否是领导
     * @param user
     */
    void setLeader(User user);

    /**
     * 修改密码
     * @param userId
     * @param oldPwd 旧密码
     * @param newPwd 新密码
     * @return
     */
    boolean changePassword(String userId, String oldPwd, String newPwd);
}

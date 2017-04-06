package com.fuhuadata.service.mybatis;

import com.fuhuadata.domain.mybatis.UserRole;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 3/29/2017
 */
public interface UserRoleService extends BaseService<UserRole, Integer> {

    /**
     * 新增用户角色关联
     * @param userRoles
     */
    void saveUserRole(List<UserRole> userRoles);

    /**
     * 新增用户角色关联
     * @param roleId
     * @param users
     */
    void saveUsersOfRole(Integer roleId, List<UserRole> users);

    /**
     * 获取角色下面的用户
     * @param roleId
     * @return
     */
    List<UserRole> listUsersOfRole(Integer roleId);

    /**
     * 删除角色关联用户
     * @param roleId
     */
    void deleteUserRoles(Integer roleId);
}

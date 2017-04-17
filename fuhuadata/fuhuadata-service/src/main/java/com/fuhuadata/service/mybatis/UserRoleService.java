package com.fuhuadata.service.mybatis;

import com.fuhuadata.domain.mybatis.UserAccount;
import com.fuhuadata.domain.mybatis.UserRole;

import java.util.List;
import java.util.Set;

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
     * 获取角色关联的用户
     * @param roleId
     * @return
     */
    List<UserAccount> listUserAccountByRoleId(Integer roleId);

    /**
     * 获取用户关联角色id
     * @param userId
     * @return
     */
    Set<Integer> getRoleIds(Integer userId);

    /**
     * 删除角色关联用户
     * @param roleId
     */
    void deleteUserRoles(Integer roleId);

    /**
     * 根据id删除角色用户
     * @param userRoleIds
     */
    void deleteUserRoles(List<Integer> userRoleIds);

    /**
     * 删除角色下关联的用户
     * @param roleId
     * @param userIds 删除的用户id
     * @return
     */
    int deleteUserRoles(Integer roleId, List<Integer> userIds);
}

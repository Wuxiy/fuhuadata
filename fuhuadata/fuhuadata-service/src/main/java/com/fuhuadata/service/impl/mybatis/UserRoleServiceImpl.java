package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.dao.mapper.UserRoleMapper;
import com.fuhuadata.domain.mybatis.UserAccount;
import com.fuhuadata.domain.mybatis.UserRole;
import com.fuhuadata.service.mybatis.UserRoleService;
import com.google.common.collect.Sets;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * <p>User: wangjie
 * <p>Date: 3/29/2017
 */
@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole, Integer> implements UserRoleService {

    private UserRoleMapper getUserRoleMapper() {
        return (UserRoleMapper) baseMapper;
    }

    @Override
    public void saveUserRole(List<UserRole> userRoles) {
        saveBatch(userRoles);
    }

    @Override
    public void saveUsersOfRole(Integer roleId, List<UserRole> users) {
        if (roleId == null) {
            throw new IllegalArgumentException("roleId 不能为空");
        }
        saveList(users);
    }

    @Override
    public List<UserRole> listUsersOfRole(Integer roleId) {
        return getUserRoleMapper().listUsersOfRole(roleId);
    }

    @Override
    public List<UserAccount> listUserAccountByRoleId(Integer roleId) {
        if (roleId == null) {
            return Collections.emptyList();
        }

        return getUserRoleMapper().listUserAccountsByRoleId(roleId);
    }

    @Override
    public Set<Integer> getRoleIds(Integer userId) {
        List<Integer> roleIdList = getUserRoleMapper().listRoleIdsByUserId(userId);
        return Sets.newHashSet(roleIdList);
    }

    @Override
    public void deleteUserRoles(Integer roleId) {
        Example example = new Example(UserRole.class);
        example.createCriteria().andEqualTo("roleId", roleId);

        int deleted = delete(example);
    }

    @Override
    public void deleteUserRoles(List<Integer> userRoleIds) {
        Example example = new Example(UserRole.class);
        example.createCriteria().andIn("id", userRoleIds);

        delete(example);
    }

    @Override
    public int deleteUserRoles(Integer roleId, List<Integer> userIds) {
        if (roleId == null || userIds == null || userIds.size() == 0) {
            return 0;
        }

        Example example = new Example(UserRole.class);
        example.createCriteria().andEqualTo("roleId", roleId)
                .andIn("userId", userIds);

        return delete(example);
    }
}

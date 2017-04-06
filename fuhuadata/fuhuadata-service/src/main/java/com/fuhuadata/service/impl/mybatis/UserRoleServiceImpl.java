package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.dao.mapper.UserRoleMapper;
import com.fuhuadata.domain.mybatis.UserRole;
import com.fuhuadata.service.mybatis.UserRoleService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

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
        deleteUserRoles(roleId);
        saveList(users);
    }

    @Override
    public List<UserRole> listUsersOfRole(Integer roleId) {
        return getUserRoleMapper().listUsersOfRole(roleId);
    }

    @Override
    public void deleteUserRoles(Integer roleId) {
        Example example = new Example(UserRole.class);
        example.createCriteria().andEqualTo("roleId", roleId);

        int deleted = delete(example);
    }
}

package com.fuhuadata.dao.mapper;

import com.fuhuadata.domain.mybatis.UserAccount;
import com.fuhuadata.domain.mybatis.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleMapper extends BaseMapper<UserRole, Integer> {

    List<UserRole> listUsersOfRole(@Param("roleId") Integer roleId);

    List<UserAccount> listUserAccountsByRoleId(@Param("roleId") Integer roleId);

    List<Integer> listRoleIdsByUserId(@Param("userId") Integer userId);

    /**
     * 根据角色id获取关联用户id
     * @param roleId
     * @return
     */
    List<Integer> listUserIdsByRoleId(@Param("roleId") Integer roleId);
}
package com.fuhuadata.dao.mapper;

import com.fuhuadata.domain.mybatis.UserAccount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserAccountMapper extends BaseMapper<UserAccount, Integer> {

    List<UserAccount> listUserByDeptId(@Param("deptId") String deptId);

    List<UserAccount> listUsersByUserIds(@Param("userIds") List<Integer> userIds);

    List<String> listDeptIdsOfUserByRoleId(@Param("roleId") Integer roleId);

    List<Integer> listUserIdsByDeptIds(@Param("deptIds") List<String> deptIds);
}
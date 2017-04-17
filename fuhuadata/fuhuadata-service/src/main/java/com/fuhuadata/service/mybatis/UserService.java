package com.fuhuadata.service.mybatis;

import com.fuhuadata.domain.mybatis.Principal;
import com.fuhuadata.domain.mybatis.UserAccount;
import com.fuhuadata.vo.MixNodeVO;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 4/12/2017
 */
public interface UserService extends BaseService<UserAccount, Integer> {

    /**
     * 获取部门下的用户
     * @param deptId
     * @return
     */
    List<UserAccount> listUserByDept(String deptId);

    /**
     * 获取某部门下的用户
     * @param deptId
     * @return
     */
    List<MixNodeVO> listUserNodesByDept(String deptId);

    /**
     * 获取用户（包含部门ID）
     * @param userIds
     * @return
     */
    List<UserAccount> listUsersWithDeptIdByUserIds(List<Integer> userIds);

    HashSet<String> listDeptIdsOfUserByRoleId(Integer roleId);

    List<MixNodeVO> getUserTreeWhenAddNodes(List<Integer> userIds);

    List<MixNodeVO> getUserTreeByRoleId(Integer roleId);

    List<MixNodeVO> listUserNodesByRoleId(Integer roleId);

    /**
     * 根据部门获取用户
     * @param deptIds
     * @return
     */
    List<Integer> listUserIdsByDeptIds(List<String> deptIds);

    UserAccount getUserByLoginName(String loginName);

    UserAccount login(String loginName, String password);

    void updateUserLoginInfo(Principal principal, HttpServletRequest request);

    void changePassword(Integer userId, String password);
}

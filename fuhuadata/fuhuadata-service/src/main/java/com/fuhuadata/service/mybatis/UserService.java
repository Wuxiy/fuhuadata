package com.fuhuadata.service.mybatis;

import com.fuhuadata.domain.mybatis.Dept;
import com.fuhuadata.domain.mybatis.Principal;
import com.fuhuadata.domain.mybatis.UserAccount;
import com.fuhuadata.vo.MixNodeVO;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

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

    List<MixNodeVO> getUserNodesByDeptCode(String deptCode);

    List<MixNodeVO> getUserNodesByDept(Dept dept);

    /**
     * 获取用户（包含部门ID）
     * @param userIds
     * @return
     */
    List<UserAccount> listUsersWithDeptIdByUserIds(List<Integer> userIds);

    /**
     * 获取角色关联用户的去重的组织 nc_ids
     * @param roleId
     * @return
     */
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

    /**
     * 根据 loginName 获取用户
     * @param loginName
     * @return
     */
    Optional<UserAccount> getUserOptByLoginName(String loginName);

    Optional<UserAccount> getUserOptById(Integer userId);

    /**
     * 根据 code 获取用户
     * @param code
     * @return
     */
    UserAccount getUserByCode(String code);

    Optional<UserAccount> getUserOptByCode(String code);

    UserAccount login(String loginName, String password);

    void updateUserLoginInfo(Principal principal, HttpServletRequest request);

    UserAccount changePassword(Integer userId, String password);
}

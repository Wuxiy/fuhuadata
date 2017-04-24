package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.constant.NodeType;
import com.fuhuadata.dao.mapper.UserAccountMapper;
import com.fuhuadata.domain.mybatis.Dept;
import com.fuhuadata.domain.mybatis.Principal;
import com.fuhuadata.domain.mybatis.UserAccount;
import com.fuhuadata.service.exception.ServiceException;
import com.fuhuadata.service.exception.UserNotExistsException;
import com.fuhuadata.service.exception.UserPasswordNotMatchException;
import com.fuhuadata.service.mybatis.DeptService;
import com.fuhuadata.service.mybatis.PasswordService;
import com.fuhuadata.service.mybatis.UserRoleService;
import com.fuhuadata.service.mybatis.UserService;
import com.fuhuadata.service.util.IpUtils;
import com.fuhuadata.service.util.UserTreeCache;
import com.fuhuadata.vo.MixNodeVO;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * <p>User: wangjie
 * <p>Date: 4/12/2017
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserAccount, Integer>
        implements UserService {

    private UserRoleService userRoleService;

    private PasswordService passwordService;

    private DeptService deptService;

    @Autowired
    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @Autowired
    public void setPasswordService(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @Autowired
    public void setDeptService(DeptService deptService) {
        this.deptService = deptService;
    }

    private UserAccountMapper getUserMapper() {
        return (UserAccountMapper) baseMapper;
    }

    @Override
    public List<UserAccount> listUserByDept(String deptId) {
        if (StringUtils.isBlank(deptId)) {
            return Collections.emptyList();
        }

        return getUserMapper().listUserByDeptId(deptId);
    }

    @Override
    public List<MixNodeVO> listUserNodesByDept(String deptId) {

        List<MixNodeVO> nodes = Lists.newArrayList();
        List<UserAccount> userAccounts = listUserByDept(deptId);

        for (UserAccount user : userAccounts) {
            nodes.add(convertToNode(user));
        }
        return nodes;
    }

    @Override
    public List<MixNodeVO> getUserNodesByDeptCode(String deptCode) {
        Dept dept = deptService.getDeptByCode(deptCode);
        return getUserNodesByDept(dept);
    }

    @Override
    public List<MixNodeVO> getUserNodesByDept(Dept dept) {
        if (dept == null) {
            return Collections.emptyList();
        }

        String pkDept = dept.getPkDept();
        return listUserNodesByDept(pkDept);
    }

    @Override
    public List<UserAccount> listUsersWithDeptIdByUserIds(List<Integer> userIds) {
        if (userIds == null || userIds.size() == 0) {
            return Collections.emptyList();
        }

        return getUserMapper().listUsersByUserIds(userIds);
    }

    @Override
    public HashSet<String> listDeptIdsOfUserByRoleId(Integer roleId) {
        if (roleId == null) {
            return Sets.newHashSet();
        }

        return Sets.newHashSet(getUserMapper().listDeptIdsOfUserByRoleId(roleId));
    }

    @Override
    public List<MixNodeVO> getUserTreeWhenAddNodes(List<Integer> userIds) {

        return null;
    }

    @Override
    public List<MixNodeVO> getUserTreeByRoleId(Integer roleId) {
        HashSet<String> deptIds = listDeptIdsOfUserByRoleId(roleId);
        Map<String, MixNodeVO> lookup = new HashMap<String, MixNodeVO>();
        List<MixNodeVO> roots = getTreeFromDeptIds(deptIds, lookup);

        List<MixNodeVO> userNodes = listUserNodesByRoleId(roleId);
        for (MixNodeVO userNode : userNodes) {
            String deptId = userNode.getPid();
            MixNodeVO deptNode = lookup.get(deptId);
            deptNode.addChildNode(userNode);
        }
        return roots;
    }

    private List<MixNodeVO> getTreeFromDeptIds(HashSet<String> deptIds, Map<String, MixNodeVO> lookup) {
        List<MixNodeVO> roots = Lists.newArrayList();

        for (String deptId : deptIds) {
            MixNodeVO nodeVO = MixNodeVO.cloneNode(UserTreeCache.get(deptId));

            lookup.put(deptId, nodeVO);
            String pid = nodeVO.getPid();
            while (!pid.equals("0")) {
                MixNodeVO pNode = lookup.get(pid);

                if (pNode != null) {
                    pNode.addChildNode(nodeVO);
                } else {
                    pNode = MixNodeVO.cloneNode(UserTreeCache.get(pid));
                    pNode.addChildNode(nodeVO);
                    lookup.put(pNode.getCid(), pNode);
                    if (pNode.getType() == NodeType.ORG.key) {
                        lookup.put(pNode.getNcId(), pNode);
                    }
                }

                pid = pNode.getPid();
                nodeVO = pNode;
                if (pid.equals("0") && roots.size() == 0) {
                    roots.add(pNode);
                }
            }
        }
        return roots;
    }

    @Override
    public List<MixNodeVO> listUserNodesByRoleId(Integer roleId) {
        List<MixNodeVO> nodes = Lists.newArrayList();
        List<UserAccount> userAccounts = userRoleService.listUserAccountByRoleId(roleId);

        for (UserAccount user : userAccounts) {
            nodes.add(convertToNode(user));
        }
        return nodes;
    }

    @Override
    public List<Integer> listUserIdsByDeptIds(List<String> deptIds) {
        if (deptIds == null || deptIds.size() == 0) {
            return Collections.emptyList();
        }

        return getUserMapper().listUserIdsByDeptIds(deptIds);
    }

    private MixNodeVO convertToNode(UserAccount user) {
        MixNodeVO node = new MixNodeVO(NodeType.USER.key);

        node.setCid(String.valueOf(user.getId()));
        node.setCode(user.getCode());
        node.setCname(user.getName());
        node.setIsParent(false);
        node.setNcId(user.getCode());
        node.setPid(user.getPkDept());

        return node;
    }

    @Override
    public UserAccount getUserByLoginName(String loginName) {
        if (StringUtils.isEmpty(loginName)) {
            return null;
        }

        Example example = new Example(UserAccount.class);
        example.createCriteria().andEqualTo("code", loginName);

        List<UserAccount> users = getUserMapper().selectByExample(example);
        int size = users.size();
        if (size == 1) {
            return users.get(0);
        } else if (size > 1) {
            throw new ServiceException("用户登录名：" + loginName + "不唯一");
        }
        return null;
    }

    @Override
    public UserAccount login(String loginName, String password) {

        if (StringUtils.isBlank(loginName) || StringUtils.isBlank(password)) {
            throw new UserNotExistsException("用户不存在");
        }
        // 检查密码长度是否正确
        if (password.length() < UserAccount.PASSWORD_MIN_LENGTH
                || password.length() > UserAccount.PASSWORD_MAX_LENGTH) {
            throw new UserPasswordNotMatchException("密码长度错误");
        }

        // 获取当前代理对象，为了走切面
        UserAccount user = ((UserService) AopContext.currentProxy()).getUserByLoginName(loginName);

        passwordService.validate(user, password);

        return user;
    }

    @Override
    public void updateUserLoginInfo(Principal principal, HttpServletRequest request) {
        Integer id = principal.getId();
        UserAccount userAccount = get(id);

        // 保存上次登录信息
        userAccount.setLastLoginIp(userAccount.getLoginIp());
        userAccount.setLastLoginTime(userAccount.getLoginTime());
        // 保存这次登录信息
        userAccount.setLoginIp(IpUtils.getIpAddr(request));
        userAccount.setLoginTime(new Date());

        update(userAccount);
    }

    @Override
    public void changePassword(Integer userId, String password) {
        if (userId == null || StringUtils.isBlank(password)) {
            return;
        }

        UserAccount userAccount = get(userId);
        if (userAccount != null) {
            userAccount.setLastPassword(userAccount.getLoginPassword());
            userAccount.setLoginPassword(password);
            update(userAccount);
        }
    }

}

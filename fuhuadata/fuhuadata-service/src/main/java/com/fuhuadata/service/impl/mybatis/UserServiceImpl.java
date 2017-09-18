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
import com.fuhuadata.vo.BaseTreeVo;
import com.fuhuadata.vo.MixNodeVO;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * <p>User: wangjie
 * <p>Date: 4/12/2017
 */
@CacheConfig(cacheNames = "sys-userCache")
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
    public List<UserAccount> listUserByUserCodes(List<String> codes) {

        if (codes == null || codes.isEmpty()) {
            return Collections.emptyList();
        }

        Example example = newExample();
        example.createCriteria().andIn("code", codes);

        return this.listByExample(example);
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
        Dept dept = deptService.getByCode(deptCode);
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
            if (deptNode != null) {
                deptNode.addChildNode(userNode);
            }
        }
        return roots;
    }

    // 根据部门 ids 获取组织和部门的树
    private List<MixNodeVO> getTreeFromDeptIds(HashSet<String> deptIds, Map<String, MixNodeVO> lookup) {
        List<MixNodeVO> roots = Lists.newArrayList();
        HashSet<String> rootIds = Sets.newHashSet();

        for (String deptId : deptIds) {
            MixNodeVO nodeVO = deptService.getMixNodeByNcId(deptId);

            while (nodeVO != null) {

                String cid = nodeVO.getCid();
                if (lookup.get(cid) != null) {
                    // 作为父节点添加过，所以设置其子节点
                    nodeVO.setNodes(lookup.get(cid).getNodes());
                }
                lookup.put(cid, nodeVO);

                if (nodeVO.isRoot()) {
                    if (!rootIds.contains(cid)) {
                        roots.add(nodeVO);
                        rootIds.add(cid);
                    }
                    break;
                }

                String pid = nodeVO.getPid();
                MixNodeVO pNode = lookup.get(pid);
                if (pNode != null) {
                    List<BaseTreeVo<String>> children = pNode.getNodes();
                    // 如果子节点中未找到该节点，则添加
                    if (children == null || children.stream().map(BaseTreeVo::getCid).noneMatch(cid::equals)) {
                        pNode.addChildNode(nodeVO);
                    }
                } else {
                    pNode = deptService.getOrgOrDepPNode(pid);
                    if (pNode != null) {
                        pNode.addChildNode(nodeVO);
                        lookup.put(pNode.getCid(), pNode);
                    }
                }

                nodeVO = pNode;
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

    @Cacheable(key = "'username-' + #loginName")
    @Override
    public UserAccount getUserByLoginName(String loginName) {
        if (StringUtils.isEmpty(loginName)) {
            return null;
        }

        return getUserMapper().getByLoginName(loginName);
    }

    @Override
    public Optional<UserAccount> getUserOptByLoginName(String loginName) {

        return Optional.ofNullable(getProxyUserService().getUserByLoginName(loginName));
    }

    private UserService getProxyUserService() {
        return (UserService) AopContext.currentProxy();
    }

    @Override
    public Optional<UserAccount> getUserOptById(Integer userId) {

        return Optional.ofNullable(get(userId));
    }

    @Override
    public UserAccount getUserByCode(String code) {

        if (StringUtils.isEmpty(code)) {
            return null;
        }

        return getUserMapper().getByCode(code);
    }

    @Override
    public UserAccount getUserByRefreshToken(String refreshToken) {

        if (StringUtils.isEmpty(refreshToken)) {
            return null;
        }

        UserAccount userAccount = newEntity();
        userAccount.setRefreshToken(refreshToken);

        return getProxyUserService().get(userAccount);
    }

    @Override
    public Optional<UserAccount> getUserOptByCode(String code) {

        return Optional.ofNullable(getProxyUserService().getUserByCode(code));
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
        UserAccount user = getProxyUserService().getUserByLoginName(loginName);

        if (user == null) {
            throw new UserNotExistsException("用户不存在");
        }

        passwordService.validate(user, password);

        return user;
    }

    @CacheEvict(key = "'username-' + #principal.loginName")
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

    @CacheEvict(key = "'username-' + #result.loginName")
    @Override
    public UserAccount changePassword(Integer userId, String password) {
        if (userId == null || StringUtils.isBlank(password)) {
            return null;
        }

        UserAccount userAccount = get(userId);
        if (userAccount != null) {
            userAccount.setLastPassword(userAccount.getLoginPassword());
            userAccount.setLoginPassword(password);
            update(userAccount);
        }

        return userAccount;
    }

    @CacheEvict(key = "'username-' + #result.loginName")
    @Override
    public UserAccount changePassword(Integer userId, String oldPwd, String newPwd) {

        if (userId == null || StringUtils.isBlank(oldPwd) || StringUtils.isBlank(newPwd)) {
            throw new IllegalArgumentException("userId [" + userId + "], oldPwd ["
                    + oldPwd + "], newPwd [" + newPwd + "], 参数不能为空");
        }

        UserAccount userAccount = get(userId);
        if (userAccount == null) {
            throw new UserNotExistsException("用户[" + userId + "]不存在");
        }

        String loginPassword = userAccount.getLoginPassword();
        if (!oldPwd.equals(loginPassword)) {
            throw new ServiceException("旧密码错误");
        }

        userAccount.setLastPassword(loginPassword);
        userAccount.setLoginPassword(newPwd);
        updateSelective(userAccount);

        return userAccount;
    }


}

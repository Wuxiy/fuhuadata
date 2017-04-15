package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.constant.NodeType;
import com.fuhuadata.dao.mapper.UserAccountMapper;
import com.fuhuadata.domain.mybatis.UserAccount;
import com.fuhuadata.service.mybatis.UserRoleService;
import com.fuhuadata.service.mybatis.UserService;
import com.fuhuadata.service.util.UserTreeCache;
import com.fuhuadata.vo.MixNodeVO;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>User: wangjie
 * <p>Date: 4/12/2017
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserAccount, Integer>
        implements UserService {

    private UserRoleService userRoleService;

    @Autowired
    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
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
        node.setCname(user.getName());
        node.setIsParent(false);
        node.setNcId(user.getCode());
        node.setPid(user.getPkDept());

        return node;
    }
}

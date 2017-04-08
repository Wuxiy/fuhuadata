package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.dao.mapper.RoleMapper;
import com.fuhuadata.domain.mybatis.Role;
import com.fuhuadata.service.mybatis.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 3/23/2017
 */
@Service
public class RoleServiceImpl extends BaseTreeableServiceImpl<Role, Integer>
        implements RoleService {

    private RoleMapper getRoleMapper() {
        return (RoleMapper) baseMapper;
    }

    @Override
    public Role get(Integer id) {
        return getRoleMapper().getRole(id);
    }

    @Override
    public int countNextIndex(Integer parentId) {
        return getRoleMapper().countNextIndex(parentId);
    }

    @Override
    public void deleteSelfAndChildren(Role self) {
        getRoleMapper().deleteSelfAndChildren(self.getId(), self.makeSelfAsNewParentIds());
    }

    @Override
    public int updateChildrenParentIds(String newChildrenParentIds, String oldChildrenParentIds) {
        return getRoleMapper().updateChildrenParentIds(newChildrenParentIds, oldChildrenParentIds);
    }

    @Override
    public List<Role> listSelfAndNextSiblings(Integer parentId, int weight) {
        return getRoleMapper().listSelfAndNextSiblings(parentId, weight);
    }

}

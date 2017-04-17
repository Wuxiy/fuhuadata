package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.dao.mapper.RoleAuthorityMapper;
import com.fuhuadata.domain.mybatis.RoleAuthority;
import com.fuhuadata.service.mybatis.RoleAuthorityService;
import com.fuhuadata.service.util.LoginUtils;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 4/3/2017
 */
@Service
public class RoleAuthorityServiceImpl extends BaseServiceImpl<RoleAuthority, Integer>
        implements RoleAuthorityService {

    @Override
    public void saveAuthOfRole(Integer roleId, List<RoleAuthority> auths) {
        if (roleId == null) {
            throw new IllegalArgumentException("roleId 不能为空");
        }

        for (RoleAuthority authority : auths) {
            authority.setRoleId(roleId);
            authority.setAuthUserId(LoginUtils.getLoginId());
            authority.setAuthUserName(LoginUtils.getLoginName());
            authority.setAuthTime(new Date());
        }

        deleteAuthOfRole(roleId);
        saveList(auths);
    }

    @Override
    public void saveAuths(List<RoleAuthority> auths) {
        saveBatch(auths);
    }

    @Override
    public int deleteAuthOfRole(Integer roleId) {
        Example example = new Example(RoleAuthority.class);
        example.createCriteria().andEqualTo("roleId", roleId);

        return delete(example);
    }

    @Override
    public void updatePermission(List<RoleAuthority> authorities) {
        List<RoleAuthority> authsForUpdate = Lists.newArrayList();

        for (RoleAuthority auth : authorities) {
            RoleAuthority roleAuthority = new RoleAuthority();
            if (null == auth.getId()) {
                throw new IllegalArgumentException("更新权限：ID 不能为空");
            }
            roleAuthority.setId(auth.getId());
            roleAuthority.setPermissionIds(auth.getPermissionIds());
            roleAuthority.setAuthUserId(LoginUtils.getLoginId());
            roleAuthority.setAuthUserName(LoginUtils.getLoginName());
            roleAuthority.setAuthTime(new Date());

            authsForUpdate.add(roleAuthority);
        }

        updateBatchSelective(authsForUpdate);
    }

    private RoleAuthorityMapper getRoleAuthMapper() {
        return (RoleAuthorityMapper) baseMapper;
    }

}

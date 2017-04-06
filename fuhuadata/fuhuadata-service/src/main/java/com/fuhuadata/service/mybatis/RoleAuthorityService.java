package com.fuhuadata.service.mybatis;

import com.fuhuadata.domain.mybatis.RoleAuthority;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 4/3/2017
 */
public interface RoleAuthorityService extends BaseService<RoleAuthority, Integer> {

    /**
     * 角色关联菜单
     * @param roleId
     * @param auths
     */
    void saveAuthOfRole(Integer roleId, List<RoleAuthority> auths);

    /**
     * 保存权限
     * @param auths
     */
    void saveAuths(List<RoleAuthority> auths);

    /**
     * 删除角色关联的菜单
     * @param roleId
     * @return
     */
    int deleteAuthOfRole(Integer roleId);

    /**
     * 更新角色菜单的权限
     * @param authorities
     */
    void updatePermission(List<RoleAuthority> authorities);

}

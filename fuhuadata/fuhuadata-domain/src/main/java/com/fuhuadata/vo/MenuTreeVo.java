package com.fuhuadata.vo;

import com.fuhuadata.domain.mybatis.Button;
import com.fuhuadata.domain.mybatis.RoleAuthority;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 4/3/2017
 */
public class MenuTreeVo extends BaseTreeVo<Integer> {

    private String identity;

    private RoleAuthority roleAuthority;
    private List<Button> buttons;

    public RoleAuthority getRoleAuthority() {
        return roleAuthority;
    }

    public void setRoleAuthority(RoleAuthority roleAuthority) {
        this.roleAuthority = roleAuthority;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}

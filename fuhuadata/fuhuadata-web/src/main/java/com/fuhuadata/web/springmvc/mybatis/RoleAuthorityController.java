package com.fuhuadata.web.springmvc.mybatis;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuhuadata.domain.mybatis.RoleAuthority;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.MenuService;
import com.fuhuadata.service.mybatis.RoleAuthorityService;
import com.fuhuadata.vo.MenuTreeVo;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 4/3/2017
 */
@RequestMapping("/sys/roleauth")
@Controller
public class RoleAuthorityController extends BaseController<RoleAuthority, Integer> {

    private RoleAuthorityService roleAuthService;

    private MenuService menuService;

    @Autowired
    public void setRoleAuthService(RoleAuthorityService roleAuthService) {
        this.roleAuthService = roleAuthService;
    }

    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping("save")
    @ResponseBody
    public ResultPojo saveAuthsOfRole(@RequestParam("roleId") Integer roleId,
                                      @RequestParam("auths") String authsStr) {

        Result<Boolean> result = Result.newResult(false);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            List<RoleAuthority> authorities =
                    objectMapper.readValue(authsStr, new TypeReference<List<RoleAuthority>>() {
                    });

            roleAuthService.saveAuthOfRole(roleId, authorities);
            result.setSuccess(true);
        } catch (IOException e) {
            logger.error("[{}]转换为[List<RoleAuthority>]失败", authsStr, e);
            result.setMessage("auths 转换失败");
        }

        return result.getResultPojo();
    }

    @RequestMapping(value = "/menu")
    @ResponseBody
    public ResultPojo listRoleAuthMenus(@RequestParam("roleId") Integer roleId) {
        Result<List<MenuTreeVo>> result = Result.newResult(true);

        List<MenuTreeVo> menuTreeVos = menuService.listAuthMenuTree(roleId);

        result.addDefaultModel(menuTreeVos);
        return result.getResultPojo();
    }

    @PostMapping("/permission")
    @ResponseBody
    @SystemLogAnnotation(module = "sys-auth", methods = "updateRolePermission")
    public ResultPojo updateRolePermissions(@RequestParam("permissions") String permissionsStr) {
        Result<Boolean> result = Result.newResult(false);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            List<RoleAuthority> authorities =
                    objectMapper.readValue(permissionsStr, new TypeReference<List<RoleAuthority>>() {
                    });

            roleAuthService.updatePermission(authorities);
            result.setSuccess(true);
        } catch (IOException e) {
            logger.error("权限转换失败", e);
            result.setMessage("权限更新失败");
        }

        return result.getResultPojo();
    }

    @GetMapping(value = "/permission")
    @ResponseBody
    public ResultPojo listPermissionMenus(@RequestParam("roleId") Integer roleId) {
        Result<List<MenuTreeVo>> result = Result.newResult(true);

        List<MenuTreeVo> menuTreeVos = menuService.listPermissionMenuTree(roleId);

        result.addDefaultModel(menuTreeVos);
        return result.getResultPojo();
    }
}

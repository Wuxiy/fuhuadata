package com.fuhuadata.web.springmvc.mybatis;

import com.fuhuadata.domain.mybatis.Role;
import com.fuhuadata.domain.mybatis.UserRole;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.UserRoleService;
import com.fuhuadata.service.mybatis.UserService;
import com.fuhuadata.service.mybatis.user.JobService;
import com.fuhuadata.service.util.LoginUtils;
import com.fuhuadata.web.util.SystemLogAnnotation;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * <p>User: wangjie
 * <p>Date: 3/28/2017
 */
@RequestMapping("/sys/role")
@Controller
public class RoleController extends BaseTreeableController<Role, Integer> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private UserRoleService userRoleService;

    private UserService userService;

    @Resource
    private JobService jobService;

    public RoleController() {
        setResourceIdentity("sys:role");
    }

    @Autowired
    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequiresPermissions("sys:role:view")
    @RequestMapping(value = {"", "init"}, method = RequestMethod.GET)
    public String mian() {
        return "system/systemRoleManage";
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    @ResponseBody
    @SystemLogAnnotation(module = "sys-role", methods = "listUsersOfRole")
    public ResultPojo listUsersOfRole(@RequestParam("roleId") Integer roleId) {
        Result<List<UserRole>> result = new Result<List<UserRole>>(true);

        List<UserRole> userRoles = userRoleService.listUsersOfRole(roleId);
        result.addDefaultModel(userRoles);

        return result.getResultPojo();
    }

    // 角色关联用户
    @RequestMapping(value = "users", method = RequestMethod.POST)
    @ResponseBody
    @SystemLogAnnotation(module = "sys-role", methods = "saveUsersOfRole")
    public ResultPojo saveUsersOfRole(UserRole userRoleOri, @RequestParam("userCodes") String userCodes,
                                      @RequestParam(value = "deptIds", required = false) String deptIds) {

        if (permissionList != null) {
            permissionList.assertHasEditPermission();
        }

        Result<Boolean> result = Result.newResult(false);
        List<UserRole> userRoles = Lists.newArrayList();
        Set<String> userCodesSet = Sets.newHashSet();

        if (StringUtils.isNotBlank(userCodes)) {// 关联的用户code

            String[] userCodesArr = StringUtils.split(userCodes, ",");

            userCodesSet.addAll(Arrays.asList(userCodesArr));
        }

        if (StringUtils.isNotBlank(deptIds)) {
            Set<String> userCodesByDeptPk =
                    jobService.listUserCodeByDeptPks(Arrays.asList(StringUtils.split(deptIds, ",")));
            userCodesSet.addAll(userCodesByDeptPk);
        }

        if (userCodesSet.size() > 0 && userRoleOri != null) {
            try {
                for (String userCode : userCodesSet) {
                    UserRole userRole = (UserRole) BeanUtils.cloneBean(userRoleOri);
                    userRole.setUserCode(userCode);
                    userRole.setAuthUserId(LoginUtils.getLoginId());
                    userRole.setAuthUserName(LoginUtils.getLoginName());
                    userRole.setAuthTime(new Date());

                    userRoles.add(userRole);
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                result.setSuccess(false);
                result.setMessage(e.getMessage());
                return result.getResultPojo();
            }

            userRoleService.saveUsersOfRole(userRoleOri.getRoleId(), userRoles);
            result.setSuccess(true);
        }

        return result.getResultPojo();
    }

    @RequestMapping(value = "/users/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultPojo deleteUsersOfRole(@RequestParam("roleId") Integer roleId,
                                        @RequestParam("userCodes") String userCodesStr) {

        List<String> userCodes = Arrays.asList(StringUtils.split(userCodesStr, ","));

        int deleted = userRoleService.deleteUserRoles(roleId, userCodes);

        Result<Integer> result = Result.newResult(true);
        result.addDefaultModel(deleted);
        return result.getResultPojo();
    }

    @Override
    protected String getDefaultOrderBy() {
        return "parent_ids asc, weight asc";
    }
}

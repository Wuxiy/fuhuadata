package com.fuhuadata.web.springmvc.mybatis;

import com.fuhuadata.domain.mybatis.Role;
import com.fuhuadata.domain.mybatis.UserRole;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.UserRoleService;
import com.fuhuadata.service.mybatis.UserService;
import com.fuhuadata.web.util.SystemLogAnnotation;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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

    @Autowired
    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

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
    public ResultPojo saveUsersOfRole(UserRole userRoleOri, @RequestParam("userIds") String userIds,
                                      @RequestParam(value = "deptIds", required = false) String deptIds) {
        Result<Boolean> result = Result.newResult(false);
        List<UserRole> userRoles = Lists.newArrayList();
        Set<Integer> userIdsSet = Sets.newHashSet();

        if (StringUtils.isNotBlank(userIds)) {

            String[] userIdsArr = StringUtils.split(userIds, ",");
            List<Integer> userIdsIter =
                    Lists.transform(Arrays.asList(userIdsArr), new Function<String, Integer>() {
                        @Override
                        public Integer apply(String input) {
                            return Integer.valueOf(input);
                        }
                    });

            userIdsSet.addAll(userIdsIter);
        }

        if (StringUtils.isNotBlank(deptIds)) {
            List<Integer> userIdsOfDept =
                    userService.listUserIdsByDeptIds(Arrays.asList(StringUtils.split(deptIds, ",")));
            userIdsSet.addAll(userIdsOfDept);
        }

        if (userIdsSet.size() > 0 && userRoleOri != null) {
            try {
                for (Integer userId : userIdsSet) {
                    UserRole userRole = (UserRole) BeanUtils.cloneBean(userRoleOri);
                    userRole.setUserId(userId);

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

    @PostMapping("/users/delete")
    @ResponseBody
    public ResultPojo deleteUsersOfRole(@RequestParam("roleId") Integer roleId,
                                        @RequestParam("userIds") String userIdsStr) {

        List<Integer> userIds = Lists.transform(Arrays.asList(StringUtils.split(userIdsStr, ",")),
                new Function<String, Integer>() {
                    @Override
                    public Integer apply(String input) {
                        return Integer.valueOf(input);
                    }
                });

        int deleted = userRoleService.deleteUserRoles(roleId, userIds);

        Result<Integer> result = Result.newResult(true);
        result.addDefaultModel(deleted);
        return result.getResultPojo();
    }

    @Override
    protected String getDefaultOrderBy() {
        return "parent_ids asc, weight asc";
    }
}

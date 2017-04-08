package com.fuhuadata.web.springmvc.mybatis;

import com.fuhuadata.domain.mybatis.Role;
import com.fuhuadata.domain.mybatis.UserRole;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.UserRoleService;
import com.fuhuadata.web.util.SystemLogAnnotation;
import com.google.common.collect.Lists;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 3/28/2017
 */
@RequestMapping("/sys/role")
@Controller
public class RoleController extends BaseTreeableController<Role, Integer> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    protected UserRoleService userRoleService;

    @Autowired
    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @RequestMapping(value = {"", "init"}, method = RequestMethod.GET)
    public String mian() {
        return "system/systemRole";
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

    @RequestMapping(value = "users", method = RequestMethod.POST)
    @ResponseBody
    @SystemLogAnnotation(module = "sys-role", methods = "saveUsersOfRole")
    public ResultPojo saveUsersOfRole(UserRole userRoleOri, @RequestParam("userIds") String userIds) {
        Result<Boolean> result = Result.newResult(false);

        if (StringUtils.isNotBlank(userIds) && userRoleOri != null) {
            List<UserRole> userRoles = Lists.newArrayList();

            String[] userIdsArr = StringUtils.split(userIds, ",");
            for (String userIdStr : userIdsArr) {
                try {
                    UserRole userRole = (UserRole) BeanUtils.cloneBean(userRoleOri);
                    Integer userId = Integer.valueOf(userIdStr);
                    userRole.setUserId(userId);

                    userRoles.add(userRole);
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                    result.setSuccess(false);
                    result.setMessage(e.getMessage());
                    return result.getResultPojo();
                }
            }

            userRoleService.saveUsersOfRole(userRoleOri.getRoleId(), userRoles);
            result.setSuccess(true);
        }

        return result.getResultPojo();
    }

    @Override
    protected String getDefaultOrderBy() {
        return "parent_ids asc, weight asc";
    }
}

package com.fuhuadata.web.springmvc.mybatis;

import com.fuhuadata.domain.mybatis.UserAccount;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.DeptService;
import com.fuhuadata.service.mybatis.UserService;
import com.fuhuadata.vo.MixNodeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 用户
 * <p>User: wangjie
 * <p>Date: 4/12/2017
 */
@RequestMapping("/sys/user")
@Controller
public class UserController extends BaseController<UserAccount, Integer> {

    private UserService userService;

    private DeptService deptService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setDeptService(DeptService deptService) {
        this.deptService = deptService;
    }

    @RequestMapping(value = "/org/tree", method = RequestMethod.GET)
    @ResponseBody
    public ResultPojo orgAndDeptTree() {
        Result<List<MixNodeVO>> result = Result.newResult(false);

        result.addDefaultModel(deptService.getOrgDeptTree());
        result.setSuccess(true);

        return result.getResultPojo();
    }

    @RequestMapping(value = "/dept/users", method = RequestMethod.GET)
    @ResponseBody
    public List<MixNodeVO> getUserTreeByDept(@RequestParam("pid") String deptId) {
        return userService.listUserNodesByDept(deptId);
    }

    @RequestMapping(value = "/dept/users/pojo", method = RequestMethod.GET)
    @ResponseBody
    public ResultPojo getUserTreeByDeptId(@RequestParam("pid") String deptId) {
        Result<List<MixNodeVO>> result = Result.newResult(false);

        result.addDefaultModel(userService.listUserNodesByDept(deptId));
        result.setSuccess(true);
        return result.getResultPojo();
    }

    @RequestMapping(value = "/role/depts/tree", method = RequestMethod.GET)
    @ResponseBody
    public ResultPojo getRoleTree(@RequestParam("roleId") Integer roleId) {
        Result<List<MixNodeVO>> result = Result.newResult(false);

        result.addDefaultModel(userService.getUserTreeByRoleId(roleId));

        return result.getResultPojo();
    }
}

package com.fuhuadata.web.springmvc.mybatis;

import com.fuhuadata.domain.mybatis.UserAccount;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.DeptService;
import com.fuhuadata.service.mybatis.UserService;
import com.fuhuadata.vo.MixNodeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/dept/users")
    @ResponseBody
    public List<MixNodeVO> getUserTreeByDept(@RequestParam("pid") String deptId) {
        return userService.listUserNodesByDept(deptId);
    }

    @RequestMapping(value = "/dept/users/pojo", method = RequestMethod.GET, params = "pid")
    @ResponseBody
    public ResultPojo getUserTreeByDeptId(@RequestParam("pid") String deptId) {
        Result<List<MixNodeVO>> result = Result.newResult(false);

        result.addDefaultModel(userService.listUserNodesByDept(deptId));
        result.setSuccess(true);
        return result.getResultPojo();
    }

    @RequestMapping(value = "/dept/users/pojo", method = RequestMethod.GET, params = "code")
    @ResponseBody
    public ResultPojo getUserTreeByDeptCode(@RequestParam("code") String code) {
        Result<List<MixNodeVO>> result = Result.newResult(false);

        result.addDefaultModel(userService.getUserNodesByDeptCode(code));
        result.setSuccess(true);
        return result.getResultPojo();
    }

    /**
     * 根据角色id获取已授权组织部门用户树
     * @param roleId
     * @return
     */
    @RequestMapping(value = "/role/depts/tree", method = RequestMethod.GET)
    @ResponseBody
    public ResultPojo getRoleTree(@RequestParam("roleId") Integer roleId) {
        Result<List<MixNodeVO>> result = Result.newResult(false);

        result.addDefaultModel(userService.getUserTreeByRoleId(roleId));

        return result.getResultPojo();
    }

    @RequestMapping(value = "/username/{code}", method = RequestMethod.GET)
    @ResponseBody
    public UserAccount getUserByUsername(@PathVariable String code) {

        return userService.getUserByLoginName(code);
    }
}

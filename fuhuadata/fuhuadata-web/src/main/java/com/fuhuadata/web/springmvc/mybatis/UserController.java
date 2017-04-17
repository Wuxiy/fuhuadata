package com.fuhuadata.web.springmvc.mybatis;

import com.fuhuadata.domain.mybatis.UserAccount;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.DeptService;
import com.fuhuadata.service.mybatis.UserService;
import com.fuhuadata.vo.MixNodeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
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

    @GetMapping("/org/tree")
    @ResponseBody
    public ResultPojo orgAndDeptTree() {
        Result<List<MixNodeVO>> result = Result.newResult(false);

        result.addDefaultModel(deptService.getOrgDeptTree());
        result.setSuccess(true);

        return result.getResultPojo();
    }

    @GetMapping("/dept/users")
    @ResponseBody
    public List<MixNodeVO> getUserTreeByDept(@RequestParam("pid") String deptId) {
        return userService.listUserNodesByDept(deptId);
    }

    @GetMapping("/role/depts/tree")
    @ResponseBody
    public ResultPojo getRoleTree(@RequestParam("roleId") Integer roleId) {
        Result<List<MixNodeVO>> result = Result.newResult(false);

        result.addDefaultModel(userService.getUserTreeByRoleId(roleId));

        return result.getResultPojo();
    }
}

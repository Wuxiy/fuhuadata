package com.fuhuadata.outworker.web;

import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.homesales.user.domain.Area;
import com.fuhuadata.homesales.user.domain.User;
import com.fuhuadata.homesales.user.service.AreaService;
import com.fuhuadata.homesales.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 7/26/2017
 */
@RequestMapping("/outworker")
@RestController
public class UserApiAction {

    @Autowired
    UserService userService;

    @Resource
    AreaService areaService;

    @RequestMapping(value = "/api/{userId}", method = RequestMethod.GET)
    public ResultPojo getUser(@PathVariable String userId) {

        Result<User> result = Result.newResult(false);

        User user = userService.get(userId);

        if (user == null) {
            result.setSuccess(false);
            result.setMessage("用户不存在");
        } else {
            result.setSuccess(true);
            result.addDefaultModel(user);
        }

        return result.getResultPojo();
    }

    /**
     * 获取下属
     * @return
     */
    @RequestMapping(value = "/user/subordinates")
    public ResultPojo listSubordinates(HttpServletRequest request) {

        Result<List<User>> result = Result.newResult(false);

        String userId = (String) request.getAttribute("userId");
        List<User> subordinates = userService.listSubordinates(userId);

        result.setSuccess(true);
        result.addDefaultModel(subordinates);

        return result.getResultPojo();
    }

    /**
     * 获取管辖地区
     * @return
     */
    @RequestMapping(value = "/user/areas")
    public ResultPojo listAreasOfUser(HttpServletRequest request) {

        Result<List<Area>> result = Result.newResult(false);

        String userId = (String) request.getAttribute("userId");
        List<Area> areas = areaService.listMngAreasByUserId(userId);

        result.setSuccess(true);
        result.addDefaultModel(areas);

        return result.getResultPojo();
    }

    /**
     * 修改密码
     * @param request
     * @param oldPwd
     * @param newPwd
     * @return
     */
    @RequestMapping(value = "/user/password", method = RequestMethod.POST)
    public ResultPojo changePassword(HttpServletRequest request, @RequestParam String oldPwd,
                                     @RequestParam String newPwd) {

        Result<Boolean> result = Result.newResult(false);

        String userId = (String) request.getAttribute("userId");
        userService.changePassword(userId, oldPwd, newPwd);

        result.setSuccess(true);
        result.addDefaultModel(true);

        return result.getResultPojo();
    }
}

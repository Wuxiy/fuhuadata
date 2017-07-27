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
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 7/26/2017
 */
@RequestMapping("/outworker/user")
@RestController
public class UserApiAction {

    @Autowired
    UserService userService;

    @Resource
    AreaService areaService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
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
     * @param userId
     * @return
     */
    @RequestMapping(value = "/subordinates")
    public ResultPojo listSubordinates(@RequestParam String userId) {

        Result<List<User>> result = Result.newResult(false);

        List<User> subordinates = userService.listSubordinates(userId);

        result.setSuccess(true);
        result.addDefaultModel(subordinates);

        return result.getResultPojo();
    }

    /**
     * 获取管辖地区
     * @param userId
     * @return
     */
    @RequestMapping(value = "/areas")
    public ResultPojo listAreasOfUser(@RequestParam String userId) {

        Result<List<Area>> result = Result.newResult(false);

        List<Area> areas = areaService.listMngAreasByUserId(userId);

        result.setSuccess(true);
        result.addDefaultModel(areas);

        return result.getResultPojo();
    }
}

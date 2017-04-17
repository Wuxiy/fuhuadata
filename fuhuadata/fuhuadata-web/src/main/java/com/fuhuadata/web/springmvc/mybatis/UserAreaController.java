package com.fuhuadata.web.springmvc.mybatis;

import com.fuhuadata.domain.mybatis.UserArea;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.UserAreaService;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 4/5/2017
 */
@RequestMapping("/sys/user/area")
@Controller
public class UserAreaController extends BaseController<UserArea, Integer> {

    private UserAreaService userAreaService;

    @Autowired
    public void setUserAreaService(UserAreaService userAreaService) {
        this.userAreaService = userAreaService;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    @SystemLogAnnotation(module = "sys-user", methods = "saveAreaForUser")
    @ResponseBody
    public ResultPojo saveAreasForUser(@RequestParam("userId") Integer userId,
                                       @RequestParam("areaIds") String areaIdsStr) {
        List<String> areaIds = Arrays.asList(StringUtils.split(areaIdsStr, ","));
        int count = userAreaService.saveUserArea(userId, areaIds);

        Result<Integer> result = Result.newResult(true);
        result.addDefaultModel(count);
        return result.getResultPojo();
    }
}

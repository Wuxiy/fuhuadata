package com.fuhuadata.web.springmvc.mybatis;

import com.fuhuadata.domain.mybatis.AreaCl;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.AreaClService;
import com.fuhuadata.vo.AreaClVo;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 4/25/2017
 */
@RequestMapping("/sys/area")
@Controller
public class AreaClController extends BaseController<AreaCl, String> {

    private AreaClService areaClService;

    @Autowired
    public void setAreaClService(AreaClService areaClService) {
        this.areaClService = areaClService;
    }

    /**
     * 获取所有国外、其他地区
     * @return
     */
    @RequestMapping(value = "foreign", method = RequestMethod.GET)
    @ResponseBody
    public ResultPojo getAllForeignAreaTreeNodes(){
        Result<List<AreaClVo>> result = Result.newResult(false);

        result.addDefaultModel(areaClService.getAreaTreeNodes());
        result.setSuccess(true);
        return result.getResultPojo();
    }

    /**
     * 获取用户地区树
     * @param userId
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    @SystemLogAnnotation(module = "sys-area", methods = "getAreaNodeByUserId")
    public ResultPojo getAreaCodeNodesArrayOfUser(@RequestParam("userId") Integer userId) {
        Result<List<AreaClVo>> result = Result.newResult(false);

        result.addDefaultModel(areaClService.getAreaTreeByUserId(userId));
        result.setSuccess(true);
        return result.getResultPojo();
    }
}

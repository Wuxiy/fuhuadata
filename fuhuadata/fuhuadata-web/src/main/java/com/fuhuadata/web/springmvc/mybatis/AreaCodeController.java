package com.fuhuadata.web.springmvc.mybatis;

import com.fuhuadata.domain.mybatis.AreaCode;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.AreaCodeService;
import com.fuhuadata.vo.MixNodeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 国家
 * <p>User: wangjie
 * <p>Date: 4/14/2017
 */
@RequestMapping("/sys/area/code")
@Controller
public class AreaCodeController extends BaseController<AreaCode, String> {

    private AreaCodeService areaCodeService;

    @Autowired
    public void setAreaCodeService(AreaCodeService areaCodeService) {
        this.areaCodeService = areaCodeService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public ResultPojo getAreaCodeNodesArrayOfUser(@RequestParam("userId") Integer userId) {
        Result<List<MixNodeVO>> result = Result.newResult(false);

        result.addDefaultModel(areaCodeService.getAreaTreeArraysByUserId(userId));
        result.setSuccess(true);
        return result.getResultPojo();
    }
}

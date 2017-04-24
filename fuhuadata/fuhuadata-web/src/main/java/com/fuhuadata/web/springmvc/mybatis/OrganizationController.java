package com.fuhuadata.web.springmvc.mybatis;

import com.fuhuadata.domain.mybatis.Organization;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.OrganizationService;
import com.fuhuadata.vo.OrganizationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 4/11/2017
 */
@Controller
@RequestMapping("/sys/org")
public class OrganizationController extends BaseController<Organization, Integer> {

    @Autowired
    OrganizationService organizationService;

    @RequestMapping("/trees")
    @ResponseBody
    public ResultPojo orgTree() {
        Result<List<OrganizationVO>> result = Result.newResult(false);

        result.addDefaultModel(organizationService.listOrgTree());
        result.setSuccess(true);

        return result.getResultPojo();
    }
}

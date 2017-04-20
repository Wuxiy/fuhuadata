package com.fuhuadata.web.springmvc.mybatis;

import com.fuhuadata.domain.mybatis.Dept;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.DeptService;
import com.fuhuadata.vo.MixNodeVO;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 部门
 * <p>User: wangjie
 * <p>Date: 4/20/2017
 */
@RequestMapping("/sys/dept")
@Controller
public class DeptController extends BaseController<Dept, Integer> {

    private DeptService deptService;

    @Autowired
    public void setDeptService(DeptService deptService) {
        this.deptService = deptService;
    }

    @RequestMapping("/tree/org")
    @ResponseBody
    @SystemLogAnnotation(module = "sys_dept", methods = "getDeptTreeByOrgId")
    public ResultPojo getDeptTreeByOrgId(@RequestParam("orgId") Integer orgId) {
        Result<List<MixNodeVO>> result = Result.newResult(false);

        if (null == orgId) {
            result.setMessage("请求参数 orgId 不能为空");
        }

        result.addDefaultModel(deptService.getDeptTree(orgId));
        result.setSuccess(true);
        return result.getResultPojo();
    }
}

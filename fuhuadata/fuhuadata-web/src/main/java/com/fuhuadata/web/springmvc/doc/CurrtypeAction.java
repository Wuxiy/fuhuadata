package com.fuhuadata.web.springmvc.doc;

import com.fuhuadata.domain.mybatis.Currtype;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.CurrtypeService;
import com.fuhuadata.web.springmvc.mybatis.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 6/2/2017
 */
@RequestMapping("/doc/currtypes")
@Controller
public class CurrtypeAction extends BaseController<Currtype, String> {

    private CurrtypeService currtypeService;

    @Resource
    public void setCurrtypeService(CurrtypeService currtypeService) {
        this.currtypeService = currtypeService;
    }

    /**
     * 获取币种档案
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ResultPojo getAll() {

        Result<List<Currtype>> result = Result.newResult(false);

        List<Currtype> currtypes = currtypeService.list();
        result.addDefaultModel(currtypes);
        result.setSuccess(true);

        return result.getResultPojo();
    }
}

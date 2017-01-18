package com.fuhuadata.web.springmvc;

/**
 * 产品问题action
 * Created by wuxi on 2017/1/16.
 */

import com.fuhuadata.domain.ProductProblem;
import com.fuhuadata.service.ProductProblemService;
import freemarker.template.TemplateModelAdapter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/productProblem/*")
public class ProductProblemAction {
    private final static Log log = LogFactory.getLog(ProductProblemAction.class);
    @Resource
    private ProductProblemService productProblemService;
    private Integer pageSize = 10 ;
    private String page = "1";

    /**
     * 产品问题列表
     * @return
     */
    @SuppressWarnings("unused")
    @RequestMapping(value = "/productProblemList",method = RequestMethod.GET)
    public ModelAndView productProblemList(){

        ModelAndView model = new ModelAndView();
        return model;

    }

}

package com.fuhuadata.web.springmvc;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fuhuadata.domain.UserAccount;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.domain.query.UserAccountQuery;
import com.fuhuadata.service.UserAccountService;

@Controller

/**
 * Created by young on 2017/1/17.
 */
@RequestMapping("/knowledgeBase/*")
public class KnowledgeBaseAction {
    /**
     * 展会动态列表
     * @return
     */
    @RequestMapping(value="/exhibitionDynamicList",method=RequestMethod.GET)
    public ModelAndView exhibitionDynamicList(){return new ModelAndView("knowledgeBase/exhibitionDynamicList");}
}

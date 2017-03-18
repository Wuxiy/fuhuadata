package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.RecordLinkman;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.RecordLinkmanService;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 拜访记录关联人员
 * Created by intanswer on 2017/3/17.
 */
@Controller
@RequestMapping("/recordLinkman/*")
public class RecordLinkmanAction {
    private final static Log log = LogFactory.getLog(RecordLinkmanAction.class);
    @Autowired
    private RecordLinkmanService recordLinkmanService;


    @RequestMapping(value = "getRecordLinkmanByLinkmanId",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "customerInfo-recordLinkman",methods = "getRecordLinkmanByLinkmanId")
    @ResponseBody
    public ResultPojo getRecordLinkmanByLinkmanId(String LinkmanId){
        try{
            Result<List<RecordLinkman>> result = recordLinkmanService.getRecordLinkmanByLinkmanId(LinkmanId);
            return result.getResultPojo();
        }catch (Exception e){
            log.error("根据联系人id获取沟通记录出错",e);
        }
        return null;
    }

}

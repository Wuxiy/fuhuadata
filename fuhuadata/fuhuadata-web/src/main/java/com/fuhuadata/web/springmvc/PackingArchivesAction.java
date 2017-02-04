package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.PackingArchives;
import com.fuhuadata.domain.query.PackingArchivesQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.service.PackingArchivesService;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 包材档案action
 * Created by intanswer on 2017/1/24.
 */
@Controller
@RequestMapping("/packingArchives/*")
public class PackingArchivesAction {
    private final static Log log= LogFactory.getLog(PackingArchivesAction.class);
    @Resource
    private PackingArchivesService packingArchivesService;
    private Integer pageSize = 10;
    private String page="1";
    @SuppressWarnings("unused")
    @RequestMapping(value = "/packingArchivesList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-包材档案",methods = "档案列表")
    public ModelAndView packingArchivesList(){
        Result<List<PackingArchives>> result = new Result<List<PackingArchives>>();
        try{
            PackingArchivesQuery query = new PackingArchivesQuery();
            query.setPageSize(pageSize);
            try{
                query.setIndex(Integer.valueOf(page.trim()));
            }catch(Exception e){
                query.setIndex(1);
            }
            result=packingArchivesService.getPackingArchivesByPage(query);
        }catch(Exception e){
            log.error("获取包材档案列表错误");
        }
        ModelAndView model= new ModelAndView("knowledgeBase/packingArchivesList","packingArchivesList",result.getModel());
        model.addObject("message","包材档案列表");
        return model;
    }

}

package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.PackingArchives;
import com.fuhuadata.domain.query.PackingArchivesQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.PackingArchivesService;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 包材成本档案action
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

    @RequestMapping(value = "/packingArchivesList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-packingCost",methods = "into")
    public ModelAndView packingArchives(){
        return new ModelAndView("knowledgeBase/packingCostList");
    }

    @RequestMapping(value = "/queryPackingArchivesList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase/packingCostList",methods = "list")
    @ResponseBody
    public ResultPojo packingArchivesList(){
        Result<List<PackingArchives>> result = new Result<List<PackingArchives>>();
        PackingArchivesQuery query = new PackingArchivesQuery();
        try{
            result=packingArchivesService.getPackingArchivesByQuery(query);
        }catch(Exception e){
            log.error("获取包材成本档案列表错误");
        }
        return result.getResultPojo();
    }

    @RequestMapping(value = "/addPackingArchives",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase/packingCostList",methods = "add")
    public ModelAndView addPackingArchives(){return new ModelAndView("knowledgeBase/addPackingArchives");}

    @RequestMapping(value = "/doAddPackingArchives",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase/packingCostList",methods = "doAdd")
    @ResponseBody
    public ResultPojo doAddPackingArchives(@RequestBody PackingArchives packingArchives){
        try{
            Result<PackingArchives> result=packingArchivesService.addPackingArchives(packingArchives);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("添加包材成本档案失败");
        }
        return null;
    }

    /**
     * 条件查询
     * @param packingArchivesQuery
     * @return
     */
    @RequestMapping(value = "/queryPackingArchivesListTest",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase/packingCostList",methods = "query")
    public ModelAndView queryPackingArchivesList(@RequestBody PackingArchivesQuery packingArchivesQuery){
        Result<List<PackingArchives>> result = new Result<List<PackingArchives>>();
        try{
            packingArchivesQuery.setPageSize(pageSize);
            if(packingArchivesQuery.getIndex()==0){
                packingArchivesQuery.setIndex(Integer.valueOf(page.trim()));
            }
            result=packingArchivesService.getPackingArchivesByPage(packingArchivesQuery);
        }catch(Exception e){
            log.error("查询包材成本档案失败",e);
        }
        ModelAndView model = new ModelAndView("knowledgeBase/packingArchivesList","packingArchivesList",result.getModel());
        model.addObject("message","包材成本档案列表");
        return model;
    }
    @RequestMapping(value="/getPackingArchivesById")
    @SystemLogAnnotation(module = "knowledgeBase/packingArchivesList",methods = "getInfoById")
    @ResponseBody
    public PackingArchives getPackingArchivesById(int id){
        try{
            Result<PackingArchives> result = packingArchivesService.getPackingArchivesById(id);
            return result.getModel();
        }catch(Exception e){
            log.error("获取成本档案信息错误",e);
        }
        return null;
    }

}

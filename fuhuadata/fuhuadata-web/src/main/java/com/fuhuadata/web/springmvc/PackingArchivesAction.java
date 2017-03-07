package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.PackingArchives;
import com.fuhuadata.domain.query.PackingArchivesQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.PackingArchivesService;
import com.fuhuadata.vo.PackingArchivesVO;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xpath.operations.Mod;
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

    /**
     * list
     * @return
     */
    @RequestMapping(value = "/packingArchivesList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-packingCost",methods = "into")
    public ModelAndView packingArchives(){
        return new ModelAndView("knowledgeBase/packingCostList");
    }

    @RequestMapping(value = "/queryPackingArchivesList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-packingCost",methods = "list")
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

    /**
     * add
     * @return
     */
    @RequestMapping(value = "/addPackingArchives",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-packingCost",methods = "add")
    public ModelAndView addPackingArchives(){return new ModelAndView("knowledgeBase/packingCostAdd");}

    @RequestMapping(value = "/doAddPackingArchives",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-packingCost",methods = "doAdd")
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
     * delete
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-packingCost",methods = "delete")
    @ResponseBody
    public ResultPojo delete(int id){
        try{
            Result result = packingArchivesService.deletePackingArchivesById(id);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("根据id删除包材成本档案错误",e);
        }
        return null;
    }

    /**
     * update
     * @param packingArchives
     * @return
     */
    @RequestMapping(value = "/doModify",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-packingCost",methods = "doUpdate")
    @ResponseBody
    public ResultPojo doModify(@RequestBody PackingArchives packingArchives){
        try{
            int id = packingArchives.getPackingId();
            Result<PackingArchives> result = packingArchivesService.updatePackingArchivesById(id,packingArchives);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("修改包材成本档案错误",e);
        }
        return null;
    }

    /**
     * 条件查询
     * @param packingArchivesQuery
     * @return
     */
    @SuppressWarnings("unused")
    @RequestMapping(value = "/queryPackingArchivesListTest",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-packingCost",methods = "query")
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

    /**
     * 根据id获取详情
     * @param id
     * @return
     */
    @RequestMapping(value="/getPackingArchivesById",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-packingArchives",methods = "GET-BY-ID")
    @ResponseBody
    public ResultPojo getPackingArchivesById(Integer id){
        try{
            Result<PackingArchivesVO> result = packingArchivesService.getPackingArchivesById(id);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("根据id获取包材成本档案信息错误",e);
        }
        return null;
    }

    /**
     * 根据PId获取目录包材
     * @param id
     * @return
     */
    @RequestMapping(value="/getPackingArchivesByPId")
    @SystemLogAnnotation(module = "knowledgeBase-packingArchives",methods = "GET-BY-PID")
    @ResponseBody
    public ResultPojo getPackingArchivesByPId(Integer id){
        try{
            Result<List<PackingArchives>> result = packingArchivesService.getPackingArchivesByPId(id);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("根据PId获取包材成本档案信息错误",e);
        }
        return null;
    }

}

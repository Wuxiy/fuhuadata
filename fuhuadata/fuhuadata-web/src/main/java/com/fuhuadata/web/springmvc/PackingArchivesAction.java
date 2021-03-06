package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.PackingArchives;
import com.fuhuadata.domain.PackingRelation;
import com.fuhuadata.domain.query.PackingArchivesQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.BCodeService;
import com.fuhuadata.service.PackingArchivesService;
import com.fuhuadata.vo.PackingArchivesVO;
import com.fuhuadata.vo.RelationPackingArchives;
import com.fuhuadata.web.exception.InvalidRequestException;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 包材成本档案action
 * Created by intanswer on 2017/1/24.
 */
@Controller
@RequestMapping("/packingArchives/*")
public class PackingArchivesAction {
    private final static Log log = LogFactory.getLog(PackingArchivesAction.class);
    @Resource
    private PackingArchivesService packingArchivesService;

    @Autowired
    private BCodeService bCodeService;
    private Integer pageSize = 10;
    private String page = "1";

    /**
     * list
     *
     * @return
     */
    @RequiresPermissions({"wiki:mate:view"})
    @RequestMapping(value = "/packingArchivesList", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-packingCost", methods = "into")
    public ModelAndView packingArchives() {
        return new ModelAndView("knowledgeBase/packingCostList");
    }

    @RequestMapping(value = "/queryPackingArchivesList", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-packingCost", methods = "list")
    @ResponseBody
    public ResultPojo packingArchivesList() {
        Result<List<PackingArchives>> result = new Result<List<PackingArchives>>();
        PackingArchivesQuery query = new PackingArchivesQuery();
        try {
            result = packingArchivesService.getPackingArchivesByQuery(query);
        } catch (Exception e) {
            log.error("获取包材成本档案列表错误");
        }
        return result.getResultPojo();
    }

    /**
     * add
     * @return
     */
    @RequestMapping(value = "/addPackingArchives", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-packingCost", methods = "add")
    public ModelAndView addPackingArchives(String name, int bid, int sid) {
        PackingArchives packingArchives = new PackingArchives();
        packingArchives.setBigCategoryId(bid);
        packingArchives.setSmallCategoryId(sid);
        packingArchives.setPackName(name);
        int packId = Integer.valueOf(bCodeService.genNextPackagingMaterialCode(packingArchives));
        return new ModelAndView("knowledgeBase/packingCostAdd").addObject("packId", packId).addObject("bid", bid).addObject("sid", sid).addObject("name", name);
    }

    /**
     * do add
     *
     * @param packingArchives
     * @return
     */
    @RequestMapping(value = "/doAddPackingArchives", method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-packingCost", methods = "doAdd")
    @ResponseBody
    public ResultPojo doAddPackingArchives(@RequestBody @Valid PackingArchives packingArchives, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            throw new InvalidRequestException("请求参数错误",bindingResult);
        }
        try {
            // 转化规格为大写
            packingArchives.setSpec(packingArchives.getSpec().toUpperCase());
            Result<PackingArchives> result = packingArchivesService.addPackingArchives(packingArchives);
            return result.getResultPojo();
        } catch (Exception e) {
            log.error("添加包材成本档案失败");
        }
        return null;
    }

    /**
     * delete
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-packingCost", methods = "delete")
    @ResponseBody
    public ResultPojo delete(int id) {
        try {
            Result result = packingArchivesService.deletePackingArchivesById(id);
            return result.getResultPojo();
        } catch (Exception e) {
            log.error("根据id删除包材成本档案错误", e);
        }
        return null;
    }

    /**
     * update
     *
     * @param packingArchives
     * @return
     */
    @RequestMapping(value = "/doModify", method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-packingCost", methods = "doUpdate")
    @ResponseBody
    public ResultPojo doModify(@RequestBody @Valid PackingArchives packingArchives,BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            throw new InvalidRequestException("请求参数错误",bindingResult);
        }
        try {
            int id = packingArchives.getPackingId();
            Result<PackingArchives> result = packingArchivesService.updatePackingArchivesById(id, packingArchives);
            return result.getResultPojo();
        } catch (Exception e) {
            log.error("修改包材成本档案错误", e);
        }
        return null;
    }

    /**
     * add relate
     */
  /*  @RequestMapping(value = "/addRelation", method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-packingCost", methods = "addRelation")
    @ResponseBody
    public ResultPojo addRelation(int id, @RequestBody String[] ids) {
        Result result = new Result();
        try {
            PackingArchives packingArchives = new PackingArchives();
            String idsstr = packingArchivesService.getPackingArchivesById(id).getModel().getPack().getAssociatedPackingId();
            String[] ids1 = null;
            if(idsstr!=null&&idsstr.length()>0){
                ids1 = idsstr.split(",");
                String[] idsArray = StringUtil.union(ids1, ids);//取并集
                String str = StringUtils.join(idsArray, ",");
                packingArchives.setAssociatedPackingId(str);
                result = packingArchivesService.updatePackingArchivesById(id, packingArchives);
                return result.getResultPojo();
            }else{
                String str = StringUtils.join(ids,",");
                packingArchives.setAssociatedPackingId(str);
                result= packingArchivesService.updatePackingArchivesById(id,packingArchives);
                return result.getResultPojo();
            }

        } catch (Exception e) {
            log.error("更新主材关联失败", e);
        }
        return null;
    }
*/

    /**
     * add relate
     */
    @RequestMapping(value = "/addRelation", method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-packingCost", methods = "addRelation")
    @ResponseBody
    public ResultPojo addRelation(@RequestBody @Valid List<PackingRelation> packingRelations,BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            throw new InvalidRequestException("请求参数错误",bindingResult);
        }
        Result result = new Result();
        int mainPackingId=0;
        if(packingRelations!=null&&packingRelations.size()>0) {
            for (PackingRelation packingRelation : packingRelations) {
                //互斥字段，默认为IsEqualOuter=1
                mainPackingId = packingRelation.getMainPackingId();
                if (packingRelation.getConsumption() != null && packingRelation.getIsEqualOuter() == 1) {
                    packingRelation.setConsumption(null);
                }
            }
        }
        try{
            result = packingArchivesService.batchAddRelationPacking(mainPackingId,packingRelations);
            result.setMessage("新增关联成功");
        }catch (Exception e){
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    /**
     * GET BY IDS
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "getByIds", method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-packingCost", methods = "GET-BY-IDS")
    @ResponseBody
    public ResultPojo getByIds(@RequestBody String[] ids) {
        Result<List<PackingArchives>> result = new Result<List<PackingArchives>>();
        try {
            result = packingArchivesService.getPakcingArchivesByIds(ids);
        } catch (Exception e) {
            log.error("根据ids获取包材档案错误", e);
        }
        return result.getResultPojo();
    }


    /**
     * delete relate
     */
  /*  @RequestMapping(value = "/deleteRelation", method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-packingCost", methods = "deleteRelation")
    @ResponseBody
    public ResultPojo deleteRelation(int id, @RequestBody String[] ids) {
        Result result = new Result();
        try {
            PackingArchives packingArchives = new PackingArchives();
            String[] ids1 = packingArchivesService.getPackingArchivesById(id).getModel().getPack().getAssociatedPackingId().split(",");
            String[] idsArray = StringUtil.minus(ids1, ids);//取差集
            String str = StringUtils.join(idsArray, ",");
            packingArchives.setAssociatedPackingId(str);
            result = packingArchivesService.updatePackingArchivesById(id, packingArchives);
            return result.getResultPojo();
        } catch (Exception e) {
            log.error("更新主材关联失败", e);
        }
        return null;
    }*/

    /**
     *  删除关联
     * @param ids
     * @param ids
     * @return
     */
    @RequestMapping(value = "/deleteRelation", method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-packingCost", methods = "deleteRelation")
    @ResponseBody
    public ResultPojo deleteRelation(String ids) {
        Result result = new Result();
        try {
            if(ids!=null) {
                result = packingArchivesService.deleteRelationPackingByIds(ids);
            }
            return result.getResultPojo();
        } catch (Exception e) {
            log.error("删除关联包材错误", e);
        }
        return null;
    }

    /**
     * 条件查询
     * @param packingArchivesQuery
     * @return
     */
    @SuppressWarnings("unused")
    @RequestMapping(value = "/queryPackingArchivesListTest", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-packingCost", methods = "query")
    public ModelAndView queryPackingArchivesList(@RequestBody PackingArchivesQuery packingArchivesQuery) {
        Result<List<PackingArchives>> result = new Result<List<PackingArchives>>();
        try {
            packingArchivesQuery.setPageSize(pageSize);
            if (packingArchivesQuery.getIndex() == 0) {
                packingArchivesQuery.setIndex(Integer.valueOf(page.trim()));
            }
            result = packingArchivesService.getPackingArchivesByPage(packingArchivesQuery);
        } catch (Exception e) {
            log.error("查询包材成本档案失败", e);
        }
        ModelAndView model = new ModelAndView("knowledgeBase/packingArchivesList", "packingArchivesList", result.getModel());
        model.addObject("message", "包材成本档案列表");
        return model;
    }


    /**
     * 进入详情页
     * @return
     */
    @RequiresPermissions({"wiki:mate:base:view"})
    @RequestMapping(value = "/getDetails", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-packingArchives", methods = "details")
    public ModelAndView getDetails(int id, int bid, int sid) {
        return new ModelAndView("knowledgeBase/packingCostInfo").addObject("id", id).addObject("sid", sid).addObject("bid", bid);
    }

    /**
     * 根据id获取详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/getPackingArchivesById", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-packingArchives", methods = "GET-BY-ID")
    @ResponseBody
    public ResultPojo getPackingArchivesById(Integer id) {
        try {
            Result<PackingArchivesVO> result = packingArchivesService.getPackingArchivesById(id);
            return result.getResultPojo();
        } catch (Exception e) {
            log.error("根据id获取包材成本档案信息错误", e);
        }
        return null;
    }


    /**
     * 根据PId获取目录包材
     * @param id
     * @return
     */
    @RequestMapping(value = "/getPackingArchivesByPId")
    @SystemLogAnnotation(module = "knowledgeBase-packingArchives", methods = "GET-BY-PID")
    @ResponseBody
    public ResultPojo getPackingArchivesByPId(Integer id) {
        try {
            Result<List<PackingArchives>> result = packingArchivesService.getPackingArchivesByPId(id);
            return result.getResultPojo();
        } catch (Exception e) {
            log.error("根据PId获取包材成本档案信息错误", e);
        }
        return null;
    }

    @RequestMapping(value = "/getRelationPackingByPackId",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-packingArchives", methods = "getRelationPackingByPackId")
    @ResponseBody
    public ResultPojo getRelationPackingByPackId(Integer packId) {

        try {
            Result<List<RelationPackingArchives>> result = packingArchivesService.getRelationPackingByPackId(packId);
            return result.getResultPojo();
        } catch (Exception e) {
            log.error("根据主材id获取关联包材全部列表错误", e);
        }
        return null;
    }

    /**
     * 判断订单产品包装表有无此包材此型号图片)
     * @param
     * @return
     */
    @RequestMapping(value = "/judgeImageModelToUse")
    @SystemLogAnnotation(module = "knowledgeBase-packingArchives", methods = "judgeImageModelToUse")
    @ResponseBody
    public ResultPojo judgeImageModelToUse(int packId,String name) {
        try {
            Result result = new Result();
            result.addDefaultModel("useTotal", 0);
            //
            result.setCode(1);
            result.setMessage("允许删除，请确认");
            return result.getResultPojo();
        } catch (Exception e) {
            log.error("删除包材图片型号出错", e);
        }
        return null;
    }
}

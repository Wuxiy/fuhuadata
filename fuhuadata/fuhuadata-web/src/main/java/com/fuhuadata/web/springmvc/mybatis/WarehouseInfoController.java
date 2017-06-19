package com.fuhuadata.web.springmvc.mybatis;

import com.fuhuadata.domain.mybatis.supplier.*;
import com.fuhuadata.domain.query.*;
import com.fuhuadata.service.mybatis.supplier.*;
import com.fuhuadata.service.util.LoginUtils;
import com.fuhuadata.vo.Supplier.ScoreInfoVO;
import com.fuhuadata.vo.Supplier.ScoreVO;
import com.fuhuadata.web.util.DateUtil;
import com.fuhuadata.web.util.SystemLogAnnotation;
import com.github.pagehelper.PageInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/** 仓库
 * Created by wuxiy on 2017/5/23.
 */
@Controller
@RequestMapping("/supplier/warehouse/*")
public class WarehouseInfoController extends BaseController<WarehouseInfo,Integer>{

    private final static Log log  = LogFactory.getLog(WarehouseInfoController.class);

    @Autowired
    private WarehouseInfoService warehouseInfoService;

    @Autowired
    private FreightForwardingService freightForwardingService;

    @Autowired
    private WarehouseScoreService warehouseScoreService;

    @Autowired
    private WarehouseEvaluationScoreRelationService warehouseEvaluationScoreRelationService;

    @Autowired
    private ScoreTermService scoreTermService;

    @RequestMapping(value = "/intoWarehouseList", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-warehouse",methods = "intoWarehouseList")
    public String intoWarehouseInfoList() {
        return "supplierInformation/warehouseList";
    }

    /**
     * 进入仓库详情
     * @return
     */
    @RequestMapping(value = "/intoWarehouseBasic", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-warehouse",methods = "intoWarehouseInfo")
    public ModelAndView intoWarehouseBasic(Integer id) {
        return new ModelAndView("supplierInformation/warehouseBasic").addObject("warehouseId",id);
    }
    /**
     * 进入仓库合作货代列表
     * @return
     */
    @RequestMapping(value = "/intoWarehouseOpperation", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-warehouse",methods = "intoWarehouseOpperation")
    public ModelAndView intoWarehouseopperation(int id) {
        return new ModelAndView("supplierInformation/warehouseOpperation").addObject("warehouseId",id);
    }
    /**
     * 进入仓库订单记录
     * @return
     */
    @RequestMapping(value = "/intoWarehouseOrder", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-warehouse",methods = "intoWarehouseOrder")
    public ModelAndView intoWarehouseOrder(int id) {
        return new ModelAndView("supplierInformation/warehouseOrder").addObject("warehouseId",id);
    }
    /**
     * 进入仓库投诉记录
     * @return
     */
    @RequestMapping(value = "/intoWarehouseComplaints", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-warehouse",methods = "intoWarehouseComplaints")
    public ModelAndView intoWarehouseComplaints(int id) {
        return new ModelAndView("supplierInformation/warehouseComplaints").addObject("warehouseId",id);
    }


    /**
     * 仓库列表
     * @return
     */
    @RequestMapping(value = "/warehouseList", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-warehouse",methods = "warehouseList")
    @ResponseBody
    public ResultPojo warehouseList(QueryWarehouseInfo query){
        Result<PageInfo<WarehouseInfo>> result = new Result<>();
        try{
            PageInfo<WarehouseInfo> warehouses  = warehouseInfoService.listWarehouses(query);
            result.addDefaultModel("warehouseList",warehouses);
        }catch(Exception e){
            log.error("分页获取仓库列表出错",e);
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    /**
     * 仓库详情
     * @return
     */
    @RequestMapping(value = "/warehouseInfo", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-warehouse",methods = "warehouseInfo")
    @ResponseBody
    public ResultPojo warehouseList(@RequestParam("id") Integer id){
        Result<WarehouseInfo> result = new Result<>();
        try{
            result.addDefaultModel("warehouseInfo",warehouseInfoService.get(id));
        }catch(Exception e){
            log.error("根据仓库id获取仓库详情",e);
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }
    /**
     * 更新仓库详情
     * @return
     */
    @RequestMapping(value = "/updateWarehouseInfo", method = RequestMethod.POST)
    @SystemLogAnnotation(module = "supplier-warehouse",methods = "updateWarehouseInfo")
    @ResponseBody
    public ResultPojo updateWarehouseInfo(@RequestBody WarehouseInfo warehouseInfo){
        Result<Integer> result = new Result<>();
        try{
            warehouseInfo.setModifiedtime(DateUtil.getDateTime());
            warehouseInfo.setModifier(LoginUtils.getLoginName());
            result.addDefaultModel("warehouseInfo",warehouseInfoService.updateSelective(warehouseInfo));
        }catch(Exception e){
            log.error("更新仓库信息出错",e);
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    /**
     * 仓库关联货代
     * @return
     */
    @RequestMapping(value = "/forwardingList", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-warehouse",methods = "warehouseInfo")
    @ResponseBody
    public ResultPojo forwardingList(QueryFreightforwarding query){
        Result<PageInfo<FreightForwarding>> result = new Result<>();
        try{
            result.addDefaultModel("warehouseInfo",freightForwardingService.getForwardingListByWarehouseId(query));
        }catch(Exception e){
            log.error("获取关联货代列表错误",e);
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    /**
     * 仓库评分项及分值
     */
    @RequestMapping(value = "/evaluationIndexItem", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-warehouse",methods = "evaluationIndexItem")
    @ResponseBody
    public ResultPojo evaluationIndexItem(Integer scoreId){
        Result<ScoreInfoVO<WarehouseEvaluationScoreRelation>> result = new Result<>();
        ScoreInfoVO<WarehouseEvaluationScoreRelation> scoreInfoVO = new ScoreInfoVO<>();
        try{
            scoreInfoVO.setTerms(scoreTermService.evaluationIndexItem(2));
            List<WarehouseEvaluationScoreRelation> scoreList = warehouseEvaluationScoreRelationService.listByScoreId(scoreId);
            if(scoreList!=null&&scoreList.size()>0) {
                scoreInfoVO.setScoreList(scoreList);
            }
            result.addDefaultModel("score",scoreInfoVO);
        }catch(Exception e){
            log.error("获取评分项详情失败",e);
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    /**
     * 保存评分项
     */
    @RequestMapping(value = "/saveScore", method = RequestMethod.POST)
    @SystemLogAnnotation(module = "supplier-warehouse",methods = "saveScore")
    @ResponseBody
    public ResultPojo saveScore(@RequestBody ScoreVO<WarehouseScore,WarehouseEvaluationScoreRelation> scoreVO){
        Result<Integer> result = new Result();
        try{
            result.addDefaultModel(warehouseScoreService.saveScore(scoreVO));
        }catch(Exception e){
            log.error("保存仓库评分出错");
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }

        return result.getResultPojo();
    }

    /**
     * 获取月度评价表
     */
    @RequestMapping(value = "/scoreListOfMonth", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-warehouse",methods = "scoreListOfMonth")
    @ResponseBody
    public ResultPojo ScoreListOfMonth(QueryWarehouseScore query){
        Result<PageInfo<WarehouseScore>> result = new Result();
        try{
            result.addDefaultModel("scoreList",warehouseScoreService.getWarehouseScoreList(query));
        }catch (Exception e){
            log.error("仓库月度评价表获取失败");
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }


}


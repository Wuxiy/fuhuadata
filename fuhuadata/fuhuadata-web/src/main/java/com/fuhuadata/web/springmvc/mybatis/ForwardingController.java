package com.fuhuadata.web.springmvc.mybatis;

import com.fuhuadata.domain.mybatis.supplier.*;
import com.fuhuadata.domain.query.*;
import com.fuhuadata.service.mybatis.supplier.*;
import com.fuhuadata.service.util.LoginUtils;
import com.fuhuadata.vo.Supplier.ScoreInfoVO;
import com.fuhuadata.vo.Supplier.ScoreVO;
import com.fuhuadata.web.util.SystemLogAnnotation;
import com.github.pagehelper.PageInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;


/**
 *    货代物流
 * Created by wuxiy on 2017/5/23.
 */
@Controller
@RequestMapping("/supplier/forwarding/*")
public class ForwardingController extends BaseController<FreightForwarding,Integer> {
    private final static Log log  = LogFactory.getLog(ForwardingController.class);

    @Autowired
    private FreightForwardingService freightForwardingService;

    @Autowired
    private WarehouseInfoService warehouseInfoService;

    @Autowired
    private ForwardingBidRecordService forwardingBidRecordService;

    @Autowired
    private ForwardingOrderRecordService forwardingOrderRecordService;

    @Autowired
    private ForwardingComplaintsRecordService forwardingComplaintsRecordService;

    @Autowired
    private ScoreTermService scoreTermService;

    @Autowired
    private ForwardingScoreService forwardingScoreService;

    @Autowired
    private ForwardingEvaluationScoreRelationService forwardingEvaluationScoreRelationService;


    @RequestMapping(value = "intoForwardingList", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-forwarding",methods = "intoForwardingList")
    public String intForwardingList() {
        return "supplierInformation/forwardingList";
    }

    @RequestMapping(value = "intoForwardingBasic", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-forwarding",methods = "intoForwardingBasic")
    public ModelAndView intoForwardingInfo(int id) {
        return new ModelAndView("supplierInformation/forwardingBasic").addObject("forwardingId",id);
    }
    @RequestMapping(value = "intoForwardingWarehouse", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-forwarding",methods = "init")
    public ModelAndView intoForwardingWarehouse(int id) {
        return new ModelAndView("supplierInformation/forwardingWarehouse").addObject("forwardingId",id);
    }

    @RequestMapping(value = "intoForwardingGradeList", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-forwarding",methods = "intoForwardingGradeList")
    public ModelAndView intoForwardingGradeList(int id) {
        return new ModelAndView("supplierInformation/forwardingGradeList").addObject("forwardingId",id);
    }

    @RequestMapping(value = "intoForwardingGradeDetails", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-forwarding",methods = "init")
    public ModelAndView intoForwardingGradeDetails(int scoreId,int forwardingId){
        return new ModelAndView("supplierInformation/forwardingGradeDetails").addObject("scoreId",scoreId).addObject("forwardingId",forwardingId);
    }

    @RequestMapping(value = "intoForwardingOrder", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-forwarding",methods = "intoForwardingOrder")
    public ModelAndView intoForwardingOrder(int id) {
        return new ModelAndView("supplierInformation/forwardingOrder").addObject("forwardingId",id);
    }
    /**
     * 货代列表
     * @return
     */
    @RequestMapping(value = "/forwardingList", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-forwarding",methods = "forwardingList")
    @ResponseBody
    public ResultPojo forwardingList(QueryFreightforwarding query){
        Result<PageInfo<FreightForwarding>> result = new Result<>();
        try{
            System.out.println(query.getIndex());
            PageInfo<FreightForwarding> forwardings  = freightForwardingService.getForwardingList(query);
            result.addDefaultModel("forwardingList",forwardings);
        }catch(Exception e){
            log.error("分页获取货代列表出错",e);
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    /**
     * 货代详情
     * @return
     */
    @RequestMapping(value = "forwardingInfo", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-forwarding",methods = "forwardingInfo")
    @ResponseBody
    public ResultPojo forwardingList(@RequestParam("id") Integer id){
        Result<FreightForwarding> result = new Result<>();
        try{
            result.addDefaultModel("forwardingInfo",freightForwardingService.getFreightForwardingInfo(id));
        }catch(Exception e){
            log.error("根据id获取货代详情出错",e);
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    /**
     * 更新货代
     * @return
     */
    @RequestMapping(value = "updateForwardingInfo", method = RequestMethod.POST)
    @SystemLogAnnotation(module = "supplier-forwarding",methods = "updateForwardingInfo")
    @ResponseBody
    public ResultPojo updateForwardingInfo(@RequestBody FreightForwarding freightForwarding){
        Result<Integer> result = new Result<>();
        try{
            freightForwarding.setModifier(LoginUtils.getLoginId());
            freightForwarding.setModifiedtime(new Date());
            result.addDefaultModel("forwardingInfo",freightForwardingService.updateSelective(freightForwarding));
        }catch(Exception e){
            log.error("更新货代详情出错",e);
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    /**
     * 关联仓库列表
     * @return
     **/
    @RequestMapping(value = "/warehouseList", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-forwarding",methods = "forwardingList")
    @ResponseBody
    public ResultPojo forwardingList(QueryWarehouseInfo query){
        Result<PageInfo<WarehouseInfo>> result = new Result<>();
        try{
            PageInfo<WarehouseInfo> warehouseInfoList  = warehouseInfoService.getListByForwardingId(query);
            result.addDefaultModel("forwardingList",warehouseInfoList);
        }catch(Exception e){
            log.error("获取关联仓库列表出错",e);
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    /**
     * 竞标记录list
     */
    @RequestMapping(value = "/forwardingBidRecordList", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-forwarding",methods = "forwardingBidRecordList")
    @ResponseBody
    public ResultPojo forwardingBidRecordList(QueryForwardBidRecord query){
        Result<PageInfo<ForwardingBidRecord>> result = new Result<>();
        try{
            PageInfo<ForwardingBidRecord> list = forwardingBidRecordService.getForwardingBidRecordList(query);
            result.addDefaultModel(list);
        }catch(Exception e){
            log.error("获取竞标记录列表出错",e);
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    /**
     * 订单记录list
     */
    @RequestMapping(value = "/orderRecordList", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-forwarding",methods = "orderRecordList")
    @ResponseBody
    public ResultPojo forwardingOrderRecordList(QueryForwardingOrderRecord query){
        Result<PageInfo<ForwardingOrderRecord>> result = new Result<>();
        try{
            PageInfo<ForwardingOrderRecord> list = forwardingOrderRecordService.getForwardingOrderRecordList(query);
            result.addDefaultModel(list);
        }catch(Exception e){
            log.error("获取订单记录列表出错",e);
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    /**
     * 投诉记录list
     */
    @RequestMapping(value = "/forwardingComplaintsRecordList", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-forwarding",methods = "forwardingComplaintsRecordList")
    @ResponseBody
    public ResultPojo forwardingComplaintsRecordList(QueryForwardingComplaintsRecord query){
        Result<PageInfo<ForwardingComplaintsRecord>> result = new Result<>();
        try{
            PageInfo<ForwardingComplaintsRecord> list = forwardingComplaintsRecordService.getForwardingComplaintsRecordList(query);
            result.addDefaultModel(list);
        }catch(Exception e){
            log.error("获取投诉记录列表出错",e);
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    /**
     * 货代评分项及分值
     */
    @RequestMapping(value = "/evaluationIndexItem", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-forwarding",methods = "evaluationIndexItem")
    @ResponseBody
    public ResultPojo evaluationIndexItem(Integer scoreId){
        Result<ScoreInfoVO<ForwardingEvaluationScoreRelation,ForwardingScore>> result = new Result<>();
        ScoreInfoVO<ForwardingEvaluationScoreRelation,ForwardingScore> scoreInfoVO = new ScoreInfoVO<>();
        try{
          scoreInfoVO.setTerms(scoreTermService.evaluationIndexItem(1));
          List<ForwardingEvaluationScoreRelation> scoreList = forwardingEvaluationScoreRelationService.listByScoreId(scoreId);
          if(scoreList!=null&&scoreList.size()>0) {
              scoreInfoVO.setScoreList(scoreList);
          }
            ForwardingScore forwardingScore = forwardingScoreService.get(scoreId);
          scoreInfoVO.setTotalScore(forwardingScore);
          result.addDefaultModel("score",scoreInfoVO);
        }catch(Exception e){
            log.error("获取评分项及分值选项",e);
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    /**
     * 保存评分项
     */
    @RequestMapping(value = "/saveScore", method = RequestMethod.POST)
    @SystemLogAnnotation(module = "supplier-forwarding",methods = "saveScore")
    @ResponseBody
    public ResultPojo saveScore(@RequestBody ScoreVO<ForwardingScore,ForwardingEvaluationScoreRelation> scoreVO){
        Result<Integer> result = new Result();
        try{
            result.addDefaultModel(forwardingScoreService.saveScore(scoreVO));
        }catch(Exception e){
            log.error("保存货代评分失败");
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }

        return result.getResultPojo();
    }

    /**
     * 获取月度评价表
     */
    @RequestMapping(value = "/scoreListOfMonth", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-forwarding",methods = "scoreListOfMonth")
    @ResponseBody
    public ResultPojo scoreListOfMonth(QueryForwardingScore query){
        Result<PageInfo<ForwardingScore>> result = new Result();
        try{
            result.addDefaultModel("scoreList",forwardingScoreService.getForwardingScoreList(query));
        }catch (Exception e){
            log.error("货代月度评价表获取失败");
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }




}


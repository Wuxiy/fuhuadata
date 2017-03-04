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
     * 产品常见问题列表
     * @return
     */
    @RequestMapping(value="/productProblem",method=RequestMethod.GET)
    public ModelAndView productQuestionList(){return new ModelAndView("knowledgeBase/productProblemList");}

    /**
     * 营销培训列表
     * @return
     */
    @RequestMapping(value="/marketTrainingList",method=RequestMethod.GET)
    public ModelAndView marketTrainList(){return new ModelAndView("knowledgeBase/marketTrainingList");}

    /**
     * 客户产品包装要求列表
     * @return
     */
    @RequestMapping(value="/customerProductPackingList",method=RequestMethod.GET)
    public ModelAndView customerProductPackingList(){return new ModelAndView("knowledgeBase/customerProductPackingList");}

    /**
     * 客户产品包装要求详情
     * @return
     */
    @RequestMapping(value="/customerProductPackingInfo",method=RequestMethod.GET)
    public ModelAndView customerProductPackingInfo(){return new ModelAndView("knowledgeBase/customerProductPackingInfo");}

    /**
     * 客户产品包装要求新增
     * @return
     */
    @RequestMapping(value="/AddcustomerProductPacking",method=RequestMethod.GET)
    public ModelAndView AddcustomerProductPacking(){return new ModelAndView("knowledgeBase/customerProductPackingAdd");}

    /**
     * 标准产品档案列表
     * @return
     */
    @RequestMapping(value="/productArchivesList",method=RequestMethod.GET)
    public ModelAndView productArchivesList(){return new ModelAndView("knowledgeBase/productArchivesList");}

    /**
     * 标准产品档案新增
     * @return
     */
    @RequestMapping(value="/productArchivesAdd",method=RequestMethod.GET)
    public ModelAndView productArchivesAdd(){return new ModelAndView("knowledgeBase/productArchivesAdd");}

    /**
     * 包材成本参考列表
     * @return
     */
    @RequestMapping(value="/packingCostList",method=RequestMethod.GET)
    public ModelAndView packingCostList(){return new ModelAndView("knowledgeBase/packingCostList");}

    /**
     * 包材成本参Add
     * @return
     */
    @RequestMapping(value="/packingCostAdd",method=RequestMethod.GET)
    public ModelAndView packingCostAdd(){return new ModelAndView("knowledgeBase/packingCostAdd");}

    /**
     * 加工成本列表
     * @return
     */
    @RequestMapping(value="/processCostList",method=RequestMethod.GET)
    public ModelAndView processCostList(){return new ModelAndView("knowledgeBase/processCostList");}

    /**
     * 百科列表
     * @return
     */
    @RequestMapping(value="/encyclopediaList",method=RequestMethod.GET)
    public ModelAndView encyclopediaList(){return new ModelAndView("knowledgeBase/encyclopediaList");}

    /**
     * 添加百科
     * @return
     */
    @RequestMapping(value="/encyclopediaAdd",method=RequestMethod.GET)
    public ModelAndView encyclopediaAdd(){return new ModelAndView("knowledgeBase/encyclopediaAdd");}

    /**
     * 展会动态列表
     * @return
     */
    @RequestMapping(value="/exhibitionInfoList",method=RequestMethod.GET)
    public ModelAndView exhibitionDynamicList(){return new ModelAndView("knowledgeBase/exhibitionInfoList");}

    /**
     * 展会添加
     * @return
     */
    @RequestMapping(value="/exhibitionInfoAdd",method=RequestMethod.GET)
    public ModelAndView exhibitionDynamicAdd(){return new ModelAndView("knowledgeBase/exhibitionInfoAdd");}

}

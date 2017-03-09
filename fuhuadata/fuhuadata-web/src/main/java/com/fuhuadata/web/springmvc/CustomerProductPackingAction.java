package com.fuhuadata.web.springmvc;


<<<<<<< HEAD
=======
import com.fuhuadata.domain.CustomerProductInfo;
import com.fuhuadata.domain.ExhibitionInfo;
import com.fuhuadata.domain.query.ExhibitionInfoQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.CustomerProductInfoService;
import com.fuhuadata.service.ExhibitionInfoService;
import com.fuhuadata.vo.CustomerProductPackagingArchives;
import com.fuhuadata.web.util.DateUtil;
>>>>>>> dfcd8437d233130064b3dd4cc16a763331d9205c
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 客户产品包装要求action
 * Created by wuxi on 2017/1/13.
 */

@Controller
@RequestMapping("/customerProductPacking/*")
public class CustomerProductPackingAction {

    private final static Log log=LogFactory.getLog(CustomerProductPackingAction.class);

    @Resource
    private CustomerProductInfoService customerProductInfoService;

    /**
     * 客户产品包装要求列表
     * @return
     */
    @SuppressWarnings("unused")
    @RequestMapping(value="/customerProductPackingList",method=RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-customerProductPackaging  ",methods = "into")
    public ModelAndView customerProductPackingList(){return new ModelAndView("knowledgeBase/customerProductPackingList");}

    /**
     * 新增客户产品包装详情
     * @return
     */
    @RequestMapping(value="/infocustomerProductPacking",method=RequestMethod.GET)
    public ModelAndView infocustomerProductPacking(){return new ModelAndView("knowledgeBase/customerProductPackingInfo");}

    @RequestMapping(value = "/queryCustomerProductPackingList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-customerProductPackaging",methods = "list")
    @ResponseBody
    public ResultPojo getCustomerProductPackagingArchives() {
        try {
            Result<List<CustomerProductPackagingArchives>> result = customerProductInfoService.getCustomerProductPackagingArchives();
            return result.getResultPojo();
        } catch (Exception e) {
            log.error("获取客户产品包装要求错误",e);
        }
        return null;
    }
}

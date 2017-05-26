package com.fuhuadata.web.springmvc.mybatis;

import com.fuhuadata.domain.mybatis.supplier.FreightForwarding;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.supplier.FreightForwardingService;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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


    @RequestMapping(value = "init", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-forwarding",methods = "init")
    public String intoForwarding() {
        return "supplier/forwardingList";
    }

    /**
     * 货代列表
     * @param startRow
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/forwardingList", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-forwarding",methods = "forwardingList")
    @ResponseBody
    public ResultPojo forwardingList(@RequestParam("startRow") Integer startRow,
                                     @RequestParam("pageSize") Integer pageSize ){
        Result<List<FreightForwarding>> result = new Result<>();
        try{
            result.addDefaultModel("forwardingList",freightForwardingService.list());
        }catch(Exception e){
            log.error("获取货代列表出错",e);
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
            result.addDefaultModel("forwardingInfo",freightForwardingService.get(id));
        }catch(Exception e){
            log.error("根据id获取货代详情出错",e);
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    /**
     * 关联仓库列表
     * @param startRow
     * @param pageSize
     * @return
     */
//    @RequestMapping(value = "/forwardingList", method = RequestMethod.GET)
//    @SystemLogAnnotation(module = "supplier-forwarding",methods = "forwardingList")
//    @ResponseBody
//    public ResultPojo forwardingList(@RequestParam("startRow") Integer startRow,
//                                     @RequestParam("pageSize") Integer pageSize ){
//        Result<List<FreightForwarding>> result = new Result<>();
//        try{
//            result.addDefaultModel("forwardingList",freightForwardingService.list());
//        }catch(Exception e){
//            log.error("获取货代列表出错",e);
//            result.setMessage(e.getMessage());
//            result.setSuccess(false);
//        }
//        return result.getResultPojo();
//    }


}

package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.SaleCustomer;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.service.SaleCustomerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.fuhuadata.domain.query.QuerySaleCustomer;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangbo on 2017/1/18.
 */
@Controller
@RequestMapping("/saleCustomer/*")
public class SaleCustomerAction {
    private final static Log log = LogFactory.getLog(SaleCustomerAction.class);
    @Resource
    private SaleCustomerService saleCustomerService;
    private Integer pageSize = 10;
    private String page = "1";

    /**
     * 用户列表
     * @return
     */
    @SuppressWarnings("unused")
    @RequestMapping(value="/saleCustomerList",method= RequestMethod.GET)
    public ModelAndView saleCustomerList(){
        Result<List<SaleCustomer>> result = new Result<List<SaleCustomer>>();
        try{
            QuerySaleCustomer query = new QuerySaleCustomer();
            query.setPageSize(pageSize);
            try{
                query.setIndex(Integer.valueOf(page.trim()));
            }catch(Exception e){
                query.setIndex(1);
            }
            result = saleCustomerService.getSaleCustomersByPage(query);
        }catch(Exception e){
            //打印日志
            log.error("获取客户列表错误",e);
        }
        ModelAndView model = new ModelAndView("saleCustomer/saleCustomerList","SaleCustomers",result.getModel());
        return model;
    }
}

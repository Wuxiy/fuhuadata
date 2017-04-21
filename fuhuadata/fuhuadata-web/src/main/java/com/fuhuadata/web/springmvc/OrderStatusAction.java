package com.fuhuadata.web.springmvc;

import com.fuhuadata.dao.NCExchange.OrderToNc;
import com.fuhuadata.domain.mybatis.UserAccount;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangxiang on 2017/4/18.
 */
@Controller
public class OrderStatusAction {

    @Autowired
    UserService userService;

    @Autowired
    private OrderToNc orderToNc;

    @RequestMapping("order/status")
    @ResponseBody
    public ResultPojo doStatus(HttpServletRequest request){
        Result<String> result = Result.newResult(false);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            UserAccount userAccount = userService.login(username, password);
        } catch(Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("用户名或密码错误");
            return result.getResultPojo();
        }
        String ncOrderId= request.getParameter("vbillcode");
        String status= request.getParameter("status");

        try {
            Map<String,Object> mapv=new HashMap<String,Object>();
            mapv.put("ncOrderId",ncOrderId);
            mapv.put("status",Integer.valueOf(status));
            orderToNc.updateOrderStatusByNcOrderId(mapv);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result.getResultPojo();
    }
}

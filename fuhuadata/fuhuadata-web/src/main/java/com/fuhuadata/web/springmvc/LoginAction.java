package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.UserAccount;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhangxiang on 2017/2/8.
 */
@Controller
@RequestMapping("/account/*")
public class LoginAction {
    private final static Log log= LogFactory.getLog(LoginAction.class);
    private UserService userService;

    @RequestMapping(value = "/login.action",method = RequestMethod.POST)
    @ResponseBody
    public ResultPojo login(String account, String password, HttpServletRequest request, HttpServletResponse response){
        ResultPojo result=new ResultPojo();
        if ("fuhua".equals(account) && "123".equals(password)){
            result.setCode(1);
            UserAccount userAccount=new UserAccount();
            userAccount.setAccount("fuhua");
            userAccount.setPassword("123");
            result.setDefaultObject(userAccount);
            Cookie cookie=new Cookie("loggedIn",System.currentTimeMillis()+"|"+account);
            cookie.setPath("/");
            response.addCookie(cookie);
        }else {
            result.setCode(0);
            result.setMessage("账号或密码错误");
        }
        return result;

        //Result<UserAccount> result=userService.getUserByAccount(account);
        //return result.getResultPojo();
    }

}

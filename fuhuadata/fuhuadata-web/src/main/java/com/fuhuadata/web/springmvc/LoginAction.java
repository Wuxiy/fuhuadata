package com.fuhuadata.web.springmvc;

import com.fuhuadata.constant.Consts;
import com.fuhuadata.domain.UserAccount;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.MenuService;
import com.fuhuadata.service.mybatis.UserService;
import com.fuhuadata.service.util.LoginUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

/**
 * Created by zhangxiang on 2017/2/8.
 */
@Controller
public class LoginAction {
    private final static Log log = LogFactory.getLog(LoginAction.class);

    @Value("${shiro.login.url}")
    private String loginUrl;

    @Autowired
    UserService userService;

    @Autowired
    MenuService menuService;

    @RequestMapping({"", "index"})
    public String index() {
        return "/salesStatistics/businessOpportunity";
    }

    @RequestMapping("/check")
    @ResponseBody
    public Boolean testPermission(@RequestParam String perm) {
        Subject subject = LoginUtils.getSubject();
        return subject.isPermitted(perm);
    }

    @RequestMapping("/permissions")
    @ResponseBody
    public Set<String> getPermissions(@RequestParam Integer userId) {
        return menuService.getStringPermissions(userId);
    }

    @RequestMapping("/exception")
    @RequiresUser
    public void testExceptionHanlding() {
        throw new IllegalArgumentException("非法参数错误");
    }

    @RequestMapping(value = "/login")
    public String loginForm(HttpServletRequest request, ModelMap model) {

        model.addAttribute("nolayout", true);

        String errorMsg = "";

        if (StringUtils.isNotBlank(request.getParameter("logout"))) {
            model.addAttribute(Consts.MESSAGE, "退出登录成功");
        }

        if (StringUtils.isNotBlank(request.getParameter("notfound"))) {
            errorMsg = "用户不存在";
        }

        Exception shiroLoginEx =
                (Exception) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
        if (null != shiroLoginEx) {
            if (shiroLoginEx instanceof UnknownAccountException) {
                errorMsg = "用户不存在";
            } else if (shiroLoginEx instanceof IncorrectCredentialsException) {
                errorMsg = "用户名或密码错误";
            } else if (shiroLoginEx instanceof AuthenticationException) {
                errorMsg = shiroLoginEx.getMessage();
            } else {
                errorMsg = "未知错误";
            }
        }

        if (StringUtils.isNotBlank(errorMsg)) {
            model.addAttribute(Consts.ERROR, errorMsg);
        }

        //如果同时存在错误消息 和 普通消息  只保留错误消息
        if (model.containsAttribute(Consts.ERROR)) {
            model.remove(Consts.MESSAGE);
        }

        //如果用户直接到登录页面 先退出一下
        //原因：isAccessAllowed实现是subject.isAuthenticated()---->即如果用户验证通过 就允许访问
        // 这样会导致登录一直死循环
        Subject subject = SecurityUtils.getSubject();
        if (subject != null && subject.isAuthenticated()) {
            return "redirect:/logout";
        }

        return "login/login";
    }

    @RequestMapping(value = "password", method = RequestMethod.GET)
    public String changePasswordView(Model model) {

        model.addAttribute("nolayout", true);
        model.addAttribute("loginUrl", loginUrl);
        return "common/modificationPassword";
    }

    @RequestMapping(value = "password", method = RequestMethod.POST)
    @ResponseBody
    public ResultPojo changePassword(@RequestParam("password") String password,
                                     @RequestParam("confirm") String confirm) {
        Result<Boolean> result = Result.newResult(false);
        result.setSuccess(false);
        String msg = "";

        Subject subject = LoginUtils.getSubject();
        if (subject == null || !subject.isAuthenticated()) {
            msg = "你尚未登录";
            result.setMessage(msg);
            return result.getResultPojo();
        }

        if (StringUtils.isNotBlank(password) && StringUtils.isNotBlank(confirm)) {
            if (password.equals(confirm)) {
                userService.changePassword(LoginUtils.getLoginId(), password);
                result.setSuccess(true);
            } else {
                msg = "两次输入的密码不一致";
            }
        } else {
            msg = "密码不能为空";
        }

        result.setMessage(msg);
        return result.getResultPojo();
    }

    @RequestMapping(value = "/account/login.action", method = RequestMethod.POST)
    @ResponseBody
    public ResultPojo login(String account, String password, HttpServletRequest request, HttpServletResponse response) {
        ResultPojo result = new ResultPojo();
        if ("fuhua".equals(account) && "123".equals(password)) {
            result.setCode(1);
            UserAccount userAccount = new UserAccount();
            userAccount.setAccount("fuhua");
            userAccount.setPassword("123");
            result.setData(userAccount);
            Cookie cookie = new Cookie("loggedIn", System.currentTimeMillis() + "|" + account);
            cookie.setPath("/");
            response.addCookie(cookie);
        } else {
            result.setCode(0);
            result.setMessage("账号或密码错误");
        }
        return result;

        //Result<UserAccount> result=userService.getUserByAccount(account);
        //return result.getResultPojo();
    }

}

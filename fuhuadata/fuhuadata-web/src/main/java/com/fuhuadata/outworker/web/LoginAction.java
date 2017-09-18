package com.fuhuadata.outworker.web;

import com.fuhuadata.domain.mybatis.UserAccount;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.homesales.user.domain.User;
import com.fuhuadata.outworker.jwt.JwtService;
import com.fuhuadata.service.exception.UserNotExistsException;
import com.fuhuadata.service.exception.UserPasswordNotMatchException;
import com.fuhuadata.service.mybatis.UserService;
import com.fuhuadata.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>User: wangjie
 * <p>Date: 7/24/2017
 */
@RequestMapping("/outworker")
@RestController(value = "outworkerLoginAction")
public class LoginAction {

    @Value("${outworker.api.username}")
    private String username;

    @Value("${outworker.api.password}")
    private String password;

    @Value("${outworker.api.ttlMillis}")
    private Long ttlMillis;

    @Value("${outworker.user.ttlMillis}")
    private Long userTtlMillis;

    @Autowired
    @Qualifier("apiJwtService")
    JwtService apiJwtService;

    @Autowired
    @Qualifier("userJwtService")
    JwtService userJwtService;

    @Autowired
    UserService userService;

    @Autowired
    com.fuhuadata.homesales.user.service.UserService homeUserService;

    // 应用登录
    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public ResultPojo login(@RequestParam String username,
                            @RequestParam String password) {

        boolean success = true;
        HttpStatus code = HttpStatus.OK;
        String msg = "";

        if (StringUtils.isEmpty(this.username) || StringUtils.isEmpty(this.password)) {
            code = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "服务器配置错误";
            success = false;
        } else if (!this.username.equals(username) || !this.password.equals(password)) {
            code = HttpStatus.UNAUTHORIZED;
            msg = "用户名或密码错误";
            success = false;
        }

        Result<String> result = Result.newResult(true);
        result.setSuccess(success);
        result.setCode(code.value());
        result.setMessage(msg);

        if (success) {
            result.addDefaultModel(apiJwtService.generateJwt(username, username, ttlMillis));
        }

        return result.getResultPojo();
    }

    // 用户登录
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public ResultPojo userLogin(@RequestParam String username,
                                @RequestParam String password) {

        boolean success = true;
        HttpStatus code = HttpStatus.OK;
        String msg = "";

        try {
            userService.login(username, password);
        } catch (UserNotExistsException e) {
            success = false;
            code = HttpStatus.NOT_FOUND;
            msg = e.getMessage();
        } catch (UserPasswordNotMatchException e) {
            success = false;
            code = HttpStatus.BAD_REQUEST;
            msg = e.getMessage();
        }

        Result<User> result = Result.newResult(true);
        result.setSuccess(success);
        result.setCode(code.value());
        result.setMessage(msg);

        if (success) {
            UserAccount userAccount = userService.getUserByLoginName(username);
            userAccount.setRefreshToken(StringUtil.uuidWithoutLine());
            userService.updateSelective(userAccount);// 保存用户refresh token

            User user = User.of(userAccount);

            String jwtToken = userJwtService.generateJwt(username, user.getCode(), userTtlMillis);
            user.setAccessToken(jwtToken);
            user.setRefreshtoken(user.getRefreshToken());

            homeUserService.setLeader(user);

            result.addDefaultModel(user);
        }

        return result.getResultPojo();
    }

    // 使用 refresh token 获取新的 access token
    @RequestMapping(value = "/user/refresh-token", method = RequestMethod.GET)
    public ResultPojo refreshToken(@RequestParam String refreshToken) {

        Result<Map<String, String>> result = Result.newResult(true);
        boolean success = true;
        String msg = "";

        UserAccount userAccount = userService.getUserByRefreshToken(refreshToken);

        if (userAccount == null) {
            success = false;
            msg = "refresh token 不存在";
        } else {
            String jwtToken =
                    userJwtService.generateJwt(userAccount.getLoginName(), userAccount.getCode(), userTtlMillis);
            String newRefreshToken = StringUtil.uuidWithoutLine();

            Map<String, String> tokens = new HashMap<>();
            tokens.put("accessToken", jwtToken);
            tokens.put("refreshtoken", newRefreshToken);
            result.addDefaultModel(tokens);

            // 保存新的 refresh token
            userAccount.setRefreshToken(newRefreshToken);
            userService.updateSelective(userAccount);
        }

        result.setSuccess(success);
        result.setMessage(msg);

        return result.getResultPojo();
    }

}

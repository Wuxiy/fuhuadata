package com.fuhuadata.outworker.web;

import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.outworker.jwt.JwtService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>User: wangjie
 * <p>Date: 7/24/2017
 */
@RequestMapping("/outworker/login")
@RestController(value = "outworkerLoginAction")
public class LoginAction {

    @Value("${outworker.api.username}")
    private String username;

    @Value("${outworker.api.password}")
    private String password;

    @Value("${outworker.api.ttlMillis}")
    private Long ttlMillis;

    @Resource
    JwtService jwtService;

    @RequestMapping(value = "", method = RequestMethod.POST)
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
            result.addDefaultModel(jwtService.generateJwt(username, username, ttlMillis));
        }

        return result.getResultPojo();
    }
}

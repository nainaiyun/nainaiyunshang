package com.nainai.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.nainai.user.common.Result;
import com.nainai.user.common.ResultGenerator;
import com.nainai.user.domain.User;
import com.nainai.user.service.UserService;
import com.nainai.user.util.MD5Utils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by haopeng yan on 2018/4/11
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. nainai All Rights Received
 */
@RestController
@RequestMapping(value = "/register")
public class RegisterController {

    @Autowired
    private UserService userService;
    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation(value = "注册填写：用户名、手机号码、密码、短信验证码", notes = "注册填写：用户名、手机号码、密码、短信验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "username", value = "用户名")
    })
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(@RequestBody JSONObject jsonObject) {
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        String mobile = jsonObject.getString("mobile");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setMobile(mobile);
        int num = userService.insertSelective(user);
        return ResultGenerator.genSuccessResult(user);
    }

    private static final String KEY = "abc123";

    @ApiOperation(value = "注册填写：用户名、手机号码、密码、短信验证码", notes = "注册填写：用户名、手机号码、密码、短信验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "username", value = "用户名")
    })
    @RequestMapping(value = "/verificationCodeLogin", method = RequestMethod.POST)
    public Result test(@RequestBody JSONObject jsonObject) {

        String requestHash = jsonObject.getString("hash");
        String tamp = jsonObject.getString("tamp");
        String msgNum = jsonObject.getString("msgNum");
        String hash = MD5Utils.getPwd(KEY + "@" + tamp + "@" + msgNum);
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar c = Calendar.getInstance();
        String currentTime = sf.format(c.getTime());
        if (tamp.compareTo(currentTime) > 0) {
            if (hash.equalsIgnoreCase(requestHash)) {
                //校验成功
                return ResultGenerator.genSuccessResult("");
            } else {
                //验证码不正确，校验失败
                return ResultGenerator.genSuccessResult("");
            }
        } else {
            return ResultGenerator.genSuccessResult("");
        }
    }



}

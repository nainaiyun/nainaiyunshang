package com.nainai.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.nainai.user.common.Result;
import com.nainai.user.common.ResultGenerator;
import com.nainai.user.domain.User;
import com.nainai.user.service.UserService;
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
    @RequestMapping(value="/register",method = RequestMethod.POST)
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

    @ApiOperation(value = "注册填写：用户名、手机号码、密码、短信验证码", notes = "注册填写：用户名、手机号码、密码、短信验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "username", value = "用户名")
    })
    @RequestMapping(value="/verificationCodeLogin",method = RequestMethod.POST)
    public Result test(@RequestBody JSONObject jsonObject) {
        String mobile = jsonObject.getString("mobile");
        JSONObject postData = new JSONObject();
        postData.put("mobile", mobile);
        System.out.println(mobile);
        String url ="http://localhost:8080/smscode/sendSmsCode";
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<>(postData.toString(), headers);
        String result = restTemplate.postForObject(url, formEntity, String.class);
        System.out.println(result);

        return ResultGenerator.genSuccessResult(result);
    }


}

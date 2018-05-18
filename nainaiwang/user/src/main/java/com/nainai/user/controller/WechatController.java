package com.nainai.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.nainai.user.common.Result;
import com.nainai.user.common.ResultGenerator;
import com.nainai.user.service.WechatService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by haopeng yan on 2018/5/12
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@RestController
@RequestMapping("/wechat")
public class WechatController {
    @Autowired
    private WechatService wechatService;

    @ApiOperation(value = "登录凭证校验", notes = "填写：用户名、手机号码、密码、短信验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "username", value = "用户名")
    })
    @RequestMapping(value = "/jscode2session", method = RequestMethod.POST)
    public Result jscode2session(@RequestBody JSONObject jsonObject, HttpServletRequest request) {
        String session =request.getSession().getId();
        System.out.println(session);
        String jsCode = jsonObject.getString("jsCode");
        System.out.println("获得jscode为："+jsCode);

        return ResultGenerator.genSuccessResult(wechatService.jscode2session(jsCode,session));

    }
}

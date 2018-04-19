package com.nainai.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.nainai.user.common.Result;
import com.nainai.user.common.ResultGenerator;
import com.nainai.user.domain.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by haopeng yan on 2018/4/16
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
    @ApiOperation(value = "企业认证", notes = "企业认证")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "username", value = "用户名")
    })
    @RequestMapping(value="/company",method = RequestMethod.POST)
    public Result test(@RequestBody JSONObject jsonObject) {
        String username = jsonObject.getString("username");
        return ResultGenerator.genSuccessResult(username);
    }

    @ApiOperation(value = "个人认证", notes = "个人认证")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "username", value = "用户名")
    })
    @RequestMapping(value="/personal",method = RequestMethod.POST)
    public Result personal(@RequestBody JSONObject jsonObject) {
        String username = jsonObject.getString("username");
        return ResultGenerator.genSuccessResult(username);
    }
}

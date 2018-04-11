package com.nainai.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.nainai.user.common.Result;
import com.nainai.user.common.ResultGenerator;
import com.nainai.user.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by haopeng yan on 2018/4/11
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. nainai All Rights Received
 */
@RestController

@RequestMapping(value = "/user")
public class LoginController {

    @Autowired
    private UserService userService;
    /**
     * 判断用户名密码是否正确
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "判断用户名密码是否正确", notes = "判断用户名密码是否正确")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "username", value = "用户名"),
            @ApiImplicitParam(dataType = "String", name = "password", value = "密码")
    })
    @RequestMapping(value = "/selectUserByUsername", method = RequestMethod.POST)
    public Result selectUserByUsername(@RequestBody JSONObject jsonObject) {
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        JSONObject jsonObject1 =userService.selectUserId(1);
        return ResultGenerator.genSuccessResult(jsonObject1);
    }

}

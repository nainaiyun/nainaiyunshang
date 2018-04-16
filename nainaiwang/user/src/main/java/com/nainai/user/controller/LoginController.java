package com.nainai.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.nainai.user.common.Result;
import com.nainai.user.common.ResultGenerator;
import com.nainai.user.common.SystemConstant;
import com.nainai.user.domain.User;
import com.nainai.user.service.UserService;
import com.nainai.user.util.JwtUtils;
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
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "用户名、手机号码、邮箱登陆", notes = "用户名、手机号码、邮箱登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "username", value = "用户名")
    })
    @RequestMapping(value="/passwordLogin",method = RequestMethod.POST)
    public Result login(@RequestBody JSONObject jsonObject) {
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        User user =userService.selectUserByUserName(username);
        if(user!=null){
            if(user.getPassword().equals(password)){
                //把token返回给客户端-->客户端保存至cookie-->客户端每次请求附带cookie参数
                String JWT = JwtUtils.createJWT("1", username, SystemConstant.JWT_TTL);
                return ResultGenerator.genSuccessResult(JWT);
            }else{
                return ResultGenerator.genFailResult("密码错误");
            }
        }else{
            return ResultGenerator.genFailResult("此用户不存在");
        }
    }
    @ApiOperation(value = "用户名、手机号码、邮箱登陆", notes = "用户名、手机号码、邮箱登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "username", value = "用户名")
    })
    @RequestMapping(value="/verificationCodeLogin",method = RequestMethod.POST)
    public Result test(@RequestBody JSONObject jsonObject) {
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        User user = userService.selectUserByUserName(username);
        return ResultGenerator.genSuccessResult(user);
    }

}

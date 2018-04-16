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

import java.util.Random;

/**
 * Created by haopeng yan on 2018/4/16
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@RestController
@RequestMapping(value = "/smscode")
public class SmsCodeController {
    @ApiOperation(value = "发送短信随机码", notes = "发送短信随机码")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "mobile", value = "手机号码")
    })
    @RequestMapping(value="/sendSmsCode",method = RequestMethod.POST)
    public Result sendSmsCode(@RequestBody JSONObject jsonObject) {
        String mobile = jsonObject.getString("mobile");
        System.out.println(mobile);
        Random random = new Random(100);
        return ResultGenerator.genSuccessResult(random.nextInt());
    }
}

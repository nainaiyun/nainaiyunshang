package com.nainai.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.nainai.user.common.Result;
import com.nainai.user.common.ResultGenerator;
import com.nainai.user.domain.User;
import com.nainai.user.util.MD5Utils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
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
    private static final String KEY = "abc123"; // KEY为自定义秘钥

    @ApiOperation(value = "发送短信随机码", notes = "发送短信随机码")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "mobile", value = "手机号码")
    })
    @RequestMapping(value = "/sendSmsCode", method = RequestMethod.POST)
    public Result sendSmsCode(@RequestBody JSONObject jsonObject) {
        String phoneNumber = jsonObject.getString("mobile");
        Random randomNum = new Random(6);
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MINUTE, 5);
        String currentTime = sf.format(c.getTime());// 生成5分钟后时间，用户校验是否过期
        //sengMsg(); //此处执行发送短信验证码方法
        String hash = MD5Utils.getPwd(KEY + "@" + currentTime + "@" + randomNum.nextInt());//生成MD5值
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("hash", hash);
        resultMap.put("tamp", currentTime);
        return ResultGenerator.genSuccessResult(resultMap);
    }

}

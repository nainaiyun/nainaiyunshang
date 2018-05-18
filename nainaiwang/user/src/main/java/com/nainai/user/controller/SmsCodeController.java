package com.nainai.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.nainai.user.common.Result;
import com.nainai.user.common.ResultGenerator;
import com.nainai.user.domain.User;
import com.nainai.user.util.MD5Utils;
import com.nainai.user.util.SmsCodeUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.bouncycastle.crypto.prng.RandomGenerator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
    @RequestMapping(value = "/sendSmsCode", method = RequestMethod.POST)
    public Result sendSmsCode(@RequestBody JSONObject jsonObject, HttpServletRequest request) throws IOException {

        String session = request.getSession().getId();
        System.out.println("session"+session);
        String mobile = jsonObject.getString("mobile");
        String news = jsonObject.getString("news");
        int num = (int)((Math.random()*9+1)*100000);
        String code = Integer.toString(num);
        System.out.println(code);
        final HttpSession httpSession = request.getSession();
        httpSession.setAttribute(mobile + "001", code);
        String rp = null;
        try {
            rp =SmsCodeUtil.readContentFromPost(news,mobile, code);
            System.out.println(rp);
            ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
                    new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());
            System.out.println("开始任务");
            //延时3秒执行
            executorService.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行任务");
                    httpSession.removeAttribute(mobile + "001");
                    System.out.println(mobile + "001删除成功");
                }
            }, 15, TimeUnit.MINUTES);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultGenerator.genSuccessResult(rp);

    }
}

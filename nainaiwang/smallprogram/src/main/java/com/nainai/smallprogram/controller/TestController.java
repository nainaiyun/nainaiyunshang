package com.nainai.smallprogram.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * Created by haopeng yan on 2018/4/24
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping("/test")
    public String test(@RequestBody JSONObject jsonObject){
        String x = jsonObject.getString("x");
        System.out.println(x);
        return  "你是蠢猪吗，这个还要测试！";
    }
    @PostMapping(value = "/upload")
    public String upload(@RequestParam("user") String user, HttpServletRequest request) {
        if (request instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            // 获取上传的文件
            Map<String, MultipartFile> fileMap = multipartHttpServletRequest.getFileMap();
            for(Map.Entry<String, MultipartFile> entry : fileMap.entrySet()){
                // 对文件进处理
                System.out.println(entry.getKey() + ":" + entry.getValue().getOriginalFilename());

            }
        }
        // 对name进行处理
        System.out.println(user);
        return "ok";
    }

}

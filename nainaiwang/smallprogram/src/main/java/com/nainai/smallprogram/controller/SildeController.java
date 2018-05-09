package com.nainai.smallprogram.controller;

import com.alibaba.fastjson.JSONObject;
import com.nainai.smallprogram.common.Result;
import com.nainai.smallprogram.common.ResultGenerator;
import com.nainai.smallprogram.domain.Slide;
import com.nainai.smallprogram.service.SlideService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by haopeng yan on 2018/4/25
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@RestController
@RequestMapping("/silde")
public class SildeController {
    @Autowired
    private SlideService slideService;

    /**
     * 查询轮播图
     * @param id
     * @param name
     * @param status
     * @return
     */
    @ApiOperation(value = "查询轮播图", notes = "查询轮播图")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",dataType = "Integer", name = "id", value = "id"),
            @ApiImplicitParam(paramType = "query",dataType = "Integer", name = "name", value = "name"),
            @ApiImplicitParam(paramType = "query",dataType = "Integer", name = "status", value = "status")
    })
    @RequestMapping(value = "/findSlide", method = RequestMethod.GET)
    public Result findSlide(@RequestParam("id") Integer id,
                            @RequestParam("name") String name,
                            @RequestParam("status") Integer status) {
        Map<String, Object> map = new HashMap<>(10);
        map.put("id", id);
        map.put("name", name);
        map.put("status", status);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        return ResultGenerator.genSuccessResult(slideService.findSlide(map));
    }
}

package com.nainai.smallprogram.controller;

import com.alibaba.fastjson.JSONObject;
import com.nainai.smallprogram.common.Result;
import com.nainai.smallprogram.common.ResultGenerator;
import com.nainai.smallprogram.service.ProductCategoryService;
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
@RequestMapping("/productCategory")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 查询顶级分类
     *
     * @param id
     * @param name
     * @param pid
     * @return
     */
    @ApiOperation(value = "查询顶级分类", notes = "查询顶级分类")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "id", value = "分类id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "name", value = "分类name", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pid", value = "父级pid", required = true),
    })
    @RequestMapping(value = "/findProductCategory", method = RequestMethod.GET)
    public Result findProductCategory(@RequestParam("id") Integer id,
                                      @RequestParam("name") String name,
                                      @RequestParam("pid") Integer pid) {
        Map<String, Object> map = new HashMap<>(10);
        map.put("id", id);
        map.put("name", name);
        map.put("pid", pid);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        return ResultGenerator.genSuccessResult(productCategoryService.findProductCategory(map));
    }

}

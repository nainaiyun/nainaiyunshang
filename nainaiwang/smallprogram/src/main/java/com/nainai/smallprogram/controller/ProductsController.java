package com.nainai.smallprogram.controller;

import com.alibaba.fastjson.JSONObject;
import com.nainai.smallprogram.common.Result;
import com.nainai.smallprogram.common.ResultGenerator;
import com.nainai.smallprogram.service.ProductsService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by haopeng yan on 2018/4/19
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductsService productsService;
    /**
     * 查询商品图片
     * @param productsId
     * @return
     */
    @ApiOperation(value = "查询商品图片", notes = "查询商品图片")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",dataType = "Integer", name = "productsId", value = "商品productsId", required = true)
    })
    @RequestMapping(value = "/findProductsPhotos", method = RequestMethod.GET)
    public Result findProductsPhotos(@RequestParam("productsId") Integer productsId) {
        Map<String ,Object> map = new HashMap<>(10);
        map.put("productsId",productsId);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        return ResultGenerator.genSuccessResult(productsService.findProductsPhotos(map));
    }

}

package com.nainai.smallprogram.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.nainai.smallprogram.common.Result;
import com.nainai.smallprogram.common.ResultGenerator;
import com.nainai.smallprogram.domain.ProductOffer;
import com.nainai.smallprogram.service.ProductOfferService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by haopeng yan on 2018/4/19
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@RestController
@RequestMapping("/productOffer")
public class ProductOfferController {

    @Autowired
    private ProductOfferService productOfferService;

    /**
     * 查询当前店铺下的商品报盘列表信息
     *
     * @param jsonObject
     * @return
     */
    @ApiOperation(value = "查询当前店铺下的商品报盘列表信息", notes = "查询当前店铺下的商品报盘列表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "id", value = "报盘id"),
            @ApiImplicitParam(dataType = "String", name = "proName", value = "报盘名称"),
            @ApiImplicitParam(dataType = "String", name = "moduleId", value = "所属模块编号"),
            @ApiImplicitParam(dataType = "String", name = "classifyId", value = "所属分类编号"),
            @ApiImplicitParam(dataType = "String", name = "navigationId", value = "所属导航编号")
    })
    @RequestMapping(value = "/selectProductOfferListingByShopId", method = RequestMethod.POST)
    public Result selectProductOfferListingByShopId(@RequestBody JSONObject jsonObject) {
        Integer id = jsonObject.getInteger("id");
        productOfferService.selectByPrimaryKey(id);
        return ResultGenerator.genSuccessResult(productOfferService.selectByPrimaryKey(1));
    }

    /**
     * 分页查询当前店铺下的商品报盘列表信息
     *
     * @param jsonObject
     * @return
     */
    @ApiOperation(value = "查询当前店铺下的商品报盘列表信息", notes = "查询当前店铺下的商品报盘列表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号"),
            @ApiImplicitParam(dataType = "String", name = "proName", value = "报盘名称"),
            @ApiImplicitParam(dataType = "String", name = "moduleId", value = "所属模块编号"),
            @ApiImplicitParam(dataType = "String", name = "classifyId", value = "所属分类编号"),
            @ApiImplicitParam(dataType = "String", name = "navigationId", value = "所属导航编号")
    })
    @RequestMapping(value = "/selectAllByProductName", method = RequestMethod.POST)
    public Result selectAllByProductName(@RequestBody JSONObject jsonObject) {
        Integer pageNum = jsonObject.getInteger("pageNum");
        Integer pageSize = jsonObject.getInteger("pageSize");
        String productName = jsonObject.getString("productName");
        return ResultGenerator.genSuccessResult(productOfferService.selectAllByProductName(pageNum, pageSize,productName));
    }

    /**
     * 分页查询当前店铺下的商品报盘列表信息
     *
     * @param jsonObject
     * @return
     */
    @ApiOperation(value = "查询当前店铺下的商品报盘列表信息", notes = "查询当前店铺下的商品报盘列表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号"),
            @ApiImplicitParam(dataType = "String", name = "proName", value = "报盘名称"),
            @ApiImplicitParam(dataType = "String", name = "moduleId", value = "所属模块编号"),
            @ApiImplicitParam(dataType = "String", name = "classifyId", value = "所属分类编号"),
            @ApiImplicitParam(dataType = "String", name = "navigationId", value = "所属导航编号")
    })
    @RequestMapping(value = "/findProductOffer", method = RequestMethod.POST)
    public Result findProductOffer(@RequestBody JSONObject jsonObject) {
        ProductOffer productOffer= new ProductOffer();
        productOffer.setProName("1");
        return ResultGenerator.genSuccessResult(productOfferService.findProductOffer(productOffer));
    }

    /**
     * 分页查询当前店铺下的商品报盘列表信息
     *
     * @param jsonObject
     * @return
     */
    @ApiOperation(value = "查询当前店铺下的商品报盘列表信息", notes = "查询当前店铺下的商品报盘列表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号"),
            @ApiImplicitParam(dataType = "String", name = "proName", value = "报盘名称"),
            @ApiImplicitParam(dataType = "String", name = "moduleId", value = "所属模块编号"),
            @ApiImplicitParam(dataType = "String", name = "classifyId", value = "所属分类编号"),
            @ApiImplicitParam(dataType = "String", name = "navigationId", value = "所属导航编号")
    })
    @RequestMapping(value = "/findProductOffer2", method = RequestMethod.POST)
    public Result findProductOffer2(@RequestBody JSONObject jsonObject) {
        ProductOffer productOffer= new ProductOffer();
        productOffer.setProName("1");
        productOffer.setId(1);
        return ResultGenerator.genSuccessResult(productOfferService.findProductOffer(productOffer));
    }


}

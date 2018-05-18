package com.nainai.smallprogram.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.nainai.smallprogram.common.Result;
import com.nainai.smallprogram.common.ResultGenerator;
import com.nainai.smallprogram.domain.ProductOffer;
import com.nainai.smallprogram.service.ProductOfferService;
import io.swagger.annotations.*;
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
@RequestMapping("/productOffer")
public class ProductOfferController {

    @Autowired
    private ProductOfferService productOfferService;

    /**
     * 分页查询查询报盘列表信息
     * @param pageNum
     * @param pageSize
     * @param id
     * @param marketId
     * @param proName
     * @param name
     * @return
     */
    @ApiOperation(value = "查询报盘列表信息", notes = "查询报盘列表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",dataType = "Integer", name = "pageNum", value = "pageNum", required = true),
            @ApiImplicitParam(paramType = "query",dataType = "Integer", name = "pageSize", value = "pageSize", required = true),
            @ApiImplicitParam(paramType = "query",dataType = "Integer", name = "id", value = "id", required = true),
            @ApiImplicitParam(paramType = "query",dataType = "Integer", name = "marketId", value = "marketId", required = true),
            @ApiImplicitParam(paramType = "query",dataType = "String", name = "proName", value = "proName", required = true),
            @ApiImplicitParam(paramType = "query",dataType = "String", name = "name", value = "name", required = true),
    })
    @RequestMapping(value = "/findProductOffer", method = RequestMethod.GET)
    public Result findProductOffer(@RequestParam("pageNum") Integer pageNum,
                                   @RequestParam("pageSize") Integer pageSize,
                                   @RequestParam("id") Integer id,
                                   @RequestParam("marketId") Integer marketId,
                                   @RequestParam("cateId") Integer cateId,
                                   @RequestParam("status") Integer status,
                                   @RequestParam("isDel") Integer isDel,
                                   @RequestParam("proName") String proName,
                                   @RequestParam("name") String name,
                                   @RequestParam("note") String note
                                   ) {
        Map<String ,Object> map = new HashMap<>(10);
        map.put("pageNum",pageNum);
        map.put("pageSize",pageSize);
        map.put("id",id);
        map.put("marketId",marketId);
        map.put("cateId",cateId);
        map.put("status",status);
        map.put("isDel",isDel);
        map.put("proName",proName);
        map.put("name",name);
        map.put("note",note);
        return ResultGenerator.genSuccessResult(productOfferService.findProductOffer(map));
    }

    /**
     * 查询报盘详情页信息
     * @param id
     * @return
     */
    @ApiOperation(value = "查询报盘详情页信息", notes = "查询报盘详情页信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",dataType = "Integer", name = "id", value = "id", required = true),
    })
    @RequestMapping(value = "/findProductOfferDetails", method = RequestMethod.GET)
    public Result findProductOfferDetails(@RequestParam("id") Integer id) {
        Map<String ,Object> map = new HashMap<>(10);
        map.put("id",id);
        return ResultGenerator.genSuccessResult(productOfferService.findProductOfferDetails(map));
    }

    /**
     * 查询报盘统计信息
     * @param id
     * @return
     */
    @ApiOperation(value = "查询报盘统计信息", notes = "查询报盘统计信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",dataType = "Integer", name = "pageNum", value = "pageNum", required = true),
            @ApiImplicitParam(paramType = "query",dataType = "Integer", name = "pageSize", value = "pageSize", required = true),
            @ApiImplicitParam(paramType = "query",dataType = "Integer", name = "id", value = "id", required = true),
    })
    @RequestMapping(value = "/findProductOfferStatistics", method = RequestMethod.GET)
    public Result findProductOfferStatistics(@RequestParam("pageNum") Integer pageNum,
                                             @RequestParam("pageSize") Integer pageSize,
                                             @RequestParam("id") Integer id) {
        Map<String ,Object> map = new HashMap<>(10);
        map.put("pageNum",pageNum);
        map.put("pageSize",pageSize);
        map.put("id",id);
        return ResultGenerator.genSuccessResult(productOfferService.findProductOfferStatistics(map));
    }

    /**
     * 查询报盘统计信息
     * @param id
     * @return
     */
    @ApiOperation(value = "查询报盘统计信息", notes = "查询报盘统计信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",dataType = "Integer", name = "pageNum", value = "pageNum", required = true),
            @ApiImplicitParam(paramType = "query",dataType = "Integer", name = "pageSize", value = "pageSize", required = true),
            @ApiImplicitParam(paramType = "query",dataType = "Integer", name = "id", value = "id", required = true),
    })
    @RequestMapping(value = "/findProductOfferStatisticsNew", method = RequestMethod.GET)
    public Result findProductOfferStatisticsNew(@RequestParam("pageNum") Integer pageNum,
                                             @RequestParam("pageSize") Integer pageSize,
                                             @RequestParam("id") Integer id) {
        Map<String ,Object> map = new HashMap<>(10);
        map.put("pageNum",pageNum);
        map.put("pageSize",pageSize);
        map.put("id",id);
        return ResultGenerator.genSuccessResult(productOfferService.findProductOfferStatisticsNew(map));
    }


    /**
     *
     * @param pageNum
     * @param pageSize
     * @param name
     * @param note
     * @return
     */
    @ApiOperation(value = "查询报盘列表信息", notes = "查询报盘列表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",dataType = "Integer", name = "pageNum", value = "pageNum", required = true),
            @ApiImplicitParam(paramType = "query",dataType = "Integer", name = "pageSize", value = "pageSize", required = true),
            @ApiImplicitParam(paramType = "query",dataType = "String", name = "name", value = "name", required = true),
            @ApiImplicitParam(paramType = "query",dataType = "String", name = "note", value = "note", required = true)
    })
    @RequestMapping(value = "/findProductOfferNote", method = RequestMethod.GET)
    public Result findProductOfferNote(@RequestParam("pageNum") Integer pageNum,
                                   @RequestParam("pageSize") Integer pageSize,
                                   @RequestParam("name") String name,
                                   @RequestParam("note") String note
                                       ) {
        Map<String ,Object> map = new HashMap<>(10);
        map.put("pageNum",pageNum);
        map.put("pageSize",pageSize);
        map.put("name",name);
        map.put("note",note);
//        map.put("note2",note2);
        return ResultGenerator.genSuccessResult(productOfferService.findProductOfferNote(map));
    }

}

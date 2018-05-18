package com.nainai.smallprogram.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nainai.smallprogram.common.Result;
import com.nainai.smallprogram.common.ResultGenerator;
import com.nainai.smallprogram.service.OrderSellService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by haopeng yan on 2018/5/4
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@RestController
@RequestMapping("ordersell")
public class OrderSellController {
    @Autowired
    private OrderSellService orderSellService;

    /**
     * 查询订单列表详情
     * @param pageNum
     * @param pageSize
     * @param id
     * @param offerId
     * @return
     */
    @ApiOperation(value = "查询订单列表详情", notes = "查询订单列表详情")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageNum", value = "pageNum", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageSize", value = "pageSize", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "id", value = "订单id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "offerId", value = "报盘id", required = true)
    })
    @RequestMapping(value = "/findorderSell", method = RequestMethod.GET)
    public Result findorderSell(@RequestParam("pageNum") Integer pageNum,
                                       @RequestParam("pageSize") Integer pageSize,
                                       @RequestParam("id") Integer id,
                                       @RequestParam("offerId") Integer offerId) {
        Map<String, Object> map = new HashMap<>(10);
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        map.put("id", id);
        map.put("offerId", offerId);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        return ResultGenerator.genSuccessResult(orderSellService.findorderSell(map));
    }

    /**
     *
     * @param pageNum
     * @param pageSize
     * @param id
     * @param termporaryName
     * @return
     */
    @ApiOperation(value = "查询订单列表详情", notes = "查询订单列表详情")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageNum", value = "pageNum", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageSize", value = "pageSize", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "id", value = "订单id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "offerId", value = "报盘id", required = true)
    })
    @RequestMapping(value = "/findorderSellNew", method = RequestMethod.GET)
    public Result findorderSellNew(@RequestParam("pageNum") Integer pageNum,
                                @RequestParam("pageSize") Integer pageSize,
                                @RequestParam("id") Integer id,
                                @RequestParam("termporaryName") String termporaryName) {
        Map<String, Object> map = new HashMap<>(10);
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        map.put("id", id);
        map.put("termporaryName", termporaryName);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        return ResultGenerator.genSuccessResult(orderSellService.findorderSellNew(map));
    }
    /**
     * 新增订单
     * @param jsonArray
     * @return
     */
    @ApiOperation(value = "新增订单", notes = "新增订单")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "JSONArray", name = "id,userId,num", value = "报盘id，用户id，购买数量", required = true)
    })
    @RequestMapping(value = "/addorderSell", method = RequestMethod.PUT)
    public Result addorderSell(@RequestBody JSONArray jsonArray){


        List<Map<String, Object>> list = new ArrayList<>(1);
        if(jsonArray.size()>0){
            for(int i=0;i<jsonArray.size();i++){
                Map<String ,Object> map = new HashMap<>(2);
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                map.put("id",jsonObject.getInteger("id"));
                map.put("openId",jsonObject.getFloat("openId"));
                map.put("num",jsonObject.getFloat("num"));
                list.add(map);
            }
        }

        return ResultGenerator.genSuccessResult(orderSellService.addorderSell(jsonArray));
    }


}

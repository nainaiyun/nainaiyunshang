package com.nainai.smallprogram.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nainai.smallprogram.mapper.OrderSellMapper;
import com.nainai.smallprogram.service.OrderSellService;
import com.netflix.client.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by haopeng yan on 2018/5/4
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@Service("orderSellService")
public class OrderSellServiceImpl implements OrderSellService {

    @Autowired
    private OrderSellMapper orderSellMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public JSONObject findorderSell(Map map) {
        JSONObject jsonObject = new JSONObject();
        if (map.get("pageNum") == null && map.get("pageSize") == null) {
            jsonObject.put("data", "数据太多请分页");
            return jsonObject;
        }
        Integer pageNum = (Integer) map.get("pageNum");
        Integer pageSize = (Integer) map.get("pageSize");
        Page page = PageHelper.startPage(pageNum, pageSize);
        Optional<List<Map<String, Object>>> optionalMapList = Optional.ofNullable(orderSellMapper.findOrderSell(map));
        optionalMapList.ifPresent(e -> jsonObject.put("a",e));
        Integer count = Integer.parseInt(String.valueOf(page.getTotal()));
        Integer size = page.size();
        jsonObject.put("count", count);
        jsonObject.put("size", size);
        return jsonObject;
    }

    @Override
    public JSONObject findorderSellNew(Map map) {
        JSONObject jsonObject = new JSONObject();
        if (map.get("pageNum") == null && map.get("pageSize") == null) {
            jsonObject.put("data", "数据太多请分页");
            return jsonObject;
        }
        Integer pageNum = (Integer) map.get("pageNum");
        Integer pageSize = (Integer) map.get("pageSize");
        String termporaryName = (String) map.get("termporaryName");
        Page page = PageHelper.startPage(pageNum, pageSize);
        Optional<List<Map<String, Object>>> optionalMapList = Optional.ofNullable(orderSellMapper.findOrderSellNew(termporaryName));
        optionalMapList.ifPresent(e -> jsonObject.put("a",e));
        Integer count = Integer.parseInt(String.valueOf(page.getTotal()));
        Integer size = page.size();
        jsonObject.put("count", count);
        jsonObject.put("size", size);
        return jsonObject;
    }

    @Override
    public JSONObject addorderSell(JSONArray jsonArray) {
        String url = "http://ceshi.nainaiwang.com/java/createorder";
        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        String requestJson = jsonArray.toJSONString();
        HttpEntity<String> entity = new HttpEntity<>(requestJson,headers);
        String result = restTemplate.postForObject(url, entity, String.class);
        System.out.println(result);
        JSONObject jsonObject = JSONObject.parseObject(result);
        return jsonObject;
    }
}

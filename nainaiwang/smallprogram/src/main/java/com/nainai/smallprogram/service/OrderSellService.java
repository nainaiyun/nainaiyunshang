package com.nainai.smallprogram.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

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
public interface OrderSellService {

    JSONObject findorderSell(Map map);

    JSONObject findorderSellNew(Map map);

    JSONObject addorderSell(JSONArray jsonArray);
}

package com.nainai.smallprogram.service;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * Created by haopeng yan on 2018/4/27
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
public interface ProductsService {

    JSONObject findProductsPhotos(Map<String,Object> map);
}

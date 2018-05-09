package com.nainai.smallprogram.service;

import com.alibaba.fastjson.JSONObject;
import com.nainai.smallprogram.domain.ProductCategory;

import java.util.Map;

/**
 * Created by haopeng yan on 2018/4/25
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
public interface ProductCategoryService {
    JSONObject deleteByPrimaryKey(Integer id);

    JSONObject insert(ProductCategory productCategory);

    JSONObject insertSelective(ProductCategory productCategory);

    ProductCategory selectByPrimaryKey(Integer id);

    JSONObject updateByPrimaryKeySelective(ProductCategory productCategory);

    JSONObject updateByPrimaryKey(ProductCategory productCategory);

    JSONObject findProductCategory(Map<String,Object> map);
}

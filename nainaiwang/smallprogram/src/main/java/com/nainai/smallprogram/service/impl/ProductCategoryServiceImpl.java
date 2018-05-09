package com.nainai.smallprogram.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.nainai.smallprogram.domain.ProductCategory;
import com.nainai.smallprogram.domain.ProductOffer;
import com.nainai.smallprogram.mapper.ProductCategoryMapper;
import com.nainai.smallprogram.mapper.ProductOfferMapper;
import com.nainai.smallprogram.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by haopeng yan on 2018/4/25
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@Service("productCategoryService")
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryMapper productCategoryMapper;
    @Override
    public JSONObject deleteByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public JSONObject insert(ProductCategory productCategory) {
        return null;
    }

    @Override
    public JSONObject insertSelective(ProductCategory productCategory) {
        return null;
    }

    @Override
    public ProductCategory selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public JSONObject updateByPrimaryKeySelective(ProductCategory productCategory) {
        return null;
    }

    @Override
    public JSONObject updateByPrimaryKey(ProductCategory productCategory) {
        return null;
    }

    @Override
    public JSONObject findProductCategory(Map<String ,Object> map) {
        JSONObject jsonObject = new JSONObject();
        Optional<List<ProductCategory>> optional = Optional.ofNullable(productCategoryMapper.findProductCategory(map));
        optional.ifPresent(e -> jsonObject.put("productCategory", e));
        return jsonObject;
    }
}

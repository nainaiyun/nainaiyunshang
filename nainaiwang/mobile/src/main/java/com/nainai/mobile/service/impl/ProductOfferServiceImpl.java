package com.nainai.mobile.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.nainai.mobile.domain.ProductOffer;
import com.nainai.mobile.mapper.ProductOfferMapper;
import com.nainai.mobile.service.ProductOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by haopeng yan on 2018/4/19
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@Service("productOfferService")
public class ProductOfferServiceImpl implements ProductOfferService {
    @Autowired
    private ProductOfferMapper productOfferMapper;

    @Override
    public JSONObject deleteByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public JSONObject insert(ProductOffer record) {
        return null;
    }

    @Override
    public JSONObject insertSelective(ProductOffer record) {

        return null;
    }

    @Override
    public JSONObject selectByPrimaryKey(Integer id) {
        JSONObject jsonObject = new JSONObject();
        PageHelper.startPage(1, 10);
        Optional<ProductOffer> optional = Optional.ofNullable(productOfferMapper.selectByPrimaryKey(id));
        optional.ifPresent(e -> jsonObject.put("productOffer", e));
        long count = PageHelper.count(() -> productOfferMapper.selectByPrimaryKey(id));
        jsonObject.put("count", count);
        return jsonObject;
    }

    @Override
    public JSONObject updateByPrimaryKeySelective(ProductOffer record) {
        return null;
    }

    @Override
    public JSONObject updateByPrimaryKey(ProductOffer record) {
        return null;
    }

    @Override
    public JSONObject selectAllProductOffer(Integer pageNum, Integer pageSize) {
        JSONObject jsonObject = new JSONObject();
//        PageHelper.startPage(pageNum, pageSize);
//        Optional<List<ProductOffer>> optional = Optional.ofNullable(productOfferMapper.selectAllProductOffer());
//        optional.ifPresent(e -> jsonObject.put("productOffer", e));
//        long count = PageHelper.count(() -> productOfferMapper.selectAllProductOffer());
//        jsonObject.put("count", count);
        return jsonObject;
    }
}

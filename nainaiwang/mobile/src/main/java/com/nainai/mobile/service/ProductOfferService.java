package com.nainai.mobile.service;

import com.alibaba.fastjson.JSONObject;
import com.nainai.mobile.domain.ProductOffer;

/**
 * Created by haopeng yan on 2018/4/19
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */

public interface ProductOfferService {

    JSONObject deleteByPrimaryKey(Integer id);

    JSONObject insert(ProductOffer record);

    JSONObject insertSelective(ProductOffer record);

    JSONObject selectByPrimaryKey(Integer id);

    JSONObject updateByPrimaryKeySelective(ProductOffer record);

    JSONObject updateByPrimaryKey(ProductOffer record);

    JSONObject selectAllProductOffer(Integer pageNum, Integer pageSize);
}

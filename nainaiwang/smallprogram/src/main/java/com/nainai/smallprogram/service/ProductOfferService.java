package com.nainai.smallprogram.service;

import com.alibaba.fastjson.JSONObject;
import com.nainai.smallprogram.domain.ProductAttribute;
import com.nainai.smallprogram.domain.ProductOffer;

import java.util.List;
import java.util.Map;

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

    JSONObject selectAllByProductName(Integer pageNum, Integer pageSize,String productName);

    JSONObject findProductOffer(Map<String,Object> map);

    JSONObject findProductOfferDetails(Map<String,Object> map);

    JSONObject findProductOfferStatistics(Map<String,Object> map);

    JSONObject findProductOfferStatisticsNew(Map<String,Object> map);

    JSONObject findProductAttribute (String attrJson);

    JSONObject findProductOfferNote(Map<String, Object> map);

}

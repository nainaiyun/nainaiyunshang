package com.nainai.smallprogram.service;

import com.alibaba.fastjson.JSONObject;
import com.nainai.smallprogram.domain.Slide;

import java.util.Map;

/**
 * Created by haopeng yan on 2018/4/25
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
public interface SlideService {
    JSONObject deleteByPrimaryKey(Integer id);

    JSONObject insert(Slide record);

    JSONObject insertSelective(Slide record);

    JSONObject selectByPrimaryKey(Integer id);

    JSONObject updateByPrimaryKeySelective(Slide record);

    JSONObject updateByPrimaryKey(Slide record);

    JSONObject findSlide(Map<String ,Object> map);

}

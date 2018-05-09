package com.nainai.smallprogram.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.nainai.smallprogram.common.Constant;
import com.nainai.smallprogram.domain.Slide;
import com.nainai.smallprogram.mapper.SlideMapper;
import com.nainai.smallprogram.service.SlideService;
import com.nainai.smallprogram.util.ImgUtil;
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
@Service("slideService")
public class SlideServiceImpl implements SlideService {

    @Autowired
    private SlideMapper slideMapper;

    @Override
    public JSONObject deleteByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public JSONObject insert(Slide record) {
        return null;
    }

    @Override
    public JSONObject insertSelective(Slide record) {
        return null;
    }

    @Override
    public JSONObject selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public JSONObject updateByPrimaryKeySelective(Slide record) {
        return null;
    }

    @Override
    public JSONObject updateByPrimaryKey(Slide record) {
        return null;
    }

    @Override
    public JSONObject findSlide(Map<String, Object> map) {
        JSONObject jsonObject = new JSONObject();
        Optional<List<Slide>> optional = Optional.ofNullable(slideMapper.findSlide(map));
        optional.ifPresent(e -> {
                    for (Slide slide : e) {
                        String oldImg = slide.getImg();
                        String newImg = ImgUtil.oldImgTo(oldImg);
                        System.out.println(newImg);
                        slide.setImg(newImg);
                    }
                    jsonObject.put("slide", e);
                }
        );
        return jsonObject;
    }

}

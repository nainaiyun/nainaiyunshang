package com.nainai.smallprogram.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.nainai.smallprogram.common.Constant;
import com.nainai.smallprogram.mapper.ProductsMapper;
import com.nainai.smallprogram.service.ProductsService;
import com.nainai.smallprogram.util.ImgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by haopeng yan on 2018/4/27
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@Service("productsService")
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    private ProductsMapper productsMapper;

    @Override
    public JSONObject findProductsPhotos(Map<String, Object> map) {
        JSONObject jsonObject = new JSONObject();
        Optional<List<Map<String, Object>>> optional = Optional.ofNullable(productsMapper.findProductsPhotos(map));
        optional.ifPresent(e -> {
            for (Map map1 : e) {
                String oldImg = (String) map1.get("photosImg");
                String newImg = ImgUtil.oldImgTo(oldImg);
                System.out.println(newImg);
                map1.put("photosImg", newImg);
            }
            jsonObject.put("productOffer", e);
        });
        return jsonObject;
    }
}

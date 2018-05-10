package com.nainai.smallprogram.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nainai.smallprogram.common.Enum;
import com.nainai.smallprogram.domain.ProductAttribute;
import com.nainai.smallprogram.domain.ProductOffer;
import com.nainai.smallprogram.mapper.OrderSellMapper;
import com.nainai.smallprogram.mapper.ProductAttributeMapper;
import com.nainai.smallprogram.mapper.ProductOfferMapper;
import com.nainai.smallprogram.mapper.ProductsMapper;
import com.nainai.smallprogram.service.ProductOfferService;
import com.nainai.smallprogram.util.ImgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

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

    @Autowired
    private ProductsMapper productsMapper;

    @Autowired
    private ProductAttributeMapper productAttributeMapper;

    @Autowired
    private OrderSellMapper orderSellMapper;

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
        return null;
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
    public JSONObject selectAllByProductName(Integer pageNum, Integer pageSize, String productName) {
        return null;
    }

    @Override
    public JSONObject findProductOffer(Map<String, Object> map) {
        JSONObject jsonObject = new JSONObject();
        Optional<List<Map<String, Object>>> optional = null;
        if (map.get("pageNum") != null && map.get("pageSize") != null) {
            Integer pageNum = (Integer) map.get("pageNum");
            Integer pageSize = (Integer) map.get("pageSize");
            Page page = PageHelper.startPage(pageNum, pageSize);
            optional = Optional.ofNullable(productOfferMapper.findProductOffer(map));
            Integer count = Integer.parseInt(String.valueOf(page.getTotal()));
            Integer size = page.size();
            jsonObject.put("count", count);
            jsonObject.put("size", size);
        } else {
            optional = Optional.ofNullable(productOfferMapper.findProductOffer(map));
        }
        optional.ifPresent(e -> {
            for (Map map1 : e) {
                if (map1.get("img") != null) {
                    String oldImg = (String) map1.get("img");
                    String newImg = ImgUtil.oldImgTo(oldImg);
                    System.out.println(newImg);
                    map1.put("img", newImg);
                }
            }
            jsonObject.put("productOffer", e);
        });
        return jsonObject;
    }


    /**
     * 查询报盘详情
     * @param map
     * @return
     */
    @Override
    public JSONObject findProductOfferDetails(Map<String, Object> map) {
        JSONObject jsonObject = new JSONObject();
        if (map.get("id") == null) {
            return jsonObject;
        }
        Integer id = (Integer) map.get("id");
        Optional<Map<String, Object>> optionalStringObjectMap = Optional.ofNullable(productOfferMapper.findProductOfferDetails(id));
        optionalStringObjectMap.ifPresent(e -> {
            String oldImg = (String) e.get("img");
            String newImg = ImgUtil.oldImgTo(oldImg);
            e.put("img", newImg);


            Integer type = (Integer) e.get("type");
            if (type != null) {
                if (type == 1) {
                    e.put("type", Enum.getName(1));
                } else {
                    e.put("type", Enum.getName(2));
                }
            }
            Integer mode = (Integer) e.get("mode");


            jsonObject.put("productOffer", e);

            /**查询商品属性*/
            String attrJson = (String) e.get("attrJson");
            JSONObject list =findProductAttribute(attrJson);
            jsonObject.put("productAttribute", list);

            /**查询商品图片*/
            Map mapProductId = new HashMap(2);
            Integer proId = (Integer) e.get("productId");
            if (proId != null) {
                mapProductId.put("productId", e.get("productId"));
                Optional<List<Map<String, Object>>> optionalMaps = Optional.ofNullable(productsMapper.findProductsPhotos(mapProductId));
                optionalMaps.ifPresent(f -> {
                    for (Map imgMap : f) {
                        String oldImg2 = (String) imgMap.get("photosImg");
                        String newImg2 = ImgUtil.oldImgTo(oldImg2);
                        imgMap.put("photosImg", newImg2);
                    }
                    jsonObject.put("ProductsPhotos", f);
                });
            }

        });
        return jsonObject;
    }

    /**
     * 查询大盘列表
     * @param map
     * @return
     */
    @Override
    public JSONObject findProductOfferStatistics(Map<String, Object> map) {
        JSONObject jsonObject = new JSONObject();
        if (map.get("pageNum") == null && map.get("pageSize") == null) {
            jsonObject.put("data", "数据太多请分页");
            return jsonObject;
        }
        Integer pageNum = (Integer) map.get("pageNum");
        Integer pageSize = (Integer) map.get("pageSize");
        Page page = PageHelper.startPage(pageNum, pageSize);
        Optional<List<Map<String, Object>>> optionalStringObjectMap = Optional.ofNullable(productOfferMapper.findProductOfferStatistics());
        Integer count = Integer.parseInt(String.valueOf(page.getTotal()));
        Integer size = page.size();
        jsonObject.put("count", count);
        jsonObject.put("size", size);

        List list = new ArrayList();
        optionalStringObjectMap.ifPresent(e -> {

            for (Map item : e) {
                /**查询商品属性*/
                String attrJson = (String) item.get("attrJson");
                JSONObject attrJsons =findProductAttribute(attrJson);
                item.put("productAttribute",attrJsons);

                /**查询与上一笔订单的差价*/
                Integer id = (Integer) item.get("offerId");
                Map map1 = new HashMap(2);
                map1.put("limit",2);
                map1.put("offerId", id);
                Optional<List<Map<String, Object>>> optionalMapList = Optional.ofNullable(orderSellMapper.findOrderSell(map1));
                optionalMapList.ifPresent(g -> {
                    BigDecimal disparity = new BigDecimal(Double.toString(0.00));
                    BigDecimal amount1 = (BigDecimal) g.get(0).get("amount");
                    if (g.size() == 2) {
                        BigDecimal amount2 = (BigDecimal) g.get(1).get("amount");
                        disparity = amount1.subtract(amount2);
                    } else if (g.size() == 1) {
                        disparity = amount1;
                    }
                    System.out.println("差价为：" + disparity);
                    item.put("disparity", disparity);
                });

                list.add(item);
            }
            jsonObject.put("list", list);
        });
        return jsonObject;
    }


    @Override
    public  JSONObject findProductAttribute (String attrJson){
        if (attrJson != null && attrJson.length() > 0) {
            JSONObject jsonObject1 = JSONObject.parseObject(attrJson);
            Map<String, Object> mapS = jsonObject1;
            LinkedHashMap<String, Integer> mapI = new LinkedHashMap<>(10);
            for (Map.Entry<String, Object> entry : mapS.entrySet()) {
                System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
                mapI.put(entry.getKey(), Integer.parseInt(entry.getKey()));
            }

            JSONObject jsonObject = new JSONObject();
            Optional<List<ProductAttribute>> optionalProductAttributes = Optional.ofNullable(productAttributeMapper.findProductAttributeById(mapI));
            optionalProductAttributes.ifPresent(g -> {
                for (ProductAttribute entry : g) {
                    for (Map.Entry<String, Object> item : mapS.entrySet()) {
                        if ((entry.getId().toString().equals(item.getKey()))) {
                            entry.setValue((String) item.getValue());
                        }
                    }
                }
                jsonObject.put("attributes",g);

            });
            return jsonObject;
        }
        return null;
    }


}


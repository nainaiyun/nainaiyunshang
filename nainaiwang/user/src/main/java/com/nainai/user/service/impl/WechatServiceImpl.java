package com.nainai.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.nainai.user.domain.User;
import com.nainai.user.mapper.UserMapper;
import com.nainai.user.service.WechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by haopeng yan on 2018/5/12
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@Service()
public class WechatServiceImpl implements WechatService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserMapper userMapper;

    @Override
    public JSONObject jscode2session(String jsCode,String session) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?" +
                "appid={appid}" +
                "&secret={secret}" +
                "&js_code={js_code}" +
                "&grant_type={grant_type}";
        Map<String, Object> uriVariables = new HashMap<>(4);
        uriVariables.put("appid", "wx8c77ee57a9939207");
        uriVariables.put("secret", "3de40b7c082f97f442a8ea4f0c211d56");
        uriVariables.put("js_code", jsCode);
        uriVariables.put("grant_type", "authorization_code");
        String result = restTemplate.getForObject(url, String.class,uriVariables );
        System.out.println(result);
        JSONObject jsonObject = JSONObject.parseObject(result);
        String openId = jsonObject.getString("openid");

        Optional<User> optional = Optional.ofNullable(userMapper.selectUserByOpenId(openId));
        optional.ifPresent(e->jsonObject.put("user",e));
        jsonObject.put("sessionId",session);
        return jsonObject;
    }
}

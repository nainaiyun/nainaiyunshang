package com.nainai.user.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by haopeng yan on 2018/5/12
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
public interface WechatService {
    JSONObject jscode2session(String jsCode,String session);
}

package com.nainai.user.service;

import com.alibaba.fastjson.JSONObject;
import com.nainai.user.domain.User;

/**
 * Created by haopeng yan on 2018/4/11
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
public interface UserService {

    int insertUser(User user);

    int updateUserIdSelective(User user);

    int deleteUserId(Integer id);

    JSONObject selectUserId(Integer id);

}

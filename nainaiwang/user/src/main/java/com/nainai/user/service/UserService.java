package com.nainai.user.service;

import com.alibaba.fastjson.JSONObject;
import com.nainai.user.domain.User;

import javax.jws.soap.SOAPBinding;
import java.util.Map;

/**
 * Created by haopeng yan on 2018/4/11
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. nainai All Rights Received
 */
public interface UserService {

    int deleteByPrimaryKey(Integer id);

    int insert(User user);

    int insertSelective(User user);

    User selectByPrimaryKey();

    int updateByPrimaryKeySelective(User user);

    int updateByPrimaryKey(User user);

    User selectUserByUserName(String username);

    JSONObject selectUserId(Integer id);

    JSONObject bindingUser (String mobile,String code,String openId);

}

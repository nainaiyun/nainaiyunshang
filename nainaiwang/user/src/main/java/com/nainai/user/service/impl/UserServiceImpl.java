package com.nainai.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.nainai.user.domain.User;
import com.nainai.user.mapper.UserMapper;
import com.nainai.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by haopeng yan on 2018/4/11
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. nainai All Rights Received
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int insertSelective(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public User selectByPrimaryKey() {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int updateByPrimaryKey(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public User selectUserByUserName(String username) {
        User user = userMapper.selectUserByUserName(username);
        return user;
    }

    @Override
    public JSONObject selectUserId(Integer id) {

        JSONObject userJsonObject = new JSONObject();
        Optional<User> user = Optional.ofNullable(userMapper.selectByPrimaryKey(id));
        user.ifPresent(e -> userJsonObject.put("user", e));
        return userJsonObject;
    }

    @Override
    public JSONObject bindingUser(String mobile, String code,String openId) {
        JSONObject jsonObject = new JSONObject();
        Optional<User> optionalUser = Optional.ofNullable(userMapper.selectUserByMobile(mobile));
        optionalUser.ifPresent(e -> {
            Integer id =e.getId();
            if (id!=null){
                User user = new User();
                System.out.println(id);
                user.setId(id);
                user.setOpenId(openId);
                int num =userMapper.updateByPrimaryKeySelective(user);
                jsonObject.put("date",id);
                jsonObject.put("status",num);
            }else {
                jsonObject.put("date",0);
            }
        });
        if (!optionalUser.isPresent()){
            jsonObject.put("date","该手机号码未注册");
        }
        return jsonObject;
    }
}

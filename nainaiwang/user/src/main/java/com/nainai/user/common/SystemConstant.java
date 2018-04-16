package com.nainai.user.common;

/**
 * Created by haopeng yan on 2018/4/11
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
public class SystemConstant {
    /**
     * token
     */
    public static final int RESCODE_REFTOKEN_MSG = 1006;		//刷新TOKEN(有返回数据)
    public static final int RESCODE_REFTOKEN = 1007;			//刷新TOKEN

    public static final int JWT_ERRCODE_NULL = 4000;			//Token不存在
    public static final int JWT_ERRCODE_EXPIRE = 4001;			//Token过期
    public static final int JWT_ERRCODE_FAIL = 4002;			//验证不通过

    /**
     * JWT
     */
    public static final String JWT_SECERT = "8677df7fc3a34e26a61c034d5ec8245d";			//密匙
    public static final long JWT_TTL = 60  * 1000;
}

package com.nainai.smallprogram.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nainai.smallprogram.common.Constant;

/**
 * Created by haopeng yan on 2018/4/27
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
public class ImgUtil {
    /**
     *
     * @param oldImg
     * @return
     */
    public static String oldImgTo(String oldImg) {
        if (oldImg!=null&&oldImg.length()>Constant.IMG_LENGTH){
            String str = oldImg.substring(oldImg.indexOf("@"), oldImg.length());
            String str2 = oldImg.substring(0, oldImg.indexOf("@"));
            if (Constant.CESHI_USER_IMG_O.equals(str)) {
                return Constant.CESHI_USER_IMG + str2;
            } else if (Constant.CESHI_ADMIN_IMG_O.equals(str)) {
                return Constant.CESHI_ADMIN_IMG + str2;
            } else if (Constant.CESHI_DEAL_IMG_O.equals(str)) {
                return Constant.CESHI_DEAL_IMG + str2;
            } else {
                return "";
            }
        }
        return "";

    }
}

package com.nainai.user.util;

import com.netflix.discovery.util.SystemUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by haopeng yan on 2018/5/11
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
public class SmsCodeUtil {
    public static final String POST_URL = "http://www.jianzhou.sh.cn/JianzhouSMSWSServer/http/sendBatchMessage";

    public static String readContentFromPost(String news,String destmobile,String code) throws IOException {
        // Post请求的url，与get不同的是不需要带参数
        URL postUrl = new URL(POST_URL);
        // 打开连接
        HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
        // 设置是否向connection输出，因为这个是post请求，参数要放在
        // http正文内，因此需要设为true
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        // Post 请求不能使用缓存
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
        // 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
        // 意思是正文是urlencoded编码过的form参数，下面我们可以看到我们对正文内容使用URLEncoder.encode
        // 进行编码
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        // 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
        // 要注意的是connection.getOutputStream会隐含的进行connect。
        connection.connect();
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        // The URL-encoded contend

        //下面为http发送短信模式--------
        String content = "account=" + "sdk_nnyskj" + "&" + "password=" + "nnys882#8k%26(npu" + "&" + "sendDateTime=" + "" + "&" + "destmobile=" + destmobile + "&"
                + "msgText=" + URLEncoder.encode(news+"验证码："+code+"【耐耐云商】", "UTF-8");

        System.out.println(content);
        out.writeBytes(content);

        out.flush();
        out.close(); // flush and close
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        String str = "";
        System.out.println("Contents of post request");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            str=line;
        }
        System.out.println("Contents of post request ends");
        reader.close();
        connection.disconnect();

        return str;
    }
}

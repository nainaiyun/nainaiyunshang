package com.nainai.smallprogram.configurer;

import com.nainai.smallprogram.aspect.CorsInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by haopeng yan on 2018/4/24
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@Configuration
@JsonComponent
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Autowired
    private CorsInterceptor corsInterceptor;
    /**
     * 跨域
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(corsInterceptor);
    }

}

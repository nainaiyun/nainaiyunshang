package com.nainai.smallprogram;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableEurekaClient
@ServletComponentScan("com.nainai.smallprogram.configurer")
@ImportResource(locations = { "classpath:druid-bean.xml" })
public class SmallprogramApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmallprogramApplication.class, args);
	}
}

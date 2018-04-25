package com.nainai.smallprogram;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication


@ServletComponentScan("com.nainai.smallprogram.configurer")
public class SmallprogramApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmallprogramApplication.class, args);
	}
}

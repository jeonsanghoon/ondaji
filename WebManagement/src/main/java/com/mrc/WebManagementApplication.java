package com.mrc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@ComponentScan
@MapperScan(basePackages = "com.mrc")
@EnableAutoConfiguration
public class WebManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebManagementApplication.class, args);
	}

}

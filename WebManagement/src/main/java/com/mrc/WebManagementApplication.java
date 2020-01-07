package com.mrc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootConfiguration
@SpringBootApplication
@ComponentScan
@EnableAspectJAutoProxy
@MapperScan(basePackages = "com.mrc")
@EnableAutoConfiguration
public class WebManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebManagementApplication.class, args);
	}
}

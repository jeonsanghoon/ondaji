package com.altsoft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@ComponentScan
@MapperScan(basePackages = "com.altsoft")
@EnableAutoConfiguration
public class OndajiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OndajiApplication.class, args);
	}

}

package com.altsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@ComponentScan
@EnableAutoConfiguration
public class OndajiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OndajiApplication.class, args);
	}

}

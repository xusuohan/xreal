package com.xreal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class XrealApplication {

	public static void main(String[] args) {
		SpringApplication.run(XrealApplication.class, args);
	}
}

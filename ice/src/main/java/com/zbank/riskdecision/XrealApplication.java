package com.zbank.riskdecision;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class XrealApplication {
	public static void main(String[] args) {
		System.out.println("Init Spring Boot ...");
		SpringApplication.run(XrealApplication.class, args);
	}
}

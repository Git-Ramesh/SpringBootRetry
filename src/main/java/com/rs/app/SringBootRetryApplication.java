package com.rs.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class SringBootRetryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SringBootRetryApplication.class, args);
	}
}

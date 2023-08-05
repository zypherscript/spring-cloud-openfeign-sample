package com.example.openfeignsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OpenfeignSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenfeignSampleApplication.class, args);
	}

}

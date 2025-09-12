package com.epam.techtalk.taskmanager;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TechtalkApplication {

	private static final Logger logger = LoggerFactory.getLogger(TechtalkApplication.class);

	public static void main(String[] args) {
		// Define the logger
		logger.info("TechtalkApplication started");


		SpringApplication.run(TechtalkApplication.class, args);


		logger.warn("Application finished with warnings.");
	}

}

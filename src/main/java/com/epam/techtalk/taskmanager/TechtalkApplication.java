package com.epam.techtalk.taskmanager;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TechtalkApplication {

	private static final Logger logger = LoggerFactory.getLogger(TechtalkApplication.class);

	public static void main(String[] args) {
		// Define the logger
		logger.info("TechtalkApplication started");


		SpringApplication.run(TechtalkApplication.class, args);

		/*try {
			int result = divide(4, 0);
			logger.debug("Division result: {}", result);
		} catch (Exception e) {
			logger.error("An error occurred: {}", e.getMessage(), e);
		}*/

		logger.warn("Application finished with warnings.");
	}

	public static int divide(int a, int b) {
		return a / b; // This will throw an ArithmeticException when b=0
	}

}

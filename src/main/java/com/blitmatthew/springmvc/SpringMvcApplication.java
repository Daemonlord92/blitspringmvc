package com.blitmatthew.springmvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@ComponentScan
//@EnableAutoConfiguration
//@Configuration
@SpringBootApplication
public class SpringMvcApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringMvcApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
		System.out.println("Hello");
		logger.info("Hello, Logger!");
		logger.error("An Error has Occurred");
		logger.warn("Waring happening!");
		logger.trace("trace");
		logger.debug("Debug");
	}

}

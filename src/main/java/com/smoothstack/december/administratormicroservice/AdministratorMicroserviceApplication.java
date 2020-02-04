package com.smoothstack.december.administratormicroservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdministratorMicroserviceApplication implements ApplicationRunner {
	private static final Logger logger = LogManager.getLogger(AdministratorMicroserviceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AdministratorMicroserviceApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		logger.info("Administrator service starting with logger...");
	}

}

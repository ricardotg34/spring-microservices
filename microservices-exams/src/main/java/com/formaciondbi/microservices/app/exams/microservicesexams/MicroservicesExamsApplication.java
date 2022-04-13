package com.formaciondbi.microservices.app.exams.microservicesexams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.formaciondbi.microservices.app.commons.commons.models.entity"})
public class MicroservicesExamsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesExamsApplication.class, args);
	}

}

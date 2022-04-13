package com.formaciondbi.microservices.app.cursos.microservicescursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({
	"com.formaciondbi.microservices.app.commons.commons.models.entity"
})
public class MicroservicesCursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesCursosApplication.class, args);
	}

}

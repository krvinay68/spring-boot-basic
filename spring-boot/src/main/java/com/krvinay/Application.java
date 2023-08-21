package com.krvinay;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot REST API Documentation",
				description = "Spring Boot REST API Documentation",
				version = "v1.0",
				contact = @Contact(
						name="vinay",
						email = "developer.vinay@gmail.com",
						url="http://localhost:8080"
				),
				license = @License(
						name = "vinay 1.0",
						url = "http://localhost:8080"
				)
				
		),
		externalDocs = @ExternalDocumentation(
							description = "Spring Boot Movie Management doc",
							url = "http://localhost:8080"
				)
)
public class Application {

	//This is for ModdelMapprer cofiguration
	@Bean
	 ModelMapper modelMapper() {
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

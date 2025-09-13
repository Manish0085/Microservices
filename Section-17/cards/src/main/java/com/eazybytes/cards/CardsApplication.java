package com.eazybytes.cards;

import com.eazybytes.cards.dto.CardsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*
@ComponentScan({ @ComponentScan("com.eazybytes.cards.controller") })
@EnableJpaRepository("com.eazybytes.cards.repository")
@EntityScan("com.eazybytes.cards.entity")
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = CardsContactInfoDto.class)
@OpenAPIDefinition(
		info = @Info(
				title = "Cards MicroService REST API Documentation",
				description = "Eazy Bank Cards MicroService Rest Api Documentation",
				version = "v1",
				contact = @Contact(
						name = "Manish Kumar",
						email = "manishk1309@gmail.com",
						url = "http://www.eazybytes.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "http://www.eazybytes.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Eazy Bank Cards microservice REST API Documentation",
				url = "http://www.eazybytes.com/swagger-ui.html"
		)
)
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

}

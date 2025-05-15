package com.eazybytes.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "A Basic project to learn microservices",
				description = "Learning how to document our project",
				version = "v1",
				contact = @Contact(
						name = "abc",
						email = "abc123@gmail.com",
						url = "https://www.xyz.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.xyz.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Know more about the apies",
				url = "https://doc.com"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}

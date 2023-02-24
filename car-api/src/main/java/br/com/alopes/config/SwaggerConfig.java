package br.com.alopes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenApi() {
		return new OpenAPI()
		        .info(new Info()
		                .title("Web Service de Integração Portal Car")
		                .version("v1")
		                .description("Este documento tem por finalidade documentar a utilização do Web Service de Integração\r\n"
		                		+ "Portal Car. As informações aqui apresentadas, serão úteis durante o desenvolvimento de aplicações que\r\n"
		                		+ "utilizem o Web Service Integração como fonte de informações.")
		                .termsOfService("http://swagger.io/terms/")
		                .license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}
}

package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo"))
				.build()
				.apiInfo(getApiInfo());
	}
	
	private ApiInfo getApiInfo() {
		return new  ApiInfoBuilder()
				.title("The Coffee House Application")
				.description("TCH for education purpose.")
				.contact(new Contact("Vo Hoang Nhat", "nhatvh.work@gmail.com", "nhatvo"))
				.license("MIT2")
				.build();
	}
	
	/*
	 * private ApiKey apiKey() { return new ApiKey("JWT", "Authorization",
	 * "header"); }
	 * 
	 * private SecurityContext securityContext() { return SecurityContext.builder()
	 * .securityReferences(securityReferences()) .build(); }
	 */
	/*
	 * private List<SecurityReference> securityReferences(){ AuthorizationScope
	 * authorizationScope = new AuthorizationScope("global",
	 * "All application can access"); AuthorizationScope[] authorizationScopes = new
	 * AuthorizationScope[1]; authorizationScopes[0] = authorizationScope; return
	 * Arrays.asList(new SecurityReference("JWT", authorizationScopes)); }
	 */
}

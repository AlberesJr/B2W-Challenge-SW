package com.b2w.challenge.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_12)
				.ignoredParameterTypes(Pageable.class)
				.select()
				.apis(basePackage("com.b2w.challenge"))
				.build()
				.apiInfo(metaData());    }

    private ApiInfo metaData() {

    	return new ApiInfoBuilder()
                .title("B2W API")
                .description("Spring Boot REST API")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .contact(new Contact(
                		"Alberes Junior", 
                		"https://github.com/AlberesJr/B2W-Challenge-SW",
                		"alberesjr22@gmail.com"))
                .build();
    }

}
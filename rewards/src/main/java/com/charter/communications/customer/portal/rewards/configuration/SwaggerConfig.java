//package com.charter.communications.customer.portal.rewards.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.oas.annotations.EnableOpenApi;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//@Configuration
//@EnableOpenApi
//public class SwaggerConfig {
//
//    @Bean
//    Docket api() {
//        return new Docket(DocumentationType.OAS_30)
//		.apiInfo(new ApiInfoBuilder()
//	    	.title("MyApp Rest APIs")
//	    	.description("APIs for MyApp.")
//	    	.version("1.0")
//	    	.termsOfServiceUrl("")
//	    	.contact(null)
//	    	.license("License of API")
//	    	.licenseUrl("API license URL")
//	    	.build()
//    	)
//        .select()
//        .apis(RequestHandlerSelectors.any())
//        .paths(PathSelectors.any())
//        .build();
//    }
//}
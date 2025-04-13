package com.employeeinform.employeewebflux.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

 @Bean
 public OpenAPI costomOpenAPI(){

     return new OpenAPI()
             .info(new Info()
                     .title("employee webflux Reactive APIs")
                     .version("1.0")
                     .description("Reactiv programming APIs")
                     .license(new License().name("Licensed..1.0")));
 }

}

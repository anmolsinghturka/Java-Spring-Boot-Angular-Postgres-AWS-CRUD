package com.bezkoder.spring.jpa.postgresql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "com.bezkoder.spring.jpa.postgresql.controller" })
public class SpringBootJpaPostgresqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaPostgresqlApplication.class, args);
    }

    @Configuration
    @EnableSwagger2
    public class SwaggerConfig {

        @Bean
        public Docket api() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.bezkoder.spring.jpa.postgresql.controller"))
                    .paths(PathSelectors.any())
                    .build()
                    .apiInfo(apiInfo());
        }

        private ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    .title("Spring Boot API By Anmol Singh")
                    .description("To document CRUD Operations")
                    .version("1.0.0")
                    .build();
        }
    }

}

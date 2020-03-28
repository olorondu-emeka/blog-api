package com.emeka.blogspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableJpaAuditing
@EnableSwagger2
public class BlogSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogSpringBootApplication.class, args);
    }

    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
//                .paths(PathSelectors.ant("/api/*"))
                .apis(RequestHandlerSelectors.basePackage("com.emeka"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Blog REST API",
                "Sample API to practice concepts learnt in Spring Boot",
                "1.0",
                "Free to use",
                new springfox.documentation.service.Contact("Olorondu Chukwuemeka", "https://linkedin.com/in/chukwuemeka-olorondu", "oloronduchukwuemeka@gmail.com"),
                "API license",
                "https://github.com/olorondu-emeka",
                Collections.emptyList()
        );
    }

}

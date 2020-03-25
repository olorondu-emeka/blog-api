package com.emeka.blogspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BlogSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogSpringBootApplication.class, args);
    }

}

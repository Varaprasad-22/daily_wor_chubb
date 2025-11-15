package com.chubb.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.chubb.repository")
@EntityScan(basePackages = "com.chubb.controller")
@ComponentScan(basePackages = "com.chubb")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
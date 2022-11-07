package com.example.clase12ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Clase12wsApplication {

    public static void main(String[] args) {
        SpringApplication.run(Clase12wsApplication.class, args);
    }

}

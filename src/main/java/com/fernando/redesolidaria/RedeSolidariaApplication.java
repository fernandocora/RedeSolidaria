package com.fernando.redesolidaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class RedeSolidariaApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedeSolidariaApplication.class, args);
    }

}

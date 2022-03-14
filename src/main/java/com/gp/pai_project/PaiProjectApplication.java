package com.gp.pai_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication(scanBasePackages={"com.gp.pai_project","com.gp.pai_project.services","com.gp.pai_project.controllers","com.gp.pai_project.dao","com.gp.pai_project.entities"})
@SpringBootApplication
public class PaiProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaiProjectApplication.class, args);
    }

}

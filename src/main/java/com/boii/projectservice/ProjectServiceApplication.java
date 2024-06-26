package com.boii.projectservice;

import com.boii.projectservice.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectServiceApplication {

    public static void main(String[] args) {

        Product product = new Product();

        SpringApplication.run(ProjectServiceApplication.class, args);
    }
}

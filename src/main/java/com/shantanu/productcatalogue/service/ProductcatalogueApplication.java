package com.shantanu.productcatalogue.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.shantanu.productcatalogue.*"})
@EntityScan("com.shantanu.productcatalogue.*")
public class ProductcatalogueApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductcatalogueApplication.class, args);
    }
}

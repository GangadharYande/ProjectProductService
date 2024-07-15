package com.boii.projectservice.controllers;

import com.boii.projectservice.models.Product;
import com.boii.projectservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class HelloController {

    @Autowired
            @Qualifier("RealProductService")
    ProductService productService;


    @GetMapping("/hello")
    public String sayHello(){
        List<Product> productList = productService.getAllProducts();
        return " Hello Form RealProductService"+ " " + productList.size();
    }
}

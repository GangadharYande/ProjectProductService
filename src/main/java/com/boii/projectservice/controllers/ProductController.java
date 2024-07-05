package com.boii.projectservice.controllers;

import com.boii.projectservice.dto.FakeStoreRequestDTO;
import com.boii.projectservice.models.Product;
import com.boii.projectservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
// ways to accept incoming requests below

    @Autowired
    ProductService productService;

    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") String productId) {

        Product products = productService.getSingleProduct(productId);
        return products;
    }
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return products;
    }

    @GetMapping("/search")
    // localhost:9000/products?text="mens wear"
    public List<Product> searchProducts(@RequestParam("/text") String queryText) {
        List<Product> products = productService.searchProducts(queryText);
        return products;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody FakeStoreRequestDTO  fakeStoreRequestDTO) {
        Product savedProduct = productService.createProduct(fakeStoreRequestDTO);
        return savedProduct;
    }
}

package com.boii.projectservice.services;

import com.boii.projectservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct( String productId);

    List<Product> getAllProducts();

    List<Product> searchProducts( String searchText);

    Product createProduct(Product product);

}

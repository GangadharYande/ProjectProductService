package com.boii.projectservice.services;

import com.boii.projectservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealProductService implements ProductService {

    @Override
    public Product getSingleProduct(String productId) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public List<Product> searchProducts(String searchText) {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }


}

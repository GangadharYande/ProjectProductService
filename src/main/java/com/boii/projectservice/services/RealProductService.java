package com.boii.projectservice.services;

import com.boii.projectservice.dto.FakeStoreRequestDTO;
import com.boii.projectservice.models.Product;
import com.boii.projectservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("RealProductService")
public class RealProductService implements ProductService {

    @Autowired
    ProductRepository productRepository;


    @Override
    public Product getSingleProduct(String productId) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public List<Product> searchProducts(String searchText) {
        List<Product> products = productRepository.getAllProducts();

        // core logic , filter products whether the name contains searchText or not
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if(product.getName().contains(searchText)) {
                result.add(product);
            }
        }
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product createProduct(FakeStoreRequestDTO fakeStoreRequestDTO) {
        return null;
    }


}

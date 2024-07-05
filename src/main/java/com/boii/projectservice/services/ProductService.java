package com.boii.projectservice.services;

import com.boii.projectservice.dto.FakeStoreRequestDTO;
import com.boii.projectservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct( String productId);

    List<Product> getAllProducts();

    List<Product> searchProducts( String searchText);

    // To Create Object in own Db
    Product createProduct(Product product);


    // To Create Object to  FakeStore
    // Not the right way to code  just to run code
    Product createProduct(FakeStoreRequestDTO fakeStoreRequestDTO);

}

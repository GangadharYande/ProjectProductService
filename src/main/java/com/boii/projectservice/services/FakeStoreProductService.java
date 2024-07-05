package com.boii.projectservice.services;

import com.boii.projectservice.dto.FakeStorePOSTResponseDTO;
import com.boii.projectservice.dto.FakeStoreRequestDTO;
import com.boii.projectservice.dto.FakeStoreResponseDTO;
import com.boii.projectservice.models.Category;
import com.boii.projectservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class FakeStoreProductService implements  ProductService{

    // This has hit the APIs of FakeStore


    @Autowired
    RestTemplate restTemplate ;   // RestTemplate Bean Created in ApplicationConfig
    // we use RestTemplate to call 3rd party APIs

    @Override
    public Product getSingleProduct( String productId) {

        FakeStoreResponseDTO response = restTemplate.getForObject(
                "https://fakestoreapi.com/products/"
                + productId, FakeStoreResponseDTO.class);

        Product product = new Product();

        product.setId(response.getId());
        product.setName(response.getTitle());
        product.setPrice(response.getPrice()*1.0); // here price was store is INTEGER for response in double -converting it in double by *1.0
        product.setDescription(response.getDescription());
        product.setImageURL(response.getImage());
        product.setDescription(response.getDescription());

        Category category = new Category();
        category.setName(response.getCategory());

        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreResponseDTO[] responseArray = restTemplate.getForObject(
                "https://fakestoreapi.com/products/", FakeStoreResponseDTO[].class
        );
        List<Product> productList = new ArrayList<>();
        for(FakeStoreResponseDTO response: responseArray){
            Product product = new Product();

            product.setId(response.getId());
            product.setName(response.getTitle());
            product.setDescription(response.getDescription());
            product.setImageURL(response.getImage());
            product.setPrice(response.getPrice()*1.0);

            Category category = new Category();
            category.setName(response.getCategory());
            product.setCategory(category);
        }
        return productList;
    }

    @Override
    public List<Product> searchProducts(String searchText) {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product createProduct(FakeStoreRequestDTO fakeStoreRequestDTO) {
        FakeStoreResponseDTO savedProductResponse = restTemplate.postForObject("https://fakestoreapi.com/products/" ,
                fakeStoreRequestDTO,
                FakeStoreResponseDTO.class);

            Product product = new Product();

            product.setId(savedProductResponse.getId());
            product.setName(savedProductResponse.getTitle());
            product.setDescription(savedProductResponse.getDescription());
            product.setImageURL(savedProductResponse.getImage());
            product.setPrice(savedProductResponse.getPrice()*1.0);

            Category category = new Category();
            category.setName(savedProductResponse.getCategory());
            product.setCategory(category);
        return product;
    }


}

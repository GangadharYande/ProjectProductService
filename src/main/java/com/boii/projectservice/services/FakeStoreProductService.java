package com.boii.projectservice.services;

import com.boii.projectservice.FakeStoreResponse;
import com.boii.projectservice.models.Category;
import com.boii.projectservice.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Primary
public class FakeStoreProductService implements  ProductService{

    // This has hit the APIs of FakeStore

    RestTemplate restTemplate = new RestTemplate();
    // we use RestTemplate to call 3rd party APIs

    @Override
    public Product getSingleProduct( String productId) {

        FakeStoreResponse response = restTemplate.getForObject("https://fakestoreapi.com/products/" + productId, FakeStoreResponse.class);
        Product product = new Product();

        product.setId(response.getId());
        product.setName(response.getTitle());
        product.setPrice(response.getPrice()*1.0);  //  here price was store is INTEGER for response in double - converting it in double by *1.0
        product.setDescription(response.getDescription());
        product.setImageURL(response.getImage());

        Category category = new Category();
        category.setName(response.getCategory());





        product.setDescription(response.getDescription());
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

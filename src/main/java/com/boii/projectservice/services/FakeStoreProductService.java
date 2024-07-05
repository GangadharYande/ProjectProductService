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

        // 1. hit the API
        // 2. You want to structure the Object, into a particular formal -> FakeStoreResponse.class
        // 3. Convert the class Structure, to its corresponding Object -> response
        Product product = convertResponseToProduct(response);

        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        // Hitting the API
        FakeStoreResponseDTO[] responseArray = restTemplate.getForObject(
                "https://fakestoreapi.com/products/", FakeStoreResponseDTO[].class
        );
        // Storing all products in List
        List<Product> productList = new ArrayList<>();

        // Converting List to ArrayList
        for(FakeStoreResponseDTO response: responseArray){
            Product product = convertResponseToProduct(response);
            productList.add(product);
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
        FakeStorePOSTResponseDTO savedProductResponse = restTemplate.postForObject(
                "https://fakestoreapi.com/products/" ,
                fakeStoreRequestDTO,
                FakeStorePOSTResponseDTO.class);

            Product product = convertPOSTResponseToProduct(savedProductResponse);
        return product;
    }


    // Handling response form client server to our server Separately
    private Product convertResponseToProduct(FakeStoreResponseDTO responseDTO){
        Product product = new Product();

        product.setId(responseDTO.getId());
        product.setName(responseDTO.getTitle());
        product.setDescription(responseDTO.getDescription());
        product.setImageURL(responseDTO.getImage());
        product.setPrice(responseDTO.getPrice()*1.0);

        Category category = new Category();
        category.setName(responseDTO.getCategory());
        product.setCategory(category);

        return product;
    }

    private Product convertPOSTResponseToProduct(FakeStorePOSTResponseDTO postResponseDTO){
        Product product = new Product();

        product.setId(postResponseDTO.getId());
        product.setName(postResponseDTO.getTitle());
        product.setDescription(postResponseDTO.getDescription());
        product.setImageURL(postResponseDTO.getImage());
        product.setPrice(postResponseDTO.getPrice()*1.0);

        Category category = new Category();
        category.setName(postResponseDTO.getCategory());
        product.setCategory(category);

        return product;
    }

}

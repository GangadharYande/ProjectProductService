package com.boii.projectservice.services;

import com.boii.projectservice.dto.FakeStorePOSTResponseDTO;
import com.boii.projectservice.dto.FakeStoreRequestDTO;
import com.boii.projectservice.dto.FakeStoreResponseDTO;
import com.boii.projectservice.exceptions.DBNotFoundException;
import com.boii.projectservice.exceptions.DBTimeOutException;
import com.boii.projectservice.exceptions.ProductNotFoundException;
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
    public Product getSingleProduct( String productId) throws ProductNotFoundException {

        FakeStoreResponseDTO response = restTemplate.getForObject(
                "https://fakestoreapi.com/products/"
                + productId,
                FakeStoreResponseDTO.class
        );

        if(response == null ){
            throw new ProductNotFoundException("Product not found with id : " + productId);
        }


//        connectTODB();
//        executeSQLQuery();


        // 1. hitting the API
        // 2. You want to structure the Object, into a particular formal -> FakeStoreResponse.class
        // 3. Convert the class Structure, to its corresponding Object -> response
        Product product = response.toProduct(); // handing   respose via FakeStoreResponseDTO

        return product;
    }
    public void connectTODB() throws DBNotFoundException {
        //
        throw new DBNotFoundException("DB not found");
    }
    public void executeSQLQuery() throws DBTimeOutException, DBNotFoundException {
        throw new DBNotFoundException("DB Stoped responding trying to Query related issue ");
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
            Product product = response.toProduct();
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

            Product product = savedProductResponse.toProduct(); // handling POST request via FakeStorePOSTResponseDTO
        return product;
    }
}

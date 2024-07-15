package com.boii.projectservice.repository;

import com.boii.projectservice.models.Product;
import com.boii.projectservice.services.ProductService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    public Product save(Product product){
        // Connect to MySQL DB
        // Execute the Query , insert into products () values()

        return null;

    }

    public List<Product> getAllProducts(){
        // connect To DB
        // Execute the Query , select * from products

        return  new ArrayList<Product>();
    }
}

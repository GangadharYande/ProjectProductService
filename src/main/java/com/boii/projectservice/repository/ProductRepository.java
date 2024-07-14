package com.boii.projectservice.repository;

import com.boii.projectservice.models.Category;
import com.boii.projectservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    public List<Product> getALlProducts();

    Product getProductById(String productId);
    List<Product> getAllByPriceGreaterThan(Double price);
    // Select * from products where price > price

    List<Product> getAllByNameLike(String text);
    // Select * From products Where Name Like '%temp%'

    List<Product> getAllByNameLikeAndPriceLessThan(String text, Double price, Category category);
}

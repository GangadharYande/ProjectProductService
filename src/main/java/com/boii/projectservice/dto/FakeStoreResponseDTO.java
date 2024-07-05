package com.boii.projectservice.dto;

import com.boii.projectservice.models.Category;
import com.boii.projectservice.models.Product;
import lombok.Getter;
import lombok.Setter;

// purpose ,to store the data from outside world  we use DTO (Data Transfer Objects )
//  Its purpose is to accept Request form the  fakeStore API
@Getter
@Setter
public class FakeStoreResponseDTO {
    private String id;
    private String title;
    private Integer price ;
    private String description;
    private String image;
    private String category;

    public Product toProduct(){
        Product product = new Product();

        product.setId(this.id);
        product.setName(this.title);
        product.setDescription(this.description);
        product.setImageURL(this.image);
        product.setPrice(this.price*1.0);

        Category category = new Category();
        category.setName(this.category);
        product.setCategory(category);

        return product;
    }
}

/*{
    "id": 1,
    "title": "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
    "price": 109.95,
    "description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
    "category": "men's clothing",
    "image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
    "rating": {
        "rate": 3.9,
        "count": 120
    }
}*/
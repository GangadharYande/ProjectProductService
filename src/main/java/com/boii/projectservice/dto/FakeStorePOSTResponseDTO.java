package com.boii.projectservice.dto;
import com.boii.projectservice.models.Category;
import com.boii.projectservice.models.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStorePOSTResponseDTO {

    private String id;
    private String title;
    private Integer price ;
    private String description;
    private String image;
    private String category;

    public Product toProduct(){
        Product product = new Product();

        product.setId(Long.valueOf(this.id));
        product.setName(this.title);
        product.setDescription(this.description);
        product.setImageURL(this.image);
        product.setPrice(this.price*1.0);

        Category category = new Category();
        category.setName(this.category);
//        product.setCategory(category);
        // more
        // more ...
        return product;
    }
}

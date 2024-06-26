package com.boii.projectservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    private String id;
    private String name;
    private Double price;
    private String Description;
    private Category category;
    private String imageURL;


// By Default every class has a default constructor, the moment u created own constructor  - default one is not usable

}

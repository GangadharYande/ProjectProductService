package com.boii.projectservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends BaseModel{
    private String name;
    private Double price;
    private String Description;

    private String imageURL;
//    private Category category;

// By Default every class has a default constructor, the moment u created own constructor  - default one is not usable

}

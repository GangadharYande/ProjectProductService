package com.boii.projectservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category  extends BaseModel {
    private  String name;

    // if @OneToMany place in Category  there will be separate mapping table for products and category
    @OneToMany(mappedBy="category")
    // but actually it is the inverse of the same relation between product and category
    // this relation is already handled by category column , in product table
    private List<Product> products;





}
